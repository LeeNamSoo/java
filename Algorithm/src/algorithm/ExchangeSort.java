package algorithm;

public class ExchangeSort {

	public int[] exchangesort(int[] x) {
		int temp;
		for (int i = 0; x.length > i; i++) {
			for (int j = i + 1; x.length > j; j++) {
				if (x[i] > x[j]) {
					temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
		return x;

	}
}
