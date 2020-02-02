package baekjoon;

import java.util.*;

public class array_Maxposition {

	public array_Maxposition() {
		int count = 0;
		int array[] = new int[9];
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		for (int i = 0; i < 9; i++) {
			array[i] = rand.nextInt(99)+1;
			for(int j=0;j<i;j++) {
				if(array[i]==array[j]) {
					i--;
				}
			}
//			array[i] = scan.nextInt();
		}

//		for(int i=0; i<9;i++) {
//			System.out.println(array[i]);
//		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (array[i] < array[j] && i != j) {
					count++;
				}
			}
			if (count == 0) {
				System.out.println(array[i]);
				System.out.println(i + 1);
				break;
			}
			count = 0;
		}
	}

}
