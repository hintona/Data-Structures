public class SkipList<T extends Comparable> implements SearchList {

 //what do we need to keep track of?
    SkipNode start; //sentinel node
    SkipNode end; //sentinel node
    SkipNode first; //start of smallest child list


    public SkipList(){

    }

    @Override
    public void insert(Comparable the_data) {
        SkipNode<T> data = searcher(the_data);
        SkipNode newNode = new SkipNode(the_data);
        newNode.setNext(data.getNext());
        data.getNext().setPrevious(newNode);
        newNode.setPrevious(data);
        data.setNext(newNode);
        
        // add node to child lists, remember to deal with sentinels
        
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
        while(baseStart.getNext() != end){
            System.out.print(baseStart.getData() + " ");
            baseStart = baseStart.getNext();
        }
    }

    // Locates where in the base list a node with the given data should be. If node with given data exists, returns that node.
    // Else, returns node "in front" of where one should go, which will be the one a little less than it 
    private SkipNode<T> searcher(Comparable the_data){
        SkipNode working = first;
        
        while(working.getAbove() != null){
            if(the_data.compareTo(working.getData()) == 1){
                if(working.getNext() == end) working = working.getAbove();
                else if(the_data.compareTo(working.getNext().getData()) == -1) working = working.getAbove();
                else working = working.getNext();
            }
            else if(the_data.compareTo(working.getData()) == -1){
                    if(working.getNext() == start) working = working.getAbove();
                    else if(the_data.compareTo(working.getNext().getData()) == 1) working = working.getAbove();
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
                else if(the_data.compareTo(working.getPrevious()) == 1) found = true;
                else working = working.getPrevious();
            }
            else found = true;
        }

        return working;
    }

    
}
