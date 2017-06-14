package test;
import java.util.ArrayList;

public class BoardListTO {
	private ArrayList<String> users;
	private ArrayList<BoardTO> boardLists;
	
	public void setUsers(ArrayList<String> users) {this.users = users;}
	public void setBoardLists(ArrayList<BoardTO> boardLists) {this.boardLists = boardLists;}

	public ArrayList<String> getUsers() {return users;}
	public ArrayList<BoardTO> getBoardLists() {return boardLists;}
	
	// BoardTO와 엮기 위해서는 xml파일이 필요하다
}
