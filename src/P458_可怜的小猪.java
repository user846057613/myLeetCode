public class P458_可怜的小猪 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie;
        int base = times + 1;

        double ans = Math.log(buckets) / Math.log(base);
        int res = (int) Math.ceil(ans);
        return res;
    }
}
