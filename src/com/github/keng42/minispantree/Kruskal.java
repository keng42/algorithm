package com.github.keng42.minispantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

	public static void main(String[] args) {
		int[][] e = { { 2, 3, 22 }, { 2, 8, 8 }, { 3, 4, 20 }, { 0, 1, 10 },
				{ 0, 5, 11 }, { 1, 8, 12 }, { 3, 7, 16 }, { 1, 6, 16 },
				{ 5, 6, 17 }, { 4, 7, 7 }, { 1, 2, 18 }, { 6, 7, 19 },
				{ 3, 8, 21 }, { 3, 6, 24 }, { 4, 5, 26 } };
		List<Edge> edges = new ArrayList<>();
		List<Vertex> vexs = new ArrayList<>();

		final int NUM = 9;
		for (int i = 0; i < NUM; i++) {
			vexs.add(new Vertex("v" + i));
		}

		for (int[] is : e) {
			edges.add(new Edge(vexs.get(is[0]), vexs.get(is[1]), is[2]));
		}

		kruskal(vexs, edges);
	}

	/**
	 * 最小生成树
	 */
	public static void kruskal(List<Vertex> vexs, List<Edge> edges) {
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		// 用于判断是否形成回路，默认为 -1
		int[] parent = new int[vexs.size()];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		for (Edge e : edges) {
			int m = tail(parent, vexs.indexOf(e.start));
			int n = tail(parent, vexs.indexOf(e.end));
			if (m != n) {
				parent[m] = n;
				System.out.println(
						e.start.data + " " + e.end.data + "  " + e.weight);
			}
		}
	}

	public static int tail(int[] parent, int f) {
		while (parent[f] > -1) {
			f = parent[f];
		}
		return f;
	}
}
