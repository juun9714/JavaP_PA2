
public class test {
	static final String ANSI_RESET = "\033[0m";
	static final String ANSI_FG_BLACK = "\033[30m";
	static final String ANSI_FG_WHITE = "\033[37m";
	static final String ANSI_BG_BLACK = "\033[40m";
	static final String ANSI_BG_WHITE = "\033[47m";
	
	public static void main(String[] args) {
			System.out.println(ANSI_FG_BLACK+ "Black Character"+ ANSI_RESET);
			System.out.println(ANSI_FG_WHITE+ "White Character"+ ANSI_RESET);
			System.out.println(ANSI_BG_WHITE + ANSI_FG_BLACK+ "Black Character with White Background"+ ANSI_RESET + ANSI_RESET);
			System.out.println(ANSI_BG_BLACK + ANSI_FG_WHITE+ "White Character with Black Background"+ ANSI_RESET + ANSI_RESET);
		}
}