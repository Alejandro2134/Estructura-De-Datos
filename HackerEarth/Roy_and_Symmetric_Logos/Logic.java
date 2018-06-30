package Roy_and_Symmetric_Logos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < t; i++)
			{
				int n = Integer.parseInt(br.readLine());
				
				String input [] = new String [n];
				String input2 [] = new String [n];
				
				boolean xFlag = false;
				boolean yFlag = false;
					
				for(int j = 0; j < n; j++)
					input [j] = br.readLine();
					
				for(int j = 0; j < n; j++)
					for(int k = 0; k < n; k++)
					{
						if(k == 0)
							input2[k] = Character.toString(input[k].charAt(j)); 
						else
							input2[j].concat(Character.toString(input[k].charAt(j)));
					}
						
				
				
					
			}
			
		}catch (Exception ex) {}
		

	}

}
