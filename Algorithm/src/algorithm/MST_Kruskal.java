package algorithm;

import java.util.ArrayList;

public class MST_Kruskal {
	int INF = 999; // 연결이 되지 않음, 가중치 무한대를 뜻함.
	int[][] graph = { { INF, 1, 3, INF, INF }, { 1, INF, 3, 6, INF }, { 3, 3, INF, 4, 2 }, { INF, 6, 4, INF, 5 },
			{ INF, INF, 2, 5, INF } };

	public MST_Kruskal() {
		int[][] path = kruskal();
		for (int i = 0; i < path[0].length; i++) {
			System.out.println(path[0][i] + "-" + path[1][i]);
		}
	}
	public int[][] kruskal() {
		int[] subtree = new int[graph.length];
		int[][] result = new int[2][graph.length - 1];
		int[][] sorted = new int[2][numberofedge(graph)];
		int count = 0;
		for (int i = 0; i < graph.length; i++) {
			subtree[i] = i;
		}
		sortedge(sorted, graph);
		while (count < result[0].length) {
			for (int i = 0; i < sorted[0].length; i++) {
				if (!iscycle(subtree, sorted[0][i], sorted[1][i])) {
					for(int j=0; j<subtree.length;j++) {
						if(subtree[j]==sorted[1][i]) {
							subtree[j]=sorted[0][i];
						}
					}
					result[0][count] = sorted[0][i];
					result[1][count] = sorted[1][i];
					count++;
					break;
				} else
					continue;
			}
		}
		return result;
	}
	public int numberofedge(int[][] graph) {// 연결된 간선의 수를 구한다.
		int result = 0;
		for (int i = graph.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (graph[i][j] != 0 && graph[i][j] != INF) {
					result++;
				}
			}
		}
		return result;
	}

	public int[][] sortedge(int[][] sorted, int[][] graph) {// 간선을 가중치가 낮은 순서대로 정렬한다.
		int temp = 0;
		ArrayList<Integer> sort = new ArrayList<Integer>();
		while (sort.size() < sorted[0].length) {
			for (int i = 0; i < graph.length; i++) {
				for (int j = graph.length - 1; j >= 0; j--) {
					if (graph[temp / 10][temp % 10] > graph[i][j] && graph[i][j] != 0) {
						temp = i * 10 + j;
					}
				}
			}
			graph[temp / 10][temp % 10] = INF;
			graph[temp % 10][temp / 10] = INF;
			sort.add(temp);
		}
		for (int i = 0; i < sorted[0].length; i++) {
			sorted[0][i] = sort.get(i) / 10;
			sorted[1][i] = sort.get(i) % 10;
		}
		return sorted;
	}

	public boolean iscycle(int[] subtree, int x, int y) {
		if (subtree[x] == subtree[y]) {
			return true;
		} else {

			return false;
		}
	}

}
