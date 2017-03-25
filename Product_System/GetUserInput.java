package Assignment.Product_System;

/**
 * Created by dinhtungtp on 3/7/2017.
 */
public class GetUserInput
{
    public Product getProductData() {
        String pcode, proName;
        int quantity, saled;
        double price;
        Product newProduct;

        System.out.println("Product Code?");
        pcode = RunProductMS.scanner.next();

        // check product code
        if (RunProductMS.pt.isExist(pcode)) {
            return null;
        } else {

            System.out.println("Product name?");
            proName = RunProductMS.scanner.next();

            System.out.println("Product initial quantity?");
            quantity = RunProductMS.scanner.nextInt();

            // get number of product saled <= quantity
            do {
                System.out.println("Product saled (saled <= quantity)?");
                saled = RunProductMS.scanner.nextInt();
            } while (saled>quantity);

            System.out.println("Product price?");
            price = RunProductMS.scanner.nextDouble();

            newProduct = new Product(pcode, proName, quantity, saled, price);
            return newProduct;
        }

    }

    public int getUserSelection() {
        int selection;
        System.out.println("Choose an appropriate selection (1-7)?");
        while (!RunProductMS.scanner.hasNextInt()) {
            System.out.println("Choose an appropriate selection (1-7)?");
            RunProductMS.scanner.next();
        }
        selection = RunProductMS.scanner.nextInt();
        return selection;
    }

    public void getInstruction() {
        System.out.println("Welcome to Product Management System");

        // list of actions
        System.out.println("1. Input & insert data");
        System.out.println("2. In-order traverse");
        System.out.println("3. Breadth-first traverse");
        System.out.println("4. Search by pcode");
        System.out.println("5. Delete by pcode");
        System.out.println("6. Simple balancing");
        System.out.println("7. Count number of products");
    }
}
