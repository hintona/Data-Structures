/*
 * Alex Hinton
 */

public class LetterInt implements Letter{

    private int iLet;

    public LetterInt(int newInt){
        if((65 <= newInt && newInt <= 90) || (97 <= newInt && newInt <= 122)){
            iLet = newInt;
        }
        else throw new IllegalArgumentException(newInt + " is not a valid ASCII code for a letter.");
    }

    @Override
    public int getInt() {
        return iLet;
    }

    @Override
    public char getChar() {
        char newChar = (char) iLet;
        return newChar;
    }
    
}
