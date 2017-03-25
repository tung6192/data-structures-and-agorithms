package Assignment.Book_System;

/**
 * Created by dinhtungtp on 3/3/2017.
 */
public class ReaderList
{
    static Reader top;

    public static void push(Reader newReader) {
        if (top == null) {
            top = newReader;
        } else {
            newReader.setNextNode(top);
            top = newReader;
        }
    }

    public static int length() {
        int length = 0;
        Reader current = top;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public static void displayData() {
        if (ReaderList.top != null) {
            System.out.println("code | Name        | Birth Year");
            System.out.println("-------------------------------");

            // get reader information
            Reader current = top;
            while (current != null) {
                System.out.println(current);
                current = current.getNextNode();
            }
        } else {
            System.out.println("There is no reader in the system");
        }
    }

    public static void search(String rcode) {
        Reader current = top;
        boolean isFound = false;
        while (current != null){
            if (current.getRcode().equals(rcode)) {
                System.out.println("code | Name        | Birth Year");
                System.out.println("-------------------------------");

                // show reader information
                System.out.println(current);
                isFound = true;
                break;
            } else {
                current = current.getNextNode();
            }
        }
        if (isFound == false){
            System.out.println("Reader not found");
        }
    }

    public static void delete(String rcode) {
        boolean isFound = false;
        // check if deleting the top node
        if (top.getRcode().equals(rcode)){
            top = top.getNextNode();
            System.out.println("Data has been deleted successfully");
        } else {
            Reader current = top;
            Reader nextNode = current.getNextNode();
            while (nextNode != null){
                // check if next node need to be deleted
                if (nextNode.getRcode().equals(rcode)){
                    current.setNextNode(nextNode.getNextNode());
                    isFound = true;
                    break;
                } else {
                    current = current.getNextNode();
                    nextNode = nextNode.getNextNode();
                }
            }
            if (isFound == false){
                System.out.println("The rcode doesn't exist in the system");
            }
        }
    }

    public static boolean isExisted(String rcode) {
        Reader current = top;
        while (current != null){
            if (current.getRcode().equals(rcode)){
                return true;
            } else {
                current = current.getNextNode();

            }
        }
        return false;
    }
}
