package guitar_ver4;

public class Guitar {

	private String serialNumber;
	private double price;
	GuitarSpec spec;
	//속성추가에 변경을 최소화하기위해 Spec클래스를 생성자의 인스턴스로받음
	public Guitar(String serialNumber, double price, GuitarSpec spec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float newPrice) {
		this.price = newPrice;
	}

	public GuitarSpec getSpec() {
		return spec;
	}
}
