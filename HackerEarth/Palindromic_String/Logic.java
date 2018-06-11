package Palindromic_String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int counter = 0;
			String word = br.readLine();
			
			for(int i = 0; i < word.length(); i++)
				if(word.charAt(i) == (word.charAt(word.length()-i-1)))
					counter += 1;
			
			if(counter == word.length())
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}catch (Exception ex) {}

	}

}
