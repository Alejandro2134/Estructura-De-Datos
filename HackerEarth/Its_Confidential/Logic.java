package Its_Confidential;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
		
	public static String itsConfidencial(String input)
	{
		if(input.length() > 1)
		{
			int middle = (int)(Math.ceil(input.length() / 2.0) - 1);
			return input.substring(middle, middle + 1) 
					+ itsConfidencial(input.substring(0, middle)) 
					+ itsConfidencial(input.substring(middle + 1));
		}
		else
			return input;
	}

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0;  i < t; i++)
			{
				int n = Integer.parseInt(br.readLine());
				
				String word = br.readLine();
			
				bw.write(itsConfidencial(word)+"\n");
				bw.flush();
				
			}
			
		}catch(Exception ex) {}

	}

}
