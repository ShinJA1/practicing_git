import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018 {
	public static char[][] board;
	public static char[][] newBoard;
	public static int cnt=0, res=0;
	public static int n, m;
	public static int a, b; //jj fixed something ~~another change
	
	//this is shin _ from ShinJA1  ~~another change too
	public static void firstB(int x, int y) {
		cnt=0;
		a = x % 2;
		b = y % 2;
		if(board[x][y] != 'B') {
			cnt++;
			newBoard[x][y]='B';
		}
		else newBoard[x][y] = board[x][y];	
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(i==x && j==y) { continue; }
				else if( (i%2==a && j%2==b) || (i%2!=a && j%2!=b)) {
					if(board[i][j] !='B') {
						newBoard[i][j] = 'B';
						cnt++;
					}
					else newBoard[x][y] = board[x][y];				 
				}
				else{
					if(board[i][j] !='W') {
						newBoard[i][j] = 'W';
						cnt++;
					}
					else newBoard[x][y] = board[x][y];
				}
			}
		}
		if(x==0 && y==0) res = cnt;
		if(cnt < res) res = cnt;		
	}
	
	public static void firstW(int x, int y) {
		cnt=0;
		a = x % 2;
		b = y % 2;
		if(board[x][y] != 'W') {
			cnt++;
			newBoard[x][y]='W';
		}
		else newBoard[x][y] = board[x][y];
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(i==x && j==y) {continue;}
				else if( (i%2==a && j%2==b) || (i%2!=a && j%2!=b)) {
					if(board[i][j] !='W') {
						newBoard[i][j] = 'W';
						cnt++;
					}
					else newBoard[x][y] = board[x][y];
				}
				else {
					if(board[i][j] !='B') {
						newBoard[i][j] = 'B';
						cnt++;
					}
					else newBoard[x][y] = board[x][y];
				}
			}
		}
		if(cnt < res) res = cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		newBoard = new char[n][m];
		
		for(int i=0; i<n; i++) {
			String chess = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = chess.charAt(j);
			}
		}
		
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				firstB(i,j);
				firstW(i, j);
			}
		}
		System.out.println(res);	
	}
}
