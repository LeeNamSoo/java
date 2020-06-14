package enumType;

public enum Builder {

	FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

	public static String toString(int i) {
		switch (i) {
		case 0:
			return "fender";
		case 1:
			return "martin";
		case 2:
			return "gibson";
		case 3:
			return "collings";
		case 4:
			return "olson";
		case 5:
			return "ryan";
		case 6:
			return "prs";
		default:
			return "Unspecified";
		}
	}
}