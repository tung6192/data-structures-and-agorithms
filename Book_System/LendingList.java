package Assignment.Book_System;

/**
 * Created by dinhtungtp on 3/3/2017.
 */
public class LendingList
{
    static Lending front;
    static Lending rear;


    public static void enqueue(Lending newLending) {
        if (front == null){
            front = newLending;
            rear = newLending;
            System.out.println("Data has been added successfully");
        } else {
            rear.setNextNode(newLending);
            rear = rear.getNextNode();
        }
    }

    public static void displayData() {
        if (LendingList.front != null) {
            System.out.println("BCode | RCode | State ");
            System.out.println("--------------------- ");

            // show lending information
            Lending current = front;
            while (current != null) {
                System.out.println(current);
                current = current.getNextNode();
            }
        } else {
            System.out.println("There is no reader in the system");
        }
    }
}
