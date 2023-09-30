package com.mycompany;
public class Sort {
    public void printArray(int[] arr) {
        int size = arr.length;
        int i;
        System.out.println("Array ordenado:");
        System.out.print("[");
        for (i = 0; i < size; i++)
            System.out.print(" "+arr[i]);
        System.out.print(" ]");
        System.out.println();
    }

    public void bubble(int[] arr){
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    public void selection(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i+1; j < arr.length; j++){
                if ( arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public void insertion(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > temp){
                arr[j+1] =arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
