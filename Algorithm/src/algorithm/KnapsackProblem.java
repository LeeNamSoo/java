package algorithm;
//보물에 가치와 중량이 있다. 가방에 담을 수 있는 중량은 한계가 있고

//제한된 중량에서 최대의 가치를 가질 수 있는 방법을 찾아라
//그리디 : 그 순간 가장 좋은 것 (가치가 가장 높은 것부터 비교, 가장 가벼운 것을 우선 비교, 가성비
//		가 높은 것 우선 )

public class KnapsackProblem {

	int value, weight, result;

	public int knapsackproblem_profit(int[][] item, int capacity) {

		int[][] array = new int[item.length][item[0].length];
		result = 0;
		value = 0;
		weight = 0;
		for (int i = 0; i < item.length; i++) {
			for (int j = 0; j < item[i].length; j++) {
				array[i][j] = item[i][j];
			}
		}
		while (capacity > 0) {
			int i;
			for (i = 0; i < array.length; i++) {
				if (array[i][1] == 0) {
					break;
				}
				if (value < array[i][1]) {//이익이 큰 아이템저장
					value = array[i][1];
					weight = array[i][0];
				}
			}
			capacity -= weight;
			result += value;
			value = 0;
			weight = 0;
			array[i - 1][1] = 0;//자장한 아이템 삭제
		}
		return result;
	}

	public int knapsackproblem_weight(int[][] item, int capacity) {

		int[][] array = new int[item.length][item[0].length];
		capacity = 30;
		result = 0;
		value = 0;
		weight = 0;
		for (int i = 0; i < item.length; i++) {//아이템 배열을 복사
			for (int j = 0; j < item[i].length; j++) {
				array[i][j] = item[i][j];
			}
		}
		while (capacity > 0) {
			int i;
			for (i = 0; i < array.length; i++) {
				if (array[i][0] == 0) {
					break;
				}
				if (weight < array[i][0]) {//무게가큰아이템저장
					value = array[i][1];
					weight = array[i][0];
				}
			}
			capacity -= weight;
			result += value;
			value = 0;
			weight = 0;
			array[i - 1][0] = 0;//저장한아이템삭제
		}
		return result;
	}

	public int knapsackproblem_density(int[][] item, int capacity) {
		result = 0;
		value = 0;
		weight = 0;
		int temp = 0;
		int[][] array = new int[item.length][item[0].length];
		int[] density = new int[item.length];//아이템의 가중치 저장
		for (int i = 0; i < item.length; i++) {
			for (int j = 0; j < item[i].length; j++) {
				array[i][j] = item[i][j];
			}
			density[i] = array[i][1] / array[i][0];
		}
		while (capacity > 0) {//수용량이 넘을때까지 반복
			int i;
			for (i = 0; i < array.length; i++) {
				if (density[i] == 0) {//없앤 아이템 생략
					i++;
				}
				if (i < array.length) {//가중치가 큰 아이템부터 담는다.
					if (temp < density[i]) {
						temp = density[i];
						value = array[i][1];
						weight = array[i][0];
					}
				}
			}
			capacity -= weight;
			if (capacity <= 0) {
				break;
			}
			result += value;
			value = 0;
			weight = 0;
			for (i = 0; i < density.length; i++) {//이미 담은 아이템을 없앤다
				if (temp == density[i]) {
					density[i] = 0;
				}
			}
			temp = 0;
		}
		return result;
	}
}
