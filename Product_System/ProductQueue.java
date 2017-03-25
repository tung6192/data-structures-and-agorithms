package Assignment.Product_System;

import java.util.ArrayList;

// Using Product Queue for Breadth First Traverse
public class ProductQueue
{
    int front = 0;
    int rear;
    ArrayList<Product> queue = new ArrayList<>();


    public void push(Product node) {
        if (queue.size() == 0){
            rear = 0;
            queue.add(node);
        } else {
            rear += 1;
            queue.add(node);
        }
    }

    public boolean isEmpty() {
        if (queue.size() == 0){
            return true;
        } else {
            return false;
        }
    }

    public Product pop() {
        if (queue.size() == 0){
            System.out.println("There is no element in the queue");
            return null;
        } else {
            rear -= 1;
            return queue.remove(front);
        }
    }

    public Product front() {
        return queue.get(front);
    }
}
