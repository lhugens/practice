import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    // Sieve of Eratosthenes Algorithm
    public static int countPrimes(int n){

        if (n <= 2){
            return 0;
        }

        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
           isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
           if(isPrime[i]) {
               for (int j = i * i; j < n; j += i) {
                  isPrime[j] = false;
               }
           }
        }


        return (int) IntStream.range(2, n).filter(i -> isPrime[i]).count();
    }

    public static void main(String[] args) {
        int n;

        System.out.println(countPrimes(10));

        System.out.println(countPrimes(0));
    }
}
