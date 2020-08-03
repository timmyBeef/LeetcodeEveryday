var sumNumbers = function(root) {
    return cal(root, 0);
};

const cal = (root, sum) => {
    if (!root) {
        return 0;
    }
    let currentSum = sum*10 + root.val;
    if (!root.left && !root.right) {
        return currentSum;
    }
    return cal(root.left, currentSum) + cal(root.right, currentSum);
}