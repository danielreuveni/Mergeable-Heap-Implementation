# Mergeable-Heap-Implementation

In this project we need to implement a mergeable heap using linked lists. Mergeable heap support in these functions: 
Insert(x), Minimum, Extract-Min, Union, Make-heap.
We implement mergeable heap in three ways:
1.	The lists are sorted.
2.	The lists are not sorted.
3.	The lists are not sorted, and the dynamic sets to be merged are foreign.

The program read the commands from commands.txt.

Make-Heap function is uniform for all sections. This function create two empty linked lists. Time complexity: O(1).

In the first way:

In this way, each list represents the elements in sorted order.

Insert(x): Each time we insert the x into one of the two lists alternately. During the insertion we will go through the elements of the list in a linear scan and find the position of x. If x is larger than all the elements of the list, we will insert it at the end of the list. Time complexity of this operation will cost O(n) at worst.

Minimum: Since each list is sorted, necessarily the minimum member in each list is located at the head of the list. Therefore, we will return the minimum between them. Time complexity: O(1).

Extract-Min: Continuing from the previous section, we will delete the minimum element from the two lists. Time complexity: O(1).

Union: We will go through pointers that will start at the head of each list respectively and put each element in the appropriate place to maintain the sorted order ratio. Each element will be placed in the appropriate place in each of the two lists in the new heap. Time complexity: Θ(n).


![image](https://user-images.githubusercontent.com/73079447/148773571-c7780277-e7e0-4650-95c3-b3ce6ece1009.png)


![image](https://user-images.githubusercontent.com/73079447/148728713-0602c81f-7872-4f5d-99e1-95837599c543.png)

In the second way:

In general, to maintain the efficiency of the insertion operation and get it running at a constant time, we will allow duplications within each list (If we do not allow duplicates, we will need to check if the element already exists within the list, using contains function that runs in linear time). The general structure of each list in this section will be as follows: At the head of each list the minimum element will be retained each time, and if there are duplicates of that element, they will appear in the rest of the list. The rest of the elements will then be kept in the list in no sorted order.

Insert(x): We must distinguish between two cases: Whether the element we want to insert is the minimum (we can check this by constant operations of comparison between the two elements at the head of the two lists), or whether the element is not minimal. If the element is minimal, we will insert it at the head of the list. If not, we insert it to the end of the list. If it is the same minimal element, we insert it to the head of the list. Time complexity of this operation will cost O(1) instead of O(n).

Minimum: As explained above, the minimum element will be saved at the head of the list, so we will simply return it at a constant cost. Time complexity: O(1).

Extract-Min: If there is one minimal element, we simply remove it from the head of the list and return it. If there are duplicates of the minimal element, we remove it and all its duplicates from the two lists. After this, we search the minimal element in the new list in linear time and save it in the head of the list. Time complexity: O(n) in worst case.

Union: In order to unify the two heaps, we will need to unify each list respectively and find the minimum of each of the two matching lists in the two heaps, and insert it at the head of the new list and its copies if any. We will insert the other elements one after the other in linear time, as stated without maintaining a sorted order. Time complexity: Θ(n).

![image](https://user-images.githubusercontent.com/73079447/148773635-08769da0-ea24-43cd-b253-0fe7e3746709.png)


![image](https://user-images.githubusercontent.com/73079447/148773617-7ed1a150-3908-4b5c-a992-676938748beb.png)


|   | Sorted lists | Unsorted lists  | Unsorted lists and foreign dynamic sets  |
| ------------- | ------------- | ------------- | ------------- |
| Make-Heap  | O(1)  | O(1)  | O(1)  |
| Insert(x)  | O(n)  | O(1)  | Content Cell  |
| Minimum  | O(1)  | O(1)  | Content Cell  |
| Extract-Min  | O(1)  | O(n)  | Content Cell  |
| Union  | Θ(n)  | Θ(n)  | Θ(n)  |

	

