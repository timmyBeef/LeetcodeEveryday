/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const map = {
        ")" : "(",
        "}" : "{",
        "]" : "["
    }
    
    let stack = [];
    
    for(let c of s) {
        
        if(map[c]) {
            let top = stack.pop();
            
            if(top !== map[c]) {
                return false;   
            }
        } else {
            stack.push(c);
        }
    }
    
    return stack.length === 0;
};
