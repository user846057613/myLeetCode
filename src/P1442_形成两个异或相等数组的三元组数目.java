public class P1442_形成两个异或相等数组的三元组数目 {
    public int countTriplets(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] xor = new int[n];
        xor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            xor[i] = xor[i-1] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int a = xor[j-1] ^ xor[i] ^ arr[i];
                    int b = xor[k] ^ xor[j] ^ arr[j];
                    if(a == b) ans++;
                }
            }
        }
        return ans;
    }
}
