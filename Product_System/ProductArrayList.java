package Assignment.Product_System;

import java.util.ArrayList;

/**
 * Created by dinhtungtp on 3/5/2017.
 */
public class ProductArrayList
{
    // Convert ArrayList to Balance Tree
    // Source: https://www.youtube.com/watch?time_continue=398&v=VCTP81Ij-EM
    public Product convertAtoBTree(ArrayList<Product> proArrayL, int start, int end) {
        if (start>end){
            return null;
        }
        int middle = (start+end) / 2;
        Product node = proArrayL.get(middle);
        node.setLeftChild(convertAtoBTree(proArrayL, start, middle-1));
        node.setRightChild(convertAtoBTree(proArrayL, middle + 1, end));

        return node;
    }

    // Merge Sort an Array
    public ArrayList<Product> sortAList(ArrayList<Product> proArrayL, int start, int end) {
        if (start < end){
            int middle = (start+end)/2;
            sortAList(proArrayL, start, middle);
            sortAList(proArrayL, middle+1, end);
            merge(proArrayL, start, middle, end);
        }
        return proArrayL;
    }

    private void merge(ArrayList<Product> proArrayL, int start, int middle, int end) {
        // Create 2 temporary array lists
        ArrayList<Product> leftSide = new ArrayList<>();
        ArrayList<Product> rightSide = new ArrayList<>();
        int lengthOfLeftSide = middle - start + 1;
        int lengthOfRightSide = end - middle;

        // Copy value of original array list to temp array
        for (int i = 0; i < lengthOfLeftSide; i++) {
            leftSide.add(proArrayL.get(start + i));
        }
        for (int j = 0; j < lengthOfRightSide; j++) {
            rightSide.add(proArrayL.get(middle + 1 + j));
        }

        // Arrange value in temp array to the origin array
        int i=0, j=0;
        for (int k = start; k <= end; k++) {
            if (i == leftSide.size()){
                proArrayL.set(k, rightSide.get(j));
                j++;
            } else if (j == rightSide.size()){
                proArrayL.set(k, leftSide.get(i));
                i++;
            } else if (leftSide.get(i).getSaled() <= rightSide.get(j).getSaled()){
                proArrayL.set(k, leftSide.get(i));
                i++;
            } else {
                proArrayL.set(k, rightSide.get(j));
                j++;
            }

        }
    }
}
