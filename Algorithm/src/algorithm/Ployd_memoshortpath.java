package algorithm;

import java.util.ArrayList;

public class Ployd_memoshortpath {
	int[][] graph = { { 0, 1, 999, 1, 5 }, { 9, 0, 3, 2, 999 }, { 999, 999, 0, 4, 999 }, { 999, 999, 2, 0, 3 },
			{ 3, 999, 999, 999, 0 } };
	int[][] path = new int[5][5];// �������� �������
	ArrayList<Integer> shortpath = new ArrayList<Integer>();

	public Ployd_memoshortpath() {
		for (int i = 0; i < graph.length; i++) {// �������� ���
			for (int j = 0; j < graph.length; j++) {// �������
				for (int k = 0; k < graph.length; k++) {// ��������
					if (graph[j][k] > graph[j][i] + graph[i][k]) {// ��ó���� ���� �������� �溸�� ����ġ���� �� ������
						graph[j][k] = graph[j][i] + graph[i][k];// �� ���� ����(�ּ� ����ġ����)
						path[j][k] = i + 1;// ���İ��� ��� ����
//						shortpath[i][k] = 0;
					}
				}
			}
		}
	}

	public void printshortpath(int start, int end) {// start���� end�� ���� �ִܰ�θ� �ⷰ�ϴ� �Լ�
		
		if (shortpath.isEmpty()) {// ��ι迭�� ����ٸ� �����־���, ù��° ���� �ߺ��ⷰ�Ǵ°��� ��������
			shortpath.add(start);
			System.out.println(start + "���� " + end + "���� �ִܰ��");
			System.out.print(shortpath.get(0));
		}
		if (path[start - 1][end - 1] != 0) {// ���İ��� ���� �ִٸ�
			printshortpath(start, path[start - 1][end - 1]);// ���İ��±����
		}
		shortpath.add(end);
		System.out.print("->" + shortpath.get(shortpath.size() - 1));// ��θ� �����
		shortpath.remove(shortpath.size() - 1);// ����
	}

	public void printvaluepath() {// ���������ϴ� ��ΰ� ����� �׷����� ����ϴ� �Լ�
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}

