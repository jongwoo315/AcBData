package homework3_1;

public class calc {
	public static void main(String[] args) {
		int a = 41;
		int b = 48;
		int d = 32;
		int total = a+ b+ d;
		float c = (int)((a + b + d) / 3f*100)/100f;
		float avr = (int)(total / 3f * 100) / 100f;
		System.out.println(avr);
	}
}
