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
		
		if (visited == 0) {//���۳�带 �����ϰ� �湶����
			path.add(0);
			visited = visited | (1);
		}
		if (visited == (1 << graph.length) - 1) {//��� ��带 �湮�ߴٸ� �Ÿ� ��ȯ
			return cost + graph[path.get(3)][0];
		}
		for (int i = 0; i < graph.length; i++) {
			if ((visited & city[i])!=0) {// i��° ���ø� �̹� �湮������ ����
				continue;
			} else {
				visited = visited | city[i];//�湮�� ���� ǥ��0->1
				path.add(i);
//				cost += graph[path.get(path.size() - 2)][i]; //�� �̰� �ȵǰ� ���� ���������� �ɱ�??
				result = min(result, shortest(path, visited, cost + graph[path.get(path.size() - 2)][i], city));
				path.remove(path.size() - 1);
				visited = visited & ~city[i];//�ٽ� �ǵ��ư�1->0
			}
		}
		return result;
	}
	

	public int min(int x, int y) {
		return x > y ? y : x;
	}

}
