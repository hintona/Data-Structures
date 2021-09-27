public class SkipNode<T extends Comparable> {
    private T data;
    private SkipNode next;
    private SkipNode previous;
    private SkipNode above;
    private SkipNode below;

    public SkipNode(T the_data){
	data = the_data;
	next = null;
	previous = null;
    above = null;
    }

    public T getData(){
	return data;
    }

    public SkipNode getNext(){
	return next;
    }

    public SkipNode getPrevious(){
	return previous;
    }

    public SkipNode getAbove(){
        return above;
    }

    public SkipNode getBelow(){
        return below;
    }

    public void setData(T the_data){
	data = the_data;
    }

    public void setNext(SkipNode n){
	next = n;
    }

    public void setPrevious(SkipNode p){
	previous = p;
    }

    public void setAbove(SkipNode a){
        above = a;
    }

    public void setBelow(SkipNode b){
        below = b;
    }
}
