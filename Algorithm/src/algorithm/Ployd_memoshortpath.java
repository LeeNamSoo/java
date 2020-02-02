package algorithm;

import java.util.ArrayList;

public class Ployd_memoshortpath {
	int[][] graph = { { 0, 1, 999, 1, 5 }, { 9, 0, 3, 2, 999 }, { 999, 999, 0, 4, 999 }, { 999, 999, 2, 0, 3 },
			{ 3, 999, 999, 999, 0 } };
	int[][] path = new int[5][5];// 지나가는 경로저장
	ArrayList<Integer> shortpath = new ArrayList<Integer>();

	public Ployd_memoshortpath() {
		for (int i = 0; i < graph.length; i++) {// 지나가는 경로
			for (int j = 0; j < graph.length; j++) {// 출발지점
				for (int k = 0; k < graph.length; k++) {// 도착지점
					if (graph[j][k] > graph[j][i] + graph[i][k]) {// 거처가는 길이 직접가는 길보다 가중치값이 더 작으면
						graph[j][k] = graph[j][i] + graph[i][k];// 그 값을 저장(최소 가중치저장)
						path[j][k] = i + 1;// 거쳐가는 경로 저장
//						shortpath[i][k] = 0;
					}
				}
			}
		}
	}

	public void printshortpath(int start, int end) {// start에서 end로 가는 최단경로를 출럭하는 함수
		
		if (shortpath.isEmpty()) {// 경로배열이 비었다면 값을넣어줌, 첫번째 값이 중복출럭되는것을 막기위합
			shortpath.add(start);
			System.out.println(start + "에서 " + end + "까지 최단경로");
			System.out.print(shortpath.get(0));
		}
		if (path[start - 1][end - 1] != 0) {// 거쳐가는 길이 있다면
			printshortpath(start, path[start - 1][end - 1]);// 거쳐가는길출력
		}
		shortpath.add(end);
		System.out.print("->" + shortpath.get(shortpath.size() - 1));// 경로를 출력후
		shortpath.remove(shortpath.size() - 1);// 삭제
	}

	public void printvaluepath() {// 지나가야하는 경로가 저장된 그래프를 출력하는 함수
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}

