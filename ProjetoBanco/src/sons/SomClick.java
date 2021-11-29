package sons;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SomClick {

	@SuppressWarnings("deprecation")
	public static void playAudio() {
		URL som = SomClick.class.getResource("somBotao.wav");
		AudioClip _som = Applet.newAudioClip(som);
		_som.play();
	}
	
	@SuppressWarnings("deprecation")
	public static void AudioOpenProgram() {
		URL som = SomClick.class.getResource("navi.wav");
		AudioClip _som = Applet.newAudioClip(som);
		_som.play();
	}
}
