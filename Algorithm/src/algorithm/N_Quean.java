package algorithm;

import java.util.Scanner;

public class N_Quean {
	int count = 0;
	public N_Quean() {
		Scanner scan = new Scanner(System.in);
		int quean = scan.nextInt();
		int[] colunm = new int[quean];
		for (int i = 0; i < colunm.length; i++) {
			colunm[0] = i;
			queans(colunm, 0);
		}
		System.out.println(count);
	}
	public void queans(int[] colunm, int index) {
		if (ispromising(colunm, index)) {
			if (index == colunm.length - 1) {
				for (int j = 0; j < colunm.length; j++) {
					System.out.println("colunm[" + j + "] : " + colunm[j]);
				}
				count++;
				return;
			}
			for (int i = 0; i < colunm.length; i++) {
				colunm[index + 1] = i;
				queans(colunm, index + 1);
			}
		}
		return;
	}
	public boolean ispromising(int[] colunm, int index) {
		boolean flag = true;
		int i = 0;
		while (i < index && flag) {
			if (colunm[index] == colunm[i] || abs(colunm[index], colunm[i]) == abs(i, index)) {
				flag = false;
			}
			i++;
		}
		return flag;
	}

	public int abs(int x, int y) {
		if (x > y) {
			return x - y;
		} else
			return y - x;
	}

}