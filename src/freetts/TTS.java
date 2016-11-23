package freetts;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;


public class TTS {
	
	private static final String VOICENAME_kevin = "kevin16";	 

	private Voice voice;
	private AudioPlayer player;
	
	public TTS(){
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(VOICENAME_kevin);
		voice.allocate();
		player = voice.getAudioPlayer();
		System.out.println(player);
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
