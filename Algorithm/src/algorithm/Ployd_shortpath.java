package algorithm;

class Ployd_shortpath {

	int[][] graph = { { 0, 1, 999, 1, 5 }, 
					  { 9, 0, 3, 2, 999 }, 
					  { 999, 999, 0, 4, 999 }, 
					  { 999, 999, 2, 0, 3 },
					  { 3, 999, 999, 999, 0 } };//�׷��� ����� ���ᱭ��
	public Ployd_shortpath() {//�� ��忡�� ���� �Ƶ��ϴµ� �ɸ��� �ּҰ���ġ�� ���ϴ� �Լ�
		for (int i = 0; i < graph.length; i++) {//�������� ���
			for (int j = 0; j < graph.length; j++) {//�������
				for (int k = 0; k < graph.length; k++) {//��������
					if (graph[j][k] > graph[j][i] + graph[i][k]) {//�ٷΰ��� �溸�� ���İ��±��� ���� �� �۴ٸ�
						graph[j][k] = graph[j][i] + graph[i][k];//���İ��� ���� ����
					}
				}
			}
		}
	}
	public void printshortpath() {//�� ��忡�� ���� �Ƶ��ϴµ� �ɸ��� �ּҰ���ġ�� �����ϴ� �Լ�
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