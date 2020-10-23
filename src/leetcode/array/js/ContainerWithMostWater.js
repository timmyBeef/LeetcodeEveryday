var maxArea = function(height) {
    let res = 0;
    let l = 0;
    let r = height.length - 1;
    while (l < r) {
        let minHeight = height[l] < height[r] ? height[l++] : height[r--];
        res = Math.max(res, minHeight*(r - l + 1));
    }
    return res;
};