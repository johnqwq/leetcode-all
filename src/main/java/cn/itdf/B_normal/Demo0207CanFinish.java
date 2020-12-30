package cn.itdf.B_normal;

import java.util.*;

/**
 * 题目:课程表
 *      在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *      给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * 思路:
 *      本题可约化为： 课程安排图是否是 有向无环图(DAG)。即课程间规定了前置条件，但不能构成任何环路，否则课程前置条件将不成立。
 *      思路是通过 拓扑排序 判断此课程安排图是否是 有向无环图(DAG)
 *      拓扑排序原理: 对某点 v 而言，只有当 v 的所有源点均出现了，v 才能出现。
 *      通过课程前置条件列表 prerequisites 可以得到课程安排图的 邻接表 adjacency，以降低算法时间复杂度
 *
 *      一 入度表(广度优先遍历)
 *      二 深度优先遍历
 *
 *      (以二叉树距离,广度优先就是一层层处理;深度优先就是顺着左子节点走到最深处,再到右子节点再纵深)
 *
 */
public class Demo0207CanFinish {
    /**
     * 广度优先遍历
     * @param numCourses
     * @param prerequisites
     * @return
     */
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表,记录课程安排表的入度(可以理解为每个点分别有多少前置条件)
        int[] indegrees = new int[numCourses];
        // 邻接表,记录图的每个店分别有哪些前置条件
        List<List<Integer>> adjacency = new ArrayList<>();
        // 队列,帮助循环处理入度为0的点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] req : prerequisites) {
            // 记录入度
            indegrees[req[0]]++;
            // 记录前置条件
            adjacency.get(req[1]).add(req[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            // 入度为0则可以放入队列中等待处理,一个都没有说明所有课程都在一个大环中
            if (indegrees[i] == 0) queue.add(i);
        }
        // BFS TopSort.
        while (queue.size() != 0) {
            Integer pre = queue.poll();
            numCourses--; // 处理一个就记录一个
            for (Integer cur : adjacency.get(pre)) {
                // 当某个点的前置条件减到0则该点也能加入到队列中等待处理
                if (--indegrees[cur] == 0) queue.add(cur);
            }
        }
        // 最后判断图的每个点是否都处理完毕,没有则说明存在环
        return numCourses == 0;
    }
    */

    /**
     * 深度遍历优先
     * 原理是通过 DFS 判断图中是否有环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // flags记录点状态
        int[] flags = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] req : prerequisites) {
            adjacency.get(req[1]).add(req[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 1表示被本轮DFS访问过,如果碰到1则说明有环
        if (flags[i] == 1) return false;
        // -1表示被其他节点启动的DFS访问过,无需再重复搜索,可直接返回true
        if (flags[i] == -1) return true;
        flags[i] = 1; // 被本轮DFS访问过
        for (Integer j : adjacency.get(i)) {
            // 递归查找是否有环
            if (!dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1; // 该节点启动的DFS结束,置为-1
        return true;
    }
}
