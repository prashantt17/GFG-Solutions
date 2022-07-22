/*
Given a linked list and a value x, partition it such that all nodes less than x come first, then all nodes with value equal to x and finally nodes with value greater than x. The original relative order of the nodes in each of the three partitions should be preserved. The partition must work in-place.
 
Example 1:
Input:
1->4->3->2->5->2->3,
x = 3
Output:
1->2->2->3->3->4->5
Explanation: 
Nodes with value less than 3 come first, 
then equal to 3 and then greater than 3.
*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        
        Node small = new Node(0);
        Node high = new Node(0);
        Node equal = new Node(0);
        
        Node smallHead = small;
        Node highHead = high;
        Node equalHead = equal;
        
        while (node != null) {
            
            if (node.data < x) {
                smallHead.next = node;
                smallHead = smallHead.next;
            } else if (node.data > x) {
                highHead.next = node;
                highHead = highHead.next;
            } else {
                equalHead.next = node;
                equalHead = equalHead.next;
            }
            node = node.next;
        }
        
        highHead.next = null;
        equalHead.next = high.next;
        smallHead.next = equal.next;
       
        
        return small.next;
    }
}
