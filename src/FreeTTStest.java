import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class FreeTTStest {

	 private static final String VOICENAME_kevin = "kevin16";
	 	 
	 public static void main(String[] args) {
	 
	  String text = "FreeTTS was written by the Sun Microsystems Laboratories "
	    + "Speech Team and is based on CMU's Flite engine. Hello!!";
	  
	  Voice voice;
	  VoiceManager voiceManager = VoiceManager.getInstance();
	  voice = voiceManager.getVoice(VOICENAME_kevin);
	  voice.allocate();
	  
//	  System.out.println(voice.speak(text));
	  voice.speak("which way should I go?");
	  	  
	 }
	 
}
