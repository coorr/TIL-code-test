package com.example.java.Y2024.M09;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * [BOJ] 1260 - DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 * 알고리즘 : DFS, BFS
 */
public class DFS와BFS_1260 {
    static int n, m, v;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q;

    public void solution() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        visited = new boolean[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }

    public void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 1; i <= n ; i++) {
            int value = graph[node][i];
            if (value > 0 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public void bfs(int node) {
        q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int i = 1; i <= n; i++) {
                int value = graph[now][i];
                if (value > 0 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
