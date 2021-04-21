import java.util.HashMap;

public class Board {
	static final String ANSI_RESET = "\033[0m";
	static final String ANSI_FG_BLACK = "\033[30m";
	static final String ANSI_FG_WHITE = "\033[37m";
	static final String ANSI_BG_BLACK = "\033[40m";
	static final String ANSI_BG_WHITE = "\033[47m";
	
	char[][][] chessBoard;
	
	Board(boolean withFile) {
		/* Make Pieces first */
		
		//White Pieces first
		gameObject wKing=new gameObject(4, 0, 'K','w','t');
		gameObject wQueen=new gameObject(3, 0, 'Q','w','t');
		gameObject wBishopL=new gameObject(2, 0, 'B','w','t');
		gameObject wBishopR=new gameObject(5, 0, 'B','w','t');
		gameObject wKnightL=new gameObject(1, 0, 'N','w','t');
		gameObject wKnightR=new gameObject(6, 0, 'N','w','t');
		gameObject wRookL=new gameObject(0, 0, 'R','w','t');
		gameObject wRookR=new gameObject(7, 0, 'R','w','t');
		gameObject wPawn1=new gameObject(0, 1, 'P','w','t');
		gameObject wPawn2=new gameObject(1, 1, 'P','w','t');
		gameObject wPawn3=new gameObject(2, 1, 'P','w','t');
		gameObject wPawn4=new gameObject(3, 1, 'P','w','t');
		gameObject wPawn5=new gameObject(4, 1, 'P','w','t');
		gameObject wPawn6=new gameObject(5, 1, 'P','w','t');
		gameObject wPawn7=new gameObject(6, 1, 'P','w','t');
		gameObject wPawn8=new gameObject(7, 1, 'P','w','t');
		
		
		HashMap<Integer, gameObject> wRooks =new HashMap<>();
		HashMap<Integer, gameObject> wKnights =new HashMap<>();
		HashMap<Integer, gameObject> wBishops =new HashMap<>();
		HashMap<Integer, gameObject> wPawns =new HashMap<>();
		wRooks.put(1,wRookL);
		wRooks.put(2,wRookR);
		
		wKnights.put(1,wKnightL);
		wKnights.put(2,wKnightR);
		
		wBishops.put(1,wBishopL);
		wBishops.put(2,wBishopR);
		
		wPawns.put(1,wPawn1);
		wPawns.put(2,wPawn2);
		wPawns.put(3,wPawn3);
		wPawns.put(4,wPawn4);
		wPawns.put(5,wPawn5);
		wPawns.put(6,wPawn6);
		wPawns.put(7,wPawn7);
		wPawns.put(8,wPawn8);
		
		
		//Black Pieces
		gameObject bKing=new gameObject(4, 7, 'K','b','t');
		gameObject bQueen=new gameObject(3, 7, 'Q','b','t');
		gameObject bBishopL=new gameObject(2, 7, 'B','b','t');
		gameObject bBishopR=new gameObject(5, 7, 'B','b','t');
		gameObject bKnightL=new gameObject(1, 7, 'N','b','t');
		gameObject bKnightR=new gameObject(6, 7, 'N','b','t');
		gameObject bRookL=new gameObject(0, 7, 'R','b','t');
		gameObject bRookR=new gameObject(7, 7, 'R','b','t');
		gameObject bPawn1=new gameObject(0, 6, 'P','b','t');
		gameObject bPawn2=new gameObject(1, 6, 'P','b','t');
		gameObject bPawn3=new gameObject(2, 6, 'P','b','t');
		gameObject bPawn4=new gameObject(3, 6, 'P','b','t');
		gameObject bPawn5=new gameObject(4, 6, 'P','b','t');
		gameObject bPawn6=new gameObject(5, 6, 'P','b','t');
		gameObject bPawn7=new gameObject(6, 6, 'P','b','t');
		gameObject bPawn8=new gameObject(7, 6, 'P','b','t');
		
		
		HashMap<Integer, gameObject> bRooks =new HashMap<>();
		HashMap<Integer, gameObject> bKnights =new HashMap<>();
		HashMap<Integer, gameObject> bBishops =new HashMap<>();
		HashMap<Integer, gameObject> bPawns =new HashMap<>();
		bRooks.put(1,bRookL);
		bRooks.put(2,bRookR);
		
		bKnights.put(1,bKnightL);
		bKnights.put(2,bKnightR);
		
		bBishops.put(1,bBishopL);
		bBishops.put(2,bBishopR);
		
		bPawns.put(1,bPawn1);
		bPawns.put(2,bPawn2);
		bPawns.put(3,bPawn3);
		bPawns.put(4,bPawn4);
		bPawns.put(5,bPawn5);
		bPawns.put(6,bPawn6);
		bPawns.put(7,bPawn7);
		bPawns.put(8,bPawn8);
		
		//Board
		chessBoard = new char[][][] {
			{{' ',' ',' '},{' ','a',' '},{' ','b',' '},{' ','c',' '},{' ','d',' '},{' ','e',' '},{' ','f',' '},{' ','g',' '},{' ','h',' '}},
			{{' ','8',' '},{'b','R',' '},{'b','N',' '},{'b','B',' '},{'b','Q',' '},{'b','K',' '},{'b','B',' '},{'b','N',' '},{'b','R',' '}},
			{{' ','7',' '},{'b','P',' '},{'b','P',' '},{'b','P',' '},{'b','P',' '},{'b','P',' '},{'b','P',' '},{'b','P',' '},{'b','P',' '}},
			{{' ','6',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','5',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','4',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','3',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','2',' '},{'w','P',' '},{'w','P',' '},{'w','P',' '},{'w','P',' '},{'w','P',' '},{'w','P',' '},{'w','P',' '},{'w','P',' '}},
			{{' ','1',' '},{'w','R',' '},{'w','N',' '},{'w','B',' '},{'w','Q',' '},{'w','K',' '},{'w','B',' '},{'w','N',' '},{'w','R',' '}}
		};
		
	}

	public boolean isFinish(boolean withFile) {
		/* Your code */
		return false;
	}
	
	public void selectObject(boolean withFile) {
		/* Your code */
	}
	
	public void moveObject(boolean withFile) {
		/* Your code */
	}
	
	public void printBoard(boolean withFile) {
		/* Your code */
		/* Sample print sudo code */
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				for(int k=0;k<3;k++) {
					//System.out.print(chessBoard[i][j][k]);
					if(i==0 || j==0) {
						System.out.print(ANSI_BG_BLACK + ANSI_FG_WHITE+ chessBoard[i][j][k]+ ANSI_RESET + ANSI_RESET);
					}else if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
						//odd odd or even even
						System.out.print(ANSI_BG_WHITE + ANSI_FG_BLACK+chessBoard[i][j][k]+ ANSI_RESET + ANSI_RESET);
					}else if((i%2==1 && j%2==0) || (i%2==0 && j%2==1)) {
						System.out.print(ANSI_BG_BLACK + ANSI_FG_WHITE+ chessBoard[i][j][k]+ ANSI_RESET + ANSI_RESET);
					}
					//System.out.println(ANSI_FG_BLACK+ "Black Character"+ ANSI_RESET);
					//System.out.println(ANSI_FG_WHITE+ "White Character"+ ANSI_RESET);
					//System.out.println(ANSI_BG_WHITE + ANSI_FG_BLACK+ "Black Character with White Background"+ ANSI_RESET + ANSI_RESET);
					//System.out.println(ANSI_BG_BLACK + ANSI_FG_WHITE+ "White Character with Black Background"+ ANSI_RESET + ANSI_RESET);
				}
			}
			System.out.println();
		}
	}
}
