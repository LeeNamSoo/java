package uTill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
//HashMap 분석 
public class AnalysisHashMapUtil {
//기타패널과 만돌린패널에서 사용 -> 검색한 하나의 행 데이터를 list로 가지고 와서 키와 값들 출력.
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