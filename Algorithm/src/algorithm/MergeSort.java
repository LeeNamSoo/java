package algorithm;

public class MergeSort {

//	int[] x = {4,3,7,8,2,9,1,6,5};
	public void mergesort(int[] x) {
		int mid = x.length / 2;
		int[] left = new int[mid];
		int[] right = new int[x.length - mid];

		if (x.length > 1) {

			for (int i = 0; i < mid; i++) {
				left[i] = x[i];
			}
			for (int i = 0; i < x.length - mid; i++) {
				right[i] = x[i + mid];
			}
			mergesort(left);
			mergesort(right);
			merge(left, right, x);
		}
	}

	public int[] merge(int[] left, int[] right, int[] sort) {
		int i = 0;
		int lp = 0;
		int rp = 0;
		while (left.length > lp && right.length > rp) {
			if (left[lp] > right[rp]) {
				sort[i++] = right[rp++];
			} else if (left[lp] < right[rp]) {
				sort[i++] = left[lp++];
			}
			if (left.length <= lp) {
				for (int j = rp; j < right.length; j++) {
					sort[i++] = right[j];
				}
			} else if (right.length <= rp) {
				for (int j = lp; j < left.length; j++) {
					sort[i++] = left[j];
				}
			}
		}
		return sort;
	}
}
