class GTAdriver{
  
  public static void main(String[] args) 
  {
    Airport.readAirports();
    Flight.readFlights();
    //PrintSystem.printSys(); //comment this out for Airmap test
    Airport.nudgeAirports(); //nudge the airports to adjust their lat and lon for map readability 
    AirMap.showMap();
        
  }
}


