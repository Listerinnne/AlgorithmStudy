package boj;

import java.util.Scanner;
import java.lang.Math;

public class boj_17404_jeongwoo {

    public static int find_min(int[][] rgb, int n) {
        // 위치별 최소값을 저장할 res배열 생성
        int[][] res = new int[n+1][3];

        // 첫 번째 줄과 마지막 줄의 색을 비교하기 위해 first_line 배열 생성
        int[][] first_line = new int[n+1][3];

        // 첫 번째 줄의 res값은 저장된 rgb배열의 크기와 같음
        for (int i = 0; i < 3; i++) {
            res[1][i] = rgb[1][i];
            first_line[1][i] = i;
        }

        // dp
        // res 배열 => N번재 줄의 r로 끝나는 최소값, g로 끝나는 최소값, b로 끝나는 최소값 중의 최소를 구하기
        // N번째 줄의 r로 끝나는 최소값 == min(N-1번째 줄에서 g로 끝나는 최소값, N-1번째 줄에서 b로 끝나는 최소값) + rgb[n][0];
        for (int i = 2; i <= n-1; i++) {
            for (int j = 0; j < 3; j++) {
                int min;    // r, g, b 중에서 작은 값의 idx
                if (j == 0)
                    min = (res[i - 1][1] < res[i-1][2]) ? 1 : 2;
                else if (j == 1)
                    min = (res[i - 1][0] < res[i - 1][2]) ? 0 : 2;
                else
                    min = (res[i - 1][0] < res[i-1][1]) ? 0 : 1;

                res[i][j] = res[i-1][min] + rgb[i][j];
                first_line[i][j] = first_line[i-1][min];
            }
        }

        int min = 1000000;

        for (int i = 0; i < 3; i++) {   // i는 n-1번째 줄의 r, g, b의 idx
            for (int j = 0; j < 3; j++) {   // j는 마지막 줄의 r,g,b의 인덱스
                if (j != i && j != first_line[n-1][i]) {  // 마지막 줄 idx != n-1번째의 idx && 마지막 줄 idx != n-1번째까지 왔을 때의 1번째 줄 idx
                    int sum = res[n-1][i] + rgb[n][j];    // n-1번째 res값에 n번째 값을 더해준다.
                    min = Math.min(min, sum);       // 해당 값이 최소값인지 비교해서 업데이트
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 총 몇 줄 입력할지 (n줄)
        int n = sc.nextInt();

        // rgb 배열 생성(각 줄에서 색상별 크기 저장)
        int[][] rgb = new int[n+1][3];

        // rgb 배열에 값 입력
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 3; j++)
                rgb[i][j] = sc.nextInt();

        int[][] reversed_rgb = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                reversed_rgb[i][j] = rgb[n+1-i][j];
            }
        }

        int min = Math.min(find_min(rgb, n), find_min(reversed_rgb, n));
        System.out.print(min);
    }
}