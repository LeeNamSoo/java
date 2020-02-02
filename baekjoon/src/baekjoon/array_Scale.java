package baekjoon;

import java.util.Random;
import java.util.Scanner;

public class array_Scale {

	public array_Scale() {
		int count = 0;
		int array[] = new int[8];
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		for (int i = 0; i < 8; i++) {
//			array[i] = rand.nextInt(8)+1;
//			for(int j=0;j<i;j++) {
//				if(array[i]==array[j]) {
//					i--;
//				}
//			}
			array[i] = scan.nextInt();
		}
		for (int i = 0; i < 7; i++) {
			if (array[i] - array[i + 1] == 1) {
				count++;
			} else if (array[i] - array[i + 1] == -1) {
				count--;
			}
		}
		if (count == 7) {
			System.out.println("descending");
		} else if (count == -7) {
			System.out.println("ascending");
		} else {
			System.out.println("mixed");
		}

	}

}
