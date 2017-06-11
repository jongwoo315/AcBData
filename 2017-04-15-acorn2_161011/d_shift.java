package p10_11_tue;

public class d_shift {
	public static void main(String[] args){
		System.out.println(8);
		
		System.out.println(Integer.toBinaryString(8));
		System.out.println();
		
		int temp = 8<<1;
		System.out.println("8<<1= "+temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		temp = 8<<2;
		System.out.println("8<<2= "+temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		System.out.println();
		System.out.println(-8);
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();
		
		temp = -8>>1;
		System.out.println("-8>>1= "+temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		temp = -8>>2;
		System.out.println("-8>>2= "+temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		System.out.println();
		System.out.println(-8);
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();
		
		temp = -8>>>1;
		System.out.println("8>>>1= "+temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		temp = -8>>>2;
		System.out.println("8>>>2= "+temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
	}
}
