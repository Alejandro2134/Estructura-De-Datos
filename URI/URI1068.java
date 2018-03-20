import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class URI1068 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try 
		{
			String input = br.readLine();
			
			while(!input.equals(""))
			{
				int counter = 0;
				
				for (int i = 0; i < input.length(); i++)
				{
					if (input.charAt(i) == '(')
						counter += 1;
					
					if(input.charAt(i) == ')' )
						if(counter > 0)
							counter -= 1;
						else
						{
							counter = -1;
							break;
						}
				}
				
				if(counter == 0)
					bw.write("correct\n");
				else
					bw.write("incorrect\n");
				
				bw.flush();
				input = br.readLine();
			}
			
			
		}catch (Exception ex) {}

	}

}
