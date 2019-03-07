package ds.sorting

import java.util.*

class SelectionSort {

    /**
     * Find smallest item in array and swap it with first indexed item in the array
     * Find second smallest item in array and swap it with second indexed item in the array
     * Similarly, do it for all items
     *
     * Selection Sort - Because we select smallest item every time and
     * swap it into the right place in array
     *
     * (size - 1) in outer loop - because putting (n - 1) smallest items to right place,
     * remaining one item is the largest and will be at right place
     *
     * Time Complexity - O(n^2) - We are iterating n*n times
     * Space Complexity - O(1)
     *
     * BUT - there is no optimization like [BubbleSort]
     * DISADVANTAGE - runs completely even array is already sorted
     */
    fun sort(itemArray: IntArray) {
        for (index in 0 until (itemArray.size - 1)) {
            var minValueIndex = index
            for (index2 in (index + 1) until itemArray.size)
                if (itemArray[index2] < itemArray[minValueIndex])
                    minValueIndex = index2

            if (minValueIndex != index)
                swap(itemArray, index, minValueIndex)

            println(Arrays.toString(itemArray))
        }
    }

    fun sortUsingRecursion(itemArray: IntArray, startingIndex: Int) {
        if (startingIndex == itemArray.size - 1)
            return

        var minValueIndex = startingIndex
        for (index in (startingIndex + 1) until itemArray.size)
            if (itemArray[index] < itemArray[minValueIndex])
                minValueIndex = index

        if (startingIndex != minValueIndex)
            swap(itemArray, startingIndex, minValueIndex)

        println(Arrays.toString(itemArray))
        sortUsingRecursion(itemArray, startingIndex + 1)
    }

    private fun swap(itemArray: IntArray, index1: Int, index2: Int) {
        itemArray[index1] = itemArray[index1] + itemArray[index2]
        itemArray[index2] = itemArray[index1] - itemArray[index2]
        itemArray[index1] = itemArray[index1] - itemArray[index2]
    }
}

fun main(args: Array<String>) {
    val itemArray = intArrayOf(3, 1, 2, 5, 4)
//    SelectionSort().sort(itemArray)
    SelectionSort().sortUsingRecursion(itemArray, 0)
}