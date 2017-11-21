
public class Sounds {
	//EZSound dada;
	EZImage daoko;
	EZImage dadada;
	EZSound play;
	int clickX = EZInteraction.getXMouse();
	int clickY = EZInteraction.getYMouse();
	String songName;

	public Sounds() {
		dadada = EZ.addImage("dada.png",200, 300);
		daoko = EZ.addImage("daoko.png", 600, 300);

		//pickSounds();

	}
	public int pickSong() {
		if(songName!=null) {
			return 1;
		}else return 0;
	}

	public void pickSounds() {
		clickX = EZInteraction.getXMouse();
		clickY = EZInteraction.getYMouse();
		if(EZInteraction.wasMouseLeftButtonPressed()) {
			if(dadada.isPointInElement(clickX, clickY)) {
				songName = "dada.wav";
			}
			if(daoko.isPointInElement(clickX, clickY)) {
				songName = "slh.wav";		
			}
		}
	}


	public void playSounds() {
		if(songName!=null) {
			play = EZ.addSound(songName);
			play.play();
			dadada.hide();
			daoko.hide();
		}
		EZ.refreshScreen();
	}
}

