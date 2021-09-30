import java.util.Random;

public class SkipList<T extends Comparable> implements SearchList {

    SkipNode start; //sentinel node
    SkipNode end; //sentinel node
    SkipNode first; //start of smallest child list
    int lists; //keep track of how many lists there are, base list is 0


    public SkipList(){
        lists = 0; 
        first = null;
        start = new SkipNode(-1);
        end = new SkipNode(-1);
    }

    @Override
    public void insert(Comparable the_data) {
        SkipNode data = searcher(the_data);
        SkipNode newNode = new SkipNode(the_data);

        if(data != null){
            newNode.setNext(data.getNext());
            data.getNext().setPrevious(newNode);
            newNode.setPrevious(data);
            data.setNext(newNode);
        }


        if(newNode.getNext() == null) newNode.setNext(end);
        if(newNode.getPrevious() == null) newNode.setPrevious(start);
        
        Random r = new Random();
        int counter = 0;

        while(r.nextBoolean()){

            counter++;
            SkipNode child = new SkipNode(newNode.getData());
            newNode.setBelow(child);
            child.setAbove(newNode);

            if(counter <= lists){ //triggers only if there's already a list at the level we're at
                SkipNode neighbourParent = newNode.getPrevious();

                //Search for the node just before our parent node that has a child
                while(neighbourParent.getBelow() == null && neighbourParent.getPrevious() != start){
                    neighbourParent = neighbourParent.getPrevious();
                }
                //If we can't find one, set the child's node to start and look for the node after our parent node that has a child
                if(neighbourParent.getPrevious() == start && neighbourParent.getBelow() == null){
                    child.setPrevious(start);
                    neighbourParent = newNode.getNext();
                    while(neighbourParent.getBelow() == null && neighbourParent.getNext() != end){
                        neighbourParent = neighbourParent.getNext();
                    }
                    if(neighbourParent.getNext() == end && neighbourParent.getBelow() == null){
                        child.setNext(end);
                    }
                    else{
                        child.setPrevious(neighbourParent.getBelow());
                        child.setNext(neighbourParent.getBelow().getNext());
                        neighbourParent.getBelow().getNext().setPrevious(child);
                        neighbourParent.getBelow().setNext(child);
                    }
                }
                //Else, we do find one and we set that parent's child to our child's neighbour
                else{
                    child.setPrevious(neighbourParent.getBelow());
                    child.setNext(neighbourParent.getBelow().getNext());
                    neighbourParent.getBelow().getNext().setPrevious(child);
                    neighbourParent.getBelow().setNext(child);
                }
            }
            else{ //otherwise this goes into an empty child list
                child.setNext(end);
                child.setPrevious(start);
                first = child;
                lists++;
            }

            newNode = child;

        }
        
    }

    @Override
    public boolean search(Comparable the_data) {
        SkipNode<T> data = searcher(the_data);
        if(data.getData().equals(the_data)) return true;
        else return false;
    }

    @Override
    public boolean remove(Comparable the_data) {
        SkipNode<T> data = searcher(the_data);
        if(!data.getData().equals(the_data)) return false;
        else{
            while(data != null){
                SkipNode prev = data.getPrevious();
                SkipNode next = data.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
                data = data.getBelow();
            }
            return true;
        }
    }

    @Override
    public void print() {
        SkipNode baseStart = first;
        while(baseStart.getAbove() != null){
            baseStart = baseStart.getAbove();
        }
        while(baseStart.getPrevious() != start){
            baseStart = baseStart.getPrevious();
        }
        while(baseStart != end){
            System.out.print(baseStart.getData() + " ");
            baseStart = baseStart.getNext();
        }
    }

    public void debugPrint(){
        SkipNode baseStart = first;
        System.out.println("First node is " + baseStart.getData());
        System.out.println("First Child list:");
        System.out.print(baseStart.getData() + " ");
        while(baseStart.getNext() != end){
            System.out.print(baseStart.getNext().getData() + " ");
            baseStart = baseStart.getNext();
        } 
        baseStart = baseStart.getAbove();
        while(baseStart.getAbove() != null){
            while(baseStart.getPrevious() != start){
                baseStart = baseStart.getPrevious();
            }
            System.out.println("\nNext list up:");
            System.out.print(baseStart.getData() + " ");
            while(baseStart.getNext() != end){
                System.out.print(baseStart.getNext().getData() + " ");
                baseStart = baseStart.getNext();
            }
            baseStart = baseStart.getAbove();
        }
        System.out.println("\nBase list:");
        while(baseStart.getPrevious() != start){
            baseStart = baseStart.getPrevious();
        }
        System.out.print(baseStart.getData() + " ");
        while(baseStart.getNext() != end){
            System.out.print(baseStart.getNext().getData() + " ");
            baseStart = baseStart.getNext();
        }
        System.out.print("\n");
    }

    // Locates where in the base list a node with the given data should be. If node with given data exists, returns that node.
    // Else, returns node "in front" of where one should go, which will be the one a little less than it 
    private SkipNode<T> searcher(Comparable the_data){
        SkipNode working = first;
        
        if(working != null){
            while(working.getAbove() != null){
                if(the_data.compareTo(working.getData()) == 1){
                    if(working.getNext() == end) working = working.getAbove();
                    else if(the_data.compareTo(working.getNext().getData()) == -1) working = working.getAbove();
                    else working = working.getNext();
                }
                else if(the_data.compareTo(working.getData()) == -1){
                        if(working.getPrevious() == start) working = working.getAbove();
                        else if(the_data.compareTo(working.getPrevious().getData()) == 1) working = working.getAbove();
                        else working = working.getPrevious();
                }
                else{
                    working = working.getAbove();
                }
            }
            
            boolean found = false;
    
            while(!found){
                if(the_data.compareTo(working.getData()) == 1){
                    if(working.getNext() == end) found = true;
                    else if(the_data.compareTo(working.getNext().getData()) == -1) found = true;
                    else working = working.getNext();
                }
                else if(the_data.compareTo(working.getData()) == -1){
                    if(working.getPrevious() == start) found = true;
                    else if(the_data.compareTo(working.getPrevious().getData()) == 1) found = true;
                    else working = working.getPrevious();
                }
                else found = true;
            }
        }

        return working;
    }

    
}
