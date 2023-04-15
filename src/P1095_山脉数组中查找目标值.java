public class P1095_山脉数组中查找目标值 {
    interface MountainArray {
      public int get(int index);
      public int length();
  }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mid = findMid(mountainArr);
        int pos = searchLeft(target,0,mid,mountainArr);
        if(pos == -1) {
            pos = searchRight(target,mid+1,mountainArr.length()-1, mountainArr);
        }
        return pos;
    }

    private int searchRight(int target,int l ,int r, MountainArray mountainArr) {
        int left = l;
        int right = r;
        int num = 0;
        while (left <= right) {
            int m = left + (right - left) / 2;
            num = mountainArr.get(m);
            if(num > target) {
                left = m + 1;
            }else if(num < target) {
                right = m - 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    private int searchLeft(int target,int l ,int r, MountainArray mountainArr) {
        int left = l;
        int right = r;
        int num = 0;
        while (left <= right) {
            int m = left + (right - left) / 2;
            num = mountainArr.get(m);
            if(num > target) {
                right = m - 1;
            }else if(num < target) {
                left = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    private int findMid(MountainArray mountainArr) {

        int left = 0;
        int right = mountainArr.length();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int pre = -1, next = -1,now = 0;
            now = mountainArr.get(mid);
            if(mid - 1 >= 0) pre = mountainArr.get(mid-1);
            if(mid + 1 < mountainArr.length()) next = mountainArr.get(mid+1);
            System.out.println("left = " + left + ", right = " + right + " , mid = " + mid + ", now = " + now + ", pre = " + pre +", next = " + next);
            if(now > pre && now > next) return mid;
            else if(now > pre) left = mid + 1;
            else right = mid;
        }
        return -1;
    }


}

