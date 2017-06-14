package adapter;

public class Calculator {
	Rect rectangle;
	
	public double getArea(Rect r){
		rectangle = r;
		return rectangle.l * rectangle.w;
	}
}
