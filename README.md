# Mergeable-Heap-Implementation

In this project we need to implement a mergeable heap using linked lists. Mergeable heap support in these functions: 
Insert(x), Minimum, Extract-Min, Union, Make-heap.
We implement mergeable heap in three ways:
1.	The lists are sorted.
2.	The lists are not sorted.
3.	The lists are not sorted, and the dynamic sets to be merged are foreign.


Make-Heap function is uniform for all sections. This function create two empty linked lists. Time complexity: O(1).
In the first way:

In this way, each list represents the elements in sorted order.
Insert(x): Each time we insert the x into one of the two lists alternately. During the insertion we will go through the members of the list in a linear scan and find the position of x. If x is larger than all the elements of the list, we will insert it at the end of the list. Time complexity of this operation will cost O(n) at worst.
Minimum: Since each list is sorted, necessarily the minimum member in each list is located at the head of the list. Therefore, we will return the minimum between them. Time complexity: O(1).
Extract-Min: Continuing from the previous section, we will delete the minimum element from the two lists and move element limb one step to the left. Time complexity: O(n) in worst case.
Union: We will go through pointers that will start at the head of each list and put each element in the appropriate place to maintain the sorted order ratio. Each element will be placed in the appropriate place in each of the two lists in the new heap. Time complexity: Θ(n).

![image](https://user-images.githubusercontent.com/73079447/148728713-0602c81f-7872-4f5d-99e1-95837599c543.png)

In the second way:

In general, to maintain the efficiency of the insertion operation and get it running at a constant time, we will allow duplications within each list (If we do not allow duplicates, we will need to check if the element already exists within the list, using contains function that runs in linear time). The general structure of each list in this section will be as follows: At the head of each list the minimum element will be retained each time, and if there are duplicates of that element, they will appear after it in the list. The rest of the elements will then be kept in the list in no sorted order.
Insert(x): We must distinguish between two cases: Whether the element we want to insert is the minimum (we can check this by constant operations of comparison between the two elements at the head of the two lists), or whether the element is not minimal. If the element is minimal, we will insert it at the head of the list. If not, we insert it to the end of the list. Time complexity of this operation will cost O(1) instead of O(n).
Minimum: As explained above, the minimum element will be saved at the head of the list, so we will simply return it at a constant cost. Time complexity: O(1).
Extract-Min: If there is one minimal element, we simply remove it from the head of the list and return it. If there are duplicates of the minimal element, we remove it and all its duplicates. After this, we search the minimal element in the new list in linear time and save it in the head of the list. Time complexity: O(n) in worst case.
Union: 
Time complexity: Θ(n).


|   | Sorted lists | Unsorted lists  | Unsorted lists and foreign dynamic sets  |
| ------------- | ------------- | ------------- | ------------- |
| Make-Heap  | O(1)  | Content Cell  | Content Cell  |
| Insert(x)  | O(n)  | Content Cell  | Content Cell  |
| Minimum  | O(1)  | Content Cell  | Content Cell  |
| Extract-Min  | O(n)  | Content Cell  | Content Cell  |
| Union  | Θ(n)  | Content Cell  | Content Cell  |

	

