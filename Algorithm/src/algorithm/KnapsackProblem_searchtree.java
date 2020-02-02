package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class KnapsackProblem_searchtree {
	public KnapsackProblem_searchtree() {
		ArrayList<Item_food> item = new ArrayList<Item_food>();
		ArrayList<Item_food> result = new ArrayList<Item_food>();
		HashMap<Integer, ArrayList<Item_food>> hashmap = new HashMap<Integer, ArrayList<Item_food>>();
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
		item.add(dount);
		item.add(apple);
		item.add(coke);
		item.add(wine);
		item.add(beer);
		item.add(fires);
		item.add(pizza);
		item.add(burger);
		double compare = 0;
		int value, calory, capacity = 750;
	}

	public ArrayList<Item_food> knapsackproblem_searchtree(HashMap<Integer, ArrayList<Item_food>> hashmap, ArrayList<Item_food> item,
			ArrayList<Item_food> result, int count, int calory) {
		if (hashmap.containsValue(item)) {
			return result;
		}
		hashmap.put(count, item);
		result.add(item.get(count));
		item.set(count, null);
		// 현재 아이템의 가치와 현재 아이템의 무게를 뺀 경우에서 최적의 가치를 더한다.//이전의 값과 비교 후 큰 값을
		// 저장한다.//(MAX(item.get(count).getValue()+result.get(count-1).getValue(), result.get(count-1).getValue())
		knapsackproblem_searchtree(hashmap, item, result, ++count, calory);
		return result;
	}

	public int MAX(int a, int b) {
		return a > b ? a : b;
	}
}