package Filler;

import Interfaces.BinarySearchTree;


import java.util.Random;

public class Filler {
    Random rand = new Random();
    public BinarySearchTree fillWithRandomNumbers(BinarySearchTree tree){
        for (int i = 0; i < 2000; i++) {
            int int_random = rand.nextInt(100000);
            tree.insert(int_random);
        }
        return tree;
    }

    public BinarySearchTree fillWithConsecutiveNumbers(BinarySearchTree tree){
        for (int i = 0; i < 2000; i++){
            tree.insert(i);
        }
        return tree;
    }
}
