package Timer;

import Interfaces.BinarySearchTree;
import java.util.Random;

public class Timer {
    public final static int FILLING_RANDOM = 1;
    public final static int FILLING_CONSECUTIVE = 2;
    public final static int BALANCING = 5;
    public final static int SEARCHING = 6;
    public final static int DELETION = 7;

    public double timer(int Method, BinarySearchTree tree){
        double startTime;
        double endTime;
        Random rand = new Random();

        switch (Method) {
            case FILLING_RANDOM -> {
                startTime = System.nanoTime();
                for (int i = 0; i < 2000; i++) {
                    int int_random = rand.nextInt(100000);
                    tree.insert(int_random);
                }
                endTime = System.nanoTime();
            }
            case FILLING_CONSECUTIVE -> {
                startTime = System.nanoTime();
                for (int i = 0; i < 2000; i++){
                    tree.insert(i);
                }
                endTime = System.nanoTime();
            }
            case BALANCING -> {
                startTime = System.nanoTime();
                tree.balance();
                endTime = System.nanoTime();
            }
            case SEARCHING -> {
                startTime = System.nanoTime();
                tree.search(120);
                endTime = System.nanoTime();
            }
            case DELETION -> {
                startTime = System.nanoTime();
                tree.delete(12);
                endTime = System.nanoTime();
            }

            default -> {
                startTime = -1;
                endTime = 0;
            }
        }

        return endTime-startTime;
    }
}
