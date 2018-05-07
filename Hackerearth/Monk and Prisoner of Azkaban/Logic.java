import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try
		{
			int n = Integer.parseInt(br.readLine()), x = 0, y = 0;
			String input = br.readLine();
			String[] stringInput = input.split(" ");
			int [] a = new int [n];
			
			for(int i = 0; i < a.length; i++)
				a[i] = Integer.parseInt(stringInput[i]);
		
			for(int i = 0; i < n; i++)
			{
				for(int j = i-1; j >= 0; j--)
				{
					if(a[j] > a[i])
					{
						x = j+1;
						break;
					}
					else
						if(j == 0)
						{
							x = -1;
							break;
						}		
				}
				
				if(i == 0)
					x = -1;
				
				for(int j = i+1; j < n; j++)
				{		
					if(a[j] > a[i])
					{
						y = j+1;
						break;
					}
					else
						if(j == n-1)
						{
							y = -1;
							break;
						}
				}
				
				if(i == n-1)
					y = -1;
				
				bw.write(x+y+" ");
				bw.flush();		
			}
						
		}catch (Exception ex) {}
		
	}

}
