package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class Cow_Transport_greedy {
	ArrayList<Cow> ship = new ArrayList<Cow>();
	int limited=10;
	public Cow_Transport_greedy() {
		int limited = this.limited;
		ArrayList<Cow> cow = new ArrayList<Cow>();
		Cow jes = new Cow("Jesse", 6);
		Cow may = new Cow("Maybel", 3);
		Cow cal = new Cow("Callie", 2);
		Cow mag = new Cow("Maggie", 5);
		cow.add(jes);
		cow.add(cal);
		cow.add(may);
		cow.add(mag);
		trip(cow, limited);
	}

	public void trip(ArrayList<Cow> cow, int limited) {
		int temp;
		while (!cow.isEmpty()) {
			temp = 0;
			for (int i = 0; i < cow.size(); i++) {
				if (cow.get(i).weight >= cow.get(temp).weight && limited >= cow.get(i).weight) {
					temp = i;//무게가 가장큰 소를 고른다.
				}
			}

			limited -= cow.get(temp).weight;
			if (limited > 0) {//제한된 무게를 넘지 않았다면 배에 태운다
				ship.add(cow.get(temp));//배에태운다
				cow.remove(temp);//배에 탄 소는 없애준다
			}
			if (limited <= 0 || cow.isEmpty()) {//배의 무게를 초과했거나 남아있는 소가 없다면
				for (int i = 0; i < ship.size(); i++) {
					System.out.print("<" + ship.get(i).name + ">");
				}
				System.out.println();
				ship.clear();//소를 배에서 내린다.
				limited = this.limited;//배에 실을 수 있는 무게가 원래대로 돌아간다.
			}

			temp = 0;
		}
	}

}
