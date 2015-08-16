package com.github.keng42.graph;

/**
 * �ڽӾ����ʾ�Ĵ�����Ȩ�ص�����ͼ
 */
public class MGraph {

	public static class MNode {
		int data;

		public MNode(int data) {
			super();
			this.data = data;
		}
	}

	MNode[] vexs;
	int[][] edges;
	int numVexs;
	int numEdges;

	public MGraph(MNode[] vexs, int[][] edges) {
		super();
		this.vexs = vexs;
		this.edges = edges;

		numEdges = 0;
		for (int[] is : edges) {
			for (int i : is) {
				if (i != 0) {
					numEdges++;
				}
			}
		}
		numEdges /= 2;
		numVexs = vexs.length;
	}

	public MGraph(MNode[] vexs, int[][] edges, int[][] e) {
		super();
		this.vexs = vexs;
		numVexs = vexs.length;
		numEdges = 0;

		for (int[] is : e) {
			edges[is[0]][is[1]] = is[2];
			edges[is[1]][is[0]] = is[2];
			numEdges++;
		}
		this.edges = edges;
	}
}
