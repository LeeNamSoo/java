package algorithm;

public class Item_food {
	
	String name;
	
	int value;
	int calory;
	public Item_food() {
		name= null;
		value=0;
		calory=0;
	}
	public Item_food(String name, int value, int calory) {
		this.name=name;
		this.value=value;
		this.calory=calory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCalory() {
		return calory;
	}
	public void setCalory(int calory) {
		this.calory = calory;
	}
}
