package algorithm;

public class CoinChange_greedy {

	public int coinchange_greedy(int x) {
		int result = 0;
		int[] array = { 1, 4, 5, 6 };
		for (int i = array.length - 1; i >= 0; i--) {
			result = x / array[i];
			x = x % array[i];
		}
		return result;
	}

}
