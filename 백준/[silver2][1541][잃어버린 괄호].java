import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int result(String line){
        // System.out.println(line);
        String[] A = line.split("\\+");

        if(A.length == 1) return Integer.parseInt(A[0]);

        int total = 0;
        for(String item : A){
            total += Integer.parseInt(item);
        }

        return total;
    }
    
    public static void main(String[] args) {
        //System.out.println(Arrays.toString("Helloworld!".split(" "))); [Helloworld!]
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        
        String A[] = line.split("-");
        int total = result(A[0]);

        for(int i = 1; i < A.length; i++){
            total -= result(A[i]);
        }

        System.out.println(total);
    }
}
