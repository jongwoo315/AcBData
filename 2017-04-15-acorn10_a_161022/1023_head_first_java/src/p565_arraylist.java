import java.util.*;
import java.io.*;

public class p565_arraylist {
	ArrayList<String> songlist = new ArrayList<String>();	//songlist에 <문자열>만 받겠다는 선언!
	
	void getsongs(){
		try {
			File file = new File("songlist.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = null;
			while( ( line = reader.readLine() ) != null ) {
				addsong(line);
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	void addsong(String linetoparse) {	//addsong()메서드는 while문이 끝나기 전까지 계속 돌아간
		String [] tokens = linetoparse.split("/");
		songlist.add(tokens[0]);	// tokens[0]에는 곡, tokens[1]에는 아티스트가 저장
	}

	public void go() {
		getsongs();
		System.out.println(songlist+"\n");	// go메서드를 통해 음악리스트를 출력한
		
		Collections.sort(songlist);		//sort의 매개변수로 객체가 들어갔음을 기억!!!!!!!!!!!
		System.out.println(songlist);	
	}
	
	public static void main(String[] args) {
		new p565_arraylist().go();
		
		/*p565_arraylist ppp = new p565_arraylist();
		ppp.go();*/
	}
}
