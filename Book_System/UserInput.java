package Assignment.Book_System;

import java.util.Scanner;

/**
 * Created by dinhtungtp on 3/7/2017.
 */
public class UserInput
{
    public Lending askLendingInfo() {
        String bcode, rcode;
        int state;
        Lending newLending;

        // Get book code
        System.out.println("Book code?");
        bcode = RunLMS.scanner.next();
        if (!BookList.isExisted(bcode)){
            System.out.println("Book code doesn't exist in the system");
            return null;
        }

        // Get reader code
        System.out.println("Reader code?");
        rcode = RunLMS.scanner.next();
        if (!ReaderList.isExisted(rcode)){
            System.out.println("Reader code doesn't exit in the system");
            return null;
        }

        // Get State
        do {
            System.out.println("State (0 - haven't delivered, 1 - haven't returned , 2 - received )?");
            state = RunLMS.scanner.nextInt();
        } while (state<0 || state>2);

        newLending = new Lending(bcode, rcode, state);
        return newLending;

    }

    public Reader askReaderInfo() {
        String rcode, name;
        int byear;

        // get reader code
        System.out.println("Reader code?");
        rcode = RunLMS.scanner.next();

        // if code exists
        if (ReaderList.isExisted(rcode)){
            System.out.println("The code exists in the system");
            return null;
        } else {
            // get reader name
            System.out.println("Reader name?");
            name = RunLMS.scanner.next();
            // get reader birth year
            do {
                System.out.println("Reader birth year (1900 - 2010)? ");
                byear = RunLMS.scanner.nextInt();
            } while (byear < 1900 || byear > 2010);
            Reader newReader = new Reader(rcode, name, byear);
            return newReader;
        }
    }

    public Book askBookInfo() {
        String bcode, title;
        int quantity, lended;
        long price;

        System.out.println("Add a book to the system");
        System.out.println("Book code?");
        bcode = RunLMS.scanner.next();

        // if the code exits
        if (BookList.isExisted(bcode) == true) {
            System.out.println("Book code exits in the system");
            return null;
        } else {

            System.out.println("Book Title?");
            title = RunLMS.scanner.next();

            System.out.println("Book Quantity?");
            quantity = RunLMS.scanner.nextInt();

            // get number of book lended
            do {
                System.out.println("Book Lended? Book Lended <= Book Quantity");
                lended = RunLMS.scanner.nextInt();
            } while (lended>quantity);
            System.out.println("Book Price?");
            price = RunLMS.scanner.nextLong();
        }

        Book newBook = new Book(bcode, title, quantity, lended, price);
        return newBook;
    }

    public int[] getUserRequest() {
        String action;
        String[] stringAction;
        System.out.println("Choose your action (example: 3.2): ");
        RunLMS.scanner = new Scanner(System.in);
        action = RunLMS.scanner.next();

        // convert input to string array then to integer array
        stringAction = action.split("\\.");
        for (int i = 0; i < RunLMS.targetAction.length; i++) {
            RunLMS.targetAction[i] = Integer.parseInt(stringAction[i]);
        }
        return RunLMS.targetAction;
    }

    public void setUpInstruction() {
        // Book list
        System.out.println("1. Book list");
        System.out.println("\t1.1. Input & add to the end");
        System.out.println("\t1.2. Display data");
        System.out.println("\t1.3. Search by bcode");
        System.out.println("\t1.4. Input & add to beginning");
        System.out.println("\t1.5. Add after position k");
        System.out.println("\t1.6. Delete position k");

        // Reader list
        System.out.println("2. Reader list");
        System.out.println("\t2.1. Add reader");
        System.out.println("\t2.2. Display data");
        System.out.println("\t2.3. Search by rcode");
        System.out.println("\t2.4. Delete by rcode");

        // Lending list
        System.out.println("3. Lending list");
        System.out.println("\t3.1. Input data");
        System.out.println("\t3.2. Display data");

    }
}
