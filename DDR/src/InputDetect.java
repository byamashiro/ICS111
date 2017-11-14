
public class InputDetect {
	private char up;
	private char right;
	private char left;
	private char down;
	
	public InputDetect(char l, char d, char u, char r) {
		up = u;
		left = l;
		down = d;
		right = r;
	}
	
	public String detect(int life) {
		if(life>100) {
			return "miss";
		} else if(life>=73 && life<=75) {
			return "perfect";
		} else if((life>=71 && life<=72) || (life>=76 && life<=77)) {
			return "great"; 
		}else if((life==70) || life==78) {
			return "good"; 
		}else if((life==69) || (life==79)) {
			return "ok"; 
		}else return "nothing";
		
	}
}
