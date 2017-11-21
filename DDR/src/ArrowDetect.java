
public class ArrowDetect {

	public ArrowDetect() {
	}
	public String detectMiss(int life) {
		if(life>180) {
			DDRMain.hp -= 20;
			return "miss";
		} else return "none";
	}

	//Arrows are perfectly aligned when life is 140
	public String detect(int life) {	//Uses the life from the Arrow to see how long it has been on the screen to keep track of where it is
		if(life<=143 && life>=137) {	//Increases/decreases Hp based on the score of the arrow
			DDRMain.hp += 5;
			return "perfect";
		} else if((life<=146 && life>=144) || (life<=134 && life>=136)) {
			DDRMain.hp += 3;
			return "great"; 
		}else if((life<=148) && life>=147 || (life<=132 && life>=133)) {
			DDRMain.hp += 2;
			return "good"; 
		}else if((life<=155) && (life>=149) || (life<=125 && life>=131)) {
			DDRMain.hp += 1;
			return "ok"; 
		}else return "nothing";

	}
}
