
/**
 * Who wrote this anyway and what does it do?
 */

import java.awt.*;
import javax.swing.*;


public class AirMap extends JPanel{ 

static double windowHeight = 600;//these values are now
static double windowWidth = 600; //adjusted by screen height and screen width
static int minLong = -160;
static int minLat = 20;
static int maxLat = 66;
static int longSpread = 90;
static int latSpread = 46;



  public static void showMap(){
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    windowWidth = screenSize.getWidth();
    windowHeight = screenSize.getHeight();
    
    JFrame frame = new JFrame("flight map");
    AirMap map = new AirMap();
    map.setPreferredSize(new Dimension((int)windowWidth,(int)windowHeight));
    frame.getContentPane().add(map);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    frame.pack();
    frame.setVisible(true);
    
      }
  
  public void paintComponent(Graphics gr){
    super.paintComponent(gr);
   
    for(int i = 0; i < Airport.GTAairports.size(); i++) {
      System.out.println(Airport.GTAairports.get(i).name + " x= " + xcoord((int)Airport.GTAairports.get(i).getLongitude() + Airport.GTAairports.get(i).getnudgeLon()) + " y= " + ycoord((int)Airport.GTAairports.get(i).getLatitude() + Airport.GTAairports.get(i).getnudgeLat()));
      gr.drawString(Airport.GTAairports.get(i).name, xcoord(Airport.GTAairports.get(i).getLongitude() + Airport.GTAairports.get(i).getnudgeLon()), ycoord((int)Airport.GTAairports.get(i).getLatitude() + Airport.GTAairports.get(i).getnudgeLat()));
      }
  }
  
  private int xcoord(float longitude) {
   return (int) (((longitude - minLong)/longSpread) * windowWidth); //return the longitude to pixel x coord
   }
   
   private int ycoord(float latitude) {
      return (int) (((maxLat - latitude)/latSpread) * windowHeight); //return the latitude to pixel y coord
      }
  
}
