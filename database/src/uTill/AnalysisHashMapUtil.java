package uTill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
//HashMap �м� 
public class AnalysisHashMapUtil {
//��Ÿ�гΰ� �������гο��� ��� -> �˻��� �ϳ��� �� �����͸� list�� ������ �ͼ� Ű�� ���� ���.
	public static List analysisHashMap(List inputList) {
		List returnList = new ArrayList();
		Set keyset;
		HashMap tmp;
		
		String output = null;
		
		for(int i = 0; i < inputList.size(); i++) {
			tmp = (HashMap)inputList.get(i);
			keyset = tmp.keySet();
			String[] array = (String[]) keyset.toArray(new String[tmp.size()]);
			for (int j = 0; j < array.length; j++) {
				output += array[j] + " : " +tmp.get(array[j]) + " \n";
			}
			System.out.println(output);
			returnList.add(output);
		}
		System.out.println(returnList.toString());
		return returnList;
	}
	
}