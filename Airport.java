import java.util.*;
import java.io.*;

class Airport{
  
  //class attributes
  String name;
  String city;
  float latitude;
  float longitude;
  float nudgeLat; //the latitude and longitude amounts to nudge airport names for map readability 
  float nudgeLon;
  int delay ;
  
  //arraylist of airport objects
  static ArrayList <Airport> GTAairports = new ArrayList <Airport>();
    
  public Airport(String n, float lat, float longi, int del, String c) {
    
    name = n;
    city = c;
    latitude = lat;
    longitude = longi;
    delay = del;
    ArrayList <Flight> flights = new ArrayList <Flight>();
    
    GTAairports.add(this); //adds the airport object to the arraylist when it is created
    
    
  }
  
   
  
  static public void readAirports()  { 
    
    String fileName;
    //Scanner nameReader = new Scanner(System.in);
    fileName = "Airports.csv";
    try{
      Scanner scan = new Scanner(new FileReader(fileName));
      
      StringTokenizer st; 
      
      String name = " ";
      String city = " ";
      float latitude = 0.0f;
      float longitude = 0.0f;
      int delay = 0;
      //flight ?
      
      scan.nextLine(); //skip the first line
      while(scan.hasNext()) {
        st = new StringTokenizer(scan.next(), "\t\n\r\f,?!;: ");
        name = st.nextToken();
        st = new StringTokenizer(scan.next(), "\t\n\r\f,?!;: ");
        latitude = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(scan.next(), "\t\n\r\f,?!;: ");
        longitude = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(scan.next(), "\t\n\r\f,?!;: ");
        delay = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(scan.next(), "\t\n\r\f,?!;:");
        city = st.nextToken();
        //city += st.nextToken();
        new Airport(name, latitude, longitude, delay, city);
        scan.nextLine();
      }
      scan.close();
    }catch(Exception ex){
      ex.printStackTrace();
    }
    
    
  }
     
  
  static public void nudgeAirports(){  //initialize the nudges
   for (Airport apt: GTAairports){ 
   apt.nudge(0,0);
     if(apt.name.equals("HNL"))
     apt.nudge(5,10);
     
     if(apt.name.equals("ANC"))
     apt.nudge(5,-10);
     
     if(apt.name.equals("FAI"))
     apt.nudge(5,-10);
     
     if(apt.name.equals("VUO"))
       apt.nudge(-5,0);
       
     if(apt.name.equals("SFO"))
       apt.nudge(-2,0); 
       
     if(apt.name.equals("PDX"))
       apt.nudge(-2,0); 
     
     if(apt.name.equals("ABQ"))
       apt.nudge(-2,0);
       
     if(apt.name.equals("SFW"))
       apt.nudge(0,-1);
       
     if(apt.name.equals("EWR"))
       apt.nudge(-2, 0);
     }
}

   private void nudge(float x, float y) { //execute the nudges
   nudgeLon = x;                          //nudges are the amount of lat,lon to push an airport name over 
   nudgeLat = y;                          //on the map for readability 
   } 
   
   //wouldn't want to steal the change from anyone's pockets...
   public float getLongitude() {
   return longitude;
   }
   
   public float getLatitude() {
     return latitude;
   }
   
   public float getnudgeLon() {
     return nudgeLon;
   }
   
   public float getnudgeLat() {
     return nudgeLat;
   }
   
   
  
  static public void printAirports(){
      
      System.out.println(GTAairports);
  
  }
  
  public String toString(){
    return name + " " + city;
  }
}  


