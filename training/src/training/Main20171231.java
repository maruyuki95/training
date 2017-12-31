package training;

public class Main20171231 {

	public static void main(String[] args) {
		String msg = "((((((()))))))(()())";
		int length =20;
		int num = 5;

		int ret = new Main20171231().execute(msg, length, num);
		System.out.println(ret);
	}

	public int execute(String msg, int length, int num) {
		boolean left = isLeft(msg, num);

		int depth = 0;
		for (int i = 1; i <= length; i++) {
			if ((left && i < num) || (!left && num < i)) {
				continue;
			}

			String str = find(msg, i, left);
			if (isLeft(str)) {
				depth++;
			} else {
				depth--;
			}
			
			if(depth == 0) {
				if(left) {
					return i;
				}else {
					return msg.length() - i + 1;
				}
			}
		}

		System.out.println("見つからんかった...orz");
		return 0;
	}

	/**
	 * @param msg
	 * @param i
	 * @param left 左から数える場合はtrue
	 * @return　msg の i 番目の文字を返す。
	 */
	private String find(String msg, int i, boolean left) {
		int index;
		if(left) {
			index = i - 1;
		}else {
			index = msg.length() - i;
		}

		return String.valueOf(msg.charAt(index));
	}

	/**
	 * @param msg
	 * @param num
	 * @return msg の左から num 番目の文字が「(」だったら、trueを返す。
	 */
	private boolean isLeft(String msg, int num) {
		String str = find(msg, num, true);
		return isLeft(str);
	}

	/**
	 * @param str
	 * @return　「(」だったら、trueを返す。
	 */
	private boolean isLeft(String str) {
		return str != null && str.equals("(");
	}

}
