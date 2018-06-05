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
	
	/**
	  * Metodo el cual busca de que forma es mas facil llegar a otra (aumenta o diminuye) 
	  * @return retorna 1 o 0 dependiendo de que forma sea mas facil llegar a otro segundo 
	  */
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
	
	/**
	  * Metodo el cual busca de que forma es mas facil llegar a otra (aumenta o diminuye) 
	  * @return retorna 1 o 0 dependiendo de que forma sea mas facil llegar a otro minuto 
	  */
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
	 /**
	  * Metodo el cual busca de que forma es mas facil llegar a otra (aumenta o diminuye) 
	  * @return retorna 1 o 0 dependiendo de que forma sea mas facil llegar a otra hora 
	  */
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
		int y = 0;
		int z = 0;
		
		ArrayList<Integer> minValue = new ArrayList <Integer>(); //ArrayList para guardar todos los posibles valores minimos de operaciones para iniciar las alarmas  		
		ArrayList<String[]> auxClocks = new ArrayList <String[]>(); //ArrayList auxiliar el cual tiene la función de guardar todas los relojes que se ingresan por consola 
		ArrayList<String[]> clocks = new ArrayList <String[]>(); //ArrayList para guardar el reloj que se ingresa por consola
		ArrayList<String[]> alarms = new ArrayList <String[]>(); //ArrayList para guardar las alarmas que se ingresan por consola
	
		String clock[]; //Arreglo de strings para almacenar el reloj que se ingresa por consola	
		String alarm[]; //Arreglo de strings para almacenar la alarma que se ingresa por consola
		
		Logic segundos = new Logic ();	//Lista circular para simular el contador de segundos de un reloj
		Logic minutos = new Logic ();	//Lista circular para simular el contador de minutos de un reloj
		Logic horas = new Logic (); //Lista circular para simular el contador de horas de un reloj 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try
		{
			for(int i = 0; i < 60; i++)
				segundos.insertAtEnd(new Node(i));	//Se ingresan valores desde 0 hasta 59 en la lista circular
			
			for(int i = 0; i < 60; i++)
				minutos.insertAtEnd(new Node(i)); //Se ingresan valores desde 0 hasta 59 en la lista circular
			
			for(int i = 0; i < 24; i++)
				horas.insertAtEnd(new Node(i)); //Se ingresan valores desde 0 hasta 23 en la lista circular
			
			int t = Integer.parseInt(br.readLine());	
			
			for(int i = 0; i < t; i++)
			{
				String input [] = br.readLine().split(" ");	
				x = Integer.parseInt(input[1]);
				z = Integer.parseInt(input[0]);
				
				for(int j = 0; j < Integer.parseInt(input[0]); j++)
				{
					clocks.add(clock = br.readLine().split(":"));	//Se inicializa el arreglo de strings, y los elementos del arreglo se guardan en un ArrayList 
					auxClocks.add(clock.clone()); 	//Se realiza el mismo proceso en un ArrayList auxiliar
				}
					
				for(int j = 0; j < Integer.parseInt(input[1]); j++)
					 alarms.add(alarm  = br.readLine().split(":"));	//Se inicializa el arreglo de strings, y los elementos del arreglo se guardan en un ArrayList
				
				for(int j = 0; j < Integer.parseInt(input[1]); j++ )
				{
					for(int k = 0; k < Integer.parseInt(input[0]); k++)	
					{
						for(int l = 2; l >= 0; l--)	//Ciclo que controla cada indice del reloj y de las alarmas para compararlos entre si y saber el número de operaciones que se deben hacer para iniciar las alarmas
						{							//Indice 2 compara segundos, Indice 1 compara minutos, Indice 0 compara horas	
							
							if(clocks.get(k)[l].equals(alarms.get(j)[l])) //Si los indices que se estan comparando son iguales     
								counter += 0; //Significa que no se realiza ninguna operación	
							
							if(l == 0 && calcularhor(clocks.get(k), alarms.get(j), horas) == 0)	//Si se estan comparando horas y la función calcularhor retorna 0 significa que la forma mas rapida de iniciar la alarma es restarle al contador de horas del reloj que se esta comparando
							{
								Node temp = horas.head; //Se crea una variable de tipo nodo inicializandolo con el primer valor de la lista circular horas 
									
								while(temp.num != Integer.parseInt(clocks.get(k)[0])) //ciclo que busca el valor de la hora que se ingreso en el reloj que se esta comparando en la lista circular horas
									temp = temp.next;
									
								while(temp.num != Integer.parseInt(alarms.get(j)[0])) //Ciclo el cual a partir del valor hallado anteriormente busca el número de operaciones para llegar a la hora de la alarma  
								{
									temp = temp.prev; //Se baja una unidad 
									clocks.get(k)[0] = String.valueOf(temp.num); // Se cambia el valor del reloj en su posición de horas   
									counter += 1; // Se va sumando uno a un contador para saber cuantas operaciones se realizan 
								}
													
							}
							else
								if(l == 1 && calcularmin(clocks.get(k), alarms.get(j), minutos) == 0) //Si se estan comparando minutos y la funcion calcularmin retorna 0 significa que la forma mas rapida de iniciar la alarma es restarle al contador de minutos del reloj que se esta comparando
								{ 
									Node temp = minutos.head; //Se crea una variable de tipo nodo inicializandolo con el primer valor de la lista circular minutos 
											
									while(temp.num != Integer.parseInt(clocks.get(k)[1])) //ciclo que busca el valor del minuto que se ingreso en el reloj que se esta comparando en la lista circular minutos
										temp = temp.next;
											
									while(temp.num != Integer.parseInt(alarms.get(j)[1])) //Ciclo el cual a partir del valor hallado anteriormente busca el número de operaciones para llegar al minuto de la alarma	
									{
										if(temp.prev.num == 59) //Si el valor anterior al que se esta bajando una unidad es igual a 59 significa que el contador de horas debe bajar en una unidad
										{
											int aux = Integer.parseInt(clocks.get(k)[0]); //Se crea una variable auxiliar la cual almacena el valor de la hora  
											aux -= 1; // a la cual se le resta uno 
													
											if(aux == -1) //Si el valor de la variable auxiliar es igual a -1 significa que antes el valor de la hora era 0 por lo tanto este valor debe cambiar a 23
												clocks.get(k)[0] = "23"; //Se cambia el valor de la hora
											else //Si no simplemente el valor de la hora va a bajar una unidad
												clocks.get(k)[0] = String.valueOf(aux); //Se baja una unidad en el valor de la hora	
										}	
										temp = temp.prev; //Se baja en una unidad el valor del minuto
										clocks.get(k)[1] = String.valueOf(temp.num); //Se cambia el valor del minuto bajado una unidad
										counter += 1; // Se va sumando uno a un contador para saber cuantas operaciones se realizan 
									}
								}
								else
									if(l == 2 && calcularseg(clocks.get(k), alarms.get(j), segundos) == 0) //Si se estan comparando segundos y la función calcularseg retorna 0 significa que la forma mas rapida de iniciar la alarma es restarle uno al contador de segundos del reloj que se esta comparando 
									{
										Node temp = segundos.head; //Se crea una variable de tipo nodo inicializandolo con el primer valor de la lista circular segundos
											
										while(temp.num != Integer.parseInt(clocks.get(k)[2])) //ciclo que busca el valor del segundo que se ingreso en el reloj que se esta comparando en la lista circular segundos
											temp = temp.next;
												
										while(temp.num != Integer.parseInt(alarms.get(j)[2])) //Ciclo el cual a partir del valor hallado anteriormente busca el número de operaciones para llegar al segundo de la alarma 
										{
											if(temp.prev.num == 59) //Si el valor anterior al que se esta bajando una unidad es igual a 59 significa que el contador de minutos debe bajar en una unidad 
											{
												int aux = Integer.parseInt(clocks.get(k)[1]); //Se crea una variable auxiliar la cual almacena el valor del minuto
												aux -= 1; // a la cual se le resta uno 
														
												if(aux == -1) //Si el valor de la variable auxiliar es igual a -1 significa que antes el valor del minuto era 0 por lo tanto este valor debe cambiar a 59
												{
													clocks.get(k)[1] = "59"; //Se cambia el valor del minuto
															
													int aux2 = Integer.parseInt(clocks.get(k)[0]); //Se crea otra variable auxiliar la cual almacena el valor de la hora 
													aux2 -= 1; // a la cual se le resta 1
															
													if(aux2 == -1) //Si el valor de la variable auxialiar es igual a -1 significa que el valor de la hora era 0 por lo tanto este valor debe cambiar a 23
														clocks.get(k)[0] = "23"; //Se cambia el valor de la hora
													else //Si no simplemente el valor de la hora va a bajar una unidad
														clocks.get(k)[0] = String.valueOf(aux2);
												}
												else //Si no simplemente el valor del minuto va a bajar una unidad
													clocks.get(k)[1] = String.valueOf(aux);
											}
											temp = temp.prev; //Se baja en una unidad el valor del segundo
											clocks.get(k)[2] = String.valueOf(temp.num); //Se cambia el valor del segundo bajado una unidad
											counter += 1; // Se va sumando uno a un contador para saber cuantas operaciones se realizan 
										}
									}
									else
										if(l == 0 && calcularhor(clocks.get(k), alarms.get(j), horas) == 1) //Si se estan comparando horas y la función calcularhor retorna 1 significa que la forma mas rapida de iniciar la alarma es sumarle al contador de horas del reloj que se esta comparando
										{
											Node temp = horas.head; //Se crea una variable de tipo nodo inicializandolo con el primer valor de la lista circular horas
										
											while(temp.num != Integer.parseInt(clocks.get(k)[0])) //ciclo que busca el valor de la hora que se ingreso en el reloj que se esta comparando en la lista circular horas
												temp = temp.next;
										
											while(temp.num != Integer.parseInt(alarms.get(j)[0])) //Ciclo el cual a partir del valor hallado anteriormente busca el número de operaciones para llegar a la hora de la alarma
											{
												temp = temp.next; //Se aumenta en una unidad
												clocks.get(k)[0] = String.valueOf(temp.num); // Se cambia el valor del reloj en su posición de horas   
												counter += 1; // Se va sumando uno a un contador para saber cuantas operaciones se realizan 
											}
														
									}
									else
										if(l == 1 && calcularmin(clocks.get(k), alarms.get(j), minutos) == 1) //Si se estan comparando minutos y la funcion calcularmin retorna 1 significa que la forma mas rapida de iniciar la alarma es aumentarle al contador de minutos del reloj que se esta comparando 
										{
											Node temp = minutos.head; //Se crea una variable de tipo nodo inicializandolo con el primer valor de la lista circular minutos
													
											while(temp.num != Integer.parseInt(clocks.get(k)[1])) //ciclo que busca el valor del minuto que se ingreso en el reloj que se esta comparando en la lista circular minutos
												temp = temp.next;
													
											while(temp.num != Integer.parseInt(alarms.get(j)[1])) //Ciclo el cual a partir del valor hallado anteriormente busca el número de operaciones para llegar al minuto de la alarma
											{
												if(temp.next.num == 0) //Si el valor anterior al que se esta bajando una unidad es igual a 0 significa que el contador de horas debe aumentar en una unidad
												{
													int aux = Integer.parseInt(clocks.get(k)[0]); //Se crea una variable auxiliar la cual almacena el valor de la hora
													aux += 1; // a la cual se le suma uno 
															
													if(aux == 24) //Si el valor de la variable auxiliar es igual a 24 significa que el valor de la hora era 23 por lo tanto este valor debe camiar a 0
														clocks.get(k)[0] = "00"; //Se cambia el valor de la hora
													else //Si no simplemente el valor de la hora va a aumentar una unidad
														clocks.get(k)[0] = String.valueOf(aux);	
												}
														
												temp = temp.next; //Se aumenta en una unidad
												clocks.get(k)[1] = String.valueOf(temp.num); // Se cambia el valor del reloj en su posición de minutos
												counter += 1; // Se va sumando uno a un contador para saber cuantas operaciones se realizan 
											}
										}
										else
											if(l == 2 && calcularseg(clocks.get(k), alarms.get(j), segundos) == 1) //Si se estan comparando segundos y la función calcularseg retorna 1 significa que la forma mas rapida de iniciar la alarma es aumentarle uno al contador de segundos del reloj que se esta comparando
											{
												Node temp = segundos.head; //Se crea una variable de tipo nodo inicializandolo con el primer valor de la lista circular segundos
													
												while(temp.num != Integer.parseInt(clocks.get(k)[2])) //ciclo que busca el valor del segundo que se ingreso en el reloj que se esta comparando en la lista circular segundos
													temp = temp.next;
														
												while(temp.num != Integer.parseInt(alarms.get(j)[2])) //Ciclo el cual a partir del valor hallado anteriormente busca el número de operaciones para llegar al segundo de la alarma	
												{
													if(temp.next.num == 0) //Si el siguiente valor al que se le esta aumentando una unidad es igual a 0 significa que el contador de minutos debe aumentar una unidad
													{
														int aux = Integer.parseInt(clocks.get(k)[1]); //Se crea una variable auxiliar la cual almacena el valor del minuto
														aux += 1; // a la cual se le suma uno 
																
														if(aux == 60) //Si el valor de la variable auxiliar es igual a 60 significa que el valor del minuto era 59 por lo tanto este valor debe cambiar a 0
														{
															clocks.get(k)[1] = "00"; //Se cambia el valor del minuto
																	
															int aux2 = Integer.parseInt(clocks.get(k)[0]); //Se crea otra variable auxiliar la cual almacena el valor de la hora
															aux2 += 1; // a la cual se le suma uno 
																	
															if(aux2 == 24) //Si el valor de la variable auxiliar es igual a 24 significa que el valor de la hora era 23 por lo tanto este valor debe camiar a 0
																clocks.get(k)[0] = "00"; //Se cambia el valor de la hora
															else //Si no simplemente el valor de la hora va a aumentar una unidad
																clocks.get(k)[0] = String.valueOf(aux2);
														}
														else //Si no simplemente el valor del minuto va a aumentar una unidad
															clocks.get(k)[1] = String.valueOf(aux);
															
													}
															
													temp = temp.next; //Se aumenta en una unidad
													clocks.get(k)[2] = String.valueOf(temp.num); // Se cambia el valor del reloj en su posición de segundos
													counter += 1; // Se va sumando uno a un contador para saber cuantas operaciones se realizan 
												}
											}	
								}
						
						minValue.add(counter); //Se añade el valor del contador a un ArrayList
						counter = 0; //Se vuelve a inicializar el contador en 0 
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/Alejandro2134/Estructura-De-Datos.git
					}
					
					clocks.clear(); //Se borran los datos del ArrayList
					
					for(int l = 0; l < Integer.parseInt(input[0]); l++)
						clocks.add(auxClocks.get(l).clone()); //Se vuelve a llenar el ArrayList con los datos del ArrayList auxiliar (Esto ya que los datos en el arrayList principal reloj fueron modificados)
				}
				
				for(int j = 0; j < z; j++)	
				{
					if(minValue.size() > 1) //Si el tamaño del arreglo de contadores es mayor a uno
						minValue.subList(0, x).sort(null); //Se organizan los datos en subarreglos de menor a mayor
					
					y += minValue.get(0); //Se mete el primer valor del subarreglo ya organizado y se va sumando
					
					if(minValue.size() > 1) //Si el tamaño del arreglo de contadores es mayor a uno 
						minValue.subList(0, x).clear(); //Se borra la sublista ya organizada	
				}
				
				auxClocks.clear();
				clocks.clear();
				bw.write(y+"\n"); //Se imprime el valor de la variable y
				bw.flush();
		
				y = 0; //Se inicializa en 0
			}
			
		}catch (Exception ex) {}
	}

}
