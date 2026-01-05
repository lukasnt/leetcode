function numTrees(n: number): number {
    const sols: number[][] = Array.from({length: n + 1},
        () => Array.from({length: n + 1}, () => 0));
    return numTreesArray(Array.from({length: n }, (_, i) => i + 1), sols);
};


function numTreesArray(nums: number[], sols: number[][]): number {
    if (nums.length === 0) {
        return 1;
    }
    if (sols[nums[0]][nums[nums.length - 1]] != 0) return sols[nums[0]][nums[nums.length - 1]];
    let result: number = 0;
    for (let i = 0; i < nums.length; i++) {
        const leftTrees = numTreesArray(nums.slice(0, i), sols);
        const rightTrees = numTreesArray(nums.slice(i + 1), sols);
        result += leftTrees * rightTrees;
    }
    sols[nums[0]][nums[nums.length - 1]] = result;
    return result;
}

console.log(numTrees(3));
console.log(numTrees(1));
console.log(numTrees(2));
console.log(numTrees(4));
console.log(numTrees(19));