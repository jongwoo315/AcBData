package p10_11_tue;

public class a_operator_test {
	public static void main(String[] args){
		int i=5;
		i++;
		System.out.println(i+"\n");
		
		i=5;
		++i;
		System.out.println(i);
		System.out.println(i++);	//Ãâ·ÂµÇŽÂ i°ªÀº 6
		//¿©±âŒ­ iŽÂ 7
		System.out.println(++i);
		
		char c1='a';
		char c2=c1;
		char c3=' ';
		
		int j=c1+1;
		
		c3= (char)(c1+1);
		c2++;
		c2++;
		
		System.out.println("j="+j);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
	}
}
