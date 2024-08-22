import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int M;
	static int N;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		//��������Ʈ �����
		adj = new ArrayList[N];
		for(int i = 0; i<N; i++) {
			adj[i]=new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		
		// 5�� �̻� ����Ǿ� �ִ��� Ž���ϱ�
		// Ž���ϴ� �߿� 5�̻� ������ �׳� ����
		ans = 0;
		for(int i = 0; i<N; i++) {
			if(adj[i].size()!=0) {
				visited = new boolean[N];
				dfs(i, 1);
				if(ans==1) break;
			}
		}
		System.out.println(ans);
	}
	
	static void dfs(int start, int count) {
		if(count==5) {
			ans=1;
			return;
		}
		visited[start]=true;
		for(int i = 0; i<adj[start].size();i++) {
			if(!visited[adj[start].get(i)])
				dfs(adj[start].get(i), count+1);
		}
		visited[start]=false;
	}
}

