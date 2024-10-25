import java.util.LinkedList;
import java.util.Scanner;

public class FindLongestSubChars {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = input.nextLine();

		String longestString = findSubChars(str);
		System.out.println(longestString);
	}

	private static String findSubChars(String str) {
		LinkedList<Character> maxList = new LinkedList<>();
		int length = str.length();

		for (int i = 0; i < length; i++) {
			int longestSize = length - i;
			if (longestSize <= maxList.size()) break;

			LinkedList<Character> list = new LinkedList<>();
			list.add(str.charAt(i));
			for (int j = i + 1; j < length; j++) {
				if (str.charAt(j) >= list.getLast()) {
					list.add(str.charAt(j));
				}
			}
			if (list.size() > maxList.size()) {
				maxList = list;
			}
		}

		String outputString = "";
		for (Character character : maxList) {
			outputString += character;
		}
		return outputString;
	}
}
