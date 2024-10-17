class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(k, 0, dungeons, 0);
        return answer;
    }
    
    public void dfs(int health, int count, int[][] dungeons, int visited){
        answer = Math.max(answer, count);
        for(int i = 0; i<dungeons.length; i++){
            //���� ���̴� �ǰ� ���� ���� �Ǻ��� ũ�� �Ȱ�
            if(health<dungeons[i][0]) continue;
            //�̹� �湮�� ���̸� �Ȱ�
            if((visited&(1<<i))!=0) continue;
            //���� �������� �� ���� ��, �鸥 ������, �湮ǥ�� �ؼ� ��͵���
            dfs(health-dungeons[i][1], count+1, dungeons, visited|(1<<i));
        }
    }
}
