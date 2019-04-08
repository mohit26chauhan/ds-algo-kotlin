package ds.sorting

import java.util.*

class MergeSort {

    /**
     * Break array into sub-arrays of half of size until we get sub-arrays of size 1
     * Then take 2 sub-arrays and create one sorted array
     * Repeat this process until we get our final sorted array
     *
     * Time Complexity - O(n * log n)
     * Space Complexity - O(n)
     */
    fun sort(itemArray: IntArray, start: Int, end: Int) {
        if (start < end) {
            val mid = (start + end) / 2
            sort(itemArray, start, mid)
            sort(itemArray, mid + 1, end)
            merge(itemArray, start, mid, end)
        }
    }

    private fun merge(itemArray: IntArray, start: Int, mid: Int, end: Int) {
        // Find sizes of two sub arrays to be merged
        val size1 = mid - start + 1
        val size2 = end - mid

        //  Create temp arrays
        val array1 = IntArray(size1)
        val array2 = IntArray(size2)

        //  Copy data to temp arrays
        for (index in 0 until size1)
            array1[index] = itemArray[start + index]
        for (index in 0 until size2)
            array2[index] = itemArray[mid + 1 + index]

        //  Merge temp arrays

        //  Initial index of first and second sub arrays
        var i = 0
        var j = 0

        //  Initial index for final (merged) sub array
        var k = start

        while (i < size1 && j < size2) {
            if (array1[i] < array2[j])
                itemArray[k++] = array1[i++]
            else
                itemArray[k++] = array2[j++]
        }

        //  Copy remaining items of array1
        while (i < size1)
            itemArray[k++] = array1[i++]

        //  Copy remaining items of array2
        while (j < size2)
            itemArray[k++] = array2[j++]

        println("Array 1 : " + Arrays.toString(array1))
        println("Array 2 : " + Arrays.toString(array2))
        println(Arrays.toString(itemArray))
    }
}

fun main(args: Array<String>) {
    val itemArray = intArrayOf(6, 3, 1, 9, 4)
    MergeSort().sort(itemArray, 0, itemArray.size - 1)
}
