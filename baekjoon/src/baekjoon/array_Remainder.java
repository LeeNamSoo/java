package baekjoon;

import java.util.Random;
import java.util.Scanner;

public class array_Remainder {

	public array_Remainder() {
		int count = 0;
		int num[] = new int[10];
		int remainder[] = new int[10];
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			num[i] = rand.nextInt(1000);
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					i--;
				}
			}
//			num[i] = scan.nextInt();
			num[i] = num[i] % 42;
			System.out.println("num[i] : " + num[i]);
		}
//		for(int i=0; i<10; i++) {
//			num[i] = num[i]%42;
//		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					num[i] = 0;
				}
			}
			if (num[i] != 0) {
				count++;
			}
		}
		System.out.println(count);
	}

}
