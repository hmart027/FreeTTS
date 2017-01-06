import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class FreeTTStest {

	 private static final String VOICENAME_kevin = "kevin16";
	 	 
	 public static void main(String[] args) {
		 
		 //Set the location of the Mbrola voices
		 System.setProperty("mbrola.base", "/media/DATA/SoftwareLibraries/freetts-1.2.2-bin/MBROLA"); 
	 
		  String text = "FreeTTS was written by the Sun Microsystems Laboratories "
		    + "Speech Team and is based on CMU's Flite engine. Hello!!";
		  
		  final Voice voice;
		  VoiceManager voiceManager = VoiceManager.getInstance();
	//	  voice = voiceManager.getVoice(VOICENAME_kevin);
		  voice = voiceManager.getVoice("mbrola_us2");
		  voice.allocate();
		  
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
	  	  
	 }
	 
}
