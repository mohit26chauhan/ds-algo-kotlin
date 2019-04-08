package ds.sorting

import java.util.*

class QuickSort {

    /**
     * It is a divide and conquer algorithm.
     * Pick an item as pivot from array. Compare it with rest of the elements.
     * While iterating, if item is less or equal to pivot then swap it with
     * consecutive elements starting from start position.
     * After iteration, swap pivot item to it's right position in the array
     * which is next to last swapped position in the array
     *
     * Time Complexity - O(n^2)
     */
    private fun partition(itemArray: IntArray, start: Int, end: Int): Int {
        val pivot = itemArray[end]
        var index = start
        for (j in start until end) {
            if (itemArray[j] <= pivot)
                swap(itemArray, index++, j)
        }

        swap(itemArray, index, end)
        println(Arrays.toString(itemArray))

        return index
    }

    fun sort(itemArray: IntArray, start: Int, end: Int) {
        if (start < end) {
            val pivotIndex = this.partition(itemArray, start, end)
            sort(itemArray, start, pivotIndex - 1)
            sort(itemArray, pivotIndex + 1, end)
        }
    }

    private fun swap(itemArray: IntArray, index1: Int, index2: Int) {
        if (index1 == index2)
            return

        itemArray[index1] = itemArray[index1] + itemArray[index2]
        itemArray[index2] = itemArray[index1] - itemArray[index2]
        itemArray[index1] = itemArray[index1] - itemArray[index2]
    }
}

fun main(args: Array<String>) {
    val itemArray = intArrayOf(9, 7, 5, 11, 12, 2, 14, 3, 10, 6)
    println(Arrays.toString(itemArray))
    QuickSort().sort(itemArray, 0, itemArray.size - 1)
    println(Arrays.toString(itemArray))
}
