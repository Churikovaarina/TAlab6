package Timer;

import BalancedTree.BalancedBinaryTree;
import Filler.Filler;
import UnbalancedTree.UnbalancedBinaryTree;


public class MainTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Filler filler = new Filler();

        //AVL
        BalancedBinaryTree avl1 = new BalancedBinaryTree();
        BalancedBinaryTree avl2 = new BalancedBinaryTree();
        BalancedBinaryTree avlFilledRandom = new BalancedBinaryTree();
        BalancedBinaryTree avlFilledConsecutive = new BalancedBinaryTree();
        filler.fillWithRandomNumbers(avlFilledRandom);
        filler.fillWithConsecutiveNumbers(avlFilledConsecutive);
        System.out.println("AVL: ");
        System.out.println("filling with random numbers: " + timer.timer(Timer.FILLING_RANDOM, avl1) + " ns");
        System.out.println("filling with consecutive numbers: " + timer.timer(Timer.FILLING_CONSECUTIVE, avl2) + " ns");
        System.out.println("balancing in tree with random numbers: " + "0 ns (already balanced while inserting)");
        System.out.println("balancing in tree with consecutive numbers: " + "0 ns (already balanced while inserting)");
        System.out.println("searching: " + timer.timer(Timer.SEARCHING, avlFilledRandom) + " ns");
        System.out.println("deletion: " + timer.timer(Timer.DELETION, avlFilledRandom) + " ns\n");

        //BST
        UnbalancedBinaryTree bst1 = new UnbalancedBinaryTree();
        UnbalancedBinaryTree bst2 = new UnbalancedBinaryTree();
        UnbalancedBinaryTree bstFilledRandom = new UnbalancedBinaryTree();
        UnbalancedBinaryTree bstFilledConsecutive = new UnbalancedBinaryTree();
        filler.fillWithRandomNumbers(bstFilledRandom);
        filler.fillWithConsecutiveNumbers(bstFilledConsecutive);
        System.out.println("BST: ");
        System.out.println("filling with random numbers: " + timer.timer(Timer.FILLING_RANDOM, bst1) + " ns");
        System.out.println("filling with consecutive numbers: " + timer.timer(Timer.FILLING_CONSECUTIVE, bst2) + " ns");
        System.out.println("balancing  in tree with random numbers: " + timer.timer(Timer.BALANCING, bstFilledRandom) + " ns");
        System.out.println("balancing in tree with consecutive numbers: " + timer.timer(Timer.BALANCING, bstFilledConsecutive) + " ns");
        System.out.println("searching: " + timer.timer(Timer.SEARCHING, bstFilledRandom) + " ns");
        System.out.println("deletion: " + timer.timer(Timer.DELETION, bstFilledRandom) + " ns");


    }
}
