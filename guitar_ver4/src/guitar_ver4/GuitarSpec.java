package guitar_ver4;

public class GuitarSpec {

	private Builder builder;
	private String model;
	private Type type;
	private int numStrings;
	private Wood backWood;
	private Wood topWood;
	//속성추가시 이 클래스만 변경하여 추가가능
	public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.numStrings = numStrings;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	public boolean matches(GuitarSpec otherSpec) {//인벤토리의 search메소드의 비교기능을 위임받음
		if (builder != otherSpec.builder)
			return false;
		if ((model != null) && (!model.equals("")) && (!model.toLowerCase().equals(otherSpec.model.toLowerCase())))
			return false;
		if (type != otherSpec.type)
			return false;
		if (numStrings != otherSpec.numStrings)
			return false;
		if (backWood != otherSpec.backWood)
			return false;
		if (topWood != otherSpec.topWood)
			return false;
		return true;
	}
}
