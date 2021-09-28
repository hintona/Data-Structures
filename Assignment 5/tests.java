public class tests {
    
    public static void main(String[] args){
        SkipList skl = new SkipList();

        skl.insert(1);
        skl.insert(2);
        skl.insert(4);
        skl.insert(3);

        System.out.println("Should print 1 2 3 4");
        skl.print();

        skl.insert(10);
        skl.insert(9);
        skl.insert(6);
        skl.insert(6);
        skl.insert(7);
        skl.insert(5);
        skl.insert(8);

        System.out.println("\nShould print 1 2 3 4 5 6 6 7 8 9 10");
        skl.print();

        if(skl.remove(6)) System.out.println("\nCorrectly removed 6");
        if(skl.remove(11)) System.out.println("\nUh-oh. Somehow removed 11");

        System.out.println("\nShould print 1 2 3 4 5 6 7 8 9 10");
        skl.print();

        if(skl.search(7)) System.out.println("\nYay! Found 7");
        if(skl.search(12)) System.out.println("\nOh no. Somehow found 12");

    }
}
