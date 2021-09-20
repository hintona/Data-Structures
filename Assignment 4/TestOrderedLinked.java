public class TestOrderedLinked {

    public static void main(String[] args){
        //Create list
        OrderedLinked<Character> list = new OrderedLinked<Character>();

        //Populate list
        System.out.println("Adding characters...");
        list.insert('B');
        list.insert('D');
        list.insert('A');
        list.insert('C');
        System.out.println("This should print A,B,C,D:");
        list.print();

        //Test search and remove part 1
        if(list.search('B')){
            System.out.println("Found B in the list.");
            if(list.remove('B')){
                System.out.println("Successfully removed B from list. Should now print A,C,D:");
                list.print();
            }
            else System.out.println("Failed to remove B.");
        }
        else System.out.println("Failed to find B.");

        //Test search and remove part 2
        if(!list.search('F')){
            System.out.println("Correctly detected that F is not in list");
            if(!list.remove('F')){
                System.out.println("Correctly refused to remove nonextant character from list");
            }
            else System.out.println("Failed to refuse the removal of nonextant character from list");
        }
        else System.out.println("Failed to realise F is not in list");

        //Add new characters
        System.out.println("Adding new characters...");
        list.insert('A');
        list.insert('F');

        //Test new characters are still in correct order
        System.out.println("Should now print A,A,C,D,F:");
        list.print();

        //Test removal from start of list
        if(list.remove('A')){
            System.out.println("Successful removal from beginning of list. Should now print A,C,D,F:");
            list.print();
        }
        else System.out.println("Failed to remove A from the beginning of list");

        //Test removal from end of list
        if(list.remove('F')){
            System.out.println("Successful removal from end of list. Should now print A,C,D:");
            list.print();
        }
        else System.out.println("Failed to remove F from end of list.");

        System.out.println("Test completed");
        
    }
    
}
