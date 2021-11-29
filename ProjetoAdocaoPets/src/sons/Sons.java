package sons;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

@SuppressWarnings("deprecation")
public class Sons {
	public static void playAudioClick() {
		URL som = Sons.class.getResource("somBotao.wav");
		AudioClip _som = Applet.newAudioClip(som);
		_som.play();
	}
	
	public static void playAudioLatir() {
		URL som = Sons.class.getResource("latir.wav");
		AudioClip _som = Applet.newAudioClip(som);
		_som.play();
	}
	
	public static void playAudioMiau() {
		URL som = Sons.class.getResource("miau.wav");
		AudioClip _som = Applet.newAudioClip(som);
		_som.play();
	}
	
	public static void playAudioGrita() {
		URL som = Sons.class.getResource("Passaro.wav");
		AudioClip _som = Applet.newAudioClip(som);
		_som.play();
	}
	
}
