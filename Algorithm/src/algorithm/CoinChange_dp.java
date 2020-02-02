package algorithm;

public class CoinChange_dp {

	int[] coin = { 1, 4, 5, 6 };

	public int coinchange_dp(int x) {

		int[] casenumber = new int[x];
		for (int i = 0; i < casenumber.length; i++) {
			casenumber[i] = -1;//-1로 초기화
		}

		return result(casenumber, x);
	}

	public int result(int[] array, int x) {

		int temp;
		for (int i = 0; i < coin.length; i++) {//코인의 종류를 하나씩 추가
			for (int j = 0; j < array.length; j++) {//1~n까지 코인개수 구하기
//				if ((j + 1) % coin[i] == 0) {//동전으로  교환해야할 금액이 나누어 떨어지면
//					array[j] = (j + 1) / coin[i];//동전의 개수저장 
//				} else if (j + 1 > coin[i] && (j + 1) % coin[i] != 0) {//동전으로 교환해야할 금액이 동전보다 크고, 나누어떨어지지않으면(동전보다 작은 수는 다시계산하지않음)
//					temp = array[j - coin[i]] + 1;//이전에 구해놨던 값사용
//					if (array[j] < temp) {//새로구한값이 이전의 값보다크면 저장하지않음
//
//					} else {// 새로구한값이 이전에 구한값보다 작거나 같으면 업데이트
//						array[j] = temp;
//					}
//				}
				//냅색과 같은 방법으로 다시 풀어보기
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
