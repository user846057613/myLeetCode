import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class P403_青蛙过河 {
    HashMap<Pair, Boolean> dp = new HashMap<>();
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        if(stones.length == 2) return true;
        return canStep(1,1,1,stones);
    }

    private boolean canStep(int index, int pos, int step, int[] stones) {
        if(index == stones.length-1) return true;
        Pair pair = new Pair(index,step);
        if(dp.containsKey(pair)) return dp.get(pair);
        int minPos = step >= 1 ? pos + step - 1 : pos;
        int midPos = pos + step;
        int maxPos = pos + step + 1;
        int indexMin = Arrays.binarySearch(stones,minPos);
        int indexMid = Arrays.binarySearch(stones,midPos);
        int indexMax = Arrays.binarySearch(stones,maxPos);
        boolean bMin = false;
        boolean bMid = false;
        boolean bMax = false;
        if(indexMin >= 0 && step - 1 > 0) {
            bMin = canStep(indexMin,minPos,step-1,stones);
            dp.putIfAbsent(new Pair(indexMin,step-1),bMin);
        }
        if(indexMid >= 0 && step > 0) {
            bMid = canStep(indexMid,midPos,step,stones);
            dp.putIfAbsent(new Pair(indexMid,step),bMid);
        }
        if(indexMax >= 0 && step > 0) {
            bMax = canStep(indexMax,maxPos,step+1,stones);
            dp.putIfAbsent(new Pair(indexMax,step+1),bMax);
        }
        return bMin || bMid || bMax;
    }
    class Pair{
        int index;
        int step;
        public Pair(int index, int step) {
            this.index = index;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index &&
                    step == pair.step;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, step);
        }
    }
}
