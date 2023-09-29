package com.mycompany;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();


        int[] arr = {2,3,4,1,5};
        int[] arr2 = {123,834,94,4854,1242};


        sort.bubble(arr2);
        sort.insertion(arr);

        sort.printArray(arr);
        sort.printArray(arr2);
    }
}