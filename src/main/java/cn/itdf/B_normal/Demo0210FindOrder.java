package cn.itdf.B_normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目:课程表 II
 *
 * 思路:
 *      和207的课程表那题思路一样
 *      只不过多加一步来记录节点顺序
 *
 *
 */
public class Demo0210FindOrder {
    /**
     * bfs版
     * @param numCourses
     * @param prerequisites
     * @return
     */
    /*
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];
        int[] ret = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] req : prerequisites) {
            indegrees[req[0]]++;
            adjacency.get(req[1]).add(req[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        int i = 0;
        while (queue.size() != 0) {
            Integer pre = queue.poll();
            ret[i++] = pre;
            numCourses--;
            for (Integer cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) queue.add(cur);
            }
        }
        if (numCourses == 0) {
            return ret;
        }else {
            return new int[] {};
        }
    }
    */

    /**
     * dfs版
     */
    int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] flags = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] ret = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] req : prerequisites) {
            adjacency.get(req[0]).add(req[1]); // 注意这里如果要记录顺序则要以节点为key而不是以前置条件为key
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(ret, adjacency, flags, i)) return new int[] {};
        }
        return ret;
    }

    private boolean dfs(int[] ret, List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if (!dfs(ret, adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        ret[index++] = i; // 记录执行顺序
        return true;
    }
}
