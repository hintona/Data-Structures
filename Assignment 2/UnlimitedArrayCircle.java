// Alex Hinton

public class UnlimitedArrayCircle implements UnlimitedArray {
    private int length;
    public int[] UArray;
    private int last;
    private int first;
    
    UnlimitedArrayCircle(){
        length = 4;
        last = 0;
        first= 0;
        UArray = new int[length];
    }

    @Override
    public boolean isEmpty() {
        return ((last == 0 && first == 0) || last == first);
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
        if(last + 1 == length){
            if(first == 0) resize();
            else last = 0;
        }
        else if(last == first){
            resize();
        }
       
       UArray[last] = number;
       last++;
    }

    @Override
    public int removeFirst() {
        int num = UArray[first];
        UArray[first] = 0;
        if(first + 1 == length){
            first = 0;
        }
        else first++;
        return num;
    }

    @Override
    public int removeLast() {
        int num = UArray[last - 1];
        UArray[last - 1] = 0;
        if(last == 0 && last != first){
            last = length - 1;
        }
        else last--;
        return num;
    }

    private void resize(){
        int[] temp = new int[length * 2];
        for(int i = 0; i < length; i++){
            if(first + i != length){
                temp[i] = UArray[first + i];
            }
            else{
                temp[i] = UArray[last - i];
            }
        }
        UArray = temp;
        length = length * 2;
    }
}
