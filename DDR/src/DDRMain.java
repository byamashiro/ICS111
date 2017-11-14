import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DDRMain {

	public static void main(String[] args) throws java.io.IOException {
		// TODO Auto-generated method stub
		Scanner sc;
		int BPM;
		int length;
		
		int[] down = new int[500];
		int[] up = new int[500];
		int[] left = new int[500];
		int[] right = new int[500];
		EZ.initialize(800,800);
		EZ.addImage("left.png", 160, 100).scaleTo(0.5);
		EZ.addImage("down.png", 320, 100).scaleTo(0.5);
		EZ.addImage("up.png", 480, 100).scaleTo(0.5);
		EZ.addImage("right.png", 640, 100).scaleTo(0.5);
		EZ.refreshScreen();
		sc = new Scanner(new FileReader("notes.txt"));
		BPM = sc.nextInt();
		length = sc.nextInt();
		int i=0;
		int value=1;
		while(value!=0) {
			left[i]=sc.nextInt();
			value = left[i];
			i++;
		}
		value=1;
		i=0;
		while(value!=0) {
			up[i]=sc.nextInt();
			value = up[i];
			i++;
		}
		value=1;
		i=0;
		while(value!=0) {
			down[i]=sc.nextInt();
			value = down[i];
			i++;
		}
		value=1;
		i=0;
		while(value!=0) {
			right[i]=sc.nextInt();
			value = right[i];
			i++;
		}
		value=1;
		i=0;
		sc.close();
		
		NoteSpawner a = new NoteSpawner(left,down,up,right,BPM,length);
		while(a.isDone()==false) {
				a.go();
			
		}
		//for(int a=0;a<right.length;a++) {
			//System.out.println(right[a]);
		//}
		
	}

}
