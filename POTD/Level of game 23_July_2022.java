/*

You are playing a game. At each level of the game, you have to choose one of the roads to go to the next level. Initially, you have h amount of health and m amount of money.
If you take the first road then your health increases by 3 and money increase by 2. If you take the second road then your health decreases by 5 and money decrease by 10. If you take the third road then health decreases by 20 and money increase by 5.
You have to tell what is the maximum level you can reach up to under the constraints that in no two consecutive levels you can select the same road twice and once your health or money becomes <= 0 game ends(that level is not counted).

Example 1:

Input:
H=2
M=10
Output:
1
Explanation:
For the first level, we can only choose the first road.
Now we cannot move ahead anymore.

*/

class Solution {
    public static int maxLevel(int h,int m) {
        // code here
        int level = -1;
        boolean firstRoadFlag = true;

        while (h > 0 && m > 0) {

          if (firstRoadFlag) {
            h += 3;
            m += 2;
            level += 1;
            firstRoadFlag = false;
          } else {
            firstRoadFlag = true;

            if (h > 5 && m > 10) {
              h -= 5;
              m -= 10;
            } else {
              h -= 20;
              m += 5;
            }
            level += 1;
          }

        }
        return level;
     }
}
