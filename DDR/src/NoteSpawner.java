
public class NoteSpawner {

	private int BPM;
	private int length;
	public float progress;
	private ArrowDetect detect = new ArrowDetect();
	private Arrow[] leftArrows = new Arrow[20];
	private Arrow[] upArrows = new Arrow[20];
	private Arrow[] downArrows = new Arrow[20];
	private Arrow[] rightArrows = new Arrow[20];
	private int leftArrow = 0;
	private int upArrow = 0;
	private int rightArrow = 0;
	private int downArrow = 0;
	private float[] leftArrowTime;
	private float[] downArrowTime;
	private float[] upArrowTime;
	private float[] rightArrowTime;
	private String detectUp;
	private String detectDown;
	private String detectRight;
	private String detectLeft;
	public NoteSpawner(float[] left, float[] down, float[] up, float[] right, int bpm, int len) {
		BPM= bpm; 
		length = len;
		leftArrowTime = left;
		downArrowTime = down;
		upArrowTime = up;
		rightArrowTime = right;
	}
	
	public void progress() {
		progress+=0.25;
	}

	public boolean isDone() {		//Takes in the song length to determine when the song is done
		if(progress<60*60*length/BPM) {
			return false;
		}else return true;
	}

	public void go() {
		if(Math.floor((double)60*120/BPM*leftArrowTime[leftArrow])==progress) { //Depending on the progress & BPM spawns note taken from the text file
			
			for(int a=0;a<20;a++) {
				if(leftArrows[a]==null) {
					leftArrows[a]=new Arrow(5,"left");
					break;
				}
			}
			leftArrow++;
		}
		if(Math.floor((double)60*120/BPM*upArrowTime[upArrow])==progress) {
			
			for(int a=0;a<20;a++) {
				if(upArrows[a]==null) {
					upArrows[a]=new Arrow(5,"up");
					break;
				}
			}
			upArrow++;
		}
		if(Math.floor((double)60*120/BPM*rightArrowTime[rightArrow])==progress) {
			
			for(int a=0;a<20;a++) {
				if(rightArrows[a]==null) {
					rightArrows[a]=new Arrow(5,"right");
					break;
				}
			}
			rightArrow++;
		}
		if(Math.floor((double)60*120/BPM*downArrowTime[downArrow])==progress) {
			for(int a=0;a<20;a++) {
				if(downArrows[a]==null) {
					downArrows[a]=new Arrow(5,"down");
					break;
				}
			}
			downArrow++;
		}

		for(int g=0;g<20;g++) { //Goes through the array of all the arrows to move them 
			if(leftArrows[g]!=null) {
				leftArrows[g].move();
			}
			if(upArrows[g]!=null) {
				upArrows[g].move();
			}
			if(rightArrows[g]!=null) {
				rightArrows[g].move();
			}
			if(downArrows[g]!=null) {
				downArrows[g].move();
			}
		}
		for(int g=0;g<20;g++) {		//Checks through the arrows to see if they were missed by the user
			if(leftArrows[g]!=null) {
				if(detect.detectMiss(leftArrows[g].returnLife())=="miss") {
					leftArrows[g].remove();
					leftArrows[g]=null;
					System.out.println("miss");
				}
			}
			if(upArrows[g]!=null) {
				if(detect.detectMiss(upArrows[g].returnLife())=="miss") {
					upArrows[g].remove();
					upArrows[g]=null;
					System.out.println("miss");
				}
			}
			if(rightArrows[g]!=null) {
				if(detect.detectMiss(rightArrows[g].returnLife())=="miss") {
					rightArrows[g].remove();
					rightArrows[g]=null;
					System.out.println("miss");
				}
			}
			if(downArrows[g]!=null) {
				if(detect.detectMiss(downArrows[g].returnLife())=="miss") {
					downArrows[g].remove();
					downArrows[g]=null;
					System.out.println("miss");
				}
			}
		}
		if(EZInteraction.wasKeyPressed('w')) {		//Checks when the controls are pressed and if the Arrow is near where they should be pressed
			//System.out.println("w");				//and removes them & scores them
			for(int g=0;g<20;g++) {
				if(upArrows[g]!=null) {
					detectUp = detect.detect(upArrows[g].returnLife());
					System.out.println(detectUp);
					switch(detectUp)
					{
					case "perfect":
						System.out.println("Perfect");
						upArrows[g].remove();
						upArrows[g]=null;
						break;
					case "great":
						System.out.println("great");
						upArrows[g].remove();
						upArrows[g]=null;
						break;
					case "good":
						System.out.println("good");
						upArrows[g].remove();
						upArrows[g]=null;
						break;
					case "ok":
						System.out.println("ok");
						upArrows[g].remove();
						upArrows[g]=null;
						break;
					default:
						break;

					}
				}
			}
		}
		if(EZInteraction.wasKeyPressed('a')) {
			//System.out.println("a");
			for(int g=0;g<20;g++) {
				if(leftArrows[g]!=null) {
					detectLeft = detect.detect(leftArrows[g].returnLife());
					switch(detectLeft)
					{
					case "perfect":
						System.out.println("Perfect");
						leftArrows[g].remove();
						leftArrows[g]=null;
						break;
					case "great":
						System.out.println("great");
						leftArrows[g].remove();
						leftArrows[g]=null;
						break;
					case "good":
						System.out.println("good");
						leftArrows[g].remove();
						leftArrows[g]=null;
						break;
					case "ok":
						System.out.println("ok");
						leftArrows[g].remove();
						leftArrows[g]=null;
						break;
					default:
						break;

					}
				}
			}
		}
		if(EZInteraction.wasKeyPressed('d')) {
			//System.out.println("d");
			for(int g=0;g<20;g++) {
				if(rightArrows[g]!=null) {
					detectRight = detect.detect(rightArrows[g].returnLife());
					switch(detectRight)
					{
					case "perfect":
						System.out.println("Perfect");
						rightArrows[g].remove();
						rightArrows[g]=null;
						break;
					case "great":
						System.out.println("great");
						rightArrows[g].remove();
						rightArrows[g]=null;
						break;
					case "good":
						System.out.println("good");
						rightArrows[g].remove();
						rightArrows[g]=null;
						break;
					case "ok":
						System.out.println("ok");
						rightArrows[g].remove();
						rightArrows[g]=null;
						break;
					default:
						break;

					}
				}
			}
		}
		if(EZInteraction.wasKeyPressed('s')) {
			//System.out.println("s");
			for(int g=0;g<20;g++) {
				if(downArrows[g]!=null) {
					detectDown = detect.detect(downArrows[g].returnLife());
					switch(detectDown)
					{
					case "perfect":
						System.out.println("Perfect");
						downArrows[g].remove();
						downArrows[g]=null;
						break;
					case "great":
						System.out.println("great");
						downArrows[g].remove();
						downArrows[g]=null;
						break;
					case "good":
						System.out.println("good");
						downArrows[g].remove();
						downArrows[g]=null;
						break;
					case "ok":
						System.out.println("ok");
						downArrows[g].remove();
						downArrows[g]=null;
						break;
					default:
						break;

					}
				}
			}
		}
		progress++;		//keeps track of the progress of the song
		//System.out.println(progress);
		EZ.refreshScreen();
	}
}
