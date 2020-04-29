package question1095;

import DataStruction.MountainArray;

public class DichotomySolution {
    //时间复杂度：O(logn)	三次二分法。
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        //二分法找山顶下标
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            //小于右边的元素,说明mid在升序部分,向右收缩搜索区间
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int topIdx = left;
        //二分法到左边部分找
        int lResult = findInLeft(mountainArr, 0, topIdx - 1, target);
        //如果左边部分没有,检查target是否是山顶元素
        if (lResult != -1) {
            return lResult;
        } else if (mountainArr.get(topIdx) == target) {
            return topIdx;
        }
        //左边和山顶都没有，到右边部分二分法
        int rResult = findInRight(mountainArr, topIdx + 1, len - 1, target);
        return rResult;
    }

    private int findInRight(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findInLeft(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
