package member.provider.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

public class ShuangFaTest {
    public static void main(String[] args) {

        int[] nums  = new int[]{2,7,11,15};
        int target = 26;
//
//         int  a = 0,b = 0;
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = 0; j < nums.length; j++) {
//                if(target -  nums[j] ==  nums[i]){
//                    b = j ;
//                    a = i;
//                    break;
//                }
//
//            }
//        }
//
//        System.out.println(Arrays.asList(a,b));

        // k  - 值    v - 下标
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)){
                System.out.println(Arrays.asList(map.get(key),i));
                break;
            }
            map.put(nums[i],i);
        }


    }

}
