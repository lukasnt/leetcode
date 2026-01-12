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

// @ts-ignore
function buildTree(inorder: number[], postorder: number[]): TreeNode | null {
    if (postorder.length === 0) return null;
    const root = postorder.at(-1);
    const rootIndex = inorder.indexOf(root);
    let left: TreeNode | null = null;
    let right: TreeNode | null = null;
    if (rootIndex != -1) {
        left = buildTree(inorder.slice(0, rootIndex), postorder.slice(0, rootIndex));
        right = buildTree(inorder.slice(rootIndex + 1), postorder.slice(rootIndex, -1));
    }
    return new TreeNode(root, left, right);
};

console.log(buildTree([9,3,15,20,7], [9,15,7,20,3]));
console.log(buildTree([-1], [-1]));
console.log(buildTree([5, 25, 10, 30, 20, 35, 40], [5, 10, 25, 20, 40, 35, 30]));