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
	
	public static void playAudioIniciar() {
		URL som = Sons.class.getResource("inicializar.wav");
		AudioClip _som = Applet.newAudioClip(som);
		_som.play();
	}
	
}
