/*
  Name: Nick Griffith
  Period: 6
  Date: 12/16/25
  Class Name: Computer Programming 3
  Description: Test program for stacks and queues.
*/

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class StackQueueMini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // PART 1

        Stack<Integer> stack = new Stack<>();
        System.out.println("PART 1: Enter 5 whole numbers for the stack:");
        for (int i = 0; i < 5; i++)
            stack.push(input.nextInt());

        Queue<Integer> helperQueue = new LinkedList<>(); // Auxiliary queue
        while (!stack.isEmpty())
            helperQueue.add(stack.pop());

        // Double up values from queue into original stack
        while (!helperQueue.isEmpty()) { 
            int value = helperQueue.remove();
            stack.push(value);
            stack.push(value);
        } // end for

        System.out.println("\nPART 1 RESULT - Stack contents (bottom to top):");
        System.out.println(stack);

        // PART 2

        Queue<Integer> queue = new LinkedList<>();

        System.out.println("\nPART 2: Enter 10 whole numbers for the queue:");
        for (int i = 0; i < 10; i++)
            queue.add(input.nextInt());

        Queue<Integer> evenQueue = new LinkedList<>(); // Auxiliary queue
        int size = queue.size();

        // Separate queues into even and odd
        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            if (value % 2 == 0)
                evenQueue.add(value);
            else queue.add(value);
        } // end for

        // Combine the two, putting odds after evens
        while (!queue.isEmpty())
            evenQueue.add(queue.remove());

        // Move back to original queue
        queue = evenQueue;

        System.out.println("\nPART 2 RESULT - Queue contents (front to back):");
        System.out.println(queue);

        input.close();
    } // end main
} // end class