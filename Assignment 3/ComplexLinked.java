// Alex Hinton

public class ComplexLinked extends SimpleLinked{

    void insert(int loc, char data){
        //inserts data at index loc
        Node newNode = new Node(data);
        Node prev = null;

        Node temp = start;
        for(int i = 0; i < loc; i++){
            prev = temp;
            temp = temp.getNext();
        }
        if(loc == 0){
            newNode.setNext(start);
            start = newNode;
        }
        else{
            newNode.setNext(temp);
            prev.setNext(newNode);
        }
        len++;
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
        if(temp == start){
            start = temp.getNext();
        }
        else{
            prev.setNext(temp.getNext());
        }
        len--;
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
        temp.setNext(prev);
        ComplexLinked newLinked = new ComplexLinked();
        newLinked.start = temp;
        return newLinked;
    }
}