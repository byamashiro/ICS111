//Copyright 2017 Reina Lyn Macaraeg, Bryan Yamashiro, Alvin Yang

import java.io.FileReader;
import java.util.Scanner;

public class DDRMain {
	public static VisualBar health;
	public static int hp = 300;
	public static void main(String[] args) throws java.io.IOException {
		// TODO Auto-generated method stub
		Scanner sc;
		int BPM;
		int length;
		
		float[] downTimes = new float[500];
		float[] upTimes = new float[500];
		float[] leftTimes = new float[500];
		float[] rightTimes = new float[500];
		EZ.initialize(800,800);
		EZ.addImage("left.png", 160, 140).scaleTo(0.5);
		EZ.addImage("down.png", 320, 140).scaleTo(0.5);
		EZ.addImage("up.png", 480, 140).scaleTo(0.5);
		EZ.addImage("right.png", 640, 140).scaleTo(0.5);
		EZ.refreshScreen();
		//EZSound song = EZ.addSound("song.wav");
		sc = new Scanner(new FileReader("notes.txt"));	//Takes in the notes.txt with BPM and song length
		BPM = sc.nextInt();								//Program is made to spawn in arrows based on what beat the song is at
		length = sc.nextInt();							//First line is for left arrows, second is for up, then for down, and last is right
		EZ.setFrameRate(120);
		health = new VisualBar();
		health.outlineBars();
		Sounds songs= new Sounds();		//Used to choose which song to play
		while(songs.pickSong()==0) {	
		songs.pickSounds();
		songs.playSounds();
		}
		
		int i=0;
		float value=1;
		while(value!=0) { //Until the scanner encounters a 0 which indicates the end of a line add the values to an array
			leftTimes[i]=sc.nextFloat();
			value = leftTimes[i];
			i++;
		}
		value=1;
		i=0;
		while(value!=0) {
			upTimes[i]=sc.nextFloat();
			value = upTimes[i];
			i++;
		}
		value=1;
		i=0;
		while(value!=0) {
			downTimes[i]=sc.nextFloat();
			value = downTimes[i];
			i++;
		}
		value=1;
		i=0;
		while(value!=0) {
			rightTimes[i]=sc.nextFloat();
			value = rightTimes[i];
			i++;
		}
		sc.close();
		NoteSpawner a = new NoteSpawner(leftTimes,downTimes,upTimes,rightTimes,BPM,length);	//Puts the arrays of arrow times into the NoteSpawner as well as the song's BPM and length
		while(a.isDone()==false) {
			a.go();
			health.hpChange(hp);	//Changes the health bar based on the current hp	
		}
		
	}

}
