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
		// 그래프만 사용하여 들린 노드의 간선을 지우는 방식으로 구현을 시도했으나 한 노드에 여러개의 간선이 있을 경우 한번 들릴때 한개의
		// 간선만 지워지기 때문에 boolean형 배열을 사용하여 구현하였다.

		int temp;
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		stack.push(root);// 첫번째 노드 적재
		while (!stack.isEmpty()) {
			temp = stack.peek();
			if(visited[temp-1]==false) {
				System.out.println(temp);// 방문한 노드 출력
				visited[temp-1]=true;// 노드 방문 표시
			}
			stack.pop();
			for (int i = graph.length-1; i >= 0; i--) {// 방문노드의 자식노드 스택에 적재
				if(visited[i] == true) {
					continue;
				}// 노드 방문표시
				if (graph[temp - 1][i] == 1) {// 노드간 간선이 있고 방문하지 않았을경우
					stack.push(i + 1);// 노드 적재
					graph[temp-1][i]=0;//방문한 간선 표시
					graph[i][temp-1]=0;
				}
			}
		}
	}
}

