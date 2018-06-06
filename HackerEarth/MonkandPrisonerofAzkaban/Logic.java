package MonkandPrisonerofAzkaban;

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
			String[] input = br.readLine().split(" ");		
			int [] a = new int [n];								//Se crea un arreglo de tamaño n
			
			for(int i = 0; i < a.length; i++)
				a[i] = Integer.parseInt(input[i]);				//Se llena el arreglo
		
			for(int i = 0; i < n; i++)							//Ciclo que controla las posiciones del arreglo
			{
				for(int j = i-1; j >= 0; j--)					//Ciclo que recorre el arreglo desde la pocisión i hacia la izquierda
				{
					if(a[j] > a[i])								//Si el arreglo en su posición j es mayor al arreglo en su posición 	
					{											//i se suma el indice j en una variable x y se rompe el ciclo
						x = j+1;									
						break;
					}
					else										
						if(j == 0)								//Si j llega a 0 significa que no hay elementos mayores a el arreglo 
						{										//en su posición i por lo tanto "x" toma el valor de -1 y se rompe el ciclo
							x = -1;								
							break;
						}		
				}
				
				if(i == 0)										//Si i es igual a 0 es por que no tiene que bscar elemento hacia la
					x = -1;										//izquierda por lo tanto "x" va a tomar el valor de -1
				
				for(int j = i+1; j < n; j++)					//Ciclo que recorre el arreglo desde la posición i hacia la derecha
				{		
					if(a[j] > a[i])								//Si el arreglo en su posición j es mayor al arreglo en su posición 
					{											//i se suma el indice j en una ariable y y se rompe el ciclo
						y = j+1;
						break;
					}
					else
						if(j == n-1)						    //Si j llega a n-1 significa que no hay elementos mayores a el arreglo 
						{										//en su posición i por lo tanto "y" toma el valor de -1 y se rompe el ciclo
							y = -1;								
							break;
						}
				}
				
				if(i == n-1)									//Si i es igual a 0 es por que no tiene que buscar elemento hacia la derecha
					y = -1;										//por lo tanto "y" va a tomar el valor de -1
				
				bw.write(x+y+" ");								
				bw.flush();		
			}
						
		}catch (Exception ex) {}
		
	}

}
