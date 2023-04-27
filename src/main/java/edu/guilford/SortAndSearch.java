package edu.guilford;

public class SortAndSearch {
    // Add a static selectionSort method that takes an array of integers as a
    // parameter
    // and sorts the array using the selection sort algorithm
    public static void selectionSort(int[] array) {
        // Loop over all elements in the array and find the smallest one
        // Note it's a counting loop and a for loop is effective
        for (int i = 0; i < array.length; i++) {
            // Assume the smallest element is the first element
            int smallest = i; // keeping track of the index of the smallest element
            // not its value
            // Loop over all elements after the first element
            // End of the array has i = array.length - 1
            // j would start at array.length, which is not less than array.length
            // the next loop won't do anything for the last element
            for (int j = i + 1; j < array.length; j++) {
                // If the current element is smaller than the smallest element
                if (array[j] < array[smallest]) {
                    // Set the smallest element to the current element
                    smallest = j;
                }
            }
            // Swap the smallest element with the first element
            swap(array, i, smallest);
        }

    }

    // Add a static quickSort method that takes an array of integers as a
    // parameter and sorts the array using the quick sort algorithm
    public static void quickSort(int[] array) {
        // Call the recursive quickSort method
        quickSort(array, 0, array.length - 1);
    }

    // Add a static quickSort method that takes an array of integers as a
    // parameter and sorts the array using the quick sort algorithm
    // This method is recursive
    public static void quickSort(int[] array, int start, int end) {
        // If the start index is less than the end index
        if (start < end) {
            // Call the partition method to partition the array
            int partitionIndex = partition(array, start, end);
            // Call the quickSort method on the left partition
            quickSort(array, start, partitionIndex - 1);
            // Call the quickSort method on the right partition
            quickSort(array, partitionIndex + 1, end);
        }
    }

    // Add a static partition method that takes an array of integers as a
    // parameter and partitions the array using the quick sort algorithm
    public static int partition(int[] array, int start, int end) {
        // Set the pivot to the last element in the array
        int pivot = array[end];
        // Set the partition index to the start index
        int partitionIndex = start;
        // Loop over all elements in the array
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot
            if (array[i] < pivot) {
                // Swap the current element with the element at the partition index
                swap(array, i, partitionIndex);
                // Increment the partition index
                partitionIndex++;
            }
        }
        // Swap the element at the partition index with the pivot
        swap(array, partitionIndex, end);
        // Return the partition index
        return partitionIndex;
    }

    // Let's create a method that swaps two elements in an array
    public static void swap(int[] array, int i, int j) {
        // Create a temporary variable to hold the value of array[i]
        int temp = array[i];
        // Set array[i] to the value of array[j]
        array[i] = array[j];
        // Set array[j] to the value of the temporary variable
        array[j] = temp;
    }

    // Add a linear or sequential search algorithm
    public static int linearSearch(int[] array, int target) {
        // Loop over all elements in the array
        // We're going to go through each element one at a time and stop when we find
        // what we're looking
        for (int i = 0; i < array.length; i++) {
            // If the current element is equal to the target
            if (array[i] == target) {
                // Return the index of the current element
                return i;
            }
        }
        // Return -1 if the target is not found (we get to the end of the array and we can't
        // find it)
        return -1;
    }

    // Add a binary search algorithm
    public static int binarySearch(int[] array, int target) {
        // Set the start index to 0
        int start = 0;
        // Set the end index to the last index in the array
        int end = array.length - 1;
        // Loop over all elements in the array
        while (start <= end) {
            // Set the middle index to the average of the start and end indices
            int middle = (start + end) / 2;
            // If the current element is equal to the target
            if (array[middle] == target) {
                // Return the index of the current element
                return middle;
            }
            // If the current element is less than the target
            if (array[middle] < target) {
                // Set the start index to the middle index plus one
                start = middle + 1;
            } else {
                // Set the end index to the middle index minus one
                end = middle - 1;
            }
        }
        // Return -1 if the target is not found (we get to the end of the array and we can't
        // find it)
        return -1;
    }

}
