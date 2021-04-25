import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Board {
	static final String ANSI_RESET = "\033[0m";
	static final String ANSI_FG_BLACK = "\033[30m";
	static final String ANSI_FG_WHITE = "\033[37m";
	static final String ANSI_BG_BLACK = "\033[40m";
	static final String ANSI_BG_WHITE = "\033[47m";
	
	//File Input Stream
	InputStream fis;
	InputStreamReader isr;
	BufferedReader br;
	//File Output Stream
	FileOutputStream fos;
	OutputStreamWriter osw;
	BufferedWriter bw;
	
	String src;
	String dst;
	int s_i,s_j,d_i,d_j;
	
	char[][][] chessBoard;
	int target;
	int finish;
	/*
	 * finish==0 : not finished
	 * finish==1 : white win
	 * finish==2 : black win
	 */
	int is_path;
	int turn;
	int [][] where;
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
	
	void moveBishop(char c, int p, int q, int i, int j) {
		if(c=='w') {
			while(true) {
				//white left down
				p++;
				q--;
				if(p>=1 && p<=8 && q>=1 && q<=8) {
					if(chessBoard[p][q][0]==' ') {
						//blank
						chessBoard[p][q][2]='*';
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
						break;
					}else //blocked
						break;
				}else //out of boundary
					break;
			}
		}else if(c=='b') {
			while(true) {
				//black left down
				p++;
				q--;
				if(p>=1 && p<=8 && q>=1 && q<=8) {
					if(chessBoard[p][q][0]==' ') {
						//blank
						chessBoard[p][q][2]='*';
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {
						//enemy, get enemy and stop
						chessBoard[p][q][2]='*';
						is_path=1;
						break;
					}else //blocked
						break;
				}else //out of boundary
					break;
			}
		}
	}
	
	void moveKnight(char c, int p, int q,int i, int j) {
		if(c=='w') {
			p=i-2;
			q=j+1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white up&left
			p=i-2;
			q=j-1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white right&up
			p=i-1;
			q=j+2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white right&down
			p=i+1;
			q=j+2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white down&right
			p=i+2;
			q=j+1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white down&left
			p=i+2;
			q=j-1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white left&up
			p=i-1;
			q=j-2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white left&down
			p=i+1;
			q=j-2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='b') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
		}else if(c=='b') {
			//white up&right
			p=i-2;
			q=j+1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white up&left
			p=i-2;
			q=j-1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white right&up
			p=i-1;
			q=j+2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white right&down
			p=i+1;
			q=j+2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white down&right
			p=i+2;
			q=j+1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white down&left
			p=i+2;
			q=j-1;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white left&up
			p=i-1;
			q=j-2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
			
			//white left&down
			p=i+1;
			q=j-2;
			if(p>=1 && p<=8 && q>=1 && q<=8) {
				if(chessBoard[p][q][0]==' ') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}else if(chessBoard[p][q][0]=='w') {
					chessBoard[p][q][2]='*';
					is_path=1;
				}
			}
		}
	}
	
	void movePawn(char c, int i, int j) {
		if(c=='w') {

			if(wPawns.get(1).getX()==i && wPawns.get(1).getY()==j) {
				target=9;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(wPawns.get(2).getX()==i && wPawns.get(2).getY()==j) {
				target=10;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(wPawns.get(3).getX()==i && wPawns.get(3).getY()==j) {
				target=11;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(wPawns.get(4).getX()==i && wPawns.get(4).getY()==j) {
				target=12;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(wPawns.get(5).getX()==i && wPawns.get(5).getY()==j) {
				target=13;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(wPawns.get(6).getX()==i && wPawns.get(6).getY()==j) {
				target=14;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(wPawns.get(7).getX()==i && wPawns.get(7).getY()==j) {
				target=15;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(wPawns.get(8).getX()==i && wPawns.get(8).getY()==j) {
				target=16;
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i-1][j][0]==' ') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='b') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='b') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='b') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}
		}else if(c=='b') {
			if(bPawns.get(1).getX()==i && bPawns.get(1).getY()==j) {
				target=25;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(bPawns.get(2).getX()==i && bPawns.get(2).getY()==j) {
				target=26;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(bPawns.get(3).getX()==i && bPawns.get(3).getY()==j) {
				target=27;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(bPawns.get(4).getX()==i && bPawns.get(4).getY()==j) {
				target=28;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(bPawns.get(5).getX()==i && bPawns.get(5).getY()==j) {
				target=29;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(bPawns.get(6).getX()==i && bPawns.get(6).getY()==j) {
				target=30;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(bPawns.get(7).getX()==i && bPawns.get(7).getY()==j) {
				target=31;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}else if(bPawns.get(8).getX()==i && bPawns.get(8).getY()==j) {
				target=32;
				if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 nothing
					if(chessBoard[i+1][j][0]==' ') {
						chessBoard[i+1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
					//바로 앞에 enemy(black)
					if(chessBoard[i-1][j][0]=='w') {
						chessBoard[i-1][j][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
					if(chessBoard[i-1][j+1][0]=='w') {
						chessBoard[i-1][j+1][2]='*';
						is_path=1;
					}
				}
				if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
					if(chessBoard[i-1][j-1][0]=='w') {
						chessBoard[i-1][j-1][2]='*';
						is_path=1;
					}
				}
			}
		}
	}
	
	void moveKing(char c, int i, int j) {
		if(c=='w') {
			if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
				if((chessBoard[i-1][j][0]==' ' || chessBoard[i-1][j][1]=='b')) { //up
					chessBoard[i-1][j][2]='*';
					is_path=1;
				}
			}
			if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
				//down
				if(chessBoard[i+1][j][0]==' ' || chessBoard[i+1][j][0]=='b') {
					chessBoard[i+1][j][2]='*';
					is_path=1;
				}
			}
			if((i>=1) && (i<=8) && (j+1>=1) && (j+1<=8)) {
				//right
				if(chessBoard[i][j+1][0]==' ' || chessBoard[i][j+1][0]=='b') {
					chessBoard[i][j+1][2]='*';
					is_path=1;
				}
			}
			if((i>=1) && (i<=8) && (j-1>=1) && (j-1<=8)) {
				//left
				if(chessBoard[i][j-1][0]==' ' || chessBoard[i][j-1][0]=='b') {
					chessBoard[i][j-1][2]='*';
					is_path=1;
				}
			}
			if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
				//left up
				if(chessBoard[i-1][j-1][0]==' ' || chessBoard[i-1][j-1][0]=='b') {
					chessBoard[i][j-1][2]='*';
					is_path=1;
				}
			}
			if((i+1>=1) && (i+1<=8) && (j-1>=1) && (j-1<=8)) {
				//left down
				if(chessBoard[i+1][j-1][0]==' ' || chessBoard[i+1][j-1][0]=='b') {
					chessBoard[i+1][j-1][2]='*';
					is_path=1;
				}
			}
			if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
				//right up
				if(chessBoard[i-1][j+1][0]==' ' || chessBoard[i-1][j+1][0]=='b') {
					chessBoard[i-1][j+1][2]='*';
					is_path=1;
				}
			}
			if((i+1>=1) && (i+1<=8) && (j+1>=1) && (j+1<=8)) {
				//right down
				if(chessBoard[i+1][j+1][0]==' ' || chessBoard[i+1][j+1][0]=='b') {
					chessBoard[i+1][j+1][2]='*';
					is_path=1;
				}
			}
		}else if(c=='b') {
			if((i-1>=1) && (i-1<=8) && (j>=1) && (j<=8)) {
				//up
				if(chessBoard[i-1][j][0]==' ' || chessBoard[i-1][j][1]=='w') {
					chessBoard[i-1][j][2]='*';
					is_path=1;
				}
			}
			if((i+1>=1) && (i+1<=8) && (j>=1) && (j<=8)) {
				//down
				if(chessBoard[i+1][j][0]==' ' || chessBoard[i+1][j][0]=='w') {
					chessBoard[i+1][j][2]='*';
					is_path=1;
				}
			}
			if((i>=1) && (i<=8) && (j+1>=1) && (j+1<=8)) {
				//right
				if(chessBoard[i][j+1][0]==' ' || chessBoard[i][j+1][0]=='w') {
					chessBoard[i][j+1][2]='*';
					is_path=1;
				}
			}
			if((i>=1) && (i<=8) && (j-1>=1) && (j-1<=8)) {
				//left
				if(chessBoard[i][j-1][0]==' ' || chessBoard[i][j-1][0]=='w') {
					chessBoard[i][j-1][2]='*';
					is_path=1;
				}
			}
			if((i-1>=1) && (i-1<=8) && (j-1>=1) && (j-1<=8)) {
				//left up
				if(chessBoard[i-1][j-1][0]==' ' || chessBoard[i-1][j-1][0]=='w') {
					chessBoard[i-1][j-1][2]='*';
					is_path=1;
				}
			}
			if((i+1>=1) && (i+1<=8) && (j-1>=1) && (j-1<=8)) {
				//left down
				if(chessBoard[i+1][j-1][0]==' ' || chessBoard[i+1][j-1][0]=='w') {
					chessBoard[i+1][j-1][2]='*';
					is_path=1;
				}
			}
			if((i-1>=1) && (i-1<=8) && (j+1>=1) && (j+1<=8)) {
				//right up
				if(chessBoard[i-1][j+1][0]==' ' || chessBoard[i-1][j+1][0]=='w') {
					chessBoard[i-1][j+1][2]='*';
					is_path=1;
				}
			}
			if((i+1>=1) && (i+1<=8) && (j+1>=1) && (j+1<=8)) {
				//right down
				if(chessBoard[i+1][j+1][0]==' ' || chessBoard[i+1][j+1][0]=='w') {
					chessBoard[i+1][j+1][2]='*';
					is_path=1;
				}
			}
		}
	}
	
	void moveRook(char c, int p, int q, int i, int j) {
		if(c=='w') {
			while(true) {
				//white Rook up
				p--;
				//moveRook(p,q);
				if(p>=1 && p<=8 && q>=1 && q<=8) {
					if(chessBoard[p][q][0]==' ') {
						chessBoard[p][q][2]='*';
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='b') {//enemy
						chessBoard[p][q][2]='*';
						is_path=1;
						break;//eat enemy and stop
					}else
						break;//blocked
				}else//out of Boundary
					break;
			}
		}else if(c=='b') {
			while(true) {
				//black Rook up
				p--;
				if(p>=1 && p<=8 && q>=1 && q<=8) {
					if(chessBoard[p][q][0]==' ') { //blank
						chessBoard[p][q][2]='*';
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {//enemy
						chessBoard[p][q][2]='*';
						is_path=1;
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
					if(chessBoard[p][q][0]==' ') { //blank
						chessBoard[p][q][2]='*';
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {//enemy
						chessBoard[p][q][2]='*';
						is_path=1;
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
					if(chessBoard[p][q][0]==' ') { //blank
						chessBoard[p][q][2]='*';
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {//enemy
						chessBoard[p][q][2]='*';
						is_path=1;
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
						is_path=1;
					}else if(chessBoard[p][q][0]=='w') {//enemy
						chessBoard[p][q][2]='*';
						is_path=1;
						break;//eat enemy and stop
					}else
						break;//blocked
				}else//out of Boundary
					break;
			}
		}
	}
	
	void Erase(int i, int j) {
		//need to erase eaten piece by something... 
		if(chessBoard[i][j][0]=='w') {
			if(chessBoard[i][j][1]=='R') {
				//White_Rook
				if(wRooks.get(1).getX()==i && wRooks.get(1).getY()==j) {
					wRooks.get(1).setX(0);
					wRooks.get(1).setY(0);
				}else if(wRooks.get(2).getX()==i && wRooks.get(2).getY()==j) {
					wRooks.get(2).setX(0);
					wRooks.get(2).setY(0);
				}
			}else if(chessBoard[i][j][1]=='N') {
				//White_Knight
				if(wKnights.get(1).getX()==i && wKnights.get(1).getY()==j) {
					wKnights.get(1).setX(0);
					wKnights.get(1).setY(0);
				}else if(wKnights.get(2).getX()==i && wKnights.get(2).getY()==j) {
					wKnights.get(2).setX(0);
					wKnights.get(2).setY(0);
				}
			}else if(chessBoard[i][j][1]=='B') {
				//White_Bishop
				if(wBishops.get(1).getX()==i && wBishops.get(1).getY()==j) {
					wBishops.get(1).setX(0);
					wBishops.get(1).setY(0);
				}else if(wBishops.get(2).getX()==i && wBishops.get(2).getY()==j) {
					wBishops.get(2).setX(0);
					wBishops.get(2).setY(0);
				}
			}else if(chessBoard[i][j][1]=='Q') {
				//White_Queen
				wQueen.setX(0);
				wQueen.setY(0);
			}else if(chessBoard[i][j][1]=='K') {
				//White_King
				wKing.setX(0);
				wKing.setY(0);
				finish=2;
			}else if(chessBoard[i][j][1]=='P') {
				if(wPawns.get(1).getX()==i && wPawns.get(1).getY()==j) {
					wPawns.get(1).setX(0);
					wPawns.get(1).setY(0);
				}else if(wPawns.get(2).getX()==i && wPawns.get(2).getY()==j) {
					wPawns.get(2).setX(0);
					wPawns.get(2).setY(0);
				}else if(wPawns.get(3).getX()==i && wPawns.get(3).getY()==j) {
					wPawns.get(3).setX(0);
					wPawns.get(3).setY(0);
				}else if(wPawns.get(4).getX()==i && wPawns.get(4).getY()==j) {
					wPawns.get(4).setX(0);
					wPawns.get(4).setY(0);
				}else if(wPawns.get(5).getX()==i && wPawns.get(5).getY()==j) {
					wPawns.get(5).setX(0);
					wPawns.get(5).setY(0);
				}else if(wPawns.get(6).getX()==i && wPawns.get(6).getY()==j) {
					wPawns.get(6).setX(0);
					wPawns.get(6).setY(0);
				}else if(wPawns.get(7).getX()==i && wPawns.get(7).getY()==j) {
					wPawns.get(7).setX(0);
					wPawns.get(7).setY(0);
				}else if(wPawns.get(8).getX()==i && wPawns.get(8).getY()==j) {
					wPawns.get(8).setX(0);
					wPawns.get(8).setY(0);
				}
			}
			
		}else if(chessBoard[i][j][0]=='b') {
			if(chessBoard[i][j][1]=='R') {
				//Black_Rook
				if(bRooks.get(1).getX()==i && bRooks.get(1).getY()==j) {
					bRooks.get(1).setX(0);
					bRooks.get(1).setY(0);
				}else if(bRooks.get(2).getX()==i && bRooks.get(2).getY()==j) {
					bRooks.get(2).setX(0);
					bRooks.get(2).setY(0);
				}
			}else if(chessBoard[i][j][1]=='N') {
				//Black_Knight
				if(bKnights.get(1).getX()==i && bKnights.get(1).getY()==j) {
					bKnights.get(1).setX(0);
					bKnights.get(1).setY(0);
				}else if(bKnights.get(2).getX()==i && bKnights.get(2).getY()==j) {
					bKnights.get(2).setX(0);
					bKnights.get(2).setY(0);
				}
			}else if(chessBoard[i][j][1]=='B') {
				//Black_Bishop
				if(bBishops.get(1).getX()==i && bBishops.get(1).getY()==j) {
					bBishops.get(1).setX(0);
					bBishops.get(1).setY(0);
				}else if(bBishops.get(2).getX()==i && bBishops.get(2).getY()==j) {
					bBishops.get(2).setX(0);
					bBishops.get(2).setY(0);
				}
			}else if(chessBoard[i][j][1]=='Q') {
				//Black_Queen
				bQueen.setX(0);
				bQueen.setY(0);
			}else if(chessBoard[i][j][1]=='K') {
				//Black_King
				bKing.setX(0);
				bKing.setY(0);
				finish=1;
			}else if(chessBoard[i][j][1]=='P') {
				if(bPawns.get(1).getX()==i && bPawns.get(1).getY()==j) {
					bPawns.get(1).setX(0);
					bPawns.get(1).setY(0);
				}else if(bPawns.get(2).getX()==i && bPawns.get(2).getY()==j) {
					bPawns.get(2).setX(0);
					bPawns.get(2).setY(0);
				}else if(bPawns.get(3).getX()==i && bPawns.get(3).getY()==j) {
					bPawns.get(3).setX(0);
					bPawns.get(3).setY(0);
				}else if(bPawns.get(4).getX()==i && bPawns.get(4).getY()==j) {
					bPawns.get(4).setX(0);
					bPawns.get(4).setY(0);
				}else if(bPawns.get(5).getX()==i && bPawns.get(5).getY()==j) {
					bPawns.get(5).setX(0);
					bPawns.get(5).setY(0);
				}else if(bPawns.get(6).getX()==i && bPawns.get(6).getY()==j) {
					bPawns.get(6).setX(0);
					bPawns.get(6).setY(0);
				}else if(bPawns.get(7).getX()==i && bPawns.get(7).getY()==j) {
					bPawns.get(7).setX(0);
					bPawns.get(7).setY(0);
				}else if(bPawns.get(8).getX()==i && bPawns.get(8).getY()==j) {
					bPawns.get(8).setX(0);
					bPawns.get(8).setY(0);
				}
			}
		}
	}
	
	void setMap() {
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
				
				chessBoard[0][0][0]=' ';
				chessBoard[0][0][1]=' ';
				chessBoard[0][0][2]=' ';
	}
	
	void setBlank() {
		for(int i=1;i<9;i++) {
			for(int j=1;j<9;j++)
				chessBoard[i][j][2]=' ';
		}
	}
	
	Board(boolean withFile) {
		/* Make Pieces first */
		
		//File Input Stream
		try {
			fis = new FileInputStream("./input1.txt");
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			//File Output Stream
			fos = new FileOutputStream("./outputt.txt");
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
		}catch(IOException e) {e.printStackTrace();}
		
		//White Pieces first
		is_path=0;
		turn=0;
		//turn == 0 : white turn
		//turn == 1 : black turn 
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
		if(withFile==true) {
			if(finish==1) {
				try {
					bw.write("White Wins");
					bw.flush();
					bw.close();
					osw.close();
					fos.close();
					br.close();
					isr.close();
					fis.close();
					return true;
				}catch(IOException e) {e.printStackTrace();}
			}
			else if(finish==2) {
				try {
					bw.write("Black Wins");
					bw.flush();
					bw.close();
					osw.close();
					fos.close();
					br.close();
					isr.close();
					fis.close();
					return true;
				}catch(IOException e) {e.printStackTrace();}
			}
			
			
			
		}else if(withFile==false){
			if(finish==1) {
				System.out.println("White Wins");
				return true;
			}
			else if(finish==2) {
				System.out.println("Black Wins");
				return true;
			}
		}
		
		return false;
	}
	
	public void selectObject(boolean withFile) {
		/* Your code */
		if(withFile==true) {
			while(true) {
				try {
					String data;
					bw.write("Select piece: ");
					bw.flush();
					while((data=br.readLine())!=null) {
						src=data.substring(0,2);
						dst=data.substring(4,6);
						s_i=Character.getNumericValue(src.charAt(1));
						s_i=9-s_i;
						s_j=src.charAt(0)-96;
						
						d_i=Character.getNumericValue(dst.charAt(1));
						d_i=9-d_i;
						d_j=dst.charAt(0)-96;
						
						//logic start
						if(chessBoard[s_i][s_j][0]==' ') //nothing there
							continue;
						else if(s_i>8 || s_i<1 || s_j>8 || s_j<1) //out of Boundary
							continue;
						else if(turn==0 && chessBoard[s_i][s_j][0]=='b')
							continue; //choose black piece on white turn 
						else if(turn==1 && chessBoard[s_i][s_j][0]=='w')
							continue; //choose white piece on black turn 
						else //choose right position
						{							
							if(chessBoard[s_i][s_j][0]=='w') {
								//white
								if(chessBoard[s_i][s_j][1]=='R') {
									//ROOK
									if(wRooks.get(1).getX()==s_i && wRooks.get(1).getY()==s_j) {
										target=1;
										int p=s_i;
										int q=s_j;
										moveRook('w',p,q,s_i,s_j);
									}else if(wRooks.get(2).getX()==s_i && wRooks.get(2).getY()==s_j) {
										target=8;
										int p=s_i;
										int q=s_j;
										moveRook('w',p,q,s_i,s_j);
									}
								}else if(chessBoard[s_i][s_j][1]=='N') {
									//Knight
									if(wKnights.get(1).getX()==s_i && wKnights.get(1).getY()==s_j) {
										target=2;
										int p=0;
										int q=0;
										moveKnight('w',p,q,s_i,s_j);
									}else if(wKnights.get(2).getX()==s_i && wKnights.get(2).getY()==s_j) {
										target=7;
										int p=0;
										int q=0;
										moveKnight('w',p,q,s_i,s_j);
									}
								}else if(chessBoard[s_i][s_j][1]=='B') {
									//Bishop
									if(wBishops.get(1).getX()==s_i && wBishops.get(1).getY()==s_j) {
										target=3;
										int p=s_i;
										int q=s_j;
										moveBishop('w',p,q,s_i,s_j);
									}else if(wBishops.get(2).getX()==s_i && wBishops.get(2).getY()==s_j) {
										target=6;
										int p=s_i;
										int q=s_j;
										moveBishop('w',p,q,s_i,s_j);
									}
								}else if(chessBoard[s_i][s_j][1]=='Q') {
									target=4;
									int p=s_i;
									int q=s_j;
									moveRook('w',p,q,s_i,s_j);
									p=s_i;
									q=s_j;
									moveBishop('w',p,q,s_i,s_j);
								}else if(chessBoard[s_i][s_j][1]=='K') {
									//King
									target=5;
									moveKing('w',s_i,s_j);
								}else if(chessBoard[s_i][s_j][1]=='P') {
									movePawn('w',s_i,s_j);
								}
							}else if(chessBoard[s_i][s_j][0]=='b') {
								//black
								if(chessBoard[s_i][s_j][1]=='R') {
									//Rook
									if(bRooks.get(1).getX()==s_i && bRooks.get(1).getY()==s_j) {
										target=17;
										int p=s_i;
										int q=s_j;
										moveRook('b',p,q,s_i,s_j);
									}else if(bRooks.get(2).getX()==s_i && bRooks.get(2).getY()==s_j) {
										target=24;
										int p=s_i;
										int q=s_j;
										moveRook('b',p,q,s_i,s_j);
									}
								}else if(chessBoard[s_i][s_j][1]=='N') {
									//Knight
									if(bKnights.get(1).getX()==s_i && bKnights.get(1).getY()==s_j) {
										target=18;
										int p=0;
										int q=0;
										moveKnight('b',p,q,s_i,s_j);
									}else if(bKnights.get(2).getX()==s_i && bKnights.get(2).getY()==s_j) {
										target=23;
										int p=0;
										int q=0;
										moveKnight('b',p,q,s_i,s_j);
									}
								}else if(chessBoard[s_i][s_j][1]=='B') {
									//Bishop
									if(bBishops.get(1).getX()==s_i && bBishops.get(1).getY()==s_j) {
										target=19;
										int p=s_i;
										int q=s_j;
										moveBishop('b',p,q,s_i,s_j);
									}else if(bBishops.get(2).getX()==s_i && bBishops.get(2).getY()==s_j) {
										target=22;
										int p=s_i;
										int q=s_j;
										moveBishop('b',p,q,s_i,s_j);
									}
								}else if(chessBoard[s_i][s_j][1]=='Q') {
									//Queen
									target=20;
									int p=s_i;
									int q=s_j;
									moveRook('b',p,q,s_i,s_j);
									p=s_i;
									q=s_j;
									moveBishop('b',p,q,s_i,s_j);
								}else if(chessBoard[s_i][s_j][1]=='K') {
									//King
									target=21;
									moveKing('b',s_i,s_j);
								}else if(chessBoard[s_i][s_j][1]=='P') {
									//Pawn
									movePawn('b',s_i,s_j);
								}
							}
							if(is_path==0)
								continue;
							else if(is_path==1) {
								if(turn==0)
									turn=1;
								else if(turn==1)
									turn=0;
								
								break;
							}
						}
						
						//logic done
						
						
						//bw.write("src is ("+s_i+", "+s_j+")"+" and dst is ("+d_i+", "+s_j+")"+"\n");
						//bw.flush();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}else if(withFile==false) {
			String piece;
			int i,j;
			while(true) {
				System.out.print("Select piece: ");
				piece=scan.nextLine();
				i=Character.getNumericValue(piece.charAt(1));
				i=9-i;
				j=piece.charAt(0)-96;
				is_path=0;
				if(chessBoard[i][j][0]==' ') //nothing there
					continue;
				else if(i>8 || i<1 || j>8 || j<1) //out of Boundary
					continue;
				else if(turn==0 && chessBoard[i][j][0]=='b')
					continue; //choose black piece on white turn 
				else if(turn==1 && chessBoard[i][j][0]=='w')
					continue; //choose white piece on black turn 
				else //choose right position
				{
					if(chessBoard[i][j][0]=='w') {
						//white
						if(chessBoard[i][j][1]=='R') {
							//ROOK
							if(wRooks.get(1).getX()==i && wRooks.get(1).getY()==j) {
								target=1;
								int p=i;
								int q=j;
								moveRook('w',p,q,i,j);
							}else if(wRooks.get(2).getX()==i && wRooks.get(2).getY()==j) {
								target=8;
								int p=i;
								int q=j;
								moveRook('w',p,q,i,j);
							}
						}else if(chessBoard[i][j][1]=='N') {
							//Knight
							if(wKnights.get(1).getX()==i && wKnights.get(1).getY()==j) {
								target=2;
								int p=0;
								int q=0;
								moveKnight('w',p,q,i,j);
							}else if(wKnights.get(2).getX()==i && wKnights.get(2).getY()==j) {
								target=7;
								int p=0;
								int q=0;
								moveKnight('w',p,q,i,j);
							}
						}else if(chessBoard[i][j][1]=='B') {
							//Bishop
							if(wBishops.get(1).getX()==i && wBishops.get(1).getY()==j) {
								target=3;
								int p=i;
								int q=j;
								moveBishop('w',p,q,i,j);
							}else if(wBishops.get(2).getX()==i && wBishops.get(2).getY()==j) {
								target=6;
								int p=i;
								int q=j;
								moveBishop('w',p,q,i,j);
							}
						}else if(chessBoard[i][j][1]=='Q') {
							target=4;
							int p=i;
							int q=j;
							moveRook('w',p,q,i,j);
							p=i;
							q=j;
							moveBishop('w',p,q,i,j);
						}else if(chessBoard[i][j][1]=='K') {
							//King
							target=5;
							moveKing('w',i,j);
						}else if(chessBoard[i][j][1]=='P') {
							movePawn('w',i,j);
						}
					}else if(chessBoard[i][j][0]=='b') {
						//black
						if(chessBoard[i][j][1]=='R') {
							//Rook
							if(bRooks.get(1).getX()==i && bRooks.get(1).getY()==j) {
								target=17;
								int p=i;
								int q=j;
								moveRook('b',p,q,i,j);
							}else if(bRooks.get(2).getX()==i && bRooks.get(2).getY()==j) {
								target=24;
								int p=i;
								int q=j;
								moveRook('b',p,q,i,j);
							}
						}else if(chessBoard[i][j][1]=='N') {
							//Knight
							if(bKnights.get(1).getX()==i && bKnights.get(1).getY()==j) {
								target=18;
								int p=0;
								int q=0;
								moveKnight('b',p,q,i,j);
							}else if(bKnights.get(2).getX()==i && bKnights.get(2).getY()==j) {
								target=23;
								int p=0;
								int q=0;
								moveKnight('b',p,q,i,j);
							}
						}else if(chessBoard[i][j][1]=='B') {
							//Bishop
							if(bBishops.get(1).getX()==i && bBishops.get(1).getY()==j) {
								target=19;
								int p=i;
								int q=j;
								moveBishop('b',p,q,i,j);
							}else if(bBishops.get(2).getX()==i && bBishops.get(2).getY()==j) {
								target=22;
								int p=i;
								int q=j;
								moveBishop('b',p,q,i,j);
							}
						}else if(chessBoard[i][j][1]=='Q') {
							//Queen
							target=20;
							int p=i;
							int q=j;
							moveRook('b',p,q,i,j);
							p=i;
							q=j;
							moveBishop('b',p,q,i,j);
						}else if(chessBoard[i][j][1]=='K') {
							//King
							target=21;
							moveKing('b',i,j);
						}else if(chessBoard[i][j][1]=='P') {
							//Pawn
							movePawn('b',i,j);
						}
					}
					if(is_path==0)
						continue;
					else if(is_path==1)
						break;
				}
			}
			if(turn==0)
				turn=1;
			else if(turn==1)
				turn=0;
		}
		
	}
	
	public void moveObject(boolean withFile) {
		/* Your code */
		//select Object 에서 target set한 것 + * 한 것 다시 되돌리기 !!!
		//움직인 piece position set하고, 기존에 있던 position 비우기 
		if(withFile==false) {
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
			String pos;
			int i,j;
			while(true) {
				System.out.print("Move piece: ");
				pos=scan.nextLine();
				i=Character.getNumericValue(pos.charAt(1));
				i=9-i;
				j=pos.charAt(0)-96;
				
				if(chessBoard[i][j][2]=='*')
					break;
			}
			
			int p;
			int q;
			switch(target) {
				case 1:
					//W_LR
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wRooks.get(1).getX();
						q=wRooks.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wRooks.get(1).setX(i);
						wRooks.get(1).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 2:
					//W_LN
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wKnights.get(1).getX();
						q=wKnights.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wKnights.get(1).setX(i);
						wKnights.get(1).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 3:
					//W_LB
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wBishops.get(1).getX();
						q=wBishops.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wBishops.get(1).setX(i);
						wBishops.get(1).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 4:
					//W_Q
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wQueen.getX();
						q=wQueen.getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wQueen.setX(i);
						wQueen.setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 5:
					//W_K
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wKing.getX();
						q=wKing.getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wKing.setX(i);
						wKing.setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 6:
					//W_RB
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wBishops.get(2).getX();
						q=wBishops.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wBishops.get(2).setX(i);
						wBishops.get(2).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 7:
					//W_RN
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wKnights.get(2).getX();
						q=wKnights.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wKnights.get(2).setX(i);
						wKnights.get(2).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 8:
					//W_RR
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wRooks.get(2).getX();
						q=wRooks.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wRooks.get(2).setX(i);
						wRooks.get(2).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 9:
					//W_P1
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(1).getX();
						q=wPawns.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(1).setX(i);
						wPawns.get(1).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 10:
					//W_P2
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(2).getX();
						q=wPawns.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(2).setX(i);
						wPawns.get(2).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 11:
					//W_P3
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(3).getX();
						q=wPawns.get(3).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(3).setX(i);
						wPawns.get(3).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 12:
					//W_P4
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(4).getX();
						q=wPawns.get(4).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(4).setX(i);
						wPawns.get(4).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 13:
					//W_P5
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(5).getX();
						q=wPawns.get(5).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(5).setX(i);
						wPawns.get(5).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 14:
					//W_P6
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(6).getX();
						q=wPawns.get(6).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(6).setX(i);
						wPawns.get(6).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 15:
					//W_P7
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(7).getX();
						q=wPawns.get(7).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(7).setX(i);
						wPawns.get(7).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 16:
					//W_P8
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='b') {
						p=wPawns.get(8).getX();
						q=wPawns.get(8).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						wPawns.get(8).setX(i);
						wPawns.get(8).setY(j);
						if(chessBoard[i][j][0]=='b')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 17:
					//B_LR
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bRooks.get(1).getX();
						q=bRooks.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bRooks.get(1).setX(i);
						bRooks.get(1).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 18:
					//B_LN
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bKnights.get(1).getX();
						q=bKnights.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bKnights.get(1).setX(i);
						bKnights.get(1).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 19:
					//B_LB
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bBishops.get(1).getX();
						q=bBishops.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bBishops.get(1).setX(i);
						bBishops.get(1).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 20:
					//B_Q
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bQueen.getX();
						q=bQueen.getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bQueen.setX(i);
						bQueen.setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 21:
					//B_K
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bKing.getX();
						q=bKing.getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bKing.setX(i);
						bKing.setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 22:
					//B_RB
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bBishops.get(2).getX();
						q=bBishops.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bBishops.get(2).setX(i);
						bBishops.get(2).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 23:
					//B_RN
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bKnights.get(2).getX();
						q=bKnights.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bKnights.get(2).setX(i);
						bKnights.get(2).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 24:
					//B_RR
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bRooks.get(2).getX();
						q=bRooks.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bRooks.get(2).setX(i);
						bRooks.get(2).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 25:
					//B_P1
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(1).getX();
						q=bPawns.get(1).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(1).setX(i);
						bPawns.get(1).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 26:
					//B_P2
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(2).getX();
						q=bPawns.get(2).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(2).setX(i);
						bPawns.get(2).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 27:
					//B_P3
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(3).getX();
						q=bPawns.get(3).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(3).setX(i);
						bPawns.get(3).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 28:
					//B_P4
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(4).getX();
						q=bPawns.get(4).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(4).setX(i);
						bPawns.get(4).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 29:
					//B_P5
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(5).getX();
						q=bPawns.get(5).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(5).setX(i);
						bPawns.get(5).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 30:
					//B_P6
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(6).getX();
						q=bPawns.get(6).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(6).setX(i);
						bPawns.get(6).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 31:
					//B_P7
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(7).getX();
						q=bPawns.get(7).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(7).setX(i);
						bPawns.get(7).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
				case 32:
					//B_P8
					if(chessBoard[i][j][0]==' ' || chessBoard[i][j][0]=='w') {
						p=bPawns.get(8).getX();
						q=bPawns.get(8).getY();
						chessBoard[p][q][0]=' ';
						chessBoard[p][q][1]=' ';
						bPawns.get(8).setX(i);
						bPawns.get(8).setY(j);
						if(chessBoard[i][j][0]=='w')
							Erase(i,j);
						setMap();
						setBlank();
					}
					break;
			}
		}
		
	}
	
	public void printBoard(boolean withFile) {
		/* Your code */
		/* Sample print sudo code */
		if(withFile==true) {
			try {
				for(int i=0;i<9;i++) {
					for(int j=0;j<9;j++) {
						for(int k=0;k<3;k++) {
							//System.out.print(chessBoard[i][j][k]);
								if(i==0 || j==0) {
									bw.write(ANSI_BG_BLACK + ANSI_FG_WHITE+ chessBoard[i][j][k]+ ANSI_RESET + ANSI_RESET);
									bw.flush();
								}else if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
									//odd odd or even even
									bw.write(ANSI_BG_WHITE + ANSI_FG_BLACK+chessBoard[i][j][k]+ ANSI_RESET + ANSI_RESET);
									bw.flush();
								}else if((i%2==1 && j%2==0) || (i%2==0 && j%2==1)) {
									bw.write(ANSI_BG_BLACK + ANSI_FG_WHITE+ chessBoard[i][j][k]+ ANSI_RESET + ANSI_RESET);
									bw.flush();
								}
						}
					}
					bw.write("\n");
					bw.flush();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}else if(withFile==false) {
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
		}
		
	}
}
