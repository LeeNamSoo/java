package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class DFS_Recurtion {
	public DFS_Recurtion(int numberOfnode, int numberOfline, int root) {
		Scanner connect = new Scanner(System.in);
		int[][] graph = new int[numberOfnode][numberOfnode];
		boolean[] visited = new boolean[graph.length];
		for (int i = 0; i < numberOfnode; i++) {
			for (int j = 0; j < numberOfnode; j++) {
				graph[i][j] = 0;
			}
		}
		int x, y;
		for (int i = 0; i < numberOfline; i++) {
			x = connect.nextInt();
			y = connect.nextInt();
			graph[x - 1][y - 1] = 1;
			graph[y - 1][x - 1] = 1;
		}
		DFS_Recurtion(graph, root, visited);
	}

	public void DFS_Recurtion(int[][] graph, int root, boolean[] visited) {
		// �׷����� ����Ͽ� �鸰 ����� ������ ����� ������� ������ �õ������� ��
		// ��忡 �������� ������ ���� ��� �ѹ� �鸱�� �Ѱ���
		// ������ �������� ������ boolean�� �迭�� ����Ͽ� �����Ͽ���.
		System.out.println(root);
		visited[root-1]=true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[root - 1][i] == 1 && visited[i] == false) {
				visited[i] = true;
				DFS_Recurtion(graph, i + 1, visited);
			}
		}
	}
}
