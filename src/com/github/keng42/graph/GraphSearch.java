package com.github.keng42.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.github.keng42.graph.LGraph.EdgeNode;
import com.github.keng42.graph.LGraph.LNode;
import com.github.keng42.graph.MGraph.MNode;

public class GraphSearch {

	static final int NUM = 9;

	public static void main(String[] args) {
		MNode[] mNode = new MNode[NUM];
		LNode[] lNode = new LNode[NUM];
		for (int i = 0; i < mNode.length; i++) {
			mNode[i] = new MNode(i);
			lNode[i] = new LNode(i);
		}
		int[][] edges = new int[NUM][NUM];
		int[][] e = { { 4, 7, 7 }, { 2, 8, 8 }, { 0, 1, 10 }, { 0, 5, 11 },
				{ 1, 8, 12 }, { 3, 7, 16 }, { 1, 6, 16 }, { 5, 6, 17 },
				{ 1, 2, 18 }, { 6, 7, 19 }, { 3, 4, 20 }, { 3, 8, 21 },
				{ 2, 3, 22 }, { 3, 6, 24 }, { 4, 5, 26 } };

		MGraph mg = new MGraph(mNode, edges, e);
		LGraph lg = new LGraph(lNode, e);

		DFS(mg, 0);
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		System.out.println();
		DFS(lg, 0);
		System.out.println();
		BFS(lg, 0);
		System.out.println();
		BFS(mg, 0);
	}

	static boolean[] visited = new boolean[NUM];

	public static void DFS(MGraph mg, int i) {
		visited[i] = true;
		System.out.print(mg.vexs[i].data + " ");
		for (int j = 0; j < visited.length; j++) {
			if (!visited[j] && mg.edges[i][j] > 0) {
				DFS(mg, j);
			}
		}
	}

	public static void DFS(LGraph lg, int i) {
		visited[i] = true;
		System.out.print(lg.vexs[i].data + " ");
		EdgeNode en = lg.vexs[i].first;
		while (en != null) {
			if (!visited[en.index]) {
				DFS(lg, en.index);
			}
			en = en.next;
		}
	}

	public static void BFS(MGraph mg, int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		boolean[] visited = new boolean[mg.numVexs];

		int index;
		while (!q.isEmpty()) {
			index = q.poll();
			System.out.print(mg.vexs[index].data + " ");
			visited[index] = true;
			for (int j = 0; j < mg.numVexs; j++) {
				if (!visited[j] && mg.edges[index][j] > 0) {
					if (!q.contains(j)) {
						q.offer(j);
					}
				}
			}
		}
	}

	public static void BFS(LGraph lg, int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		boolean[] visited = new boolean[lg.numVexs];

		int index;
		while (!q.isEmpty()) {
			index = q.poll();
			System.out.print(lg.vexs[index].data + " ");
			visited[index] = true;
			EdgeNode en = lg.vexs[index].first;
			while (en != null) {
				if (!visited[en.index] && !q.contains(en.index)) {
					q.offer(en.index);
				}
				en = en.next;
			}
		}
	}
}
