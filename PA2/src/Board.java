import java.util.HashMap;
import java.util.Scanner;

public class Board {
	static final String ANSI_RESET = "\033[0m";
	static final String ANSI_FG_BLACK = "\033[30m";
	static final String ANSI_FG_WHITE = "\033[37m";
	static final String ANSI_BG_BLACK = "\033[40m";
	static final String ANSI_BG_WHITE = "\033[47m";
	
	char[][][] chessBoard;
	Scanner scan = new Scanner(System.in);
	gameObject wKing;
	gameObject wQueen;
	gameObject wBishopL;
	gameObject wBishopR;
	gameObject wKnightL;
	gameObject wKnightR;
	gameObject wRookL;
	gameObject wRookR;
	gameObject wPawn1;
	gameObject wPawn2;
	gameObject wPawn3;
	gameObject wPawn4;
	gameObject wPawn5;
	gameObject wPawn6;
	gameObject wPawn7;
	gameObject wPawn8;
	
	
	HashMap<Integer, gameObject> wRooks;
	HashMap<Integer, gameObject> wKnights;
	HashMap<Integer, gameObject> wBishops;
	HashMap<Integer, gameObject> wPawns;
	
	gameObject bKing;
	gameObject bQueen;
	gameObject bBishopL;
	gameObject bBishopR;
	gameObject bKnightL;
	gameObject bKnightR;
	gameObject bRookL;
	gameObject bRookR;
	gameObject bPawn1;
	gameObject bPawn2;
	gameObject bPawn3;
	gameObject bPawn4;
	gameObject bPawn5;
	gameObject bPawn6;
	gameObject bPawn7;
	gameObject bPawn8;
	
	
	HashMap<Integer, gameObject> bRooks;
	HashMap<Integer, gameObject> bKnights;
	HashMap<Integer, gameObject> bBishops;
	HashMap<Integer, gameObject> bPawns;
	
	
	
	Board(boolean withFile) {
		/* Make Pieces first */
		
		//White Pieces first
		wKing=new gameObject(8, 5, 'K','w','x');
		wQueen=new gameObject(8, 4, 'Q','w','x');
		wBishopL=new gameObject(8, 3, 'B','w','x');
		wBishopR=new gameObject(8, 6, 'B','w','x');
		wKnightL=new gameObject(8, 2, 'N','w','x');
		wKnightR=new gameObject(8, 7, 'N','w','x');
		wRookL=new gameObject(8, 1, 'R','w','x');
		wRookR=new gameObject(8, 8, 'R','w','x');
		wPawn1=new gameObject(7, 1, 'P','w','x');
		wPawn2=new gameObject(7, 2, 'P','w','x');
		wPawn3=new gameObject(7, 3, 'P','w','x');
		wPawn4=new gameObject(7, 4, 'P','w','x');
		wPawn5=new gameObject(7, 5, 'P','w','x');
		wPawn6=new gameObject(7, 6, 'P','w','x');
		wPawn7=new gameObject(7, 7, 'P','w','x');
		wPawn8=new gameObject(7, 8, 'P','w','x');
		
		
		wRooks =new HashMap<>();
		wKnights =new HashMap<>();
		wBishops =new HashMap<>();
		wPawns =new HashMap<>();
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
		bKing=new gameObject(1, 5, 'K','b','t');
		bQueen=new gameObject(1, 4, 'Q','b','t');
		bBishopL=new gameObject(1, 3, 'B','b','t');
		bBishopR=new gameObject(1, 6, 'B','b','t');
		bKnightL=new gameObject(1, 2, 'N','b','t');
		bKnightR=new gameObject(1, 7, 'N','b','t');
		bRookL=new gameObject(1, 1, 'R','b','t');
		bRookR=new gameObject(1, 8, 'R','b','t');
		bPawn1=new gameObject(2, 1, 'P','b','t');
		bPawn2=new gameObject(2, 2, 'P','b','t');
		bPawn3=new gameObject(2, 3, 'P','b','t');
		bPawn4=new gameObject(2, 4, 'P','b','t');
		bPawn5=new gameObject(2, 5, 'P','b','t');
		bPawn6=new gameObject(2, 6, 'P','b','t');
		bPawn7=new gameObject(2, 7, 'P','b','t');
		bPawn8=new gameObject(2, 8, 'P','b','t');
		
		
		bRooks =new HashMap<>();
		bKnights =new HashMap<>();
		bBishops =new HashMap<>();
		bPawns =new HashMap<>();
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
			{{' ','8',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','7',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','6',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','5',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','4',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','3',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','2',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}},
			{{' ','1',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}}
		};
		
		//set chess board with white pieces
		chessBoard[wPawns.get(1).getX()][wPawns.get(1).getY()][0]=wPawns.get(1).getColor();
		chessBoard[wPawns.get(1).getX()][wPawns.get(1).getY()][1]=wPawns.get(1).getType();
		chessBoard[wPawns.get(2).getX()][wPawns.get(2).getY()][0]=wPawns.get(2).getColor();
		chessBoard[wPawns.get(2).getX()][wPawns.get(2).getY()][1]=wPawns.get(2).getType();
		chessBoard[wPawns.get(3).getX()][wPawns.get(3).getY()][0]=wPawns.get(3).getColor();
		chessBoard[wPawns.get(3).getX()][wPawns.get(3).getY()][1]=wPawns.get(3).getType();
		chessBoard[wPawns.get(4).getX()][wPawns.get(4).getY()][0]=wPawns.get(4).getColor();
		chessBoard[wPawns.get(4).getX()][wPawns.get(4).getY()][1]=wPawns.get(4).getType();
		chessBoard[wPawns.get(5).getX()][wPawns.get(5).getY()][0]=wPawns.get(5).getColor();
		chessBoard[wPawns.get(5).getX()][wPawns.get(5).getY()][1]=wPawns.get(5).getType();
		chessBoard[wPawns.get(6).getX()][wPawns.get(6).getY()][0]=wPawns.get(6).getColor();
		chessBoard[wPawns.get(6).getX()][wPawns.get(6).getY()][1]=wPawns.get(6).getType();
		chessBoard[wPawns.get(7).getX()][wPawns.get(7).getY()][0]=wPawns.get(7).getColor();
		chessBoard[wPawns.get(7).getX()][wPawns.get(7).getY()][1]=wPawns.get(7).getType();
		chessBoard[wPawns.get(8).getX()][wPawns.get(8).getY()][0]=wPawns.get(8).getColor();
		chessBoard[wPawns.get(8).getX()][wPawns.get(8).getY()][1]=wPawns.get(8).getType();
		//white Pawn done
		chessBoard[wKnights.get(1).getX()][wKnights.get(1).getY()][0]=wKnights.get(1).getColor();
		chessBoard[wKnights.get(1).getX()][wKnights.get(1).getY()][1]=wKnights.get(1).getType();
		chessBoard[wKnights.get(2).getX()][wKnights.get(2).getY()][0]=wKnights.get(2).getColor();
		chessBoard[wKnights.get(2).getX()][wKnights.get(2).getY()][1]=wKnights.get(2).getType();
		
		chessBoard[wBishops.get(1).getX()][wBishops.get(1).getY()][0]=wBishops.get(1).getColor();
		chessBoard[wBishops.get(1).getX()][wBishops.get(1).getY()][1]=wBishops.get(1).getType();
		chessBoard[wBishops.get(2).getX()][wBishops.get(2).getY()][0]=wBishops.get(2).getColor();
		chessBoard[wBishops.get(2).getX()][wBishops.get(2).getY()][1]=wBishops.get(2).getType();
		
		chessBoard[wRooks.get(1).getX()][wRooks.get(1).getY()][0]=wRooks.get(1).getColor();
		chessBoard[wRooks.get(1).getX()][wRooks.get(1).getY()][1]=wRooks.get(1).getType();
		chessBoard[wRooks.get(2).getX()][wRooks.get(2).getY()][0]=wRooks.get(2).getColor();
		chessBoard[wRooks.get(2).getX()][wRooks.get(2).getY()][1]=wRooks.get(2).getType();
		
		chessBoard[wKing.getX()][wKing.getY()][0]=wKing.getColor();
		chessBoard[wKing.getX()][wKing.getY()][1]=wKing.getType();
		chessBoard[wQueen.getX()][wQueen.getY()][0]=wQueen.getColor();
		chessBoard[wQueen.getX()][wQueen.getY()][1]=wQueen.getType();
		
		
		
		//Black
		chessBoard[bPawns.get(1).getX()][bPawns.get(1).getY()][0]=bPawns.get(1).getColor();
		chessBoard[bPawns.get(1).getX()][bPawns.get(1).getY()][1]=bPawns.get(1).getType();
		chessBoard[bPawns.get(2).getX()][bPawns.get(2).getY()][0]=bPawns.get(2).getColor();
		chessBoard[bPawns.get(2).getX()][bPawns.get(2).getY()][1]=bPawns.get(2).getType();
		chessBoard[bPawns.get(3).getX()][bPawns.get(3).getY()][0]=bPawns.get(3).getColor();
		chessBoard[bPawns.get(3).getX()][bPawns.get(3).getY()][1]=bPawns.get(3).getType();
		chessBoard[bPawns.get(4).getX()][bPawns.get(4).getY()][0]=bPawns.get(4).getColor();
		chessBoard[bPawns.get(4).getX()][bPawns.get(4).getY()][1]=bPawns.get(4).getType();
		chessBoard[bPawns.get(5).getX()][bPawns.get(5).getY()][0]=bPawns.get(5).getColor();
		chessBoard[bPawns.get(5).getX()][bPawns.get(5).getY()][1]=bPawns.get(5).getType();
		chessBoard[bPawns.get(6).getX()][bPawns.get(6).getY()][0]=bPawns.get(6).getColor();
		chessBoard[bPawns.get(6).getX()][bPawns.get(6).getY()][1]=bPawns.get(6).getType();
		chessBoard[bPawns.get(7).getX()][bPawns.get(7).getY()][0]=bPawns.get(7).getColor();
		chessBoard[bPawns.get(7).getX()][bPawns.get(7).getY()][1]=bPawns.get(7).getType();
		chessBoard[bPawns.get(8).getX()][bPawns.get(8).getY()][0]=bPawns.get(8).getColor();
		chessBoard[bPawns.get(8).getX()][bPawns.get(8).getY()][1]=bPawns.get(8).getType();
		//white Pawn done
		chessBoard[bKnights.get(1).getX()][bKnights.get(1).getY()][0]=bKnights.get(1).getColor();
		chessBoard[bKnights.get(1).getX()][bKnights.get(1).getY()][1]=bKnights.get(1).getType();
		chessBoard[bKnights.get(2).getX()][bKnights.get(2).getY()][0]=bKnights.get(2).getColor();
		chessBoard[bKnights.get(2).getX()][bKnights.get(2).getY()][1]=bKnights.get(2).getType();
		
		chessBoard[bBishops.get(1).getX()][bBishops.get(1).getY()][0]=bBishops.get(1).getColor();
		chessBoard[bBishops.get(1).getX()][bBishops.get(1).getY()][1]=bBishops.get(1).getType();
		chessBoard[bBishops.get(2).getX()][bBishops.get(2).getY()][0]=bBishops.get(2).getColor();
		chessBoard[bBishops.get(2).getX()][bBishops.get(2).getY()][1]=bBishops.get(2).getType();
		
		chessBoard[bRooks.get(1).getX()][bRooks.get(1).getY()][0]=bRooks.get(1).getColor();
		chessBoard[bRooks.get(1).getX()][bRooks.get(1).getY()][1]=bRooks.get(1).getType();
		chessBoard[bRooks.get(2).getX()][bRooks.get(2).getY()][0]=bRooks.get(2).getColor();
		chessBoard[bRooks.get(2).getX()][bRooks.get(2).getY()][1]=bRooks.get(2).getType();
		
		chessBoard[bKing.getX()][bKing.getY()][0]=bKing.getColor();
		chessBoard[bKing.getX()][bKing.getY()][1]=bKing.getType();
		chessBoard[bQueen.getX()][bQueen.getY()][0]=bQueen.getColor();
		chessBoard[bQueen.getX()][bQueen.getY()][1]=bQueen.getType();
	}

	public boolean isFinish(boolean withFile) {
		/* Your code */
		return false;
	}
	
	public void selectObject(boolean withFile) {
		/* Your code */
		String piece;
		int i,j;
		while(true) {
			System.out.print("Select piece: ");
			piece=scan.nextLine();
			i=Character.getNumericValue(piece.charAt(1));
			i=9-i;
			j=piece.charAt(0)-96;
			
			if(chessBoard[i][j][0]==' ') //nothing there
				continue;
			else if(i>8 || i<1 || j>8 || j<1) //out of Boundary
				continue;
			else //choose right position
				break;
		}
		
		if(chessBoard[i][j][0]=='w') {
			//white
			if(chessBoard[i][j][1]=='R') {
				//ROOK
				if(wRooks.get(1).getX()==i && wRooks.get(1).getY()==j) {
					System.out.println("wR_Left");
					wRooks.get(1).setTarget('o');
					int p=i;
					int q=j;
					
					while(true) {
						//white Rook up
						p--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white Rook down
						p++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white Rook right
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white Rook left
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') { //blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {//enemy
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
				}else if(wRooks.get(2).getX()==i && wRooks.get(2).getY()==j) {
					System.out.println("wR_Right");
					wRooks.get(2).setTarget('o');
					int p=i;
					int q=j;
					while(true) {
						//white Rook up
						p--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white Rook down
						p++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white Rook right
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white Rook left
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') { //blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {//enemy
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
				}
			}else if(chessBoard[i][j][1]=='N') {
				//Knight
				if(wKnights.get(1).getX()==i && wKnights.get(1).getY()==j) {
					System.out.println("wN_Left");
					wKnights.get(1).setTarget('o');
					int p;
					int q;
					
					//white up&right
					p=i-2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white up&left
					p=i-2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&up
					p=i-1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&down
					p=i+1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&right
					p=i+2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&left
					p=i+2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&up
					p=i-1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&down
					p=i+1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
				}else if(wKnights.get(2).getX()==i && wKnights.get(2).getY()==j) {
					System.out.println("wN_Right");
					wKnights.get(2).setTarget('o');
					int p;
					int q;
					
					//white up&right
					p=i-2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white up&left
					p=i-2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&up
					p=i-1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&down
					p=i+1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&right
					p=i+2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&left
					p=i+2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&up
					p=i-1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&down
					p=i+1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
						}
					}
				}
			}else if(chessBoard[i][j][1]=='B') {
				//Bishop
				if(wBishops.get(1).getX()==i && wBishops.get(1).getY()==j) {
					System.out.println("wB_Left");
					wBishops.get(1).setTarget('o');
					int p=i;
					int q=j;
					while(true) {
						//white left down
						p++;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white left up
						p--;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white right up
						p--;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white right down
						p++;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
				}else if(wBishops.get(2).getX()==i && wBishops.get(2).getY()==j) {
					System.out.println("wB_Right");
					wBishops.get(2).setTarget('o');
					int p=i;
					int q=j;
					while(true) {
						//white left down
						p++;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white left up
						p--;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white right up
						p--;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//white right down
						p++;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='b') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
				}
			}else if(chessBoard[i][j][1]=='Q') {
				//Queen
				System.out.println("wQ");
				wQueen.setTarget('o');

				int p=i;
				int q=j;
				//+Rook
				while(true) {
					//white Rook up
					p--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//white Rook down
					p++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//white Rook right
					q++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//white Rook left
					q--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') { //blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {//enemy
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				
				//+Bishop
				p=i;
				q=j;
				while(true) {
					//white left down
					p++;
					q--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//white left up
					p--;
					q--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//white right up
					p--;
					q++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//white right down
					p++;
					q++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='b') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
				
			}else if(chessBoard[i][j][1]=='K') {
				//King
				System.out.println("wK");
				wKing.setTarget('o');
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					if((chessBoard[i-1][j][0]==' ' || chessBoard[i-1][j][1]=='b')) //up
						chessBoard[i-1][j][2]='*';
				}
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//down
					if(chessBoard[i+1][j][0]==' ' || chessBoard[i+1][j][0]=='b')
						chessBoard[i+1][j][2]='*';
				}
				if((i>=1) && (i<=8) && (j+1>=1) && (j+1<=8)) {
					//right
					if(chessBoard[i][j+1][0]==' ' || chessBoard[i][j+1][0]=='b')
						chessBoard[i][j+1][2]='*';
				}
				if((i>=1) && (i<=8) && (j-1>=1) && (j-1<=8)) {
					//left
					if(chessBoard[i][j-1][0]==' ' || chessBoard[i][j-1][0]=='b')
						chessBoard[i][j-1][2]='*';
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					//left up
					if(chessBoard[i-1][j-1][0]==' ' || chessBoard[i-1][j-1][0]=='b')
						chessBoard[i][j-1][2]='*';
				}
				if((i+1>=1) && (i+1<=8) && (j-1>=1) && (j-1<=8)) {
					//left down
					if(chessBoard[i+1][j-1][0]==' ' || chessBoard[i+1][j-1][0]=='b')
						chessBoard[i+1][j-1][2]='*';
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					//right up
					if(chessBoard[i-1][j+1][0]==' ' || chessBoard[i-1][j+1][0]=='b')
						chessBoard[i-1][j+1][2]='*';
				}
				if((i+1>=1) && (i+1<=8) && (j+1>=1) && (j+1<=8)) {
					//right down
					if(chessBoard[i+1][j+1][0]==' ' || chessBoard[i+1][j+1][0]=='b')
						chessBoard[i+1][j+1][2]='*';
				}
			}else if(chessBoard[i][j][1]=='P') {
				//Pawn
				if(wPawns.get(1).getX()==i && wPawns.get(1).getY()==j) {
					System.out.println("wP_1");
					wPawns.get(1).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(wPawns.get(2).getX()==i && wPawns.get(2).getY()==j) {
					System.out.println("wP_2");
					wPawns.get(2).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(wPawns.get(3).getX()==i && wPawns.get(3).getY()==j) {
					System.out.println("wP_3");
					wPawns.get(3).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(wPawns.get(4).getX()==i && wPawns.get(4).getY()==j) {
					System.out.println("wP_4");
					wPawns.get(4).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(wPawns.get(5).getX()==i && wPawns.get(5).getY()==j) {
					System.out.println("wP_5");
					wPawns.get(5).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(wPawns.get(6).getX()==i && wPawns.get(6).getY()==j) {
					System.out.println("wP_6");
					wPawns.get(6).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(wPawns.get(7).getX()==i && wPawns.get(7).getY()==j) {
					System.out.println("wP_7");
					wPawns.get(7).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(wPawns.get(8).getX()==i && wPawns.get(8).getY()==j) {
					System.out.println("wP_8");
					wPawns.get(8).setTarget('o');
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i-1][j][0]==' ')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='b')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='b')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='b')
							chessBoard[i-1][j-1][2]='*';
					}
				}
			}
		}else if(chessBoard[i][j][0]=='b') {
			//black
			if(chessBoard[i][j][1]=='R') {
				//Rook
				if(bRooks.get(1).getX()==i && bRooks.get(1).getY()==j) {
					System.out.println("bR_Left");
					bRooks.get(1).setTarget('o');
					int p=i;
					int q=j;
					
					while(true) {
						//black Rook up
						p--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black Rook down
						p++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black Rook right
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black Rook left
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') { //blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {//enemy
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
				}else if(bRooks.get(2).getX()==i && bRooks.get(2).getY()==j) {
					System.out.println("bR_Right");
					bRooks.get(2).setTarget('o');
					
					int p=i;
					int q=j;
					
					while(true) {
						//black Rook up
						p--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black Rook down
						p++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black Rook right
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black Rook left
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') { //blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {//enemy
								chessBoard[p][q][2]='*';
								break;//eat enemy and stop
							}else
								break;//blocked
						}else//out of Boundary
							break;
					}
				}
			}else if(chessBoard[i][j][1]=='N') {
				//Knight
				if(bKnights.get(1).getX()==i && bKnights.get(1).getY()==j) {
					System.out.println("bN_Left");
					bKnights.get(1).setTarget('o');
					int p;
					int q;
					
					//white up&right
					p=i-2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white up&left
					p=i-2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&up
					p=i-1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&down
					p=i+1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&right
					p=i+2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&left
					p=i+2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&up
					p=i-1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&down
					p=i+1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
				}else if(bKnights.get(2).getX()==i && bKnights.get(2).getY()==j) {
					System.out.println("bN_Right");
					bKnights.get(2).setTarget('o');
					
					int p;
					int q;
					
					//white up&right
					p=i-2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white up&left
					p=i-2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&up
					p=i-1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white right&down
					p=i+1;
					q=j+2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&right
					p=i+2;
					q=j+1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white down&left
					p=i+2;
					q=j-1;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&up
					p=i-1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
					
					//white left&down
					p=i+1;
					q=j-2;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
						}
					}
				}
			}else if(chessBoard[i][j][1]=='B') {
				//Bishop
				if(bBishops.get(1).getX()==i && bBishops.get(1).getY()==j) {
					System.out.println("bB_Left");
					bBishops.get(1).setTarget('o');
					int p=i;
					int q=j;
					while(true) {
						//black left down
						p++;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black left up
						p--;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black right up
						p--;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black right down
						p++;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
				}else if(bBishops.get(2).getX()==i && bBishops.get(2).getY()==j) {
					System.out.println("bB_Right");
					bBishops.get(2).setTarget('o');
					int p=i;
					int q=j;
					while(true) {
						//black left down
						p++;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black left up
						p--;
						q--;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black right up
						p--;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
					
					p=i;
					q=j;
					while(true) {
						//black right down
						p++;
						q++;
						if(p>=1 && p<=8 && q>=1 && q<=8) {
							if(chessBoard[p][q][0]==' ') {
								//blank
								chessBoard[p][q][2]='*';
							}else if(chessBoard[p][q][0]=='w') {
								//enemy, get enemy and stop
								chessBoard[p][q][2]='*';
								break;
							}else //blocked
								break;
						}else //out of boundary
							break;
					}
				}
			}else if(chessBoard[i][j][1]=='Q') {
				//Queen
				System.out.println("bQ");
				bQueen.setTarget('o');
				int p=i;
				int q=j;
				//Rook
				while(true) {
					//black Rook up
					p--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//black Rook down
					p++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//black Rook right
					q++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//black Rook left
					q--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') { //blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {//enemy
							chessBoard[p][q][2]='*';
							break;//eat enemy and stop
						}else
							break;//blocked
					}else//out of Boundary
						break;
				}
				
				//++Bishop
				p=i;
				q=j;
				while(true) {
					//black left down
					p++;
					q--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//black left up
					p--;
					q--;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//black right up
					p--;
					q++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
				
				p=i;
				q=j;
				while(true) {
					//black right down
					p++;
					q++;
					if(p>=1 && p<=8 && q>=1 && q<=8) {
						if(chessBoard[p][q][0]==' ') {
							//blank
							chessBoard[p][q][2]='*';
						}else if(chessBoard[p][q][0]=='w') {
							//enemy, get enemy and stop
							chessBoard[p][q][2]='*';
							break;
						}else //blocked
							break;
					}else //out of boundary
						break;
				}
			}else if(chessBoard[i][j][1]=='K') {
				//King
				System.out.println("bK");
				bKing.setTarget('o');
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//up
					if(chessBoard[i-1][j][0]==' ' || chessBoard[i-1][j][1]=='w')
						chessBoard[i-1][j][2]='*';
				}
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//down
					if(chessBoard[i+1][j][0]==' ' || chessBoard[i+1][j][0]=='w')
						chessBoard[i+1][j][2]='*';
				}
				if((i>=1) && (i<=8) && (j+1>=1) && (j+1<=8)) {
					//right
					if(chessBoard[i][j+1][0]==' ' || chessBoard[i][j+1][0]=='w')
						chessBoard[i][j+1][2]='*';
				}
				if((i>=1) && (i<=8) && (j-1>=1) && (j-1<=8)) {
					//left
					if(chessBoard[i][j-1][0]==' ' || chessBoard[i][j-1][0]=='w')
						chessBoard[i][j-1][2]='*';
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					//left up
					if(chessBoard[i-1][j-1][0]==' ' || chessBoard[i-1][j-1][0]=='w')
						chessBoard[i-1][j-1][2]='*';
				}
				if((i+1>=1) && (i+1<=8) && (j-1>=1) && (j-1<=8)) {
					//left down
					if(chessBoard[i+1][j-1][0]==' ' || chessBoard[i+1][j-1][0]=='w')
						chessBoard[i+1][j-1][2]='*';
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					//right up
					if(chessBoard[i-1][j+1][0]==' ' || chessBoard[i-1][j+1][0]=='w')
						chessBoard[i-1][j+1][2]='*';
				}
				if((i+1>=1) && (i+1<=8) && (j+1>=1) && (j+1<=8)) {
					//right down
					if(chessBoard[i+1][j+1][0]==' ' || chessBoard[i+1][j+1][0]=='w')
						chessBoard[i+1][j+1][2]='*';
				}
			}else if(chessBoard[i][j][1]=='P') {
				//Pawn
				if(bPawns.get(1).getX()==i && bPawns.get(1).getY()==j) {
					System.out.println("bP_1");
					bPawns.get(1).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(bPawns.get(2).getX()==i && bPawns.get(2).getY()==j) {
					System.out.println("bP_2");
					bPawns.get(2).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(bPawns.get(3).getX()==i && bPawns.get(3).getY()==j) {
					System.out.println("bP_3");
					bPawns.get(3).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(bPawns.get(4).getX()==i && bPawns.get(4).getY()==j) {
					System.out.println("bP_4");
					bPawns.get(4).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(bPawns.get(5).getX()==i && bPawns.get(5).getY()==j) {
					System.out.println("bP_5");
					bPawns.get(5).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(bPawns.get(6).getX()==i && bPawns.get(6).getY()==j) {
					System.out.println("bP_6");
					bPawns.get(6).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(bPawns.get(7).getX()==i && bPawns.get(7).getY()==j) {
					System.out.println("bP_7");
					bPawns.get(7).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}else if(bPawns.get(8).getX()==i && bPawns.get(8).getY()==j) {
					System.out.println("bP_8");
					bPawns.get(8).setTarget('o');
					if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 nothing
						if(chessBoard[i+1][j][0]==' ')
							chessBoard[i+1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
						//바로 앞에 enemy(black)
						if(chessBoard[i-1][j][0]=='w')
							chessBoard[i-1][j][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
						if(chessBoard[i-1][j+1][0]=='w')
							chessBoard[i-1][j+1][2]='*';
					}
					if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
						if(chessBoard[i-1][j-1][0]=='w')
							chessBoard[i-1][j-1][2]='*';
					}
				}
			}
		}
	}
	
	public void moveObject(boolean withFile) {
		/* Your code */
		//select Object 에서 target set한 것 + * 한 것 다시 되돌리기 !!!
		//움직인 piece position set하고, 기존에 있던 position 비우기 
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
				}
			}
			System.out.println();
		}
		
//		char a = 'a';
//		char one='1';
//		int i=Character.getNumericValue(one);
//		int j=a-96;
//		System.out.println("1 is "+i+" and a is "+j);
	}
}
