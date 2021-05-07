package com.company;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG)
 * of n nodes labeled from 0 to n – 1,
 * find all possible paths from node 0 to node n - 1, and return them in any order.
 */


public class AllPaths{
    //rember Apply DFS on all those vertex whose indegree is 0.
    //graph = [[4,3,1],[3,2,4],[3],[4],[]]
    //Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    public List<List<Integer>> allPaths(int[][] graph) {
        List<List<Integer>> now = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, now);
        return now;
    }
    //adopt the recursion as its main form of implementation
    private void dfs(int[][] graph,int cur, List<Integer> path, List<List<Integer>> result) {
        if (cur == graph.length - 1) {
            // reached
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph[cur]) {
            path.add(i);
            dfs(graph, i, path, result);
            path.remove(path.size() - 1);
        }
    }


}