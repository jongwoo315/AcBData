package factory;

public class FactoryPatternEx {
	public static void main(String[] args) throws Exception {
		System.out.println("***Factory Pattern Demo***\n");
		IAnimalFactory animalFactory = new ConcreteFactory();
		IAnimal DuckType = animalFactory.GetAnimalType("Duck");
		DuckType.Speak();
		
		IAnimal TigerType = animalFactory.GetAnimalType("Tiger");
		TigerType.Speak();
		// there is no lion type. so, an exception will be thrown
		IAnimal LionType = animalFactory.GetAnimalType("Lion");
		LionType.Speak();
	}
}
