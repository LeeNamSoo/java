package algorithm;
//������ ��ġ�� �߷��� �ִ�. ���濡 ���� �� �ִ� �߷��� �Ѱ谡 �ְ�

//���ѵ� �߷����� �ִ��� ��ġ�� ���� �� �ִ� ����� ã�ƶ�
//�׸��� : �� ���� ���� ���� �� (��ġ�� ���� ���� �ͺ��� ��, ���� ������ ���� �켱 ��, ������
//		�� ���� �� �켱 )

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
				if (value < array[i][1]) {//������ ū ����������
					value = array[i][1];
					weight = array[i][0];
				}
			}
			capacity -= weight;
			result += value;
			value = 0;
			weight = 0;
			array[i - 1][1] = 0;//������ ������ ����
		}
		return result;
	}

	public int knapsackproblem_weight(int[][] item, int capacity) {

		int[][] array = new int[item.length][item[0].length];
		capacity = 30;
		result = 0;
		value = 0;
		weight = 0;
		for (int i = 0; i < item.length; i++) {//������ �迭�� ����
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
				if (weight < array[i][0]) {//���԰�ū����������
					value = array[i][1];
					weight = array[i][0];
				}
			}
			capacity -= weight;
			result += value;
			value = 0;
			weight = 0;
			array[i - 1][0] = 0;//�����Ѿ����ۻ���
		}
		return result;
	}

	public int knapsackproblem_density(int[][] item, int capacity) {
		result = 0;
		value = 0;
		weight = 0;
		int temp = 0;
		int[][] array = new int[item.length][item[0].length];
		int[] density = new int[item.length];//�������� ����ġ ����
		for (int i = 0; i < item.length; i++) {
			for (int j = 0; j < item[i].length; j++) {
				array[i][j] = item[i][j];
			}
			density[i] = array[i][1] / array[i][0];
		}
		while (capacity > 0) {//���뷮�� ���������� �ݺ�
			int i;
			for (i = 0; i < array.length; i++) {
				if (density[i] == 0) {//���� ������ ����
					i++;
				}
				if (i < array.length) {//����ġ�� ū �����ۺ��� ��´�.
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
			for (i = 0; i < density.length; i++) {//�̹� ���� �������� ���ش�
				if (temp == density[i]) {
					density[i] = 0;
				}
			}
			temp = 0;
		}
		return result;
	}
}
