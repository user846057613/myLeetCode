public class P134_加油站 {
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int[] save = new int[n];
        for (int i = 0; i < n; i++) {
            save[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < n; i++) {
            if(save[i] >= 0) {
                int index = ( i + 1 ) % n;
                int num = save[i];
                while (index != i) {
                    num += save[index];
                    if(num < 0) {
                        break;
                    }
                    index = (index + 1) % n;
                }
                if(index == i) {
                    return i;
                }else{
                    continue;
                }
            }
        }
        return -1;
    }
}
