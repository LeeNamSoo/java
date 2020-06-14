package enumType;

public enum Type {

	ACOUSTIC, ELECTRIC;

	public static String toString(int i) {
		switch (i) {
		case 0:
			return "acoustic";
		case 1:
			return "electric";
		default:
			return "unspecified";
		}
	}
}