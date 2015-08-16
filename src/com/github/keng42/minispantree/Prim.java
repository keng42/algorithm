package com.github.keng42.minispantree;

import java.util.ArrayList;
import java.util.List;

public class Prim {

	public static void main(String[] args) {
		int[][] e = { { 4, 7, 7 }, { 2, 8, 8 }, { 0, 1, 10 }, { 0, 5, 11 }, { 1, 8, 12 }, { 3, 7, 16 }, { 1, 6, 16 },
				{ 5, 6, 17 }, { 1, 2, 18 }, { 6, 7, 19 }, { 3, 4, 20 }, { 3, 8, 21 }, { 2, 3, 22 }, { 3, 6, 24 },
				{ 4, 5, 26 } };
		List<Edge> edges = new ArrayList<>();
		List<Vertex> vexs = new ArrayList<>();

		final int NUM = 9;
		for (int i = 0; i < NUM; i++) {
			vexs.add(new Vertex("v" + i));
		}

		for (int[] is : e) {
			edges.add(new Edge(vexs.get(is[0]), vexs.get(is[1]), is[2]));
		}

		List<Edge> newEdges = prim(vexs, edges);
		for (Edge edge : newEdges) {
			System.out.println(edge.start.data + " " + edge.end.data + " " + edge.weight);
		}
	}

	public static List<Edge> prim(List<Vertex> vexs, List<Edge> edges) {
		List<Vertex> newVexs = new ArrayList<>();
		List<Edge> newEdges = new ArrayList<>();

		Vertex start = vexs.get(0);
		newVexs.add(start);
		for (int i = 0; i < vexs.size(); i++) {
			Vertex tmp = null;
			Edge tmpEdge = new Edge(start, start, Integer.MAX_VALUE);
			for (Vertex v : newVexs) {
				for (Edge e : edges) {
					if (e.start == v && !newVexs.contains(e.end)) {
						if (e.weight < tmpEdge.weight) {
							tmp = e.end;
							tmpEdge = e;
						}
					} else if (e.end == v && !newVexs.contains(e.start)) {
						if (e.weight < tmpEdge.weight) {
							tmp = e.start;
							tmpEdge = e;
						}
					}
				}
			}
			if (tmp != null) {
				newVexs.add(tmp);
				newEdges.add(tmpEdge);
			}
		}
		return newEdges;
	}
}

class Vertex {
	String data;

	public Vertex(String data) {
		this.data = data;
	}
}

class Edge {
	Vertex start;
	Vertex end;
	int weight;

	public Edge(Vertex start, Vertex end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
