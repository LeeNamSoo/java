package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	
	ArrayList<LinkedList<Integer>> graph;
	public  Graph(int x) {//생성자 노드의 수만큼 배열 길이 생성
		graph = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i<x; i++) {
			graph.add(new LinkedList<Integer>());
		}
	}
	public void addedge(int x, int y) {//노드의 양방향 연결함수
		graph.get(x-1).add(y);
		graph.get(y-1).add(x);
	}
	public void printgraph() {//인접노드 출력함수
		for(int i = 0; i<graph.size();i++) {
			System.out.print(i+1+"의 인접 노드  ");
			for(int j=0; j<graph.get(i).size();j++) {
				System.out.print("->"+graph.get(i).get(j));
			}
			System.out.println();
		}
	}
	
}
