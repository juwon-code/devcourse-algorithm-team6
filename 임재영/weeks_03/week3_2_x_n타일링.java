package pgs.java.study;

public class week3_2_x_n타일링 {
    public static void main(String[] args) {
        week3_2_x_n타일링 sol = new week3_2_x_n타일링();
        System.out.println(sol.solution(4));
    }
    public long solution(int n) {
        long n1 = 1;
        long n2 = 2;
        long n3 = 0;
        for (int c = 3;c<=n;c++){
            n3 = (n1 + n2)%1000000007;
            n1 = n2%1000000007;
            n2 = n3%1000000007;
        }
        return n3;
    }
}

