function isInterleave(s1: string, s2: string, s3: string): boolean {
    const m: number = s1.length;
    const n: number = s2.length;
    const q: number = s3.length;
    if (q != m + n) return false;
    if (m == 0) return s2 == s3
    if (n == 0) return s1 == s3
    const sols: boolean[][] = Array.from({length: m + 1},
        () => Array.from({length: n + 1}, () => false));
    for (let i = 0; i < m; i++) {
        if (s1.at(i) == s3.at(i)) {
            sols[i + 1][0] = true;
        } else {
            break;
        }
    }
    for (let j = 0; j < n; j++) {
        if (s2.at(j) == s3.at(j)) {
            sols[0][j + 1] = true;
        } else {
            break;
        }
    }
    for (let i = 1; i < m + 1; i++) {
        for (let j = 1 ; j < n + 1; j++) {
            const last: string = s3.at(i + j - 1);
            if (s1.at(i - 1) == last && sols[i - 1][j]) sols[i][j] = true;
            if (s2.at(j - 1) == last && sols[i][j - 1]) sols[i][j] = true;
        }
    }
    return sols[m][n];
};

console.log(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
console.log(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
console.log(isInterleave("abcc", "aaaq", "abaacaqc"));
console.log(isInterleave("", "", ""));
console.log(isInterleave("aba", "", "aba"));
console.log(isInterleave("", "ab", "aba"));
console.log(isInterleave("a", "b", "ab"));
console.log(isInterleave("a", "ab", "aab"));
