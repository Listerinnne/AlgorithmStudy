import java.util.Scanner;

public class Main {
	public static int gcd(int a, int b) {
		int n1 = a;
		int n2 = b;
		while(n1!=n2) {
			if (n1>n2) { //n1�� �� �۾���
				int tmp1 = n1;
				n1 = n2;
				n2 = tmp1;
			}
			n2 = n2 - n1;
		}
		return n1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<T+1; test_case++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			if (Math.abs(x-y)%gcd(M, N)!=0) System.out.println(-1);
			else {
				//x�� �� �۵��� ������ �ٲ�
				if (y<x) {
					int tmp = M;
					M = N;
					N = tmp;
					
					tmp = x;
					x = y;
					y = tmp;
				}
				
				
				//�ϴ� <x, x>�� ����°ž�.
				int ans = x+1;
				int nowY = x;
				
				// �ι�° x�� y�� �ɶ����� x�� �� ���� ���ƾ� �ϴ����� ����ؾ��ϴµ�
				// x���� M�� ���� �ڱ� ��ġ�ϱ� �׶� y�� y+M�� �Ǵµ�,
				// ���� mod N�� ���ؼ� ����ϰ� �����ϱ�, N���� ���� ���� y�� �ɶ����� ����� �������� ����
				while (nowY!=y) {
					nowY = (nowY+M)%N;
					ans += M;
				}
				System.out.println(ans);
			}
		}
	}
}

