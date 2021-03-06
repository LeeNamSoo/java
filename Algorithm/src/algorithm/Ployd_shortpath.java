package algorithm;

class Ployd_shortpath {

	int[][] graph = { { 0, 1, 999, 1, 5 }, 
					  { 9, 0, 3, 2, 999 }, 
					  { 999, 999, 0, 4, 999 }, 
					  { 999, 999, 2, 0, 3 },
					  { 3, 999, 999, 999, 0 } };//그래프 노드의 연결괸계
	public Ployd_shortpath() {//각 노드에서 노드로 아동하는데 걸리는 최소가중치를 구하는 함수
		for (int i = 0; i < graph.length; i++) {//지나가는 경로
			for (int j = 0; j < graph.length; j++) {//출발지점
				for (int k = 0; k < graph.length; k++) {//도착지점
					if (graph[j][k] > graph[j][i] + graph[i][k]) {//바로가는 길보다 거쳐가는길의 값이 더 작다면
						graph[j][k] = graph[j][i] + graph[i][k];//거쳐가는 값을 저장
					}
				}
			}
		}
	}
	public void printshortpath() {//각 노드에서 노드로 아동하는데 걸리는 최소가중치를 춮력하는 함수
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph.length;j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
//https://kingpodo.tistory.com/53
//https://m.blog.naver.com/PostView.nhn?blogId=dhdudwh1&logNo=220863482093&proxyReferer=https%3A%2F%2Fwww.google.com%2F
//int [][] gragh = new int [5][5];