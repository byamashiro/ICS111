
//Copyright 2017 Reina Lyn Macaraeg, Bryan Yamashiro, Alvin Yang

import java.awt.Color;
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
		boolean gameover = false;
		float[] downTimes = new float[500];
		float[] upTimes = new float[500];
		float[] leftTimes = new float[500];
		float[] rightTimes = new float[500];
		EZ.initialize(800,800);
		EZText score = EZ.addText(70, 760, "Score: ", Color.black, 20);
		EZ.addImage("left.png", 160, 140).scaleTo(0.5);
		EZ.addImage("down.png", 320, 140).scaleTo(0.5);
		EZ.addImage("up.png", 480, 140).scaleTo(0.5);
		EZ.addImage("right.png", 640, 140).scaleTo(0.5);
		EZ.refreshScreen();
		String[] dancing = {"Steven gif/1.png", "Steven gif/2.png", "Steven gif/3.png", "Steven gif/4.png","Steven gif/5.png","Steven gif/6.png",
				"Steven gif/7.png", "Steven gif/8.png", "Steven gif/9.png", "Steven gif/10.png", "Steven gif/11.png", "Steven gif/12.png","Steven gif/13.png", 
				"Steven gif/14.png", "Steven gif/15.png", "Steven gif/16.png", "Steven gif/17.png", "Steven gif/18.png", "Steven gif/19.png", "Steven gif/20.png", 
				"Steven gif/21.png", "Steven gif/22.png", "Steven gif/23.png"};
		Steven steven = new Steven(dancing,1000,500,730); //Adds the steven animation
		//EZSound song = EZ.addSound("song.wav");


		health = new VisualBar();
		health.outlineBars();
		Sounds songs= new Sounds();		//Used to choose which song to play
		while(songs.pickSong()==0) {	
			songs.pickSounds();
			songs.playSounds();
		}
		sc = new Scanner(new FileReader(songs.fileName()));	//Takes in the notes.txt with BPM and song length
		BPM = sc.nextInt();								//Program is made to spawn in arrows based on what beat the song is at
		length = sc.nextInt();							//First line is for left arrows, second is for up, then for down, and last is right
		EZ.setFrameRate(120);
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
		while(a.isDone()==false && gameover==false) {
			a.go();
			if(health.hpChange(hp)) {	//Changes the health bar based on the current hp
				gameover = true;
				songs.stopSong();

			}
			score.setMsg("Score: " + a.getScore()); //Updates score
			steven.go();
		}
		if(a.isDone()==true) {
			EZ.addRectangle(400, 400, 800, 800, Color.white, true);//Winning screen is added
			EZ.addText(400, 400, "YOU WIN", Color.GREEN, 100);
			score.translateTo(400, 500);
			score.pullToFront();
			songs.stopSong();
			score.setFontSize(30);
		}
	}

}
