import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class URI1211 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
		
		try {
			
			String input = br.readLine();
			String phoneNumber;
			char [] phone_number;
			int cases, counter;
			
			while(!input.equals(""))
			{
				cases = Integer.parseInt(input);
				counter = 0;
				
				phoneNumber = br.readLine();
				phone_number = new char [phoneNumber.length()];
				
				for(int i = 0; i < phoneNumber.length(); i++)
					phone_number[i] = phoneNumber.charAt(i);
			
				for(int i = 1; i < cases; i++)
				{
					phoneNumber = br.readLine();
					
					int j = 0;
					while(true)
					{
						if(phone_number[j] == phoneNumber.charAt(j))
							counter += 1;
						else
							break;
						
						j++;
					}
				}
				
				bw.write(counter + "\n");
				bw.flush();
				input = br.readLine();
				
			}
	
		}catch(Exception ex) {}
	}

}
