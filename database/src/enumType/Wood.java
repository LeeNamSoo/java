package enumType;

public enum Wood {

	INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

	public static String toString(int i) {
		switch (i) {
		case 0:
			return "indian_rosewood";
		case 1:
			return "brazilian_rosewood";
		case 2:
			return "mahogany";
		case 3:
			return "maple";
		case 4:
			return "cocobolo";
		case 5:
			return "cedar";
		case 6:
			return "adirondack";
		case 7:
			return "alder";
		case 8:
			return "sitka";
		default:
			return "unspecified";
		}
	}
}
