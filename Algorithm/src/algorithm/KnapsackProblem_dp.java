
package algorithm;

public class KnapsackProblem_dp {
	
	int[][] result;
//0�� ����, 1�� ��ġ
	public int knapsackproblem_dp(int[][] item, int capacity) {

		result = new int[item.length+1][capacity + 1];
		for (int i = 1; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if (item[i-1][0] > j)//���� �������� ���Ժ��� ���뷮�� ������
					result[i][j] = result[i - 1][j];//���� ���� ����.
				else {
					result[i][j] = MAX(item[i-1][1] + result[i - 1][j - item[i-1][0]], result[i - 1][j]);
					                   //���� �������� ��ġ�� ���� �������� ���Ը� �� ��쿡�� ������ ��ġ�� ���Ѵ�.//������ ���� �� ��  ū ���� �����Ѵ�.
				}
			}
		}
		return result[item.length][capacity];
	}
	public int MAX(int a, int b) {
		return a > b ? a : b;
	}
}
