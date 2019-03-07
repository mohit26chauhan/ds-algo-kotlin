package ds.searching

/**
 * Techniques of searching an element in a sorted array
 *
 * Pick middle item of array and compare it to the element
 * Check whether element is smaller or greater than middle item
 * If element is greater then pick array from (middle + 1) position to end position for further searching
 * otherwise pick array from first position to (middle - 1) for further searching
 * Repeat this until you found the element in array or your picking array becomes empty
 *
 * If element found in array then return current position of array
 * otherwise return -1
 *
 * Use this algorithm when:
 * 1. Array is sorted (limitation)
 *
 * Time Complexity : O(log n)
 */
class BinarySearch {

    fun search(itemArray: IntArray, element: Int): Int {
        var start = 0
        var end = itemArray.size - 1
        var mid: Int

        while (end >= start) {
            mid = (start + end) / 2
            when {
                itemArray[mid] == element -> return mid
                itemArray[mid] > element -> end = mid - 1
                else -> start = mid + 1
            }
        }

        return -1
    }

    fun searchUsingRecursion(itemArray: IntArray, element: Int, start: Int, end: Int): Int {
        val mid = (start + end) / 2
        return when {
            end < start -> -1
            itemArray[mid] == element -> mid
            itemArray[mid] > element -> searchUsingRecursion(itemArray, element, start, mid - 1)
            else -> searchUsingRecursion(itemArray, element, start + 1, end)
        }
    }
}

fun main(args: Array<String>) {
    val element = 11
    val sortedArray = intArrayOf(2, 6, 9, 11, 12, 25, 35, 45, 55, 87, 93, 111, 115, 120)
    val binarySearch = BinarySearch()
    println(binarySearch.search(sortedArray, element))
    println(binarySearch.searchUsingRecursion(sortedArray, element, 0, sortedArray.size - 1))
}