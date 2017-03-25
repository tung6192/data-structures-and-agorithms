package Assignment.Product_System;

import java.util.Scanner;

/**
 * Created by dinhtungtp on 3/3/2017.
 */
public class RunProductMS {
    static Scanner scanner = new Scanner(System.in);
    static ProductTree pt = new ProductTree();

    public static void main(String[] args) {
        int selection = 0;
        String cont = "y";
        String pcode;

        // Testing information
        pt.insert(new Product("p01", "Test1", 200, 10, 15));
        pt.insert(new Product("p06", "Test6", 200, 5, 15));
        pt.insert(new Product("p02", "Test2", 200, 2, 15));
        pt.insert(new Product("p03", "Test3", 200, 15, 15));
        pt.insert(new Product("p04", "Test4", 200, 14, 15));
        pt.insert(new Product("p05", "Test5", 200, 17, 15));

        // Start program
        GetUserInput userInput = new GetUserInput();

        while (!cont.equals("n")) {
            userInput.getInstruction();
            selection = userInput.getUserSelection();
            switch (selection) {
                case 1:
                    System.out.println("1. Input & insert data");
                    Product newProduct = userInput.getProductData();
                    if (newProduct != null){
                        pt.insert(newProduct);
                    } else {
                        System.out.println("Product code exists in the system");
                    }
                    break;

                case 2:
                    System.out.println("2. In-order traverse");
                    System.out.println("Code | Name | Quantity | Saled | Price");
                    System.out.println("--------------------------------------");
                    pt.inOrderTraverse();
                    break;

                case 3:
                    System.out.println("3. Breadth-first traverse");
                    System.out.println("Code | Name | Quantity | Saled | Price");
                    System.out.println("--------------------------------------");
                    pt.breathFirstTraverse();
                    break;

                case 4:
                    System.out.println("4. Search by pcode");
                    System.out.println("Product Code you want to search");
                    pcode = scanner.next();
                    // Show results
                    System.out.println("Code | Name | Quantity | Saled | Price");
                    System.out.println("--------------------------------------");
                    if (pt.isExist(pcode)){
                        pt.search(pcode);
                    } else {
                        System.out.println("The code doesn't match any item");
                    }
                    break;

                case 5:
                    System.out.println("5. Delete by pcode");
                    System.out.println("Product Code you want to delete");
                    pcode = scanner.next();

                    // Check if exist
                    if (pt.isExist(pcode)){
                        pt.delete(pcode);
                    } else {
                        System.out.println("The code doesn't match any item");
                    }
                    break;

                case 6:
                    System.out.println("6. Simple balancing");
                    // create balance Tree
                    pt.createBTree();
                    // show balance tree
                    System.out.println("Code | Name | Quantity | Saled | Price");
                    System.out.println("--------------------------------------");
                    pt.inOrderTraverse();
                    System.out.println("Tree has been converted to balance tree");
                    break;

                case 7:
                    System.out.println("7. Count number of products");
                    System.out.println("Number of products is: " + pt.countProduct());
                    break;

                default:
                    System.out.println("There is no such command in the system");
            }
            System.out.println("Would you like to continue (y/n)?");
            cont = scanner.next();
        }

        scanner.close();
    }
}
