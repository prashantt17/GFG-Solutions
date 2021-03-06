/*

Now, we'll try to solve a famous stack problem.
You are given an array A of size N. You need to first push the elements of the array into a stack and then print minimum in the stack at each pop.

Example 1:

Input:
N = 5
A = {1 2 3 4 5}
Output: 
1 1 1 1 1
Explanation: 
After pushing elements to the stack, 
the stack will be "top -> 5, 4, 3, 2, 1". 
Now, start popping elements from the stack
popping 5: min in the stack is 1.popped 5
popping 4: min in the stack is 1. popped 4
popping 3: min in the stack is 1. popped 3
popping 2: min in the stack is 1. popped 2
popping 1: min in the stack is 1. popped 1

*/

class GetMin
{
    //Function to push all the elements into the stack.
    public static Stack<Integer> _push(int arr[],int n)
    {
        // your code here
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(stack.empty())
                stack.push(arr[i]);
            else{
                int top = stack.peek();
                if(top<=arr[i]){
                    stack.push(top);
                }else{
                    stack.push(arr[i]);
                }
            }
        }
        return stack; 
    }
    
    //Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer>s)
    {
        // your code here
          while(!s.empty()){
            int top = s.pop();
            System.out.print(top+" ");
        }
    }
}

