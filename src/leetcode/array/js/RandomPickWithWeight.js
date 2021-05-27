/**
 * @param {number[]} w
 */
var Solution = function(w) {

    this.sum = [w[0]];
    for(let i = 1; i < w.length; i++) {
        this.sum.push(this.sum[i-1] + w[i]);
    }
    this.size = this.sum.length-1;
};

/**
 * @return {number}
 */
Solution.prototype.pickIndex = function() {
    const {sum, size} = this;
    const index = Math.floor(Math.random() * this.sum[size]+1);
    let left = 0;
    let right = size;

    while(left < right){
        const mid = (left + right) >> 1;
        if(sum[mid] == index)
            return mid;
        else if(sum[mid] < index)
            left = mid + 1;
        else
            right = mid;
    }
    return left;
};

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */
