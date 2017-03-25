package Assignment.Product_System;

import java.util.*;


/**
 * Created by dinhtungtp on 3/3/2017.
 */
public class Product
{
    private String pcode, proName;
    private int quantity, saled;
    private double price;
    private Product leftChild, rightChild;
    private boolean isDeleted = false;

    public Product(String pcode, String proName, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.proName = proName;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public String getProName() {
        return proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSaled() {
        return saled;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Product getLeftChild() {
        return leftChild;
    }

    public Product getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Product leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Product rightChild) {

        this.rightChild = rightChild;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void insert(Product newProduct) {
        if (newProduct.saled >= this.saled){
            if (this.rightChild == null){
                this.rightChild = newProduct;
            } else {
                this.rightChild.insert(newProduct);
            }
        } else {
            if (this.leftChild == null){
                this.leftChild = newProduct;
            } else {
                this.leftChild.insert(newProduct);
            }
        }
    }

    public void inOrderTraverse() {
        if (this.leftChild != null){
            this.leftChild.inOrderTraverse();
        }
        if (!this.isDeleted){
            System.out.println(this);
        }
        if (this.rightChild != null){
            this.rightChild.inOrderTraverse();
        }
    }

    public boolean isExist(String pcode) {
        boolean found = false;
        ProductQueue queue = new ProductQueue();

        // initiate the queue
        queue.push(this);

        // start process
        while (!queue.isEmpty()) {
            Product current = queue.front();
            if (!current.isDeleted && current.pcode.equals(pcode)){
                found = true;
                break;
            }
            if (current.leftChild != null) {
                queue.push(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.push(current.rightChild);
            }
            // remove the front element
            queue.pop();
        }
        return found;
    }

    public void search(String pcode) {
        if (this.pcode.equals(pcode) && !this.isDeleted) {
            System.out.println(this);
        }
        if (this.leftChild != null) {
            this.leftChild.search(pcode);
        }
        if (this.rightChild != null) {
            this.rightChild.search(pcode);
        }
    }

    public void delete(String pcode) {
        if (this.pcode.equals(pcode) && !this.isDeleted){
            this.isDeleted = true;
            System.out.println("Product has been deleted");
        }
        if (this.leftChild != null) {
            this.leftChild.delete(pcode);
        }
        if (this.rightChild != null) {
            this.rightChild.delete(pcode);
        }
    }

    public void breadthFirstTraverse() {
        ProductQueue queue = new ProductQueue();
        // initiate the queue
        queue.push(this);

        // start process
        while (!queue.isEmpty()) {
            Product current = queue.front();
            if (!current.isDeleted){
                System.out.println(current);
            }
            if (current.leftChild != null) {
                queue.push(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.push(current.rightChild);
            }
            // remove the front element
            queue.pop();
        }
    }

    public ArrayList<Product> convertToArray() {
        ArrayList<Product> proArrayList = new ArrayList<>();
        ProductQueue queue = new ProductQueue();

        // initiate the queue
        queue.push(this);

        // start process
        while (!queue.isEmpty()) {
            Product current = queue.front();
            if (!current.isDeleted){
                proArrayList.add(current);
            }
            if (current.leftChild != null) {
                queue.push(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.push(current.rightChild);
            }
            // remove the front element
            queue.pop();
        }

        return proArrayList;
    }

    @Override
    public String toString(){
        return this.pcode + " | " + this.proName + " | " + this.quantity +
                " | " + this.saled + " | " + this.price;
    }
}
