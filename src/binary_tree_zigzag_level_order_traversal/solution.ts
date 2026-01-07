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

function zigzagLevelOrder(root: TreeNode | null): number[][] {
    if (root == null) return [];
    const result: number[][] = [];
    let current: TreeNode[] = [root];
    let next: TreeNode[] = [];
    let level: number = 0;
    while (current.length > 0) {
        if (level % 2 == 1) {
            result.push(current.toReversed().map(node => node.val));
        } else {
            result.push(current.map(node => node.val));
        }
        while (current.length > 0) {
            const node = current.shift();
            if (node.left) next.push(node.left);
            if (node.right) next.push(node.right);
        }
        level++;
        current = next;
        next = [];
    }
    return result;
};

console.log(zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
console.log(zigzagLevelOrder(new TreeNode(3, new TreeNode(9, new TreeNode(4), new TreeNode(5)), new TreeNode(20, new TreeNode(15), new TreeNode(7)))))
console.log(zigzagLevelOrder(new TreeNode(3)))
console.log(zigzagLevelOrder(new TreeNode(3, new TreeNode(5))))
console.log(zigzagLevelOrder(new TreeNode(3, new TreeNode(5), new TreeNode(5))))
console.log(zigzagLevelOrder(null))
