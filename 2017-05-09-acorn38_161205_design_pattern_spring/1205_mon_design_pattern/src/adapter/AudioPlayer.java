package adapter;

public class AudioPlayer implements MediaPlayer{
	MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String fileName) {
		// inbuilt support to play mp3 music files
		if(audioType.equalsIgnoreCase("mp3")) {
			System.out.println("playing mp3 file. Name:"+fileName);
		}

		// mediaAdpater is providing support to play other file formats
		else if(audioType.equalsIgnoreCase("vlc") || 
					audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}	
		else {
			System.out.println("Invalid media."+audioType+"format not supported");
		}
	}
}
