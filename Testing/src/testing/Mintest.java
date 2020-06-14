//package testing;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Mintest {
//	private List<String> list;
//
//	public void setUp() {
//		list = new ArrayList<String>();
//	}
//	public void tearDown() {
//		list = null;
//	}
//	public void testForNullList() {
//		list = null;
//		try {
//			Min.min(list);
//		} catch (NullPointerException e) {
//			// TODO: handle exception
//			return;
//		}
//		fail("NullpointerException expected");
//	}
//	public void testForNullElement() {
//		list.add(null);
//		list.add("cat");
//		Min.min(list);
//	}
//	public void testForSoloNullElement() {
//		list.add(null);
//		Min.min(list);
//	}
//	public void testMutuallyIncomparable() {
//		List list = new ArrayList();
//		list.add("cat");
//		list.add("dog");
//		list.add(1);
//		Min.min(list);
//	}
//	public void testEmptyList() {
//		Min.min(list);
//	}
//	public void testSingleElement() {
//		list.add("cat");
//		Object obj = Min.min(list);
//		assertTrue ("single Element List", obj.equals("cat"));
//	}
//	public void testDoubleElement() {
//		list.add("dog");
//		list.add("cat");
//		Object obj = Min.min(list);
//		assertTrue("Double Element list", obj.equals("cat"));
//	}
//}
