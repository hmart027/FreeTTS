import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import freetts.TTS;

@SuppressWarnings("unused")
public class FreeTTStest {

	 private static final String VOICENAME_kevin = "kevin16";
	 	 
	 public static void main(String[] args) {
		 
		 //Set the location of the Mbrola voices
		 System.setProperty("mbrola.base", "/home/bookreader/SoftwareLibraries/freetts-1.2.2-bin/MBROLA"); 
	 		  
		  VoiceManager voiceManager = VoiceManager.getInstance();
		  final Voice voice = voiceManager.getVoice("mbrola_us1");
		  voice.allocate();
		  
		  voice.setVolume((float) 0.8);
		  
//		  System.out.println(voice.speak(text));
//		  voice.speak("which way should I go?");
		  
		  
		  TextInputGUI gui = new TextInputGUI();
		  gui.setTalkListener(new TextInputGUI.TalkListener() {
			
			public void actionPerformed(final String e) {
				new Thread() {
					@Override
					public void run() {
						voice.speak(e);
					}
				}.start();
			}
		});
		 
//		 TTS tts = new TTS();
//		 tts.doTTS("Hello World");
	  	  
	 }
	 
}
