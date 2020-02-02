package algorithm;
//�Ǻ��� �������� ������ �Ǻ����� ���� ����, �������� �Ǻ����� ū ���� �����Ѵ�. 
//�Լ��� �迭�� ������ ������ �Է����ش�.
//while�� 3���� �ִµ� ���� �ٱ��� �ݺ��� �˻� ���� ���ǳ����� �ݺ���  �� �ְ� �Ѵ�.
//�ȿ� �ִ� ������ �ݺ����� ���ʿ��� ����������, �����ʿ��� �������� �̵��ϸ� �Ǻ����� ū��(��->��)�� �Ǻ����� ���� ��(��->��)�� ã�´�.
//���۰� ���� �������� �Լ��� ����ȴ�.
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
		
		quicksort(x,start,lp-1);//�Ǻ� ��������
		quicksort(x,lp,end);//�� ����������
	}
}
