package algorithm;

import java.util.ArrayList;

public class MST_Prim {
	int INF = 999; // 연결이 되지 않음, 가중치 무한대를 뜻함.
	int[][] graph = { { 0, 1, 3, INF, INF }, { 1, 0, 3, 6, INF }, { 3, 3, 0, 4, 2 }, { INF, 6, 4, 0, 5 },
			{ INF, INF, 2, 5, 0 } };
	
	public MST_Prim() {
		int[][] line = new int[2][graph.length - 1];
		prim(graph, graph.length, line, 0);
		for (int i = 0; i < line[0].length; i++) {
			System.out.println(line[0][i] + "-" + (line[1][i]));
		}
	}
	
	public  void prim(int[][] c, int n, int[][] t, int vertex) {
		// c배열은 그래프의 인접행렬, n은 정점의 개수, t배열은 연결된 간선배열, vertex는 시작 정점
		int[] from = new int[n]; // 현재 부분 배열이 어디로부터 연결된지 표시하는 from배열 생성
		int[] dist = new int[n]; // 현재 부분 배열의 각 정점마다의 가중치를 표시
		for (int i = 0; i < n; i++) { // 최초 시작정점은 첫번째 정점임으로 vertex으로 초기화
			from[i] = vertex;
			dist[i] = c[vertex][i];
		}
		for (int i = 0; i < n - 1; i++) { // n-1은 연결될 간선의 수
			int best = isBest(dist); // dist배열중 0을 제외한 최소값을 가진 원소의 인덱스
			t[0][i] = from[best] + 1; // 가중치가 가장 적은 간선을 선택해서 넣어준다. +1은 정점이 1부터 시작해서 넣음.
			t[1][i] = best + 1;
			dist[best] = 0; // 부분 트리로 선택된 정점까지의 가중치는 0으로 변경
			for (int j = 1; j < n; j++) { // dist배열과 from배열의 최신화
				if (c[best][j] < dist[j]) { // 최근에 선택된 정점에 인접한 정점에 가중치와 기존 dist배열과 비교
					from[j] = best;
					dist[j] = c[best][j];
				}
			}
		}
	}
	public int isBest(int[] dist) { // dist배열중 0을 제외한 최소값을 가진 원소의 인덱스를 반환하는 메소드
		int best = 0;
	
		for (int i = 0; i< dist.length; i++) {
			if(dist[i]!=0) {
			best = i;
			break;
			}
		}
		for (int j = 0; j < dist.length; j++) { // dist에서 0이아닌 값 중 값이 가장 작은 인덱스를 찾는다.
			if (dist[j] != 0 && dist[j] < dist[best]) {
				best = j;
			}
		}
		return best;
	}
	
}

//int INF = 999;
//int[][] graph = { { 0, 1, 3, INF, INF }, { 1, 0, 3, 6, INF }, { 3, 3, 0, 4, 2 }, { INF, 6, 4, 0, 5 },
//		{ INF, INF, 2, 5, 0 } };
//int[] selected = new int[graph.length];// 선택된 정점의 정보를 담을 배열, 선택이 됐는지 안됐는지를 표시한다.
//int[] dist = new int[graph.length];// 최소의 거리 정보만을 담는 배열, 새로운 최소거리가 나올 때마다 갱신된다.
//
//public MST_Prim() {
//	prim(0, graph.length);
//}
//// 최소 거리값을 갖는 정점을 반환
//
//
//public void prim(int start, int n) {
//	int u,temp=0;
//	int x=0,y=0;//선택된 간선을 표현하기위한 변수
//	for (int i = 0; i < n; i++) {// dist배열과 selected배열의 정보를 초기화
//		dist[i] = INF;
//		selected[i] = 0;
//	}
//	dist[start] = 0; // 시작정점과 시작정점간의 거리는 0이다. 자기자신을 순환하는 경로는 없다고 가정한다.
//
//	for (int i = 0; i < n; i++) {
//		// 리턴된 정점 번호를 u에 저장한다. u는 최소거리를 가지는 정점. 손으로 썻을 때 선택하는 효과를 가져온다.
//		u = get_min_vertex(n);
//		if(temp!=0) {
//		System.out.println("연결노드 : "+temp+"-"+u);
//		}
//		temp=u;
//		selected[u] = 1; // 최소거리를 갖는 정점의 정보(u)를 알아냈으니 해당 정점을 선택했다고 표시한다.
//
//		// 만약 경로가 없다면 함수를 종료한다. 정상적인 신장트리의 정보가 들어왔다면 실행될 일은 없을 것이다.
//		if (dist[u] == INF) {
//			return;
//		}
////		System.out.println(u);
//		for (int j = 0; j < n; j++) { // 이 과정은 우리가 새롭게 발견한 정보를 저장하는 과정이다.
//			// 직접적인 경로가 발견되어 INF 에서 상수거리로 바뀌는 과정과
//			// 기존의 상수거리보다 더 짧은 거리가 발견되 그 정보를 갱신하는 과정이 포함되어 있다.
//
//			// 선택된 u 정점을 기준으로 정점(u)과 연결되어 있는 정점까지의 거리를 각각 비교한다.
//			if (graph[u][j] != INF) { // 정점 u와 연결이 되어있고
//
//				// 아직 선택되지 않았으며 해당 변(graph[u][j])의 길이가 기존의 dist[j] 값보다 작다면
//				if (selected[j] == 0 && graph[u][j] < dist[j]) {
//					dist[j] = graph[u][j]; // dist[v]의 값을 갱신해준다.
//					x=u;
//					y=j;
//				}
//			}
//		}
//		
//	}
//}
//public int get_min_vertex(int n) {// n은 노드의 수
//	int v = 0; // 정점의 정보를 저장할 변수 v
//	
//
//	for (int i = 0; i < n; i++) {
//		if (selected[i] == 0) {
//			v = i; // 아직 선택되지 않은 정점의 번호를 v에 저장, 각 함수 실행별 0부터 n - 1까지 차례대로 저장된다.
//			break;
//		}
//	}
//
//	// 위에서 선택된 정점이 과연 최소거리를 지니고 있는 정점인지를 확인한다.
//	for (int i = 0; i < n; i++) {
//		// 선택되지 않은 정점들을 순회하면서 최소거리를 가진 정점을 찾아낸다.
//		if (selected[i] == 0 && dist[i] < dist[v]) {
//			v = i; // 더 적은 거리가 존재한다면 해당 정점을 저장한다.
//		}
//	}
//	return v; // 최소의 거리를 갖는 정점이 선택됐으므로 정점 번호를 리턴한다.
//}
//-------------------------------------------------------------------------------------------
//int INF = 999; // 연결이 되지 않음, 가중치 무한대를 뜻함.
//int[][] graph = { { 0, 1, 3, INF, INF }, { 1, 0, 3, 6, INF }, { 3, 3, 0, 4, 2 }, { INF, 6, 4, 0, 5 },
//		{ INF, INF, 2, 5, 0 } };
//
//public MST_Prim() {
//	int[][] line = new int[2][graph.length - 1];
//	prim(graph, graph.length, line, 0);
//	for (int i = 0; i < line[0].length; i++) {
//		System.out.println(line[0][i] + "-" + (line[1][i]));
//	}
//}
//
//public static void prim(int[][] c, int n, int[][] t, int vertex) {
//	// c배열은 그래프의 인접행렬, n은 정점의 개수, t배열은 연결된 간선배열, vertex는 시작 정점
//	int[] from = new int[n]; // 현재 부분 배열이 어디로부터 연결된지 표시하는 from배열 생성
//	int[] dist = new int[n]; // 현재 부분 배열의 각 정점마다의 가중치를 표시
//
//	for (int i = 0; i < n; i++) { // 최초 시작정점은 첫번째 정점임으로 vertex으로 초기화
//		from[i] = vertex;
//		dist[i] = c[vertex][i];
//	}
//
//	for (int i = 0; i < n - 1; i++) { // n-1은 연결될 간선의 수
//
//		int best = isBest(dist); // dist배열중 0을 제외한 최소값을 가진 원소의 인덱스
//		t[0][i] = from[best] + 1; // 가중치가 가장 적은 간선을 선택해서 넣어준다. +1은 정점이 1부터 시작해서 넣음.
//		t[1][i] = best + 1;
//		dist[best] = 0; // 부분 트리로 선택된 정점까지의 가중치는 0으로 변경
//
//		for (int j = 1; j < n; j++) { // dist배열과 from배열의 최신화
//			if (c[best][j] < dist[j]) { // 최근에 선택된 정점에 인접한 정점에 가중치와 기존 dist배열과 비교
//				from[j] = best;
//				dist[j] = c[best][j];
//			}
//		}
//	}
//}
//
//public static int isBest(int[] dist) { // dist배열중 0을 제외한 최소값을 가진 원소의 인덱스를 반환하는 메소드
//	int best = 0;
//
//	for (int i = 0; i< dist.length; i++) {
//		best = i;
//		break;
//	}
//
//	for (int j = 0; j < dist.length; j++) { // dist에서 0이아닌 값 중 값이 가장 작은 인덱스를 찾는다.
//		if (dist[j] != 0 && dist[j] < dist[best]) {
//			best = j;
//		}
//	}
//
//	return best;
//}

//-------------------------------------------------------------------------------
//int INF = 999;
//int[][] graph = { { 0, 1, 3, INF, INF }, { 1, 0, 3, 6, INF }, { 3, 3, 0, 4, 2 }, { INF, 6, 4, 0, 5 },
//		{ INF, INF, 2, 5, 0 } };
//int[] selected = new int[graph.length];// 선택된 정점의 정보를 담을 배열, 선택이 됐는지 안됐는지를 표시한다.
//int[] dist = new int[graph.length];// 최소의 거리 정보만을 담는 배열, 새로운 최소거리가 나올 때마다 갱신된다.
//
//public MST_Prim() {
//	prim(0, graph.length);
//}
//public void prim(int start, int n) {
//	int u,temp=0;
//	int[][] line=new int[2][graph.length-1];
//	for (int i = 0; i < n; i++) {// dist배열과 selected배열의 정보를 초기화
//		dist[i] = INF;
//		selected[i] = 0;
//	}
//	dist[start] = 0; // 시작정점과 시작정점간의 거리는 0이다. 자기자신을 순환하는 경로는 없다고 가정한다.
//
//	for (int i = 0; i < n; i++) {
//		// 리턴된 정점 번호를 u에 저장한다. u는 최소거리를 가지는 정점. 손으로 썻을 때 선택하는 효과를 가져온다.
//		u = get_min_vertex(n,line);
//		if(temp!=0) {
//		System.out.println("연결노드 : "+temp+"-"+u);
//		}
//		temp=u;
//		selected[u] = 1; // 최소거리를 갖는 정점의 정보(u)를 알아냈으니 해당 정점을 선택했다고 표시한다.
//		// 만약 경로가 없다면 함수를 종료한다. 정상적인 신장트리의 정보가 들어왔다면 실행될 일은 없을 것이다.
//		if (dist[u] == INF) {
//			return;
//		}
////		System.out.println(u);
//		for (int j = 0; j < n; j++) { // 이 과정은 우리가 새롭게 발견한 정보를 저장하는 과정이다.
//			// 직접적인 경로가 발견되어 INF 에서 상수거리로 바뀌는 과정과
//			// 기존의 상수거리보다 더 짧은 거리가 발견되 그 정보를 갱신하는 과정이 포함되어 있다.
//
//			// 선택된 u 정점을 기준으로 정점(u)과 연결되어 있는 정점까지의 거리를 각각 비교한다.
//			if (graph[u][j] != INF) { // 정점 u와 연결이 되어있고
//
//				// 아직 선택되지 않았으며 해당 변(graph[u][j])의 길이가 기존의 dist[j] 값보다 작다면
//				if (selected[j] == 0 && graph[u][j] < dist[j]) {
//					dist[j] = graph[u][j]; // dist[v]의 값을 갱신해준다.
//				}
//			}
//		}
//		
//	}
//}
//// 최소 거리값을 갖는 정점을 반환
//public int get_min_vertex(int n, int[][] line) {// n은 노드의 수
//	int v = 0; // 정점의 정보를 저장할 변수 v
//	
//
//	for (int i = 0; i < n; i++) {
//		if (selected[i] == 0) {
//			v = i; // 아직 선택되지 않은 정점의 번호를 v에 저장, 각 함수 실행별 0부터 n - 1까지 차례대로 저장된다.
//			break;
//		}
//	}
//
//	// 위에서 선택된 정점이 과연 최소거리를 지니고 있는 정점인지를 확인한다.
//	for (int i = 0; i < n; i++) {
//		// 선택되지 않은 정점들을 순회하면서 최소거리를 가진 정점을 찾아낸다.
//		if (selected[i] == 0 && dist[i] < dist[v]) {
//			v = i; // 더 적은 거리가 존재한다면 해당 정점을 저장한다.
//		}
//	}
//	return v; // 최소의 거리를 갖는 정점이 선택됐으므로 정점 번호를 리턴한다.
//}
