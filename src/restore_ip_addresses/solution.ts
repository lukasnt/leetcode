function restoreIpAddresses(s: string): string[] {
    const result: string[] = restoreSubAddresses(s, 4);
    return result ? result : [];
}

function restoreSubAddresses(s: string, parts: number): string[] {
    const result: string[] = [];
    for (let i: number = 1; i <= 3; i++) {
        const code: string = s.slice(0, i);
        const codeNumber: number = parseInt(code);
        const leadingZeros: boolean = codeNumber.toString() !== code;
        const outOfRange: boolean = codeNumber < 0 || codeNumber > 255;
        const valid = !leadingZeros && !outOfRange;
        if (valid) {
            if (parts === 1 && i === s.length) {
                result.push(code);
            } else if (parts > 1 && i < s.length) {
                const subAddresses: string[] = restoreSubAddresses(s.slice(i), parts - 1);
                const addresses: string[] = subAddresses.map(sub => code + '.' + sub);
                result.push(...addresses);
            }
        }
    }
    return result;
}

console.log(restoreIpAddresses("25525511135"));
console.log(restoreIpAddresses("0000"));
console.log(restoreIpAddresses("101023"));
console.log(restoreIpAddresses("000"));
console.log(restoreIpAddresses(""));
