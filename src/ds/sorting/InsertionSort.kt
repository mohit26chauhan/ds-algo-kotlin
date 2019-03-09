package ds.sorting

import java.util.*

class InsertionSort {

    /**
     * Inserting a new item in sorted array at appropriate position
     * For new item - start iteration from 2nd item i.e. index 1
     * For sorted array - we have sub array from 0 to (index - 1) in the iteration
     *
     * So, we pick an item from array at index, compare it with the elements from it's left side in the array
     * If we found any item greater then picked item, we swap. Do it until 0th item and found true during comparison
     *
     * itemArray[index2 - 1] > itemArray[index2] - If comparison gives false
     * then all items to left are less than the picked item
     *
     * Time Complexity - O(n*n) - we are iterating n*n times
     * Space Complexity - O(1)
     */
    fun sort(itemArray: IntArray) {
        for (index in 1 until itemArray.size) {
            var index2 = index
            while (index2 > 0 && itemArray[index2 - 1] > itemArray[index2]) {
                swap(itemArray, index2, index2 - 1)
                index2--
            }

            println(Arrays.toString(itemArray))
        }
    }

    private fun swap(itemArray: IntArray, index1: Int, index2: Int) {
        itemArray[index1] = itemArray[index1] + itemArray[index2]
        itemArray[index2] = itemArray[index1] - itemArray[index2]
        itemArray[index1] = itemArray[index1] - itemArray[index2]
    }
}

fun main(args: Array<String>) {
    val itemArray = intArrayOf(6, 5, 1, 2, 4, 3)
    InsertionSort().sort(itemArray)
}
