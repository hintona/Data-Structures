// Alex Hinton

public class UnlimitedArrayFast implements UnlimitedArray{
    private int length;
    public int[] UArray;
    private int last;
    private int first;
    
    UnlimitedArrayFast(){
        length = 4;
        last = 0;
        first= 0;
        UArray = new int[length];
    }

    @Override
    public boolean isEmpty() {
        return (last == first);
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public int getLast() {
        return last;
    }

    @Override
    public void add(int number) {
       if((last + 1) == length){
            resize();
       }
       UArray[last] = number;
       last++;
    }

    @Override
    public int removeFirst() {
        int num = UArray[first];
        UArray[first] = 0;
        first++;
        return num;
    }

    @Override
    public int removeLast() {
        int num = UArray[last - 1];
        UArray[last - 1] = 0;
        last--;
        return num;
    }

    private void resize(){
        int[] temp = new int[length * 2];
        for(int i = 0; i < length; i++){
            temp[i] = UArray[i];
        }
        UArray = temp;
        length = length * 2;
    }
}
