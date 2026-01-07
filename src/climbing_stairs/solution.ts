function climbStairs(n: number): number {
    const sols: number[] = Array.from({length: n}, () => 0);
    sols[0] = 1;
    sols[1] = 2;
    for (let s = 2; s < n; s++) {
        sols[s] = sols[s - 1] + sols[s - 2];
    }
    return sols[n - 1];
};

console.log(climbStairs(2));
console.log(climbStairs(3));
console.log(climbStairs(4));