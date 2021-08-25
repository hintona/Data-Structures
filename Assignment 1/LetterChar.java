/*
 * Alex Hinton
 */

public class LetterChar implements Letter {

    private char cLet;

    public LetterChar(char newChar){
        int tempInt = (int) newChar;
        if((65 <= tempInt && tempInt <= 90) || (97 <= tempInt && tempInt <= 122)){
            cLet = newChar;
        }
        else throw new IllegalArgumentException(newChar + " is not a valid letter.");
    }

    @Override
    public int getInt() {
        int newLet = (int) cLet;
        return newLet;
    }

    @Override
    public char getChar() {
        return cLet;
    }
    
}
