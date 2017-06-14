package factory;

interface IAnimal{
	void Speak();
}

class Duck implements IAnimal{
	//@Override
	public void Speak(){
		System.out.println("Duck says Pack-pack");
	}
}

class Tiger implements IAnimal{
	//@Override
	public void Speak(){
		System.out.println("tiger says  halum, halum");
	}
}

abstract class IAnimalFactory{
	public abstract IAnimal GetAnimalType(String type) throws Exception;
}

class ConcreteFactory extends IAnimalFactory{
	@Override
	public IAnimal GetAnimalType(String type) throws Exception{
		switch(type){
			case "Duck":
				return new Duck();
			case "Tiger":
				return new Tiger();
			default:
				throw new Exception("Animal type: "+type+"cannot be instantiated");
		}
	}
}



