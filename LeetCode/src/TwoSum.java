import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int [] result = new int[2];
        // value, index
        Map<Integer, Integer> set = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
        	if (set.containsKey(target-nums[i])) {
        		result[1] = i;
        		result[0] = set.get(target-nums[i]);
        	} else {
        		set.put(nums[i], i);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int [] num = {2, 7, 11, 15};
		TwoSum twoSum = new TwoSum();
		
		int [] result = twoSum.twoSum(num, 9);
		System.out.println(result[0] + " " + result[1]);
	}

}
