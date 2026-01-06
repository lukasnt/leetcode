// @ts-ignore
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

function levelOrder(root: TreeNode | null): number[][] {
    if (root == null) return [];
    const result = []
    result.push([root.val]);
    const left = levelOrder(root.left);
    const right = levelOrder(root.right);
    for (let l = 0; l < Math.max(left.length, right.length); l++) {
        let level = [];
        if (l < left.length) {
            level = level.concat(left[l]);
        }
        if (l < right.length) {
            level = level.concat(right[l]);
        }
        result.push(level);
    }
    return result;
};

console.log(levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
console.log(levelOrder(new TreeNode(3, new TreeNode(9, new TreeNode(4), new TreeNode(5)), new TreeNode(20, new TreeNode(15), new TreeNode(7)))))
console.log(levelOrder(new TreeNode(3)))
console.log(levelOrder(new TreeNode(3, new TreeNode(5))))
console.log(levelOrder(new TreeNode(3, new TreeNode(5), new TreeNode(5))))
console.log(levelOrder(null))