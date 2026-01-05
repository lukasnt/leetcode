class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null

    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}

function generateTrees(n: number): Array<TreeNode | null> {
    return generateSubTrees(Array.from( { length: n } , (_, i) => i + 1));
};

function generateSubTrees(nums: number[]): Array<TreeNode | null> {
    if (nums.length === 0) {
        return [null];
    } else if (nums.length === 1) {
        return [new TreeNode(nums[0], null, null)];
    }

    const result: Array<TreeNode | null> = [];
    for (let i = 0; i < nums.length; i++) {
        const leftTrees = generateSubTrees([...nums].splice(0, i));
        const rightTrees = generateSubTrees([...nums].splice(i + 1));
        for (const left of leftTrees) {
            for (const right of rightTrees) {
                result.push(new TreeNode(nums[i], left, right));
            }
        }
    }
    return result;
};

console.log(generateTrees(1));
console.log(generateTrees(2));
console.log(generateTrees(3));
//console.log(generateTrees(8));
