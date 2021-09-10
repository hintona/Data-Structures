public class ComplexLinked extends SimpleLinked{

    void insert(int loc, char data){
        //inserts data at index loc
        Node newNode = new Node(data);

        Node temp = start;
        for(int i = 0; i < loc; i++){
            temp = temp.getNext();
        }
        if(loc == 0){
            newNode.setNext(start);
            start = newNode;
        }
        else{
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    boolean remove(char data){
        Node prev = null;
        Node temp = start;
        while(temp.getData() != data){
            if(temp.getNext() == null){
                return false;
            }
            else{
                prev = temp;
                temp = temp.getNext();
            }
        }
        prev.setNext(temp.getNext());
        return true;
    }

    ComplexLinked reverse(){
        Node prev = null;
        Node temp = start;
        Node next = start.getNext();
        while(next != null){
            temp.setNext(prev);
            prev = temp;
            temp = next;
            next = temp.getNext();
        }
        ComplexLinked newLinked = new ComplexLinked();
        newLinked.start = temp;
        return newLinked;
    }
}