import java.util.Iterator;
import java.util.List;

public class P341_扁平化嵌套列表迭代器 {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class NestedIterator implements Iterator<Integer> {

        List<NestedInteger> list;
        int pos;
        int size;
        NestedIterator t;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = nestedList;
            pos = 0;
            size = list.size();
        }
        @Override
        public boolean hasNext() {
            while (pos < size ) {
                if(t == null && !list.get(pos).isInteger()) {
                    t = new NestedIterator(list.get(pos).getList());
                }
                if(t == null || t.hasNext()) {
                    return true;
                }else {
                    pos++;
                    t = null;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            NestedInteger now = list.get(pos);
            if(now.isInteger()) {
                pos++;
                return now.getInteger();
            }else{
                if(t == null) {
                    t = new NestedIterator(now.getList());
                }
                Integer n = t.next();
                if(!t.hasNext()){
                    t = null;
                    pos++;
                }
                return n;
            }
        }
    }
}

