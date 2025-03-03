import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    static long func(long A, long B, long C) {
        if (B == 0) return 1; 
        long half = func(A, B / 2, C);
        long result = (half * half) % C;
        if (B % 2 == 1) result = (result * A) % C; 
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(func(A, B, C));
    }
}
