import java.util.regex.*;

public class regexes {
	/**
	 * TODO: given a candidate string, determine if it is an email or not.
	 */
	public static boolean matchEmail(String candidateStr) {
	/*
	TODO: given a candidate string, determine if it is an email or not.
	 Test cases are provided. DO NOT change them!!!

    eg.
        Input:
            afrenk@wpi.edu
        Returns:
            True

        Input:
            gchist@xyz
        Returns:
            False (no valid ending)
			*/
		return false;
	}

	public static boolean matchLink(String candidateStr) {
		/*TODO: given a candidate string, determine if it is a valid full web link (http/https)
	 Test cases are provided. DO NOT change them!!!

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
			*/
		return false;
	}
	public static boolean matchPassword(String candidateStr) {
		/*
		  TODO: match a password with 8 or more  characters,
		  1 uppercase letter, 1 lowercase letter, a number 
		  and a special character (not alphanum)

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
		 */
		return false;
	}

	private static class Case {
		final String input;
		final boolean expect;

		Case(String input, boolean expect) {
			this.input = input;
			this.expect = expect;
		}
	}

	@FunctionalInterface
	private interface TestFn {
		boolean apply(String s);
	}

	private static void runTests(String name, Case[] cases, TestFn fn) {
		int passed = 0;
		java.util.List<String> failed = new java.util.ArrayList<>();
		for (Case c : cases) {
			boolean got = fn.apply(c.input);
			if (got == c.expect) passed++;
			else failed.add("input: '" + c.input + "' expected: " + c.expect + " got: " + got);
		}
		System.out.println("\n[TEST SUITE] " + name + ": " + passed + "/" + cases.length + " passed");
		if (!failed.isEmpty()) {
			System.out.println("[FAILED CASES] (" + failed.size() + ")");
			for (String s : failed) System.out.println(" - " + s);
		}
	}

	public static void testEmail() {
		Case[] cases = new Case[]{
			new Case("afrenk@wpi.edu", true),
			new Case("gchist@xyz", false),
			new Case("user.name+tag@.in", false),
			new Case("plainaddress", false)
		};
		runTests("matchEmail", cases, regexes::matchEmail);
	}

	public static void testLink() {
		Case[] cases = new Case[]{
			new Case("https://www.google.com", true),
			new Case("http://canvas.wpi.edu", true),
			new Case("wpi.edu", false),
			new Case("ftp://example.com", false)
		};
		runTests("matchLink", cases, regexes::matchLink);
	}

	public static void testPassword() {
		Case[] cases = new Case[]{
			new Case("Meowmeowmeow123!", true),
			new Case("Test123", false),
			new Case("test123!", false),
			new Case("Aa1!aaaa", true)
		};
		runTests("matchPassword", cases, regexes::matchPassword);
	}

	public static void main(String[] args) {
		testEmail();
		testLink();
		testPassword();
	}
}
