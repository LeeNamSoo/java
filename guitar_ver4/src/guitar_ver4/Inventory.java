package guitar_ver4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List guitars;

	public Inventory() {
		guitars = new LinkedList();
	}

	public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
		Guitar guitar = new Guitar(serialNumber, price, spec);
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

	public List search(GuitarSpec searchSpec) {
		List matchingGuitars = new LinkedList();
		for (Iterator i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSpec().matches(searchSpec))//속성비교 기능을 Spec클래스에 위임
				matchingGuitars.add(guitar);
		}
		return matchingGuitars;
	}
}
