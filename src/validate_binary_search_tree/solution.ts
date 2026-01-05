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


function isValidBST(root: TreeNode | null): boolean {
    if (root == null) {
        return true;
    }
    const left: boolean = root.left == null || root.left.val < root.val;
    const right: boolean = root.right == null || root.right.val > root.val;
    return left && isValidSubBST(root.left, Number.MIN_SAFE_INTEGER, root.val) && right && isValidSubBST(root.right, root.val, Number.MAX_SAFE_INTEGER);
}

function isValidSubBST(root: TreeNode | null, min: number, max: number) {
    if (root == null) {
        return true;
    }
    if (root.val <= min || root.val >= max) {
        return false;
    }
    const left: boolean = root.left == null || root.left.val < root.val;
    const right: boolean = root.right == null || root.right.val > root.val;
    return left && isValidSubBST(root.left, min, root.val) && right && isValidSubBST(root.right, root.val, max);
}

console.log(isValidBST(new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null))));
console.log(isValidBST(new TreeNode(5, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3, null, null), new TreeNode(6, null, null)))));
console.log(isValidBST(new TreeNode(5, new TreeNode(4, null, null), new TreeNode(6, new TreeNode(3, null, null), new TreeNode(7, null, null)))));
console.log(isValidBST(new TreeNode(0, new TreeNode(-1, null, null), null)));
