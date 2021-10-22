//IMPORTANT: You will modify this class to add functions
//the functions that you need to add are described in the assignment document

//All functions in this class are static.
//This class is never intended to be constructed.

import java.util.Random;

public abstract class TreeUtilities{

    public static void printTreeHelper(IntNode nd){
		if (nd != null){
			printTreeHelper(nd.getLeft());
			System.out.print(nd.getData());
			System.out.print(" ");
			printTreeHelper(nd.getRight());
		}
    }

    //This function prints all of the data an IntSearchTree in order
    //Starting with the lowest and going to the highest
    public static void printTree(IntSearchTree tree){
		printTreeHelper(tree.getRoot() );
		System.out.println("");
    }

    //This function creates a IntSearchTree filled with randomly chosen data
    //num is the number of nodes in the random search tree
    //max_val is the upper limit on the randomly chosen integer data
    public static IntSearchTree makeRandomTree(int num, int max_val){
	Random rand = new Random();
	IntSearchTree tree = new IntSearchTree();
	
	for(int i=0; i<num; i++){
	    int rand_data = rand.nextInt(max_val);
	    tree.insert(rand_data);
	}

	return tree;
    }

	public static int getMax(IntSearchTree the_tree){
		IntNode root = the_tree.getRoot();
		IntNode highestLeaf = root;
		while(highestLeaf.getRight() != null){
			highestLeaf = highestLeaf.getRight();
		}
		return highestLeaf.getData();
	}

	public static int getNodeHeight(IntSearchTree  the_tree, int target){
		IntNode root = the_tree.getRoot();
		IntNode targetLeaf = root;
		int height = 1;
		while(targetLeaf.getData() != target && height != -1){
			if(targetLeaf.getData() > target){
				if(targetLeaf.getLeft() != null){
					targetLeaf = targetLeaf.getLeft();
					height++;
				}
				else height = -1;
			}
			else if(targetLeaf.getData() < target){
				if(targetLeaf.getRight() != null){
					targetLeaf = targetLeaf.getRight();
					height++;
				}
				else height = -1;
			}
		}
		return height;
	}

	public static int getTreeHeight(IntSearchTree the_tree){
		return -1;
	}

    //Don't hesitate to modify this code, it is only here for testing purposes
    public static void main(String args[]){
	IntSearchTree tree = makeRandomTree(10, 20);
	printTree(tree);
	System.out.println(getTreeHeight(tree));
	
	
	    
    }
}
