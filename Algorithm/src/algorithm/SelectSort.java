package algorithm;

public class SelectSort {

	public int[] selectionsort(int[] x) {

		int temp;
		for (int i = 0; x.length > i; i++) {
			int smallest = i;
			for (int j = i + 1; x.length > j; j++) {
				if (x[smallest] > x[j]) {
					smallest = j;
				}
			}
			temp = x[i];
			x[i] = x[smallest];
			x[smallest] = temp;
		}
		return x;
	}
}
