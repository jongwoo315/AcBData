package command1;
public class command_pattern {
	public static void main(String[] args){
		System.out.println("***Command Pattern Demo***\n");

		Receiver intendedreceiver = new Receiver();
		MyUndoCommand unCmd = new MyUndoCommand(intendedreceiver);
		MyRedoCommand reCmd = new MyRedoCommand(intendedreceiver);
		
		Invoke inv = new Invoke();
		inv.ExecuteCommand(unCmd);	// 명령어를 매개변수로 던져준다.
		inv.ExecuteCommand(reCmd);	// 같은 함수 executecommand에 다른 매개변수가 들어오는 것이 포인트
	}
}

interface lCommand{void Do();}	// 인터페이스는 순수가상함수로 구성. 그 자체로 실행할 수 없다.

class Receiver{
	public  void performUndo(){
		System.out.println("Executing - MyUndoCommand");
	}
	public void performRedo(){
		System.out.println("Executing - MyRedoCommand");
	}
}

class MyUndoCommand implements lCommand{	//	여기서 인터페이스를 구성
	private Receiver receiver;	
	MyUndoCommand(Receiver recv){	 
		receiver = recv;
	}	// 생성자
	//@Override
	public void Do(){receiver.performUndo();}	//do를 오버라이딩
}

class MyRedoCommand implements lCommand{
	private Receiver receiver;
	MyRedoCommand(Receiver recv){
		receiver = recv;
	}
	//@Override
	public void Do(){receiver.performRedo();}
}

class Invoke{
	lCommand cmd;	// 인터페이스
	public void ExecuteCommand(lCommand cmd){	//의존관계
		this.cmd = cmd;
		cmd.Do();
	}	
}
//class command_patternex{}