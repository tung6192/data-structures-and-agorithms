package Assignment.Product_System;

import java.util.ArrayList;

/**
 * Created by dinhtungtp on 3/3/2017.
 */

public class ProductTree {
    Product root;

    public void insert(Product newProduct) {
        if (root == null || root.isDeleted()) {
            root = newProduct;
        } else {
            root.insert(newProduct);
        }
    }

    public void inOrderTraverse() {
        if (root == null || root.isDeleted()) {
            System.out.println("List of Product is empty");
        } else {
            root.inOrderTraverse();
        }
    }

    public void breathFirstTraverse() {

        if (root == null || root.isDeleted()) {
            System.out.println("List of Product is empty");
        } else {
            root.breadthFirstTraverse();
        }
    }

    public boolean isExist(String pcode) {
        if (root == null || root.isDeleted()) {
            return false;
        } else {
            return root.isExist(pcode);
        }
    }

    public void search(String pcode) {
        if (root == null || root.isDeleted()) {
            System.out.println("List of Product is empty");
        } else {
            root.search(pcode);
        }
    }

    public void delete(String pcode) {
        if (root == null || root.isDeleted()) {
            System.out.println("List of Product is empty");
        } else {
            root.delete(pcode);
        }
    }

    public void createBTree() {
        if (root == null || root.isDeleted()) {
            System.out.println("List of Product is empty");
        } else {
            // convert current Tree to Array
            ArrayList<Product> rawArrayL, sortedArrayL;
            ProductArrayList arrayF = new ProductArrayList();
            // convert to array
            rawArrayL = root.convertToArray();

            // sort the array
            sortedArrayL = arrayF.sortAList(rawArrayL, 0, rawArrayL.size()-1);

            // create Balance Tree
            root = arrayF.convertAtoBTree(sortedArrayL, 0, sortedArrayL.size()-1);
        }
    }

    public int countProduct() {
        if (root == null) {
            System.out.println("List of Product is empty");
            return 0;
        } else {

            // convert current Tree to Array
            ArrayList<Product> proArrayL;
            proArrayL = root.convertToArray();
            return proArrayL.size();
        }
    }
}
