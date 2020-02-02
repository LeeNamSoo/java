package baekjoon;

import java.util.Random;
import java.util.Scanner;

public class array_TheNumOfNums {

	public array_TheNumOfNums() {

		int multi = 0;
		int num[] = new int[3];
		int count[] = new int[10];
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			num[i] = rand.nextInt(900)+100;
			for(int j=0;j<i;j++) {
				if(num[i]==num[j]) {
					i--;
				}
			}
//			num[i] = scan.nextInt();
		}
		multi = num[0]*num[1]*num[2];
		System.out.println("multi : " + multi);
		while(multi!=0) {
			count[multi%10]++;
//			System.out.println("count[multi%10] : " + count[multi%10]);
			multi = multi/10;
//			System.out.println(multi);
		}
		for(int i=0;i<10;i++) {
			System.out.println(count[i]);
		}
	}

}
