package algorithm;
//피봇을 기준으로 왼쪽은 피봇보다 작은 값을, 오른쪽은 피봇보다 큰 값을 저장한다. 
//함수에 배열과 정렬할 범위를 입력해준다.
//while이 3개가 있는데 가장 바깥쪽 반복은 검색 종료 조건내에서 반복할  수 있게 한다.
//안에 있는 각각의 반복문은 왼쪽에서 오른쪽으로, 오른쪽에서 왼쪽으로 이동하며 피봇보다 큰값(왼->오)과 피봇보다 작은 값(오->왼)을 찾는다.
//시작과 끝이 같아지면 함수는 종료된다.
public class QuickSort {

//	int[] x = {4,3,7,8,2,9,1,6,5};
	public void quicksort(int[] x, int start, int end) {
		if(start>=end) {
			return;
		}
		int lp = start+1, rp = end-1, temp;
		int pivot = x[start];
		while (lp < rp) {
			while (pivot>x[lp]) {
				lp++;
			}
			while (pivot<x[rp]) {
				rp--;
			}
			if(lp>rp) {
				temp=x[rp];
				x[rp] = pivot;
				x[start] = temp;
			}else {
				temp=x[lp];
				x[lp]=x[rp];
				x[rp]=temp;
			}
		}
		
		quicksort(x,start,lp-1);//피봇 왼쪽정렬
		quicksort(x,lp,end);//비봇 오른쪽정렬
	}
}
