/*

Given a graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:

Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]

Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.

*/


class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
     ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ArrayList<Integer> vis = new ArrayList<>();
        for(int i=0; i<V; ++i){
            adjList.add(new ArrayList<Integer>());
            vis.add(0);
        }
        for(int i=0; i<V; ++i){
            for(int j=0; j<V; ++j){
                if(adj.get(i).get(j) == 1){
                    adjList.get(i).add(j);
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<V; ++i){
            if(vis.get(i) == 0){
                cnt += 1;
                dfs(i,-1,adjList,vis);
            }
        }
        return cnt;
    }
    static void dfs(int node,int par,ArrayList<ArrayList<Integer>> adjList,ArrayList<Integer> vis){
        vis.set(node,1);
        for(Integer v:adjList.get(node)){
            if(vis.get(v) == 0){
                dfs(v,node,adjList,vis);
            }
        }
        
    }
};
