package Testing_Strings;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			String input [] = br.readLine().split(" ");
			
			int variations  = Integer.parseInt(input[2]) * Integer.parseInt(input[2]); 
			
			for(int i = 0; i < Integer.parseInt(input[0]); i++)
			{
				String input2 [] = br.readLine().split(" ");
				
				
				
			}
			
			
		}catch (Exception ex) {}
		
		
 
	}

}
