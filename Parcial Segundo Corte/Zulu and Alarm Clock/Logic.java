import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Logic {

	Node head = null; //Empty list
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public void insertAtEnd (Node newNode)
	{
		if(isEmpty())
		{
			head = newNode;
			newNode.next = head;
			newNode.prev = head;
		}
		else
		{
			Node temp = head;
			while(temp.next != head) 
				temp = temp.next;
			
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = head;
			head.prev = newNode;
		}
	}
	
	public static int calcularseg (String [] clock, String [] alarm, Logic segundos)
	{
		int counter = 0;
		int counter2 = 0;
		Node temp = segundos.head;
		Node temp2 = segundos.head;
		
		while(temp.num != Integer.parseInt(clock[2]))
		{
			temp = temp.next;
			temp2 = temp.next.prev;
		}
			
		while(temp2.num != Integer.parseInt(alarm[2]))
		{
			counter += 1;
			temp2 = temp2.prev;
		}
				
		while(temp.num != Integer.parseInt(alarm[2]))
		{
			counter2 += 1;
			temp = temp.next;
		}
		
		if(counter2 < counter)
			return 1;
		else
			return 0;
	}
	
	public static int calcularmin (String [] clock, String [] alarm, Logic minutos)
	{
		int counter = 0;
		int counter2 = 0;
		Node temp = minutos.head;
		Node temp2 = minutos.head;
		
		while(temp.num != Integer.parseInt(clock[1]))
		{
			temp = temp.next;
			temp2 = temp.next.prev;
		}
			
		while(temp2.num != Integer.parseInt(alarm[1]))
		{
			counter += 1;
			temp2 = temp2.prev;
		}
				
		while(temp.num != Integer.parseInt(alarm[1]))
		{
			counter2 += 1;
			temp = temp.next;
		}
		
		if(counter2 < counter)
			return 1;
		else
			return 0;
	}
	
	public static int calcularhor (String [] clock, String [] alarm, Logic horas)
	{
		int counter = 0;
		int counter2 = 0;
		Node temp = horas.head;
		Node temp2 = horas.head;
		
		while(temp.num != Integer.parseInt(clock[0]))
		{
			temp = temp.next;
			temp2 = temp.next.prev;
		}
			
		while(temp2.num != Integer.parseInt(alarm[0]))
		{
			counter += 1;
			temp2 = temp2.prev;
		}
				
		while(temp.num != Integer.parseInt(alarm[0]))
		{
			counter2 += 1;
			temp = temp.next;
		}
		
		if(counter2 < counter)
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		
		int counter = 0;
		int x = 0;
	
		ArrayList<Integer> minValue = new ArrayList <Integer>();
		ArrayList<String[]> auxClocks = new ArrayList <String[]>();
		ArrayList<String[]> clocks = new ArrayList <String[]>();
		ArrayList<String[]> alarms = new ArrayList <String[]>();
	
		String clock[] = new String [3];
		String alarm[] = new String [3];
		
		Logic segundos = new Logic ();
		Logic minutos = new Logic ();
		Logic horas = new Logic ();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try
		{
			for(int i = 0; i < 60; i++)
				segundos.insertAtEnd(new Node(i));
			
			for(int i = 0; i < 60; i++)
				minutos.insertAtEnd(new Node(i));
			
			for(int i = 0; i < 24; i++)
				horas.insertAtEnd(new Node(i));
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < t; i++)
			{
				String input [] = br.readLine().split(" ");
				x = Integer.parseInt(input[1]);
					
				for(int j = 0; j < Integer.parseInt(input[0]); j++)
				{
					clocks.add(clock = br.readLine().split(":"));
					auxClocks.add(clock.clone());
				}
					
				for(int j = 0; j < Integer.parseInt(input[1]); j++)
					 alarms.add(alarm  = br.readLine().split(":"));
				
				for(int j = 0; j < Integer.parseInt(input[0]); j++ )
				{
					for(int k = 0; k < Integer.parseInt(input[1]); k++)
					{
						for(int l = 2; l >= 0; l--)
						{	
							if(clocks.get(j)[l].equals(alarms.get(k)[l]))
							{
								counter += 0;
								l -= 1;
							}
							
							if(l == 0 && calcularhor(clocks.get(j), alarms.get(k), horas) == 0)
							{
								Node temp = horas.head;
									
								while(temp.num != Integer.parseInt(clocks.get(j)[0]))
									temp = temp.next;
									
								while(temp.num != Integer.parseInt(alarms.get(k)[0]))
								{
									temp = temp.prev;
									clocks.get(j)[0] = String.valueOf(temp.num);
									counter += 1;
								}
													
							}
							else
								if(l == 1 && calcularmin(clocks.get(j), alarms.get(k), minutos) == 0)
								{
									Node temp = minutos.head;
											
									while(temp.num != Integer.parseInt(clocks.get(j)[1]))
										temp = temp.next;
											
									while(temp.num != Integer.parseInt(alarms.get(k)[1]))
									{
										if(temp.prev.num == 59)
										{
											int aux = Integer.parseInt(clocks.get(j)[0]);
											aux -= 1;
													
											if(aux == -1)
												clocks.get(j)[0] = "23";
											else
												clocks.get(j)[0] = String.valueOf(aux);	
										}	
										temp = temp.prev;
										clocks.get(j)[1] = String.valueOf(temp.num);
										counter += 1;
									}
								}
								else
									if(l == 2 && calcularseg(clocks.get(j), alarms.get(k), segundos) == 0)
									{
										Node temp = segundos.head;
											
										while(temp.num != Integer.parseInt(clocks.get(j)[2]))
											temp = temp.next;
												
										while(temp.num != Integer.parseInt(alarms.get(k)[2]))
										{
											if(temp.prev.num == 59)
											{
												int aux = Integer.parseInt(clocks.get(j)[1]);
												aux -= 1;
														
												if(aux == -1)
												{
													clocks.get(j)[1] = "59";
															
													int aux2 = Integer.parseInt(clocks.get(j)[0]);
													aux2 -= 1;
															
													if(aux2 == -1)
														clocks.get(j)[0] = "23";
													else
														clocks.get(j)[0] = String.valueOf(aux2);
												}
												else
													clocks.get(j)[1] = String.valueOf(aux);
											}
											temp = temp.prev;
											clocks.get(j)[2] = String.valueOf(temp.num);
											counter += 1;
										}
									}
									else
										if(l == 0 && calcularhor(clocks.get(j), alarms.get(k), horas) == 1)
										{
											Node temp = horas.head;
										
											while(temp.num != Integer.parseInt(clocks.get(j)[0]))
												temp = temp.next;
										
											while(temp.num != Integer.parseInt(alarms.get(k)[0]))
											{
												temp = temp.next;
												clocks.get(j)[0] = String.valueOf(temp.num);
												counter += 1;
											}
														
									}
									else
										if(l == 1 && calcularmin(clocks.get(j), alarms.get(k), minutos) == 1)
										{
											Node temp = minutos.head;
													
											while(temp.num != Integer.parseInt(clocks.get(j)[1]))
												temp = temp.next;
													
											while(temp.num != Integer.parseInt(alarms.get(k)[1]))
											{
												if(temp.next.num == 0)
												{
													int aux = Integer.parseInt(clocks.get(j)[0]);
													aux += 1;
															
													if(aux == 24)
														clocks.get(j)[0] = "00";
													else
														clocks.get(j)[0] = String.valueOf(aux);	
												}
														
												temp = temp.next;
												clocks.get(j)[1] = String.valueOf(temp.num);
												counter += 1;
											}
										}
										else
											if(l == 2 && calcularseg(clocks.get(j), alarms.get(k), segundos) == 1)
											{
												Node temp = segundos.head;
													
												while(temp.num != Integer.parseInt(clocks.get(j)[2]))
													temp = temp.next;
														
												while(temp.num != Integer.parseInt(alarms.get(k)[2]))
												{
													if(temp.next.num == 0)
													{
														int aux = Integer.parseInt(clocks.get(j)[1]);
														aux += 1;
																
														if(aux == 60)
														{
															clocks.get(j)[1] = "00";
																	
															int aux2 = Integer.parseInt(clocks.get(j)[0]);
															aux2 += 1;
																	
															if(aux2 == 24)
																clocks.get(j)[0] = "00";
															else
																clocks.get(j)[0] = String.valueOf(aux2);
														}
														else
															clocks.get(j)[1] = String.valueOf(aux);
															
													}
															
													temp = temp.next;
													clocks.get(j)[2] = String.valueOf(temp.num);
													counter += 1;
												}
											}	
								}
						
						minValue.add(counter);
						counter = 0;
						
						clocks.clear();
					
						for(int l = 0; l < Integer.parseInt(input[0]); l++)
							clocks.add(auxClocks.get(l).clone());
					}
				}
				
				int y = 0;
				minValue.sort(null);
				
				for(int j = 0; j < x; j++)
					 y += minValue.get(j);
				
				bw.write(y+"\n");
				bw.flush();
		
			}
			
		}catch (Exception ex) {}
	}

}
