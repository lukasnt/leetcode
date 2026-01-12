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

function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
    if (preorder.length === 0) return null;
    const rootIndex = inorder.indexOf(preorder[0]);
    let left: TreeNode | null = null;
    let right: TreeNode | null = null;
    if (rootIndex != -1) {
        left  = buildTree(preorder.slice(1, rootIndex + 1), inorder.slice(0, rootIndex));
        right = buildTree(preorder.slice(rootIndex + 1), inorder.slice(rootIndex + 1));
    }
    return new TreeNode(preorder[0], left, right);
};

console.log(buildTree([3,9,20,15,7], [9,3,15,20,7]))
console.log(buildTree([-1], [-1]))
console.log(buildTree([5, 10, 30, 20, 40], [40, 20, 30, 10, 5]))
console.log(buildTree([5, 10, 30, 20, 40, 50, 60], [30, 10, 20, 5, 50, 40, 60]))