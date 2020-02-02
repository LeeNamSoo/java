package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS {
	public BFS(int numberOfnode, int numberOfline, int root) {
		Scanner connect = new Scanner(System.in);
		int[][] graph = new int[numberOfnode][numberOfnode];
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
		BFS(graph, root);
	}

	public void BFS(int[][] graph, int root) {// �׷����� ����Ͽ� �鸰 ����� ������ ����� ������� ������ �õ������� �� ��忡 �������� ������ ���� ��� �ѹ� �鸱�� �Ѱ���
		// ������ �������� ������ boolean�� �迭�� ����Ͽ� �����Ͽ���.
		int temp;
		boolean[] visited = new boolean[graph.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		queue.add(root);// ù��° ��� �湮
		visited[root - 1] = true;// ù��° �湮��� ǥ��
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp);// �湮�� ��� ���
			for (int i = 0; i < graph.length; i++) {// �湮����� �ڽĳ�� ���ÿ� ����
				if (graph[temp - 1][i] == 1 && visited[i] == false) {// ��尣 ������ �ְ� �湮���� �ʾ������
					queue.add(i + 1);// ��� ����
					visited[i] = true;// ��� �湮ǥ��
				}
			}
		}
	}

}
