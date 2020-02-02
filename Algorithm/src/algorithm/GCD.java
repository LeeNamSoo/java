package algorithm;

public class GCD {

	public int GCD_sub(int x, int y) {// �y���� �̿��� �ִ����� ���ϱ�

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

	public int GCD_mod_repeat(int x, int y) {// �������� �̿��� �ִ����� ���ϱ�_�ݺ�
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

	public int GCD_mod(int x, int y) {// ���������̿��� �ִ����� ���ϱ�_���

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
