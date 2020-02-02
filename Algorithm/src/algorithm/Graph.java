package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	
	ArrayList<LinkedList<Integer>> graph;
	public  Graph(int x) {//������ ����� ����ŭ �迭 ���� ����
		graph = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i<x; i++) {
			graph.add(new LinkedList<Integer>());
		}
	}
	public void addedge(int x, int y) {//����� ����� �����Լ�
		graph.get(x-1).add(y);
		graph.get(y-1).add(x);
	}
	public void printgraph() {//������� ����Լ�
		for(int i = 0; i<graph.size();i++) {
			System.out.print(i+1+"�� ���� ���  ");
			for(int j=0; j<graph.get(i).size();j++) {
				System.out.print("->"+graph.get(i).get(j));
			}
			System.out.println();
		}
	}
	
}
