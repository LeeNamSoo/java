package algorithm;

public class Binarysearch {
	int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public int binarysearch(int x) {
		int mid = array.length / 2;
		if (x == array[mid]) {
			return mid;
		} else if (x < mid) {
			return result(0, mid - 1, x);
		} else {
			return result(mid + 1, array.length - 1, x);
		}
	}

	public int result(int start, int end, int x) {
		int mid = (start + end) / 2;
		if (mid == x) {
			return mid;
		} else if (x < mid) {
			return result(0, mid - 1, x);
		} else {
			return result(mid + 1, array.length - 1, x);
		}
	}

}
