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

/**     Phân tích độ phức tạp thời gian của chương trình
 *     thông qua phân tích số phép tính của hàm findSubChars
 *     (Cỡ của dữ liệu truyền vào (Độ dài String truyền vào hàm) là n)
 *
 *      Các câu lệnh trước và sau vòng lặp ngoài: O(1)
 *      Vòng lặp ngoài: n
 *          Các câu lệnh trước và sau vòng lặp trong: O(1)
 *          Vòng lặp trong: n - x
 *              Câu lệnh trong vòng lặp trong: O(1)
 *
 *      T(n) = O(c + n * (c + (n - x) * c))         (n-1 >= x >= 1)
 *           = O(c + n * c + n * (n - 1) * c)
 *           = O(n^2)
 *      => Độ phức tạp thời gian của bài toán là O(n^2)
 */