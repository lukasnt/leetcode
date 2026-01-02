function numDecodings(s: string): number {
    let sols: number[] = Array<number>(s.length + 1)
    if (s.charAt(s.length - 1) != '0') {
        sols[s.length - 1] = 1;
    } else {
        sols[s.length - 1] = 0;
    }
    for (let i = s.length - 2; i >= 0; i--) {
        if (s.charAt(i) == '0') {
            sols[i] = 0;
        } else {
            sols[i] = sols[i + 1];
            const twoDigit: number = parseInt(s.slice(i, i + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                if (i + 2 <= s.length - 1) {
                    sols[i] += sols[i + 2];
                } else {
                    sols[i] += 1;
                }
            }
        }
    }
    return sols[0];
}

console.log(numDecodings("11106"))
console.log(numDecodings("12"))
console.log(numDecodings("226"))
console.log(numDecodings("06"))
console.log(numDecodings("0"))
console.log(numDecodings("1"))
console.log(numDecodings("10"))
console.log(numDecodings("2101"))
console.log(numDecodings("27"))
console.log(numDecodings("111"))