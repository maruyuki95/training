package training;

public class Main20171231 {

	public static void main(String[] args) {
		String msg = "(())";
		int length = 4;
		int num = 4;

		int ret = new Main20171231().execute(msg, length, num);
		System.out.println(ret);
	}

	public int execute(String msg, int length, int num) {
		Parenthesis parenthesis = initParenthesis(msg, num);
		
		int depth = 0;
		for (int i = 1; i <= length; i++) {
			if (parenthesis.needToCheck(i, num) == false) {
				continue;
			}

			String str = parenthesis.find(i);
			if (isLeft(str)) {
				depth++;
			} else {
				depth--;
			}

			if(depth != 0) {
				continue;
			}

			return parenthesis.getResult(i);
		}

		System.out.println("見つからんかった...orz");
		return 0;
	}

	private Parenthesis initParenthesis(String msg, int num) {
		String targetChar = String.valueOf(msg.charAt(num - 1));

		if(isLeft(targetChar)) {
			return new LeftParenthesis(msg);
		}else {
			return new RightParenthesis(msg);
		}
	}

	/**
	 * @param str
	 * @return　「(」だったら、trueを返す。
	 */
	private boolean isLeft(String str) {
		return str != null && str.equals("(");
	}

	private abstract class Parenthesis {
		protected String msg;
		public Parenthesis(String msg) {
			this.msg = msg;
		}
		public abstract String find(int index);
		public abstract boolean needToCheck(int index, int num);
		public abstract int getResult(int index);
	}

	private class RightParenthesis extends Parenthesis {
		public RightParenthesis(String msg) {
			super(msg);
		}

		@Override
		public String find(int index) {
			int i = msg.length() - index;
			return String.valueOf(msg.charAt(i));
		}

		@Override
		public boolean needToCheck(int index, int num) {
			return index <= num;
		}

		@Override
		public int getResult(int index) {
			return msg.length() - index + 1;
		}

	}
	
	private class LeftParenthesis extends Parenthesis {
		public LeftParenthesis(String msg) {
			super(msg);
		}

		@Override
		public String find(int index) {
			int i = index - 1;
			return String.valueOf(msg.charAt(i));
		}

		@Override
		public boolean needToCheck(int index, int num) {
			return num <= index;
		}

		@Override
		public int getResult(int index) {
			return index;
		}

	}
}
