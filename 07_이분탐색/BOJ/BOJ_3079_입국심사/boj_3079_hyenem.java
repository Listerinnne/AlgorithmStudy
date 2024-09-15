import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextLong();
		int[] arr = new int[N];
		
		int mintime = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			mintime = Math.min(mintime, arr[i]);
		}
		
		//�ð��� ��� �̰ź��� ���԰ɸ��� : ���� ���� ������ �˻��븸�� �̿��� �� ����ϴ� ���
		long right = mintime * M;
		long left = 1;
		long mid = 0;
		long ans = right;
		//�̺�Ž���� �ϸ鼭 left�� right�� ��������
		//���ʿ� �ּ� �ð����� �����ʿ� �ּ� �ð����� Ȯ����
		while(left<=right) {
			mid = (left+right)/2;
			long count = 0;
			// mid �ð����� �� �˻��뿡 �� ���� ����� �� �ִ���
			// mid�� �� �˻��뿡�� �ɸ��� �ð����� ���� 
			for(int i = 0; i<N; i++) {
				count += mid/arr[i];
			}
			
			// M�� �̻��� ����ϸ� ���� ������ ������ ��
			// �� ������ ���信 mid�� ����
			if(count>=M) {
				ans = mid;
				right = mid-1;
			} else { //M���� �� ��� ���ϸ� ���� �� �������� 
				left = mid+1;
			}
		}
		System.out.println(ans);
	}
}

