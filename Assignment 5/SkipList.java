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
        
        //while working's above is not null
            //determine if thedata is more or less than working
                //more: is thedata more, equal, or less than working's next, or is next sentinel
                    //sentinel: go up
                    //more: move working to its next 
                    //less: move up
                    //equal: go all the way to base, which breaks loop
                //less: is thedata more, equal, or less than working's prev, or is prev sentinel
                    //sentinel: go up
                    //more: move up
                    //less: move working to its prev
                    //equal: go all the way up to base, which breaks loop
        
        //once at the base list, is working more or less than thedata
            //more: is thedata more, equal, or less than working's next, or is next sentinel?
                //sentinel: return working
                //more: move working forward
                //less: return working
                //equal: return working
            //less: is thedata more, equal, or less than working's prev, or is prev sentinel?
                //sentinel: return sentinel
                //more: return working's prev
                //less: move working back
                //equal: return working's prev

        return null;
    }

    
}
