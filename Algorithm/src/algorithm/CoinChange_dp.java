package algorithm;

public class CoinChange_dp {

	int[] coin = { 1, 4, 5, 6 };

	public int coinchange_dp(int x) {

		int[] casenumber = new int[x];
		for (int i = 0; i < casenumber.length; i++) {
			casenumber[i] = -1;//-1�� �ʱ�ȭ
		}

		return result(casenumber, x);
	}

	public int result(int[] array, int x) {

		int temp;
		for (int i = 0; i < coin.length; i++) {//������ ������ �ϳ��� �߰�
			for (int j = 0; j < array.length; j++) {//1~n���� ���ΰ��� ���ϱ�
//				if ((j + 1) % coin[i] == 0) {//��������  ��ȯ�ؾ��� �ݾ��� ������ ��������
//					array[j] = (j + 1) / coin[i];//������ �������� 
//				} else if (j + 1 > coin[i] && (j + 1) % coin[i] != 0) {//�������� ��ȯ�ؾ��� �ݾ��� �������� ũ��, �����������������(�������� ���� ���� �ٽð����������)
//					temp = array[j - coin[i]] + 1;//������ ���س��� �����
//					if (array[j] < temp) {//���α��Ѱ��� ������ ������ũ�� ������������
//
//					} else {// ���α��Ѱ��� ������ ���Ѱ����� �۰ų� ������ ������Ʈ
//						array[j] = temp;
//					}
//				}
				//������ ���� ������� �ٽ� Ǯ���
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		return array[x - 1];
	}
	
	public int MIN(int a, int b) {
		return a < b ? a : b;
	}
}
