import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Logic {
	
	public static boolean primo (int number)
	{
		 int raizCuadrada = (int)Math.sqrt(number);
		 
		 if(number < 2)
			 return false;
		 else
		 {
			 for(int i = 2; i <= raizCuadrada; i++)
		     {
				 if((number % i) == 0)
					 return false;
		     }
		
		     return true;	     
		 }   
	}  
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < t; i++)
			{
				ArrayList <Integer> mulPrimos = new ArrayList<Integer>();
				int n = Integer.parseInt(br.readLine());
				int a [] = new int [n];
				String input [] = br.readLine().split(" ");
				
				for(int j = 0; j < n; j++)
					a[j] = Integer.parseInt(input[j]);					
				
				for(int j = 0; j < a.length; j++)
				{
					if(primo(a[j]))
					{
						mulPrimos.add(a[j] * a[j]);
						
						for(int k = j+1; k < a.length; k++)
						{
							if(primo(a[k]))
								mulPrimos.add(a[j] * a[k]);
						}
					}
				}
				
				if(mulPrimos.isEmpty())
					bw.write(-1+"\n");
				else
				{
					mulPrimos.sort(null);
					bw.write(mulPrimos.get(mulPrimos.size()-1)+"\n");
				}
				
				bw.flush();
			}
	
		}catch (Exception ex) {}

	}

}
