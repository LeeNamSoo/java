package guitar_ver1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List guitars;//

	public Inventory() {
		guitars = new LinkedList();
	}

	public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood,
			String topWood) {
		Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
		guitars.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Iterator i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	public Guitar search(Guitar searchGuitar) {//대소문자 구분 불가로 찾는 기타가 있어도 못찾음, 찾는기타가 재고에 여려개 있어도 하나밖에 못 보여준다.
		for (Iterator i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			// Ignore serial number since that's unique
			// Ignore price since that's unique
			String builder = searchGuitar.getBuilder();
			if ((builder != null) && (!builder.equals("")) && (!builder.equals(guitar.getBuilder())))
				continue;
			String model = searchGuitar.getModel();
			if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel())))
				continue;
			String type = searchGuitar.getType();
			if ((type != null) && (!searchGuitar.equals("")) && (!type.equals(guitar.getType())))
				continue;
			String backWood = searchGuitar.getBackWood();
			if ((backWood != null) && (!backWood.equals("")) && (!backWood.equals(guitar.getBackWood())))
				continue;
			String topWood = searchGuitar.getTopWood();
			if ((topWood != null) && (!topWood.equals("")) && (!topWood.equals(guitar.getTopWood())))
				continue;
			return guitar;
		}
		return null;
	}
}
