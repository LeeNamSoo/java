package algorithm;

public class InsertionSort {

	public int[] insertionsort(int[] x) {

		int temp, i, j;
		for (i = 1; x.length > i; i++) {
			temp = x[i];
			for (j = i - 1; j > -1; j--) {
				if (temp > x[j]) {
					break;
				}
				x[j + 1] = x[j];
			}
			x[j + 1] = temp;
		}
		return x;
	}
}
