package singleton;

class MakeACaptain{
	private static MakeACaptain _captain;
	private MakeACaptain(){}
	
	private static class SingletonHelper{
		private static final MakeACaptain _captain = new MakeACaptain();
	}
	
	public static MakeACaptain getCaptain(){
		return SingletonHelper._captain;
	}
}

public class SingletonPatternEx {
	public static void main(String[] args) {
		System.out.println("***Singleton Pattern Demo***\n");
		
		System.out.println("Trying to make a captain for our team");
		MakeACaptain c1 = MakeACaptain.getCaptain();
		
		System.out.println("Trying to make another captain for our team");
		MakeACaptain c2 = MakeACaptain.getCaptain();
		
		if(c1 == c2 ){
			System.out.println("c1 and c2 are same instance");
		}
	}
}

/* 

	Concept 
A particular class should have only one instance. We will use only that instance whenever we are in need.

	Real-Life Example
Suppose you are a member of a cricket team. And in a tournament your team is going to play against another
team. As per the rules of the game, the captain of each side must go for a toss to decide which side will bat
(or bowl) first. So, if your team does not have a captain, you need to elect someone as a captain first. And at
the same time, your team cannot have more than one captain.

	Computer World Example
In a software system sometimes we may decide to use only one file system. Usually we may use it for the
centralized management of resources.

	Illustration
In this example, we have made the constructor private first, so that we cannot instantiate in normal fashion.
When we attempt to create an instance of the class, we are checking whether we already have one available
copy. If we do not have any such copy, we’ll create it; otherwise, we’ll simply reuse the existing copy.
*/