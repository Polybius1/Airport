class PrintSystem {
//public static void main (String[] args){
//Airport.readAirports();
//Flight.readFlights();
  public static void printSys(){
  for ( int i = 0; i< Airport.GTAairports.size(); i++){
    System.out.println(Airport.GTAairports.get(i));
    for (int j=0; j<Flight.GTAflights.size(); j++){
      if (Airport.GTAairports.get(i).name.equals(Flight.GTAflights.get(j).from)){
        System.out.println(Flight.GTAflights.get(j));
      }
      
    }
    System.out.println("");
  }
  
}
}


