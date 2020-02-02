package algorithm;

import java.util.ArrayList;

public class KnapsackProblem_food {
	ArrayList<Item_food> item = new ArrayList<Item_food>();
	ArrayList<Item_food> result = new ArrayList<Item_food>();
	ArrayList<Double> density = new ArrayList<Double>();
	Item_food wine = new Item_food("wine", 89, 123);
	Item_food beer = new Item_food("beer", 90, 154);
	Item_food pizza = new Item_food("pizza", 95, 258);
	Item_food burger = new Item_food("burger", 100, 354);
	Item_food fires = new Item_food("fires", 90, 365);
	Item_food coke = new Item_food("coke", 79, 150);
	Item_food apple = new Item_food("apple", 50, 95);
	Item_food dount = new Item_food("dount", 10, 195);
	Item_food temp = new Item_food();
	Item_food NULL = new Item_food();
	double compare=0;
	int value, calory, capacity = 750;

	public KnapsackProblem_food() {
	}

	public KnapsackProblem_food(String key) {
		if (key == "value") {
			item.add(dount);
			item.add(apple);
			item.add(coke);
			item.add(wine);
			item.add(beer);
			item.add(fires);
			item.add(pizza);
			item.add(burger);
			while (capacity > 0) {
				int i;
				for (i = 0; i < item.size(); i++) {
					if (item.get(i).getValue() == 0) {
						break;
					}
					if (compare < item.get(i).getValue() && capacity > item.get(i).getCalory()) {// key에 따른 아이템저장
						compare = item.get(i).getValue();
						temp = item.get(i);
					}
				}
				capacity -= temp.getCalory();
				if (capacity <= 0) {
					break;
				}
				compare = 0;
				result.add(temp);
				item.set(i - 1, NULL);
			}
		} else if (key == "calory") {
			item.add(apple);
			item.add(wine);
			item.add(coke);
			item.add(beer);
			item.add(dount);
			item.add(pizza);
			item.add(burger);
			item.add(fires);
			while (capacity > 0) {
				int i;
				for (i = 0; i < item.size(); i++) {
					if (item.get(i).getValue() == 0) {
						break;
					}
					if (compare < item.get(i).getCalory() && capacity > item.get(i).getCalory()) {// key에 따른 아이템저장
						compare = item.get(i).getCalory();
						temp = item.get(i);
					}
				}
				capacity -= temp.getCalory();
				if (capacity <= 0) {
					break;
				}
				compare = 0;
				result.add(temp);
				item.set(i - 1, NULL);
			}
		} else if (key == "density") {
			item.add(dount);
			item.add(apple);
			item.add(coke);
			item.add(wine);
			item.add(beer);
			item.add(fires);
			item.add(pizza);
			item.add(burger);
			for (int i = 0; i < item.size(); i++) {
				density.add((double) (item.get(i).getValue() /(double) item.get(i).getCalory()));
			}
			while (capacity > 0) {
				int i;
				for (i = 0; i < density.size(); i++) {
					if (density.get(i) == 0.0) {
						i++;
					}
					if (i < density.size()) {
						if (compare < density.get(i)&& capacity > item.get(i).getCalory()) {// key에 따른 아이템저장
							compare = density.get(i);
							temp = item.get(i);
						}
					}
				}
				capacity -= temp.getCalory();
				if (capacity <= 0) {
					break;
				}
				result.add(temp);
				for (i = 0; i < density.size(); i++) {//이미 담은 아이템을 없앤다
					if (compare == density.get(i)) {
						density.set(i, 0.0);
					}
				}
				compare = 0;
				
			}
		}
		for (int i = 0; i < result.size(); i++) {
			value += result.get(i).getValue();
		}
		System.out.println("Use greedy by value to allocate 750 calories");
		System.out.println("Total value of items taken = " + value);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getName() + " : <" + result.get(i).getValue() + ", "
					+ result.get(i).getCalory() + ">");
		}
	}
}
