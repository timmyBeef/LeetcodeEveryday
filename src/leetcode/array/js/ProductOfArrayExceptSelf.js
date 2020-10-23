const nums =  [1, 2, 3, 4];
const productExceptSelf = function (nums) {
    const res = [];
    res[0] = 1;
    for (let i = 1; i < nums.length; i++) {
        res[i] = res[i - 1] * nums[i - 1];
    }

    let right = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        res[i] *= right;
        right *= nums[i];
    }
    return res;
};
productExceptSelf(nums)
