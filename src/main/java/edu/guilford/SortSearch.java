package edu.guilford;

import java.util.Arrays;
import java.util.Random;

public class SortSearch 
{
    public static void main( String[] args )
    {
        // Define two constants MAX (number of elements in array) 
        // and RANGE (range of random numbers)
        final int MAX = 40000;
        final int RANGE = 50000;
        Random rand = new Random();

        // Create an array of MAX integers with random assigned values in RANGE
        int[] array = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            array[i] = rand.nextInt(1, RANGE + 1);
        }
        //System.out.println("Original: " + Arrays.toString(array));
        // Time how long it takes to sort the array
        long startTime = System.nanoTime();
        // Sort the array using the selection sort algorithm
        SortAndSearch.selectionSort(array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Selection sort took " + (duration / 1.e6) + " milliseconds");
        //System.out.println("Sorted: " + Arrays.toString(array));
      
        // shuffle the array for the next test
        shuffle(array);
        // sort the array using quicksort
        startTime = System.nanoTime();
        SortAndSearch.quickSort(array);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick sort took " + (duration / 1.e6) + " milliseconds");
        
        shuffle(array);
        // use linear search to find a random value
        int target = rand.nextInt(1, RANGE + 1);
        startTime = System.nanoTime();
        int index = SortAndSearch.linearSearch(array, target);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Linear search took " + (duration / 1.e6) + " milliseconds");
        System.out.println("Linear search found " + target + " at index " + index);

        // To use binary search, we must have a sorted array
        // sort the array using quicksort
        SortAndSearch.quickSort(array);
        // We only have to do the sort once, and then we can do as many searches as we want
        // use binary search to find the same value as before
        startTime = System.nanoTime();
        index = SortAndSearch.binarySearch(array, target);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Binary search took " + (duration / 1.e6) + " milliseconds");
        System.out.println("Binary search found " + target + " at index " + index);

    }

    // Add a static method to shuffle the array
    public static void shuffle(int[] array) {
        // Loop over all elements in the array
        for (int i = 0; i < array.length; i++) {
            // Generate a random index between 0 and array.length - 1
            int randomIndex = (int) (Math.random() * array.length);
            // Swap the current element with the random element using the swap  method
            swap(array, i, randomIndex);
           
        }
    }

    // Add a static method to swap two elements in an array
    public static void swap(int[] array, int i, int j) {
        // Store the value of the first element in a temporary variable
        int temp = array[i];
        // Set the value of the first element to the value of the second element
        array[i] = array[j];
        // Set the value of the second element to the value of the temporary variable
        array[j] = temp;
    }

    
}
