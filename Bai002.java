public class Bai002 {
    public Integer singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j)
                    count++;
            }
            if (count == 0) {
                return nums[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,1,3};
        Bai002 test = new Bai002();
        System.out.println(test.singleNumber(nums));
    }
}
