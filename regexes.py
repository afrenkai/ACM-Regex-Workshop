import re


def match_email(candidate_str: str) -> bool:
    """
    TODO: given a candidate string, determine if it is an email or not. Test cases are provided. DO NOT change them!!!

    eg.
        Input:
            afrenk@wpi.edu
        Returns:
            True

        Input:
            gchist@xyz
        Returns:
            False (no valid ending)
    """
    return False


def match_web_link(candidate_str: str) -> bool:
    """
    TODO: given a candidate string, determine if it is a valid full web link (http/https)

    eg:
        Input:
            https://www.google.com
        Returns:
            True

        Input:
            wpi.edu
        Returns:
            False

        Input:
            http://canvas.wpi.edu
        Returns:
            True
    """
    return False


def match_password(candidate_str: str) -> bool:
    """
    TODO: match a password with 8 or more  characters, 1 uppercase letter, 1 lowercase letter, a number and a special character (not alphanum)

    eg.
        Input:
            Meowmeowmeow123!
        Returns:
            True

        Input:
            Test123
        Returns:
            False (too short)

        Input:
            test123!
        Returns:
            False (no uppercase letter)
    """
    return False


from typing import List, NamedTuple, Callable


class Case(NamedTuple):
    input: str
    expect: bool


def run_tests(name: str, cases: List[Case], fn: Callable[[str], bool]) -> None:
    passed = 0
    failed: List[str] = []
    for c in cases:
        got = fn(c.input)
        if got == c.expect:
            passed += 1
        else:
            failed.append(f"input: '{c.input}' expected: {c.expect} got: {got}")

    print(f"\n[TEST SUITE] {name}: {passed}/{len(cases)} passed")
    if failed:
        print(f"[FAILED CASES] ({len(failed)})")
        for f in failed:
            print(" - " + f)


def testEmail() -> None:
    cases = [
        Case('afrenk@wpi.edu', True),
        Case('gchist@xyz', False),
        Case('user.name+tag@sub.example.co.uk', True),
        Case('plainaddress', False),
    ]
    run_tests('matchEmail', cases, match_email)


def testLink() -> None:
    cases = [
        Case('https://www.google.com', True),
        Case('http://canvas.wpi.edu', True),
        Case('wpi.edu', False),
        Case('ftp://example.com', False),
    ]
    run_tests('matchLink', cases, match_web_link)


def testPassword() -> None:
    cases = [
        Case('Meowmeowmeow123!', True),
        Case('Test123', False),
        Case('test123!', False),
        Case('Aa1!aaaa', True),
    ]
    run_tests('matchPassword', cases, match_password)


if __name__ == "__main__":
    testEmail()
    testLink()
    testPassword()
