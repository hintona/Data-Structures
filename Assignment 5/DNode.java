//This class represents a node in a Linked List
//The class holds one character of data

public class DNode<T extends Comparable>{
    private Comparable data;
    private DNode next;
    private DNode previous;

    public DNode(Comparable data2){
	data = data2;
	next = null;
	previous = null;
    }

    public Comparable getData(){
	return data;
    }

    public DNode getNext(){
	return next;
    }

    public DNode getPrevious(){
	return previous;
    }

    public void setData(Comparable the_data){
	data = the_data;
    }

    public void setNext(DNode n){
	next = n;
    }

    public void setPrevious(DNode p){
	previous = p;
    }
}
