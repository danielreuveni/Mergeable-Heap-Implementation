# Mergeable-Heap-Implementation

In this project we need to implement a mergeable heap using linked lists. Mergeable heap support in these functions: 
Insert(x), Minimum, Extract-Min, Union, Make-heap.
We implement mergeable heap in three ways:
1.	The lists are sorted.
2.	The lists are not sorted.
3.	The lists are not sorted, and the dynamic groups to be merged are foreign.


Make-Heap function is uniform for all sections. This function create two empty linked lists. Time complexity: O(1).
In the first way:
Insert(x): Each time we insert the x into one of the two lists alternately. During the insertion we will go through the members of the list in a linear scan and find the position of x. If x is larger than all the elements of the list, we will insert it at the end of the list. Time complexity of this operation will cost O(n) at worst.
Minimum: Since each list is sorted, necessarily the minimum member in each list is located at the head of the list. Therefore, we will return the minimum between them. Time complexity: O(1).
Extract-Min: Continuing from the previous section, we will delete the minimum element from the two lists and move element limb one step to the left. Time complexity: O(n) in worst case.
Union: We will go through pointers that will start at the head of each list and put each element in the appropriate place to maintain the sorted order ratio. Each element will be placed in the appropriate place in each of the two lists in the new heap. Time complexity: Θ(n).



|   | Sorted lists | Unsorted lists  | Unsorted lists and foreign dynamic groups  |
| ------------- | ------------- | ------------- | ------------- |
| Make-Heap  | O(1)  | Content Cell  | Content Cell  |
| Insert(x)  | O(n)  | Content Cell  | Content Cell  |
| Minimum  | O(1)  | Content Cell  | Content Cell  |
| Extract-Min  | O(n)  | Content Cell  | Content Cell  |
| Union  | Θ(n)  | Content Cell  | Content Cell  |

		|Unsorted lists |Unsorted lists and foreign dynamic groups
Make-Heap	O(1)	O(1)	O(1)
Insert(x)	O(n)		
Minimum	O(1)		
Extract-Min	O(n)		
Union	Θ(n)		

