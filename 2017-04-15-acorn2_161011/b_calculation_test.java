package p10_11_tue;
//import java.math.*;


public class b_calculation_test {
	public static void main(String[] args){
		float pi=3.141592f;
		
		float shortpi=Math.round(pi*1000) / 1000f;
		System.out.println(shortpi);
		
		float shortpi_1=(float)Math.ceil(pi*1000)/1000;
		System.out.println(shortpi_1);
		
		float shortpi_2=(float)Math.floor(pi*1000)/1000f;	
		System.out.println(shortpi_2);
		
		float shortpi_3=(int)(pi*1000)/1000f;
		System.out.println(shortpi_3);
	}
}
