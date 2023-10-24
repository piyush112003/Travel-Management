package miniProjects;
import java.util.*;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Class for Hotel recommendation
class hotels{

	String cityName;
	String HotelName;
	String price;
	String rating;

}
// Class for Place recommendation
class place{
	place next;
	String place;
	String City;

	place(String []places){
		this.City=places[0];
		this.place=places[1];
	}
	place(){
		next=null;
	}

}
// Linked List for Places to visit
class list{

	place head;

	list(){
		head=null;
	}


	void places1(int p,int d,String place[]) throws IOException
	{
		//System.out.println("p"+p);
		//System.out.println("d"+d);
		//System.out.println(Arrays.toString(place));
		String line="";  
		//read text file         
		BufferedReader br;

		br = new BufferedReader(new FileReader("C:\\Users\\nandg\\eclipse-workspace\\miniProjects\\src\\miniProjects\\places"));


		System.out.println("\n\n\n\n*****************************************************************************SUGGESTIONS OF PLACES*******************************************************************************************");
		System.out.println(" \n\t\t\tHERE IS LIST OF SOME PLACES YOU  MAY LIKE TO VISIT   8-)");
		while((line=br.readLine())!=null)
		{

			String w[]=line.split(" ");
			int k=p;

			int last=d;

			for(int a=k;a<=last;a++) {

				if(place[a].equals(w[0])) {


					//System.out.println("\n\ncity name:"+w[0]);
					//System.out.println("place name:"+w[1]);
					place temp=new place(w);

					if(head==null) {

						head=temp;
						//System.out.println(temp.City);
					}
					else {
						place ptr=head;
						while(ptr.next!=null) {
							//System.out.println("city:"+ptr.City);
							//System.out.println("place:"+ptr.place);
							ptr=ptr.next;

						}
						ptr.next=temp;
					}
				}
			}
		}
		printplace();
	}

	void printplace()
	{

		if(head==null) {
			System.out.println("list is empty");
		}
		else {
			place curr = head;


			while(curr!=null) {
				int i=1;
				System.out.print("\n\t\t\t\t\t|  City : "+curr.City+"   |     ");
				System.out.print(" \t\t\t\t\t|  Place name:"+curr.place+"  |\n");
				System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

				curr=curr.next;
			}
			System.out.println();
		}
	}	
}

//Input source destination
class input
{
	Scanner sc=new Scanner(System.in);


	void busnew() throws IOException {


		String line="";  
		//read text file         
		BufferedReader br;
		Scanner sc=new Scanner(System.in);
		br = new BufferedReader(new FileReader("C:\\Users\\nandg\\eclipse-workspace\\miniProjects\\src\\miniProjects\\bus"));
		//index =index of city array
		//row=index of row
		//column=index of column
		boolean flag=false;
		input ob=new input();
		System.out.println("Enter start point:");
		
		int start=sc.nextInt();
		System.out.println("\n\n__________________________________________________________________________________________________________________________________________________________________________");
		int [][] bus=new int [10][10];
		while((line=br.readLine())!=null)
		{
			//	System.out.println(line);

			String w[]=line.split(" ");

			//String c[]=city;


			String b[]=new String [12];
			b[0]="Solapur";
			b[1]="Sangli";
			b[2]="Parbhani";
			b[3]="Nanded";
			b[4]="Nagpur";
			b[5]="Buldhana";
			b[6]="Pune";
			b[7]="Ratnagiri";
			b[8]="Ahmadnagar";


			int k=start-1;
			





			if(b[k].equals(w[0])) {
				

				System.out.println("\n\n \t\t\t\t\t\t------------             --------------");
				System.out.println("\t\t\t\t\t\t|   "+w[0]+"   |   ---->  |      "+w[1]+"     |");
				System.out.println(" \t\t\t\t\t\t------------             --------------");
				System.out.print("\n\n\t\t|   Bus name:"+w[2]+" |  ");
				System.out.print("\t\t\t|    Price:"+w[3]+"  |  ");
				System.out.print("\t\t\t|    Ratings:"+w[4]+"  |  ");
				System.out.println("\n\n__________________________________________________________________________________________________________________________________________________________________________");

			}
		}
	}


	int displaymenu() {
		System.out.println("\n\n******************************************************************LIST OF CITIES***********************************************************************************\n");
		System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|1).| Solapur |     2).| Sangli |    3).| Parbhani |     4).| Nanded |     5).| Buldhana |     6).| Nagpur |     7).| Pune |      8).| Ratnagiri |      9).| Ahmadnagar |");
		System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		System.out.println("Enter which city you want as your starting location/point:");
		System.out.println("(Enter number of that city)");
		int point=sc.nextInt();

		int index=point-1;

		return index;
	}
	public void read()
	{
		try {

			String line="";  
			//read text file         
			BufferedReader br;
			br = new BufferedReader(new FileReader("C:\\Users\\nandg\\eclipse-workspace\\miniProjects\\src\\miniProjects\\time"));
			//index =index of city array
			//row=index of row
			//column=index of column
			int index=0,row=0,column=0;
			String[] city= new String[12];
			boolean flag=false;
			int graph[][] = new int[12][12];
			while((line=br.readLine())!=null)
			{
				//	System.out.println(line);
				//word[0]=start  word[1]=destination word[2]=distance               
				String w[]=line.split(" ");
				//for(int i=0;i<w.length;i++)
				//System.out.println("words:"+w[i]);
				// check if city is already inserted in aaray
				flag=false;           
				for(int p=0;p<index;p++)
				{
					if(city[p].equals(w[0])){
						flag=true;
						row=p;
					}
				}
				if(flag==false)
				{
					city[index++]=w[0];

					row=index-1;
				}

				flag=false;
				for(int p=0;p<index;p++)
				{
					if(city[p].equals(w[1]))
					{   flag=true;
					column=p;
					}
				}
				if(flag==false)
				{
					city[index++]=w[1];
					column=index-1;
				}


				//print city array 


				//System.out.println (index1+ "  "+index2 + "  "+index);
				//convert string dis into int and store in graph
				graph[row][column]=Integer.parseInt(w[2]); 

				//System.out.println(graph[row][column]);

			}
			System.out.println("\n***************************************************************************************************************************************************************************");
			System.out.println("\nCities:");
			System.out.println(Arrays.toString(city));
			System.out.println("\n\nMatrix form:");
			System.out.println("________________________________________________________________");
			for (int k=0;k<=10;k++)
			{
				for(int m=0;m<=10;m++) {
					System.out.print(graph[k][m]+ "  |  ");
				}
				System.out.println(" ");
				System.out.println("________________________________________________________________");
			}


			ShortestPath t = new ShortestPath();

			int startingPoint=displaymenu();
			System.out.print("Enter destination:");
			int destination=sc.nextInt();

			int destindex=destination-1;
			t.dijkstra(graph, startingPoint, city,destindex); 
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

class ShortestPath {
	// A utility function to find the vertex with minimum distance value,
	// from the set of vertices not yet included in shortest path tree
	static final int V = 9;
	int minDistance(int dist[], Boolean visited[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (visited[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;

			}

		return min_index;
	}

	// A utility function to print the constructed distance array
	void printSolution(int dist[], int n, String[] city, int point, int dest) throws IOException
	
	{
		System.out.println("\nSource City ----> "+city[point]);
		System.out.println("\nDestination ---->"+city[dest]);
		System.out.println("\nDISPLAYING TIME TAKEN TO TRAVEL FROM SOURCE CITY TO DESTINATION");
		System.out.println("\n_______________________________________________________________");
		System.out.println("Starting city        |       Time taken from Source city");
		System.out.println("_______________________________________________________________");
		for (int i = point; i <= dest; i++) {
			System.out.println(city[i] + "                             " + dist[i]);
			System.out.println("_______________________________________________________________");

		}
		hotels(city,point,dest);


	}
	void hotels (String[] city1,int point,int dest) throws IOException {


		String line="";  
		//read text file         
		BufferedReader br;
		br = new BufferedReader(new FileReader("C:\\Users\\nandg\\eclipse-workspace\\miniProjects\\src\\miniProjects\\Hotel"));
		//index =index of city array
		//row=index of row
		//column=index of column
		int index=0,row=0,column=0;
		int k=0,last=0;
		String[] city= new String[12];
		boolean flag=false;
		int graph[][] = new int[12][12];
		System.out.println("\n\n********************************************************************************SUGGESTIONS OF HOTELS*****************************************************************************************\n");
		System.out.println(" Here are list of some hotels in case you will to take rest  (^^)");
		System.out.println();
		while((line=br.readLine())!=null)
		{

			String w[]=line.split(" ");


			k=point;

			last=dest;



			for(int a=k;a<=last;a++) {

				if(city1[a].equals(w[0])) {

					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

					System.out.println((a+1)+"). \t\t \t\t\t\t\t\t*****|     "+w[0]+"     |*****\n");
					System.out.println("                | hotel name : "+w[1]+"  |                         | price : "+w[2]+"  |            \t\t\t       | ratings : "+w[3]+" |");
					//System.out.println("--------------------------------------------------------------------------------------------------");



				}


			}
			System.out.println();


		}

		list y=new list();
		y.places1(k,last,city1);
		System.out.println("\t\t\t\t\t\t\t\t\tHOPE YOY ENJOY YOUR TRIP  :)");

	}


	void dijkstra(int graph[][], int point, String[] city,int dest) throws IOException
	{
		int dist[] = new int[V];         //The output array. 
		//dist[i] will hold the shortest distance from point to i

		// visited[i] will true if vertex i is included in shortest

		Boolean visited[] = new Boolean[V];          //size 9

		// Initialize all distances as INFINITE and visited[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		// Distance of source vertex from itself is  0
		dist[point] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// minimum distance vertex from the set of vertices is selected
		
			int u = minDistance(dist, visited);

			// Mark the picked vertex as visited
			visited[u] = true;

			// Update dist value of the adjacent vertices of the  picked vertex.
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in dist, there is an edge from u to v, and total weight of path from point to v through u is smaller than current value of dist[v]
				if (!visited[v] && graph[u][v] != 0 &&  dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist, V, city,point, dest);
	}
}

public class BookHotels {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input ob=new input();
		list ob1=new list();
		Scanner sc=new Scanner(System.in);
		int ans=0;
		System.out.println("\t\t\t\t\t\t\t\t\t ________________");
		System.out.println("\t\t\t\t\t\t\t\t\t|                |");
		System.out.println("\t\t\t\t\t\t\t\t\t| TRAVEL PLANNER |");
		System.out.println("\t\t\t\t\t\t\t\t\t|________________|");
		do {
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\n1) < Shortest distance between two cities >\n\n2) < See available buses for a city >\n");
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:

				ob.read();
				break;

			case 2:

				ob.busnew();

				break;
			default:
				System.out.println("Enter valid choice......");
			}
			System.out.println("\n\nDo you want to continue?");
			System.out.println("If yes press 1 else press 0");
			ans=sc.nextInt();
			if(ans==1) {
				System.out.println("You are being redirected to menu page\n");
			}
			else {
				System.out.println("******************************************************************THANYOU ! VISIT AGAIN ! !*****************************************************************************");
			}
		}while(ans!=0);

	}

}


/*									 ________________
									|                |
									| TRAVEL PLANNER |
									|________________|
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1) < Shortest distance between two cities >

2) < See available buses for a city >

Enter your choice:
1

 *************************************************************************************************************************************

Cities:
[Solapur, Sangli, Parbhani, Nanded, Nagpur, Buldhana, Pune, Ratnagiri, Ahmadnagar, null, null, null]


Matrix form:
________________________________________________________________
0  |  3  |  0  |  0  |  0  |  0  |  0  |  8  |  0  |  0  |  0  |   
________________________________________________________________
3  |  0  |  8  |  9  |  0  |  0  |  0  |  7  |  0  |  0  |  0  |   
________________________________________________________________
0  |  8  |  0  |  2  |  4  |  0  |  0  |  0  |  7  |  0  |  0  |   
________________________________________________________________
0  |  9  |  2  |  0  |  7  |  5  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  4  |  7  |  0  |  7  |  9  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  5  |  7  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  9  |  0  |  0  |  5  |  3  |  0  |  0  |   
________________________________________________________________
8  |  7  |  0  |  0  |  0  |  0  |  5  |  0  |  7  |  0  |  0  |   
________________________________________________________________
0  |  0  |  7  |  0  |  0  |  0  |  3  |  7  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________


 ********************************************************LIST OF CITIES*************************************************************

--------------------------------------------------------------------------------------------------------------------------------------
1).| Solapur | 2).| Sangli | 3).| Parbhani | 4).| Nanded | 5).| Buldhana | 6).| Nagpur | 7).| Pune | 8).| Ratnagiri | 9).| Ahmadnagar |
--------------------------------------------------------------------------------------------------------------------------------------

Enter which city you want as your starting location/point:
(Enter number of that city)
1
Enter destination:5
Source City ----> Solapur

Destination ---->Nagpur

DISPLAYING TIME TAKEN TO TRAVEL FROM SOURCE CITY TO DESTINATION

_______________________________________________________________
Starting city       |       Time taken from Source city
_______________________________________________________________
Solapur                             0
_______________________________________________________________
Sangli                             3
_______________________________________________________________
Parbhani                             11
_______________________________________________________________
Nanded                             12
_______________________________________________________________
Nagpur                             15
_______________________________________________________________


 ****************************************************************SUGGESTIONS OF HOTELS*******************************************************************

 Here are list of some hotels in case you will to take rest  (^^)

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Grand        | price : 4000        | ratings : 3 |

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Amruta        | price : 3000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Milan        | price : 4000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Aishwara        | price : 5000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Sidhant        | price : 4000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Prajesh        | price : 3000        | ratings : 3 |

--------------------------------------------------------------------------------------------------
3). 		*****|     Parbhani     |*****

 | hotel name : Abhinav        | price : 6000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
3). 		*****|     Parbhani     |*****

 | hotel name : Leela        | price : 4000        | ratings : 5 |

--------------------------------------------------------------------------------------------------
4). 		*****|     Nanded     |*****

 | hotel name : Manas        | price : 3000        | ratings : 4 |


--------------------------------------------------------------------------------------------------
5). 		*****|     Nagpur     |*****

 | hotel name : Gaurav        | price : 5000        | ratings : 4 |






 **********************************************************SUGGESTIONS OF PLACES******************************************************************************

HERE IS LIST OF SOME PLACES YOU  MAY LIKE TO VISIT   8-)

| City : Solapur     |      Place name:Sidheshwar_temple   |

----------------------------------------------------------------------------------

| City : Solapur     |      Place name:Animal_Park   |

----------------------------------------------------------------------------------

| City : Solapur     |      Place name:Garden   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:WCE_College   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:DMart   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:open_Garden   |

----------------------------------------------------------------------------------

| City : Parbhani     |      Place name:shiv_Temple   |

----------------------------------------------------------------------------------

| City : Parbhani     |      Place name:friends_Garden   |

----------------------------------------------------------------------------------

| City : Nanded     |      Place name:palace   |

----------------------------------------------------------------------------------

| City : Nanded     |      Place name:Masjit   |

----------------------------------------------------------------------------------

| City : Nagpur     |      Place name:fashion_street   |

----------------------------------------------------------------------------------

| City : Nagpur     |      Place name:Vnit_campus   |

----------------------------------------------------------------------------------

Hope you enjpoy your trip  :)


Do you want to continue?
If yes press 1 else press 0
1
You are being redirected to menu page...................
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1) < Shortest distance between two cities >

2) < See available buses for a city >

Enter your choice:
1

 *************************************************************************************************************************************

Cities:
[Solapur, Sangli, Parbhani, Nanded, Nagpur, Buldhana, Pune, Ratnagiri, Ahmadnagar, null, null, null]


Matrix form:
________________________________________________________________
0  |  3  |  0  |  0  |  0  |  0  |  0  |  8  |  0  |  0  |  0  |   
________________________________________________________________
3  |  0  |  8  |  9  |  0  |  0  |  0  |  7  |  0  |  0  |  0  |   
________________________________________________________________
0  |  8  |  0  |  2  |  4  |  0  |  0  |  0  |  7  |  0  |  0  |   
________________________________________________________________
0  |  9  |  2  |  0  |  7  |  5  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  4  |  7  |  0  |  7  |  9  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  5  |  7  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  9  |  0  |  0  |  5  |  3  |  0  |  0  |   
________________________________________________________________
8  |  7  |  0  |  0  |  0  |  0  |  5  |  0  |  7  |  0  |  0  |   
________________________________________________________________
0  |  0  |  7  |  0  |  0  |  0  |  3  |  7  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________


 ********************************************************LIST OF CITIES*************************************************************

--------------------------------------------------------------------------------------------------------------------------------------
1).| Solapur | 2).| Sangli | 3).| Parbhani | 4).| Nanded | 5).| Buldhana | 6).| Nagpur | 7).| Pune | 8).| Ratnagiri | 9).| Ahmadnagar |
--------------------------------------------------------------------------------------------------------------------------------------

Enter which city you want as your starting location/point:
(Enter number of that city)
1
Enter destination:9
Source City ----> Solapur

Destination ---->Ahmadnagar

DISPLAYING TIME TAKEN TO TRAVEL FROM SOURCE CITY TO DESTINATION

_______________________________________________________________
Starting city       |       Time taken from Source city
_______________________________________________________________
Solapur                             0
_______________________________________________________________
Sangli                             3
_______________________________________________________________
Parbhani                             11
_______________________________________________________________
Nanded                             12
_______________________________________________________________
Nagpur                             15
_______________________________________________________________
Buldhana                             17
_______________________________________________________________
Pune                             13
_______________________________________________________________
Ratnagiri                             8
_______________________________________________________________
Ahmadnagar                             15
_______________________________________________________________


 ****************************************************************SUGGESTIONS OF HOTELS*******************************************************************

 Here are list of some hotels in case you will to take rest  (^^)

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Grand        | price : 4000        | ratings : 3 |

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Amruta        | price : 3000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Milan        | price : 4000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Aishwara        | price : 5000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Sidhant        | price : 4000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Prajesh        | price : 3000        | ratings : 3 |

--------------------------------------------------------------------------------------------------
3). 		*****|     Parbhani     |*****

 | hotel name : Abhinav        | price : 6000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
3). 		*****|     Parbhani     |*****

 | hotel name : Leela        | price : 4000        | ratings : 5 |

--------------------------------------------------------------------------------------------------
4). 		*****|     Nanded     |*****

 | hotel name : Manas        | price : 3000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
6). 		*****|     Buldhana     |*****

 | hotel name : Indra        | price : 4000        | ratings : 5 |

--------------------------------------------------------------------------------------------------
5). 		*****|     Nagpur     |*****

 | hotel name : Gaurav        | price : 5000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
7). 		*****|     Pune     |*****

 | hotel name : Sarang        | price : 6000        | ratings : 5 |

--------------------------------------------------------------------------------------------------
8). 		*****|     Ratnagiri     |*****

 | hotel name : Royal        | price : 5000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
9). 		*****|     Ahmadnagar     |*****

 | hotel name : Payal        | price : 3000        | ratings : 5 |



 **********************************************************SUGGESTIONS OF PLACES******************************************************************************

HERE IS LIST OF SOME PLACES YOU  MAY LIKE TO VISIT   8-)

| City : Solapur     |      Place name:Sidheshwar_temple   |

----------------------------------------------------------------------------------

| City : Solapur     |      Place name:Animal_Park   |

----------------------------------------------------------------------------------

| City : Solapur     |      Place name:Garden   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:WCE_College   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:DMart   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:open_Garden   |

----------------------------------------------------------------------------------

| City : Parbhani     |      Place name:shiv_Temple   |

----------------------------------------------------------------------------------

| City : Parbhani     |      Place name:friends_Garden   |

----------------------------------------------------------------------------------

| City : Nanded     |      Place name:palace   |

----------------------------------------------------------------------------------

| City : Nanded     |      Place name:Masjit   |

----------------------------------------------------------------------------------

| City : Buldhana     |      Place name:laxmi_market   |

----------------------------------------------------------------------------------

| City : Buldhana     |      Place name:gandhi_meuseum   |

----------------------------------------------------------------------------------

| City : Nagpur     |      Place name:fashion_street   |

----------------------------------------------------------------------------------

| City : Nagpur     |      Place name:Vnit_campus   |

----------------------------------------------------------------------------------

| City : Pune     |      Place name:Fc_road   |

----------------------------------------------------------------------------------

| City : Pune     |      Place name:shaniwarwada   |

----------------------------------------------------------------------------------

| City : Ratnagiri     |      Place name:raj_farms   |

----------------------------------------------------------------------------------

| City : Ratnagiri     |      Place name:fort   |

----------------------------------------------------------------------------------

| City : Ahmadnagar     |      Place name:Hello!_shoppingMall   |

----------------------------------------------------------------------------------

| City : Ahmadnagar     |      Place name:sagar_foodCourt   |

----------------------------------------------------------------------------------

Hope you enjpoy your trip  :)


Do you want to continue?
If yes press 1 else press 0
1
You are being redirected to menu page...................
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1) < Shortest distance between two cities >

2) < See available buses for a city >

Enter your choice:
1

 *************************************************************************************************************************************

Cities:
[Solapur, Sangli, Parbhani, Nanded, Nagpur, Buldhana, Pune, Ratnagiri, Ahmadnagar, null, null, null]


Matrix form:
________________________________________________________________
0  |  3  |  0  |  0  |  0  |  0  |  0  |  8  |  0  |  0  |  0  |   
________________________________________________________________
3  |  0  |  8  |  9  |  0  |  0  |  0  |  7  |  0  |  0  |  0  |   
________________________________________________________________
0  |  8  |  0  |  2  |  4  |  0  |  0  |  0  |  7  |  0  |  0  |   
________________________________________________________________
0  |  9  |  2  |  0  |  7  |  5  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  4  |  7  |  0  |  7  |  9  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  5  |  7  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  9  |  0  |  0  |  5  |  3  |  0  |  0  |   
________________________________________________________________
8  |  7  |  0  |  0  |  0  |  0  |  5  |  0  |  7  |  0  |  0  |   
________________________________________________________________
0  |  0  |  7  |  0  |  0  |  0  |  3  |  7  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________
0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |  0  |   
________________________________________________________________


 ********************************************************LIST OF CITIES*************************************************************

--------------------------------------------------------------------------------------------------------------------------------------
1).| Solapur | 2).| Sangli | 3).| Parbhani | 4).| Nanded | 5).| Buldhana | 6).| Nagpur | 7).| Pune | 8).| Ratnagiri | 9).| Ahmadnagar |
--------------------------------------------------------------------------------------------------------------------------------------

Enter which city you want as your starting location/point:
(Enter number of that city)
1
Enter destination:4
Source City ----> Solapur

Destination ---->Nanded

DISPLAYING TIME TAKEN TO TRAVEL FROM SOURCE CITY TO DESTINATION

_______________________________________________________________
Starting city       |       Time taken from Source city
_______________________________________________________________
Solapur                             0
_______________________________________________________________
Sangli                             3
_______________________________________________________________
Parbhani                             11
_______________________________________________________________
Nanded                             12
_______________________________________________________________


 ****************************************************************SUGGESTIONS OF HOTELS*******************************************************************

 Here are list of some hotels in case you will to take rest  (^^)

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Grand        | price : 4000        | ratings : 3 |

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Amruta        | price : 3000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
1). 		*****|     Solapur     |*****

 | hotel name : Milan        | price : 4000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Aishwara        | price : 5000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Sidhant        | price : 4000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
2). 		*****|     Sangli     |*****

 | hotel name : Prajesh        | price : 3000        | ratings : 3 |

--------------------------------------------------------------------------------------------------
3). 		*****|     Parbhani     |*****

 | hotel name : Abhinav        | price : 6000        | ratings : 4 |

--------------------------------------------------------------------------------------------------
3). 		*****|     Parbhani     |*****

 | hotel name : Leela        | price : 4000        | ratings : 5 |

--------------------------------------------------------------------------------------------------
4). 		*****|     Nanded     |*****

 | hotel name : Manas        | price : 3000        | ratings : 4 |








 **********************************************************SUGGESTIONS OF PLACES******************************************************************************

HERE IS LIST OF SOME PLACES YOU  MAY LIKE TO VISIT   8-)

| City : Solapur     |      Place name:Sidheshwar_temple   |

----------------------------------------------------------------------------------

| City : Solapur     |      Place name:Animal_Park   |

----------------------------------------------------------------------------------

| City : Solapur     |      Place name:Garden   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:WCE_College   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:DMart   |

----------------------------------------------------------------------------------

| City : Sangli     |      Place name:open_Garden   |

----------------------------------------------------------------------------------

| City : Parbhani     |      Place name:shiv_Temple   |

----------------------------------------------------------------------------------

| City : Parbhani     |      Place name:friends_Garden   |

----------------------------------------------------------------------------------

| City : Nanded     |      Place name:palace   |

----------------------------------------------------------------------------------

| City : Nanded     |      Place name:Masjit   |

----------------------------------------------------------------------------------

Hope you enjpoy your trip  :)


Do you want to continue?
If yes press 1 else press 0
1
You are being redirected to menu page...................
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1) < Shortest distance between two cities >

2) < See available buses for a city >

Enter your choice:
2
Enter start point:
4


_____________________________________________________________________________________________________________________


 ------------             --------------
|   Nanded   |   ---->    |  Buldhana  |
 ------------             --------------


Bus name:Yuga|      Price:4000|       Ratings:3

_____________________________________________________________________________________________________________________


 ------------             --------------
|   Nanded  |   ---->    |   Nagpur   |
 ------------             --------------


Bus name:LNT|      Price:3500|       Ratings:5

Do you want to continue?
If yes press 1 else press 0
1
You are being redirected to menu page...................
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1) < Shortest distance between two cities >

2) < See available buses for a city >

Enter your choice:
2
Enter start point:
2


_____________________________________________________________________________________________________________________


 ------------            --------------
|   Sangli   |   ---->  |   Parbhani   |
 ------------            --------------


Bus name:Neeta|      Price:2000|       Ratings:3

_____________________________________________________________________________________________________________________


 ------------             --------------
|   Sangli   |   ---->   |     Nanded   |
 ------------             --------------


Bus name:Purple|      Price:3000|       Ratings:4

Do you want to continue?
If yes press 1 else press 0
0
 ************************************************THANYOU! VISIT AGAIN!!*****************************************************************
 */
