package DNA_Pride;

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
				int tam = Integer.parseInt(br.readLine());
				String sequence = br.readLine();
				
				if(sequence.contains("U"))
					bw.write("Error RNA nucleobases found! \n");
				else
				{
					String output = "";
					
					for(int j = 0; j < tam; j++ )
					{
						switch(sequence.charAt(j))
						{
							case 'A':	output += "T";	break;
							case 'C':	output += "G";	break;
							case 'G':	output += "C";	break;
							default:	output += "A";	break;
						}
					}
					
					bw.write(output+"\n");
					
				}
				
				bw.flush();
			}
			
			
		}catch (Exception ex) {}

	}

}
