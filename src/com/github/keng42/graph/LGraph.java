package com.github.keng42.graph;

/**
 * 邻接表表示的带正数权重的无向图
 */
public class LGraph {

	public static class EdgeNode {
		int index;
		int weight;
		EdgeNode next;

		public EdgeNode(int index, int weight) {
			super();
			this.index = index;
			this.weight = weight;
			next = null;
		}
	}

	public static class LNode {
		int data;
		EdgeNode first;

		public LNode(int data) {
			super();
			this.data = data;
			this.first = null;
		}
	}

	LNode[] vexs;
	int numVexs;
	int numEdges;

	public LGraph(LNode[] vexs) {
		super();
		this.vexs = vexs;
		this.numVexs = vexs.length;

		for (LNode node : vexs) {
			EdgeNode en = node.first;
			while (en != null) {
				numEdges++;
				en = en.next;
			}
		}
	}

	public LGraph(LNode[] vexs, int[][] e) {
		super();
		numEdges = 0;
		for (int[] is : e) {
			EdgeNode en = new EdgeNode(is[1], is[2]);
			if (vexs[is[0]].first == null) {
				vexs[is[0]].first = en;
			} else {
				EdgeNode p = vexs[is[0]].first;
				while (p.next != null) {
					p = p.next;
				}
				p.next = en;
			}

			en = new EdgeNode(is[0], is[2]);
			if (vexs[is[1]].first == null) {
				vexs[is[1]].first = en;
			} else {
				EdgeNode p = vexs[is[1]].first;
				while (p.next != null) {
					p = p.next;
				}
				p.next = en;
			}
			numEdges++;
		}
		this.vexs = vexs;
		this.numVexs = vexs.length;
	}
}
