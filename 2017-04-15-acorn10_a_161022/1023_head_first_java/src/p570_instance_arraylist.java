import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Song implements Comparable<Song>{
	String title;
	String artist;
	String rating;
	String bpm;
	
	Song(String t, String a, String r, String b){
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}
	
	public int compareTo(Song s) {
		return title.compareTo(s.gettitle());
	}
	
	public String gettitle() { return title; }
	public String getartist() { return artist; }
	public String getrating() { return rating; }
	public String getbpm() { return bpm; }
	public String toString() { return title; }
}
//노래를 파일에서 읽어온다 -> 파싱(적절한 처리과정)을 한다 -> 출력한다.

public class p570_instance_arraylist {

	ArrayList<Song> songlist = new ArrayList<Song>();	// main메서드 밖에 선언한다.

	void getsong() {
		try {
			File file = new File("songlist1.txt");	//FileReader에서 직접 읽으면 생략가
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			//line = reader.readLine();
			
			while((line = reader.readLine()) != null) {
				addsong(line);
			}
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// 이제 arraylist에 노래를 추가하도록 하 

	void addsong(String linetoparse) {
		String [] tokens = linetoparse.split("/");
		Song nextsong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songlist.add(nextsong);
	}
	
	void go() {
		getsong();
		System.out.println(songlist);
		Collections.sort(songlist);
		System.out.println(songlist);
		
		artistcompare artistcc = new artistcompare();
		Collections.sort(songlist, artistcc);
		System.out.println(songlist);
	}
	
	public static void main(String[] args) {
		p570_instance_arraylist juke = new p570_instance_arraylist();
		juke.go();
	}
	
	class artistcompare implements Comparator<Song>{
		public int compare(Song one, Song two) {
			return one.getartist().compareTo(two.getartist());
		}
	}
}
