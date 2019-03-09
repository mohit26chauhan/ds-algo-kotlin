package ds.searching

/**
 * Techniques of searching an element in an unsorted array
 *
 * Compare each item in array with element either from start, from end
 * or from both sides simultaneously
 *
 * If element found in array then return current position of array
 * otherwise return -1
 *
 * Use this algorithm when:
 * 1. Array is unsorted or
 * 2. Array has less items (limitation)
 *
 * Time Complexity : O(n)
 */
class LinearSearch {

    /**
     * Search by comparing every item of array from 0th (zero) position till end (n-1).
     */
    fun search(itemArray: IntArray, element: Int): Int {
        for (index in 0 until itemArray.size)
            if (element == itemArray[index])
                return index

        return -1
    }

    /**
     * Search by comparing items from start (0) and end (n-1) simultaneously in the array.
     */
    fun searchFromBothEnds(itemArray: IntArray, element: Int): Int {
        var startIndex = 0
        var endIndex = itemArray.size - 1
        while (startIndex <= endIndex) {
            if (itemArray[startIndex] == element)
                return startIndex
            else if (itemArray[endIndex] == element)
                return endIndex
            startIndex++
            endIndex--
        }

        return -1
    }

    fun searchUsingRecursion(itemArray: IntArray, element: Int, index: Int): Int {
        return when {
            index < 0 -> -1
            itemArray[index] == element -> index
            else -> searchUsingRecursion(itemArray, element, index - 1)
        }
    }
}

fun main(args: Array<String>) {
    val element = 11

    val unsortedArray = intArrayOf(2, 6, 9, 67, 34, 12, 55, 87, 43, 21, 11, 4, 8, 5, 33, 31, 22, 25, 1)
    val linearSearch = LinearSearch()
    println(linearSearch.search(unsortedArray, element))
    println(linearSearch.searchFromBothEnds(unsortedArray, element))
    println(linearSearch.searchUsingRecursion(unsortedArray, element, unsortedArray.size - 1))
}
