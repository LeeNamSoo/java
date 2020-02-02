package algorithm;

public class GCD {

	public int GCD_sub(int x, int y) {// 뻴셈을 이용한 최대공약수 구하기

		while (x != 0 && y != 0) {
			if (x <= y) {
				y = y - x;
			} else if (x >= y) {
				x = x - y;
			}
		}
		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		}
		return 0;
	}

	public int GCD_mod_repeat(int x, int y) {// 나머지를 이용한 최대공약수 구하기_반복
		while (x != 0 && y != 0) {
			if (x <= y) {
				y = y % x;
			} else if (x >= y) {
				x = x % y;
			}
		}

		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		}
		return 0;
	}

	public int GCD_mod(int x, int y) {// 나머지를이용한 최대공약수 구하기_재귀

		int temp;
		if (y > x) {
			temp = x;
			x = y;
			y = temp;
		}
		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		}
		return GCD_mod(x % y, y);

	}

}
