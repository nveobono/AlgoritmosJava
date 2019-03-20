/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author nveob
 */
public class Skyline {

    /**
     * @param args the command line arguments
     */    
    public static class Building {
        final public int left;
        final public int right;
        final public int height;
	
        public Building(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
            if (left <= 0 || right <= 0 || height <= 0 || left >= right) {
                throw new IllegalArgumentException ("Invalid building parameters: " + left  + "," + right + "," + height);
            }
        }  
        @Override
        public String toString () {
            return "[" + left + "," + right + "] @ " + height;
        }
    } 
    
    public static Collection<Building> retrieveInput(InputStream is) {
    ArrayList<Building> buildings = new ArrayList<Building>();
    Scanner sc = new Scanner (is);
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.equals("")) { break; }

      try {
        StringTokenizer st = new StringTokenizer(s);
        int left = Integer.valueOf(st.nextToken());
        int right = Integer.valueOf(st.nextToken());
        int height = Integer.valueOf(st.nextToken());
        
        Building b = new Building (left, right, height);
        buildings.add(b);
      } catch (NumberFormatException nfe) {
        System.err.println(" ** Ignoring " + s + ": all values must be integers.");
      } catch (Exception e) {
        System.err.println(" ** Ignoring " + s + ": " + e.getMessage());
      }
    }
    
    return (buildings);
  }

  public static void main(String[] args) {
    Collection<Building> buildings = retrieveInput(System.in);

    for (Building b : buildings) {
      System.out.println("[" + b.left + "," + b.right + "] @ " + b.height);
    }
  }
}
