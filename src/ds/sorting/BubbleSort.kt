package ds.sorting

import java.util.*

class BubbleSort {

    /**
     * Putting highest item in array at end in every iteration of inner loop
     * Bubble Sort - Like a water bubble rises up to the top of water surface
     *
     * (index + 1) in inner loop - because we are comparing current item with next item
     *
     * (size - 1) in outer loop - because when putting (n - 1) item to end,
     * remaining one item is the smallest
     *
     * swapped - Used for OPTIMIZATION
     * ADVANTAGE - if there are no elements to be swapped then array has already been sorted
     *
     * Time Complexity - O(n^2) - we are iterating n*n times
     */
    fun sort(itemArray: IntArray) {
        for (index in 0 until itemArray.size - 1) {
            var swapped = false
            for (index2 in 0 until itemArray.size - (index + 1)) {
                if (itemArray[index2] > itemArray[index2 + 1]) {    // Swap
                    swapped = true
                    swap(itemArray, index2, index2 + 1)
                }
            }

            println(Arrays.toString(itemArray))
            if (!swapped)
                break
        }
    }

    /**
     * (size == 1) - when putting (n - 1) item to end,
     * remaining one item is the smallest
     */
    fun sortUsingRecursion(itemArray: IntArray, size: Int) {
        if (size == 1)
            return

        var swapped = false
        for (index in 0 until size - 1) {
            if (itemArray[index] > itemArray[index + 1]) {
                swapped = true
                swap(itemArray, index, index + 1)
            }
        }

        println(Arrays.toString(itemArray))
        sortUsingRecursion(itemArray, if (swapped) size - 1 else 1)
    }

    private fun swap(itemArray: IntArray, index1: Int, index2: Int) {
        itemArray[index1] = itemArray[index1] + itemArray[index2]
        itemArray[index2] = itemArray[index1] - itemArray[index2]
        itemArray[index1] = itemArray[index1] - itemArray[index2]
    }
}

fun main(args: Array<String>) {
    val itemArray = intArrayOf(5, 6, 2, 4, 3, 1)
//    BubbleSort().sort(itemArray)
    BubbleSort().sortUsingRecursion(itemArray, itemArray.size)
}