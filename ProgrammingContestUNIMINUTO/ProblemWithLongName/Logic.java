package ProblemWithLongName;

import java.math.BigInteger;
import java.util.Scanner;

public class Logic {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int t = sc.nextInt();
			BigInteger base = BigInteger.valueOf(66);
			BigInteger mod = BigInteger.valueOf(100);
			
			for(int i = 0; i < t; i++) {
				BigInteger n = sc.nextBigInteger();
				BigInteger result = base.modPow(n, mod);
				System.out.println(result);
			}
			
		} catch (Exception ex) {}
	}

}
