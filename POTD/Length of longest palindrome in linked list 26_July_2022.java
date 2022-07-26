/*
Given a linked list, the task is to complete the function maxPalindrome() which returns an integer denoting  the length of the longest palindrome list that exist in the given linked list.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the size of the linked list . Then in the next line are N space separated values of the given linked list.

Output:
For each test case output will be the required max length of the palindrome present in the given linked list.

User Task:
The task is to complete the function maxPalindrome() which should count the length of longest palindrome in the given list and return it.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
7
2 3 7 3 2 12 24
5
12 4 4 3 14

Output:
5
2

Explanation:
Testcase 1: 2 -> 3 -> 7 -> 3 -> 2 is the linked list whose nodes leads to a palindrome as 2 3 7 3 2.

*/

class GfG {
  public static int maxPalindrome(Node head) {
    //add code here.
    Node curr = head;
    Node prev = null;
    int count = 0;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      count = Math.max(count, getMaxCount(prev, next) * 2 + 1);
      count = Math.max(count, getMaxCount(curr, next) * 2);
      prev = curr;
      curr = next;

    }
     return count;
  }

    private static int getMaxCount(Node left, Node right) {
      Node node1 = left;
      Node node2 = right;
      int counter = 0;
      while (node1 != null && node2 != null) {
        if (node1.data == node2.data) {
          node1 = node1.next;
          node2 = node2.next;
          counter++;
        } else {
          break;
        }
      }

      return counter;
    }
  }


