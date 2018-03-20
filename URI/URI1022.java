import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class URI1022 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int counter = 0;
		
		try
		{
			int cases = Integer.parseInt(br.readLine());
			int num, den, numS, denS;
				
			do
			{
				String[] expression = br.readLine().split(" ");
				switch(expression[3].charAt(0))
				{
			
				case '+':
			
					num = (Integer.parseInt(expression[0]) * Integer.parseInt(expression[6]))
					+ (Integer.parseInt(expression[2]) * Integer.parseInt(expression[4]));
					
					den = (Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]));
					
					numS = num/euclides(num,den);
					denS = den/euclides(num,den);
					
					bw.write(num+"/"+den+" = "+numS+"/"+denS+"\n");
					bw.flush();
					break;
					
				case '-':
					
					num = (Integer.parseInt(expression[0]) * Integer.parseInt(expression[6]))
					- (Integer.parseInt(expression[2]) * Integer.parseInt(expression[4]));
					
					den = (Integer.parseInt(expression[2]) * Integer.parseInt(expression[6]));
					
					numS = num/euclides(num,den);
					denS = den/euclides(num,den);
					
					bw.write(num+"/"+den+" = "+numS+"/"+denS + "\n");
					bw.flush();
					break;
					
				case '*':
					
					num = (Integer.parseInt(expression[0])) * (Integer.parseInt(expression[4]));
					
					den = (Integer.parseInt(expression[2])) * (Integer.parseInt(expression[6]));
					
					numS = num/euclides(num,den);
					denS = den/euclides(num,den);
					
					bw.write(num+"/"+den+" = "+numS+"/"+denS+ "\n");
					bw.flush();
					break;
					
				case '/':
					
					num = (Integer.parseInt(expression[0])) * (Integer.parseInt(expression[6]));
					
					den = (Integer.parseInt(expression[2])) * (Integer.parseInt(expression[4]));
					
					numS = num/euclides(num,den);
					denS = den/euclides(num,den);
					
					bw.write(num+"/"+den+" = "+numS+ "/" + denS + "\n");
					bw.flush();
					break;
				}
				
				counter += 1;
				
			}while(cases != counter);
			
		}
		catch (Exception ex) {}
			
	}
	
	public static int euclides (int num, int den) throws IOException
	{
		if (num != 0)
		{
			int mcd = 0;
			int resto = 0;
			
			do {	
				resto = num % den;
				num = den;
				
				if(resto != 0)
					den = resto;
			
				if(resto == 0)
					mcd = den;
				
			}while(resto != 0);
					
			return mcd;
		}
		
		return 1;		
	}

}
