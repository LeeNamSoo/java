
package algorithm;

public class KnapsackProblem_dp {
	
	int[][] result;
//0은 무게, 1은 가치
	public int knapsackproblem_dp(int[][] item, int capacity) {

		result = new int[item.length+1][capacity + 1];
		for (int i = 1; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if (item[i-1][0] > j)//현재 아이템의 무게보다 수용량이 작으면
					result[i][j] = result[i - 1][j];//이전 값과 같다.
				else {
					result[i][j] = MAX(item[i-1][1] + result[i - 1][j - item[i-1][0]], result[i - 1][j]);
					                   //현재 아이템의 가치와 현재 아이템의 무게를 뺀 경우에서 최적의 가치를 더한다.//이전의 값과 비교 후  큰 값을 저장한다.
				}
			}
		}
		return result[item.length][capacity];
	}
	public int MAX(int a, int b) {
		return a > b ? a : b;
	}
}
