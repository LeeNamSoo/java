package algorithm;

import java.util.ArrayList;

public class TSP_BruteForce_Bit {
	int INF = 999;
	int result = 10000;
	int[][] graph = { { 0, 2, 9, INF }, { 1, 0, 6, 4 }, { INF, 7, 0, 8 }, { 6, 3, INF, 0 } };
//	int[][] graph = { { 2, 6, 10, 4, 3 }, { 3, 2, 7, 9, 2 }, { 6, 10, 2, 10, 6 }, { 5, 3, 9, 9, 6 },{ 6, 5, 1, 5, 5 } };
	public TSP_BruteForce_Bit() {
		int visited = 0;
		int[] city = { 1, 2, 4, 8 };
		int cost = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		System.out.println("cost : " + shortest(path, visited, cost, city));
	}

	public int shortest(ArrayList<Integer> path, int visited, int cost, int[] city) {
		
		if (visited == 0) {//시작노드를 저장하고 방뭉설정
			path.add(0);
			visited = visited | (1);
		}
		if (visited == (1 << graph.length) - 1) {//모든 노드를 방문했다면 거리 반환
			return cost + graph[path.get(3)][0];
		}
		for (int i = 0; i < graph.length; i++) {
			if ((visited & city[i])!=0) {// i번째 도시를 이미 방문했으면 생략
				continue;
			} else {
				visited = visited | city[i];//방문한 도시 표시0->1
				path.add(i);
//				cost += graph[path.get(path.size() - 2)][i]; //왜 이건 안되고 값을 직접넣으면 될까??
				result = min(result, shortest(path, visited, cost + graph[path.get(path.size() - 2)][i], city));
				path.remove(path.size() - 1);
				visited = visited & ~city[i];//다시 되돌아감1->0
			}
		}
		return result;
	}
	

	public int min(int x, int y) {
		return x > y ? y : x;
	}

}
