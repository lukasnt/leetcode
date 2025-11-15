function plusOne(digits: number[]): number[] {
    let result: number[] = new Array(digits.length);
    let done: boolean = false;
    for (let i = digits.length -1; i >= 0; i--) {
        if (digits[i] == 9 && !done) {
            result[i] = 0;
        } else if (!done) {
            result[i] = digits[i] + 1;
            done = true;
        } else {
            result[i] = digits[i];
        }
    }
    if (result[0] == 0) {
        result[0] = 1;
        result.push(0);
    }
    return result;
};