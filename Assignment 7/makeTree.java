import java.util.ArrayList;
import java.util.Collections;

public class makeTree{

    makeTree(){}

    IntSearchTree makeUnbalancedTree(){
        IntSearchTree tree = new IntSearchTree();
        for(int i = 0; i<1000; i++){
            tree.insert(i);
        }
        return tree;
    }

    IntSearchTree makeBalancedTree(){
        IntSearchTree tree = new IntSearchTree();
        ArrayList<Integer> my_list = new ArrayList<Integer>();
        for(int i = 0; i<1000; i++){
            my_list.add(i);
        }
        Collections.shuffle(my_list);
        for(int i : my_list){
            tree.insert(i);
        }
        return tree;
    }

}

public static void main(String args[]){
    makeTree treeMaker = new makeTree();
    
}