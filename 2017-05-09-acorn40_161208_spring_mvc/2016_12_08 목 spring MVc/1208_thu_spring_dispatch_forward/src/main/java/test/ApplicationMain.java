package test;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:test/context.xml");
		
		BoardListTO listTO = (BoardListTO)ctx.getBean("listTO");
		
		for(String user12 : listTO.getUsers()){
			System.out.println(user12);
		}
		
		for(BoardTO to : listTO.getBoardLists()){
			System.out.println();
			System.out.println(to.getSeq());
			System.out.println(to.getSubject());
			System.out.println(to.getContent());
		}
	}
}


/**
 * 1. new Generic을 하면 인스턴스화되어 xml을 통째로 main으로 불러온다.
 * 2. .xml파일의 bean id="listTO"인 곳을 찾고, class파일은 BoardListTO를 향함
 * 		(2개의 property users, boardLists는 연결된 것. 즉, 홍길동-to1, 박문수-to2)
 * 3. <property name="users">는 값을 set하는 기능이다.
 * 3. 다시 main함수로 돌아와, BoardListTO class의 getUsers메서드를 호출한다
 * 4. getUsers내의 변수들을 모두 출력 (println)
 * 5. .xml파일의 <bean id="listTO">를 보면 property name="boardLists"가
 * 			있는데,  이것은 BoardListTO클래스의
 * 			private ArrayList<BoardTO> boardLists; 를 가리킨다.
 * 6. .xml파일의 ref bean="to1"에 의해 <bean id="to1">으로 향하고, 여기에 담긴
 * 			name(BoardTO클래스의 변수명과 일치)을 차례로 출력한다.
 * 7. to2도 마찬가지
 */