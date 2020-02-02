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
					temp = i;//���԰� ����ū �Ҹ� ����.
				}
			}

			limited -= cow.get(temp).weight;
			if (limited > 0) {//���ѵ� ���Ը� ���� �ʾҴٸ� �迡 �¿��
				ship.add(cow.get(temp));//�迡�¿��
				cow.remove(temp);//�迡 ź �Ҵ� �����ش�
			}
			if (limited <= 0 || cow.isEmpty()) {//���� ���Ը� �ʰ��߰ų� �����ִ� �Ұ� ���ٸ�
				for (int i = 0; i < ship.size(); i++) {
					System.out.print("<" + ship.get(i).name + ">");
				}
				System.out.println();
				ship.clear();//�Ҹ� �迡�� ������.
				limited = this.limited;//�迡 ���� �� �ִ� ���԰� ������� ���ư���.
			}

			temp = 0;
		}
	}

}
