import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class URI1110 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int number = Integer.parseInt(br.readLine());
			
			while(number != 0 )
			{
				Vector<Integer> deck = new Vector<Integer>();
				
				for(int i = 0; i < number ; i++)
					deck.add(i + 1);
				
				bw.write("Discarted cards: ");
				
				while(deck.size() >= 2)
				{
					if(deck.size() > 2)
						bw.write(deck.get(0) + ", ");
					if(deck.size() == 2)
						bw.write(deck.get(0) + " ");
					deck.remove(0);
					deck.add(deck.get(0));
					deck.remove(0);
				}
				
				bw.write("\n");
				
				bw.write("Remaining card: "+deck.get(0));
				
				bw.flush();
	
				number = Integer.parseInt(br.readLine());
				
			}	
			
		}catch (Exception ex) {}

	}

}
