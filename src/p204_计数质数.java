import java.util.Arrays;

public class p204_计数质数 {
    public static final int MAX_NUM = 1000005;
    boolean[] isprime = new boolean[MAX_NUM];
    int[] prime = new int[100000];
    int counter = 0;
    public int countPrimes(int n) {
        getPrime();
        int ans = 0;
        for (int i = 0; i < counter; i++) {
            if(prime[i] < n) {
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }

    public void getPrime() {
        Arrays.fill(isprime,true);
        isprime[0] = false;
        isprime[1] = false;
        for (int i = 2; i < MAX_NUM; i++) {
            if(isprime[i]) {
                prime[counter++] = i;
            }
            for (int j = 0; j < counter && i * prime[j] < MAX_NUM; j++) {
                isprime[i*prime[j]] = false;
            }
        }
    }
}
