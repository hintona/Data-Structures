public class OrderedLinked<T extends Comparable<T>> extends DoubleLinked<T>{

    DoubleLinked<T> list;

    public OrderedLinked(){
        list = new DoubleLinked<>();
    }

    public void insert(T data){
        if(this.len == 0){
            append(data);
        }
        
        else{
            boolean notEnd = true;
            DNode<T> temp = start;

            while(temp.getData().compareTo(data) < 0){
                temp = temp.getNext();
                if(temp == null){
                    append(data);
                    notEnd = false;
                    break;
                }
            }

            if(notEnd){
            DNode<T> newData = new DNode<T>(data);
                if(temp == start){
                    start = newData;
                }
            newData.setNext(temp);
            newData.setPrevious(temp.getNext());
            temp.setPrevious(newData);
            }
        }
    }

    public boolean remove(T data){
        DNode<T> found = searcher(data);
        if(found == null) return false;
        else{
            DNode<T> prev = found.getPrevious();
            DNode<T> next = found.getNext();
            if(found == start) start = found.getNext();
            if(found == end) end = found.getPrevious();
            prev.setNext(next);
            next.setPrevious(prev);
            return true;
        }
    }

    public boolean search(T data){
        DNode<T> found = searcher(data);
        if(found == null) return false;
        else return true;
    }

    //looks for the given data, returns node with it if found, otherwise returns null
    public DNode<T> searcher(T data){
        DNode<T> temp = start;
        while(temp.getData() != data){
            temp = temp.getNext();
            if(temp == null){
                return null;
            }
        }
        return temp;
    }
    
}
