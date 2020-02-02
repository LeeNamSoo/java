package algorithm;

public class Fibonacci_dp {

	public int fibonacci(int x) {

		if (x <= 1) {
			return 0;
		} else if (x == 2) {
			return 1;
		}
		int[] array = new int[x];
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
		return dynamic_fibo(array, x);
	}

	public int dynamic_fibo(int[] x, int num) {
		if (num <= 1) {
			return 0;
		} else if (num == 2) {
			return 1;
		}
		if (x[num - 1] == -1) {
			x[num - 1] = dynamic_fibo(x, num - 1) + dynamic_fibo(x, num - 2);
		} else {
			return x[num - 1];
		}
		return x[num-1];
	}

}
