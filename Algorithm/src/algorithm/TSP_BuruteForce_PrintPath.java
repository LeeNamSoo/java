package algorithm;

import java.util.ArrayList;

public class TSP_BuruteForce_PrintPath {
	int INF = 999;
	int result = 10000;
	int[][] graph = { { 0, 2, 9, INF }, { 1, 0, 6, 4 }, { INF, 7, 0, 8 }, { 6, 3, INF, 0 } };
//	int[][] graph = { { 2, 6, 10, 4, 3 }, { 3, 2, 7, 9, 2 }, { 6, 10, 2, 10, 6 }, { 5, 3, 9, 9, 6 },{ 6, 5, 1, 5, 5 } };
	int[] shortestpath = new int [graph.length];
	public TSP_BuruteForce_PrintPath() {
		boolean[] visited = new boolean[graph.length];
		int cost = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		System.out.println("cost : "+shortest(path, visited, cost));
		System.out.print("path : "+shortestpath[0]);
		for(int i=1; i<shortestpath.length; i++) {
			System.out.print("->"+shortestpath[i]);
		}
		System.out.print("->"+shortestpath[0]);
	}

	public int shortest(ArrayList<Integer> path, boolean[] visited, int cost) {
		if (path.isEmpty()) {
			path.add(0);
			visited[0] = true;
		}
		if (path.size() == visited.length) {
			return cost + graph[path.get(3)][0];
		}
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == true) {
				continue;
			} else {
				visited[i] = true;
				path.add(i);
//				cost += graph[path.get(path.size() - 2)][i]; //왜 이건 안되고 값을 직접넣으면 될까??
				int temp=result;//최소거리를 감지하기 위한 변수
				result = min(result, shortest(path, visited, cost + graph[path.get(path.size() - 2)][i]));
				if(temp>result) {//result 값이 작아졌다면 최단경로를 초기화
					for(int j=0; j<path.size(); j++) {
						shortestpath[j]=path.get(j);
					}
				}
				path.remove(path.size() - 1);
				visited[i] = false;
			}
		}
		return result;
	}

	public int min(int x, int y) {
		return x > y ? y : x;
	}
}
