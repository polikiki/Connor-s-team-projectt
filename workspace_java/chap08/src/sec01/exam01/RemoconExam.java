package sec01.exam01;

import java.util.ArrayList;
import java.util.List;

public class RemoconExam {

	public static void main(String[] args) {
		
		RemoteControl tv = new Tv();
		
		Audio audio = new Audio();
		RemoteControl audio2 = audio;
		
//		RemoteControl rc = new RemoteControl();
		
		tv.turnOn();
		
		audio2.setVolume(12);
		
		List list = new ArrayList();
//		List l2 = new List(); interface라서 new를 할 수없기 때문에 안됨
		
		audio.turnOff();
	}

}
