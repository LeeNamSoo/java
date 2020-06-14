package enumType;

public enum Style {

	A, F;

	public static String toString(int i) {
		switch (i) {
		case 0:
			return "A style";
		case 1:
			return "F style";
		default:
			return "Unspecified";
		}
	}
}