package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class DFS {

	public DFS(int numberOfnode, int numberOfline, int root) {
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
		DFS(graph, root);
	}

	public void DFS(int[][] graph, int root) {
		// �׷����� ����Ͽ� �鸰 ����� ������ ����� ������� ������ �õ������� �� ��忡 �������� ������ ���� ��� �ѹ� �鸱�� �Ѱ���
		// ������ �������� ������ boolean�� �迭�� ����Ͽ� �����Ͽ���.

		int temp;
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		stack.push(root);// ù��° ��� ����
		while (!stack.isEmpty()) {
			temp = stack.peek();
			if(visited[temp-1]==false) {
				System.out.println(temp);// �湮�� ��� ���
				visited[temp-1]=true;// ��� �湮 ǥ��
			}
			stack.pop();
			for (int i = graph.length-1; i >= 0; i--) {// �湮����� �ڽĳ�� ���ÿ� ����
				if(visited[i] == true) {
					continue;
				}// ��� �湮ǥ��
				if (graph[temp - 1][i] == 1) {// ��尣 ������ �ְ� �湮���� �ʾ������
					stack.push(i + 1);// ��� ����
					graph[temp-1][i]=0;//�湮�� ���� ǥ��
					graph[i][temp-1]=0;
				}
			}
		}
	}
}

