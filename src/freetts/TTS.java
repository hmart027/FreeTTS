package freetts;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;


public class TTS {
	
	private static final String VOICENAME_kevin = "kevin16";	 

	private Voice voice;
	private AudioPlayer player;
	
	public TTS(){
		//Set the location of the Mbrola voices
		System.setProperty("mbrola.base", "/home/bookreader/SoftwareLibraries/freetts-1.2.2-bin/MBROLA"); 
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(VOICENAME_kevin);
		voice.allocate();
		player = voice.getAudioPlayer();
	}
	
	public boolean doTTS(String text){
		return voice.speak(text);
	}
	
	public void pause(){
		player.pause();
	}
	
	public void resume(){
		player.resume();
	}

}
