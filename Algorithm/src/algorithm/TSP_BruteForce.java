//package algorithm;
//
//import java.util.ArrayList;
//
//public class TSP_BruteForce {
//	int INF = 999;
//	int result = 0;
//	int[][] graph = { { 0, 2, 9, INF }, { 1, 0, 6, 4 }, { INF, 7, 0, 8 }, { 6, 3, INF, 0 } };
//
//	public TSP_BruteForce() {
//		boolean[] visited = new boolean[graph.length];
//		int cost = 0;
//		ArrayList<Integer> path = new ArrayList<Integer>();
//		System.out.println(shortest(path, visited, cost));
//	}
//
//	public int shortest(ArrayList<Integer> path, boolean[] visited, int cost) {
//		if (path.isEmpty()) {
//			path.add(0);
//			visited[0] = true;
//		}
//		if (path.size() == 4) {
//			System.out.println("cost : " + cost);
//			cost += graph[path.get(3)][0];
//			System.out.println("4cost : " + cost);
//			return cost;
//		}
//		for (int i = 0; i < visited.length; i++) {
//			if (visited[i] == true) {
//				continue;
//			} else {
//				visited[i] = true;
//				path.add(i);
//				cost += graph[path.get(path.size() - 2)][i];
////				System.out.println("graph[path.get(path.size()-1)][i] : " + graph[path.get(path.size() - 1)][i]);
////				System.out.println("path.get(path.size()-1) : " + path.get(path.size() - 2)+", i : "+i);
////				System.out.println("cost : " + cost);
//				cost = min(cost, shortest(path, visited, cost));
//				path.remove(path.size() - 1);
//				visited[i] = false;
//				
//			}
//		}
//		return cost;
//	}
//
//	public int min(int x, int y) {
//		return x >= y ? y : x;
//	}
//
//}

package algorithm;

import java.util.ArrayList;

public class TSP_BruteForce {
	int INF = 999;
	int result = 10000;
	int[][] graph = { { 0, 2, 9, INF }, { 1, 0, 6, 4 }, { INF, 7, 0, 8 }, { 6, 3, INF, 0 } };
//	int[][] graph = { { 2, 6, 10, 4, 3 }, { 3, 2, 7, 9, 2 }, { 6, 10, 2, 10, 6 }, { 5, 3, 9, 9, 6 },
//			{ 6, 5, 1, 5, 5 } };

	public TSP_BruteForce() {
		boolean[] visited = new boolean[graph.length];
		int cost = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		System.out.println("cost : "+shortest(path, visited, cost));
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
				result = min(result, shortest(path, visited, cost + graph[path.get(path.size() - 2)][i]));

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