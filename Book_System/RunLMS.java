package Assignment.Book_System;

import java.util.*;

/**
 * Created by dinhtungtp on 3/2/2017.
 */
public class RunLMS {
    static Scanner scanner;
    static int[] targetAction = new int[2];

    public static void main(String[] args) {
        Book newBook;
        int k; // position k
        int lengthOfBookList;
        String cont = "y";
        String bcode, rcode;
        UserInput userInput = new UserInput();

        // testing input
            BookList.insertAtTheHead(new Book("b01", "Test01", 210, 20, 200));
            BookList.insertAtTheHead(new Book("b02", "Test02", 10, 23, 210));
            BookList.insertAtTheHead(new Book("b03", "Test03", 110, 70, 300));
            BookList.insertAtTheHead(new Book("b04", "Test04", 20, 2, 209));
            BookList.insertAtTheHead(new Book("b05", "Test05", 250, 40, 20));

        // start program
        do {
            userInput.setUpInstruction();
            targetAction = userInput.getUserRequest();
            // targetAction[0] choose type of list
            if (targetAction[0] == 1){
                switch (targetAction[1]){
                    case 1:
                        System.out.println("Input & add to the end");
                        newBook = userInput.askBookInfo();
                        if (newBook != null){
                            BookList.insertAtTheEnd(newBook);
                        }
                        break;
                    case 2:
                        System.out.println("Display data");
                        BookList.displayData();
                        break;
                    case 3:
                        System.out.println("Search by bcode");
                        System.out.println("Book code you want to search");
                        bcode = scanner.next();
                        BookList.search(bcode);
                        break;
                    case 4:
                        System.out.println("Input & add to beginning");
                        newBook = userInput.askBookInfo();
                        if (newBook != null){
                            BookList.insertAtTheHead(newBook);
                        }
                        break;
                    case 5:
                        System.out.println("Add after position k");
                        System.out.println("Position k: ");
                        k = scanner.nextInt();
                        lengthOfBookList = BookList.length();
                        // position k have to < length of book list
                        if (k >= lengthOfBookList){
                            System.out.println("Don't exits position K");
                            if (lengthOfBookList == 0 ){
                                System.out.println("Book List doesn't have any item");
                            } else {
                                System.out.println("Maximum position is " + (lengthOfBookList-1));
                            }
                        } else {
                            newBook = userInput.askBookInfo();
                            if (newBook != null){
                                BookList.insertAfterPositionK(k, newBook);
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Delete position k");
                        System.out.println("Position k: ");
                        k = scanner.nextInt();
                        lengthOfBookList = BookList.length();
                        // position k have to < length of book list
                        if (k >= lengthOfBookList){
                            System.out.println("Don't exits position K");
                            if (lengthOfBookList == 0 ){
                                System.out.println("Book List doesn't have any item");
                            } else {
                                System.out.println("Maximum position is " + (lengthOfBookList-1));
                            }
                        } else {
                            BookList.deletePositionK(k);
                        }
                        break;
                    default:
                        System.out.println("There is no such command in the system");
                }
            } else if (targetAction[0] == 2){
                switch (targetAction[1]){
                    case 1:
                        System.out.println("Add reader");
                        Reader newReader = userInput.askReaderInfo();
                        if (newReader != null){
                            ReaderList.push(newReader);
                        }
                        break;
                    case 2:
                        System.out.println("Display data");
                        ReaderList.displayData();
                        break;
                    case 3:
                        System.out.println("Search by Rcode");
                        System.out.println("Code of Reader you want to check?");
                        rcode = scanner.next();
                        ReaderList.search(rcode);
                        break;
                    case 4:
                        System.out.println("Delete by Rcode");
                        System.out.println("Code of Reader you want to delete");
                        rcode = scanner.next();
                        ReaderList.delete(rcode);
                        break;
                    default:
                        System.out.println("There is no such command in the system");
                }
            } else if (targetAction[0]==3){
                switch (targetAction[1]){
                    case 1:
                        System.out.println("Input data");
                        Lending newLending = userInput.askLendingInfo();
                        if (newLending != null){
                            LendingList.enqueue(newLending);
                        }
                        break;
                    case 2:
                        System.out.println("Display data");
                        LendingList.displayData();
                        break;
                    default:
                        System.out.println("There is no such command in the system");
                }
            } else {
                System.out.println("There is no such command in the system");
            }
            System.out.println("Continue (y/n)?");
            cont = scanner.next();
        } while (!cont.equals("n"));
    }

}
