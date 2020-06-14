package guitar_ver4;

public class Guitar {

	private String serialNumber;
	private double price;
	GuitarSpec spec;
	//�Ӽ��߰��� ������ �ּ�ȭ�ϱ����� SpecŬ������ �������� �ν��Ͻ��ι���
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
