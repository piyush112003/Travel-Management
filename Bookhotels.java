//package miniProjects;
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

		br = new BufferedReader(new FileReader("P:\\travel management\\places.unknown"));


		System.out.println("\n\n**********************************************************SUGGESTIONS OF PLACES******************************************************************************");
		System.out.println(" \nHERE IS LIST OF SOME PLACES YOU  MAY LIKE TO VISIT   8-)");
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
				System.out.print("\n| City : "+curr.City+"     |     ");
				System.out.print(" Place name:"+curr.place+"  |\n");
				System.out.println("\n----------------------------------------------------------------------------------");

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
		br = new BufferedReader(new FileReader("P:\\travel management\\bus.unknown"));
		//index =index of city array
		//row=index of row
		//column=index of column
		boolean flag=false;
		input ob=new input();
		System.out.println("Enter start point:");
		int start=sc.nextInt();
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
				System.out.println("\n\n_____________________________________________________________________________________________________________________");

				System.out.println("\n\n ------------             --------------");
				System.out.println("|   "+w[0]+"   |   ---->  |      "+w[1]+"     |");
				System.out.println(" ------------             --------------");
				System.out.print("\n\nBus name:"+w[2]);
				System.out.print("|      Price:"+w[3]);
				System.out.print("|       Ratings:"+w[4]);

			}
		}
	}


	int displaymenu() {
		System.out.println("\n\n********************************************************LIST OF CITIES*************************************************************\n");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("1).| Solapur | 2).| Sangli | 3).| Parbhani | 4).| Nanded | 5).| Buldhana | 6).| Nagpur | 7).| Pune | 8).| Ratnagiri | 9).| Ahmadnagar |");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n");

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
			br = new BufferedReader(new FileReader("P:\\travel management\\time.unknown"));
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
			System.out.println("\n*************************************************************************************************************************************");
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
		System.out.println("Source City ----> "+city[point]);
		System.out.println("\nDestination ---->"+city[dest]);
		System.out.println("\nDISPLAYING TIME TAKEN TO TRAVEL FROM SOURCE CITY TO DESTINATION");
		System.out.println("\n_______________________________________________________________");
		System.out.println("Starting city       |       Time taken from Source city");
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
		br = new BufferedReader(new FileReader("P:\\travel management\\Hotel.unknown"));
		//index =index of city array
		//row=index of row
		//column=index of column
		int index=0,row=0,column=0;
		int k=0,last=0;
		String[] city= new String[12];
		boolean flag=false;
		int graph[][] = new int[12][12];
		System.out.println("\n\n****************************************************************SUGGESTIONS OF HOTELS*******************************************************************\n");
		System.out.println(" Here are list of some hotels in case you will to take rest  (^^)");
		System.out.println();
		while((line=br.readLine())!=null)
		{

			String w[]=line.split(" ");


			k=point;

			last=dest;



			for(int a=k;a<=last;a++) {

				if(city1[a].equals(w[0])) {

					System.out.println("--------------------------------------------------------------------------------------------------");

					System.out.println((a+1)+"). \t\t*****|     "+w[0]+"     |*****\n");
					System.out.println(" | hotel name : "+w[1]+"        | price : "+w[2]+"        | ratings : "+w[3]+" |");
					//System.out.println("--------------------------------------------------------------------------------------------------");



				}


			}
			System.out.println();


		}

		list y=new list();
		y.places1(k,last,city1);
		System.out.println("Hope you enjpoy your trip  :)");

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

		// Distance of source vertex from itself is always 0
		dist[point] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// minimum distance vertex from the set of vertices is selected
			// not yet processed. u is always equal to point in first iteration.
			int u = minDistance(dist, visited);

			// Mark the picked vertex as visited
			visited[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < V; v++)

				// Update dist[v] only if is not in dist, there is an edge from u to v, and total weight of path from point to
				// v through u is smaller than current value of dist[v]
				if (!visited[v] && graph[u][v] != 0 &&  dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist, V, city,point, dest);
	}
}

public class BookHotels{
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
				System.out.println("You are being redirected to menu page...................");
			}
			else {
				System.out.println("************************************************THANYOU! VISIT AGAIN!!*****************************************************************");
			}
		}while(ans!=0);

	}

}
