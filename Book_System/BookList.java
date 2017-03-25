package Assignment.Book_System;

/**
 * Created by dinhtungtp on 3/2/2017.
 */
public class BookList
{
    static Book head;

    public static boolean isExisted(String bcode) {
        if (head == null){
            return false;
        } else {
            Book current = head;
            while (current != null){
                if (current.getBcode().equals(bcode)){
                    return true;
                } else {
                    current = current.getNextNode();
                }
            }
            return false;
        }
    }

    public static void insertAtTheEnd(Book newBook) {
        if (head == null){
            head = newBook;
        } else {
            Book current = head;
            while (current.nextNode != null){
                current = current.getNextNode();
            }
            current.setNextNode(newBook);
        }
    }

    public static void insertAtTheHead(Book newBook) {
        if (head == null){
            head = newBook;
        } else {
            newBook.setNextNode(head);
            head = newBook;
        }
    }

    public static void displayData() {
        // check if any book exists
        if (BookList.head != null){
            System.out.println("code | Title        | Quantity | Lended | Price | Value");
            System.out.println("-------------------------------------------------------");
            Book current = head;

            // get book information
            while (current != null) {
                System.out.println(current);
                current = current.getNextNode();
            }
        } else {
            System.out.println("There is no book in the system");
        }
    }

    public static Book search(String bcode) {
        Book current = head;
        while (current != null){
            if (current.getBcode().equals(bcode)) {
                System.out.println("code | Title        | Quantity | Lended | Price | Value");
                System.out.println("-------------------------------------------------------");

                // get book information
                System.out.println(current);
                return current;
            } else {
                current = current.getNextNode();
            }
        }
        System.out.println("Book not found");
        return null;
    }

    public static void deletePositionK(int k) {
        int count = 0;
        Book current = head;

        // delete at the head
        if (k == 0){
            head = current.getNextNode();
            System.out.printf("Data has been deleted successfully");
        } else {
            while (current != null){
                // parent of element K is K-1
                if (count == k-1){
                    // check existence of element K
                    if (current.nextNode != null){
                        current.setNextNode(current.getNextNode().getNextNode());
                        System.out.println("Data has been deleted successfully");
                    }
                } else {
                    current = current.getNextNode();
                    count++;
                }
            }
        }

    }

    public static void insertAfterPositionK(int k, Book newBook) {
        int count = 0;
        Book current = head;
        while (current != null){
            // parent of element K is K-1
            if (count == k){
                newBook.setNextNode(current.getNextNode());
                current.setNextNode(newBook);
                System.out.println("Data has been inserted successfully");
                break;
            } else {
                current = current.getNextNode();
                count++;
            }
        }
    }

    public static int length() {
        int length = 0;
        Book current = head;
        while (current!= null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }


}
