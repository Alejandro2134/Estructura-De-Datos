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
							input2[j] = Character.toString(input[k].charAt(j)); 
						else
							input2[j] = input2[j].concat(Character.toString(input[k].charAt(j)));
					}
				
				int counter = 0;
				int x = 0;
				int y = n-1;
				
				while(counter != n/2)
				{
					if(!input[x].equals(input[y]))
					{
						xFlag = false;
						break;
					}						
					else
					{
						xFlag = true;
						
						if(!input2[x].equals(input2[y]))
						{
							yFlag = false;
							break;
						}
						else
							yFlag = true;
					}
					
					counter += 1;
					++x;
					--y;	
				}
				
				if(xFlag && yFlag)
					bw.write("YES\n");
				else
					bw.write("NO\n");
		
				bw.flush();
			}
			
		}catch (Exception ex) {}
		

	}

}
