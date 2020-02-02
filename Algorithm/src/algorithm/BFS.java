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

	public void BFS(int[][] graph, int root) {// 그래프만 사용하여 들린 노드의 간선을 지우는 방식으로 구현을 시도했으나 한 노드에 여러개의 간선이 있을 경우 한번 들릴때 한개의
		// 간선만 지워지기 때문에 boolean형 배열을 사용하여 구현하였다.
		int temp;
		boolean[] visited = new boolean[graph.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		queue.add(root);// 첫번째 노드 방문
		visited[root - 1] = true;// 첫번째 방문노드 표시
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp);// 방문한 노드 출력
			for (int i = 0; i < graph.length; i++) {// 방문노드의 자식노드 스택에 적재
				if (graph[temp - 1][i] == 1 && visited[i] == false) {// 노드간 간선이 있고 방문하지 않았을경우
					queue.add(i + 1);// 노드 적재
					visited[i] = true;// 노드 방문표시
				}
			}
		}
	}

}
