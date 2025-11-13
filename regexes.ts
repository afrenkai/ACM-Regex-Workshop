export function matchEmail(candidateStr: string): boolean {
	/*
    TODO: given a candidate string, determine if it is an email or not. Test cases are provided. DO NOT change them!!!

    eg.
        Input:
            afrenk@wpi.edu
        Returns:
            true

        Input:
            gchist@xyz
        Returns:
            false (no valid ending)
    */

	
	return false;
}

export function matchLink(candidateStr: string): boolean {
    /*
    TODO: given a candidate string, determine if it is a valid full web link (http/https)

    eg:
        Input:
            https://www.google.com
        Returns:
            true

        Input:
            wpi.edu
        Returns:
            false

        Input:
            http://canvas.wpi.edu
        Returns:
            true
    */

    
    return false;
}

export function matchPassword(candidateStr: string): boolean {
/*
    todo: match a password with 8 or more  characters, 1 uppercase letter, 1 lowercase letter, a number and a special character (not alphanum)

    eg.
        Input:
            Meowmeowmeow123!
        Returns:
            true

        Input:
            Test123
        Returns:
            false (too short)

        Input:
            test123!
        Returns:
            false (no uppercase letter)
 
*/
    
    return false;
}


type Case = { input: string; expect: boolean };

function runTests(name: string, cases: Case[], fn: (s: string) => boolean): void {
    let passed = 0;
    const failed: Array<{c: Case; got: boolean}> = [];
    for (const c of cases) {
        const got = fn(c.input);
        if (got === c.expect) passed++;
        else failed.push({c, got});
    }

    console.log(`\n[TEST SUITE] ${name}: ${passed}/${cases.length} passed`);
    if (failed.length) {
        console.log(`[FAILED CASES] (${failed.length})`);
        for (const f of failed) {
            console.log(` - input: ${JSON.stringify(f.c.input)} expected: ${f.c.expect} got: ${f.got}`);
        }
    }
}

export function testEmail(): void {
    const cases: Case[] = [
        { input: 'afrenk@wpi.edu', expect: true },
        { input: 'gchist@xyz', expect: false },
        { input: 'user.name+tag@sub.example.co.uk', expect: true },
        { input: 'plainaddress', expect: false },
    ];
    runTests('matchEmail', cases, matchEmail);
}

export function testLink(): void {
    const cases: Case[] = [
        { input: 'https://www.google.com', expect: true },
        { input: 'http://canvas.wpi.edu', expect: true },
        { input: 'wpi.edu', expect: false },
        { input: 'ftp://example.com', expect: false },
    ];
    runTests('matchLink', cases, matchLink);
}

export function testPassword(): void {
    const cases: Case[] = [
        { input: 'Meowmeowmeow123!', expect: true },
        { input: 'Test123', expect: false },
        { input: 'test123!', expect: false },
        { input: 'Aa1!aaaa', expect: true },
    ];
    runTests('matchPassword', cases, matchPassword);
}

try {
    // eslint-disable-next-line @typescript-eslint/no-var-requires
    if (require && require.main === module) {
        testEmail();
        testLink();
        testPassword();
    }
} catch (e) {
    
}
