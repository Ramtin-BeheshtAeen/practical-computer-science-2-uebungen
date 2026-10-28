// int this version the high elemnt is included

// QUICKSORT – summary
//
// quicksort(array, low, high):
//   if low >= high: stop (0 or 1 element → already sorted)
//   pivotIndex = partition(array, low, high)    // pivot is now in its final place
//   quicksort on low .. pivotIndex - 1          // left part (all ≤ pivot)
//   quicksort on pivotIndex + 1 .. high         // right part (all > pivot)
//   pivot itself is excluded → every call gets a smaller range → recursion ends
//
// partition(array, low, high):
//   pivot = array[high]                         // last element as pivot
//   i = low                                     // zone low..i-1 = elements ≤ pivot (empty at start)
//   j goes from low to high - 1                 // whole range except the pivot
//     if array[j] <= pivot:
//       swap i and j                            // put the small element into the zone
//       i++                                     // zone grows by one
//   swap i and high                             // pivot goes right after the zone
//   return i                                    // pivot's final index
//
// After partition: left of pivot all ≤ pivot, right of pivot all > pivot.
// Start with: quicksort(array, 0, array.length - 1)
// Cost: average O(n log n), worst O(n²) (e.g. already sorted + last-element pivot), in place.

package de.uni_bremen.pi2;

public class MyQuickSort {
    public <E> void swap(final E[] array, final int a, final int b){
        E temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public <E extends Comparable<E>> int partition(E[] array, int low, int high){
        int i = low;
        E pivotElement = array[high];
        for(int j = low;  j < high; j++){
            if(array[j].compareTo(pivotElement) < 0){
                swap(array, i , j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
    }

    public  <E extends Comparable<E>> void quicksort(E[] array, int low, int high){
        if (low >= high){
            return;
        }
        int pivot = partition(array, low, high);
        quicksort(array, 0 , pivot - 1);
        quicksort(array, pivot + 1, high);
    }

    public void main(){
        // make an array with 4 element inside:
        Integer[] myArray = {4,1,3,2};
        Integer[] myArray2 = {40,10,30,20};

        quicksort(myArray, 0, myArray.length - 1);

        for (Integer integer : myArray) {
            System.out.print(integer + ", ");
        }

        System.out.print("\n");

        //quicksortHighNotInclusive(myArray2, 0, myArray2.length);
        for (Integer integer : myArray2) {
            System.out.print(integer + ", ");
        }

    }
}
