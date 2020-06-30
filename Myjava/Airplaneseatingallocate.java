package Myjava;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Airplaneseatingallocate {
	    public static final int zeroIndex = 0;
	    public static final int firstIndex = 1;
	    public static final int seatSize = 3;
	    public static final int asileSeat = 0;
	    public static final int windowSeat = 1;
	    public static final int middleSeat = 2;
	    @SuppressWarnings("resource")
		public static void main(String[] args) {
	    
	Scanner Sc=new Scanner(System.in);
	  System.out.println("Enter the total number of Rows");
	   int R=Sc.nextInt();
	  String[] inputArray=new String[R];
	  for(int x=zeroIndex;x<R && Sc.hasNextInt();x++){
	      inputArray[x]=Sc.next();
	      }
	   System.out.println("Enter the total number of Passengers boarding:");   
	        int maxPsg =Sc.nextInt();
	        int counter=1;
	        Map<String,String> seatingMap = new TreeMap<String,String>();
	        int inputArrayLength = inputArray.length;
	        int maxArrayIndex = 0;
	        //the starting array index values are zero index and first index
	       //comparing max of zero index and first index to the repective object created
	        for(int j=zeroIndex;j<inputArrayLength;j++){
	            int seatLocationIndex = Integer.parseInt(""+inputArray[j].charAt(zeroIndex));
	            int locationIndex=Integer.parseInt(""+inputArray[j].charAt(firstIndex));
	            maxArrayIndex = seatLocationIndex > maxArrayIndex ? seatLocationIndex : maxArrayIndex;
	            maxArrayIndex = locationIndex > maxArrayIndex ? locationIndex : maxArrayIndex;
	        }
	        //compare seat size with both index and allocate to the third (k)
	        for(int seatCategory=zeroIndex;seatCategory<seatSize;seatCategory++){    
	            for(int i=zeroIndex;i<maxArrayIndex;i++){
	                for(int j=zeroIndex;j<inputArrayLength;j++){
	                    
	                    int seatLocationIndex = Integer.parseInt(""+inputArray[j].charAt(zeroIndex));
	                    int locationIndex=Integer.parseInt(""+inputArray[j].charAt(firstIndex));
	                    //compare k with i and j and map them with the seat category as they are keys to the value and order them according to keyindex
	                    //The order is aisle followed by window and then any order of center
	                    //name them as a-aisle w-window c-center
	                    for(int k=zeroIndex;k<seatLocationIndex;k++){
	                        
	                        String seatKeyIndex = j+""+i+""+k;
	                        
	                        if(maxPsg+firstIndex != counter && (seatingMap.get(seatKeyIndex)==null) && i<locationIndex) {
	                            
	                            if(seatCategory==asileSeat){
	                                if(j==zeroIndex&&k==seatLocationIndex -firstIndex){
	                                    seatingMap.put(seatKeyIndex,"A-"+counter++);
	                                }
	                                if(j>zeroIndex&&j<inputArrayLength-firstIndex&&(k==zeroIndex||k==seatLocationIndex-firstIndex)){
	                                    seatingMap.put(seatKeyIndex,"A-"+counter++);
	                                }
	                                if(j==inputArrayLength-firstIndex&&k==zeroIndex){
	                                    seatingMap.put(seatKeyIndex,"A-"+counter++);
	                                }    
	                            }
	                            else if(seatCategory==windowSeat){
	                                if(j==zeroIndex&&k==zeroIndex){
	                                    seatingMap.put(seatKeyIndex,"W-"+counter++);
	                                }
	                                if(j==inputArrayLength-firstIndex&&k==seatLocationIndex-firstIndex){
	                                    seatingMap.put(seatKeyIndex,"W-"+counter++);
	                                }
	                            }
	                            else if(seatCategory==middleSeat){
	                                if(k!=zeroIndex&&k!=seatLocationIndex-firstIndex){
	                                    seatingMap.put(seatKeyIndex,"M-"+counter++);
	                                }
	                            }
	                            
	                        }
	                        if(maxPsg+firstIndex == counter) {
	                            break;
	                        }
	                    }    
	                }
	            }    
	        }
	        
	        
	        System.out.println(" Window ");
	        System.out.println(" Middle ");
	        System.out.println(" Aisle ");
	        System.out.println("|");
	        //After mapping the key index to the values set to display the output
	        //map the key index to key data and set the length and space to be allocated in the matrix
	        //print the values according to the print command
	        //each matrix is separated by a line indicating a pathway next of the last number
	        for(int i=zeroIndex;i<maxArrayIndex;i++){
	            for(int j=zeroIndex;j<inputArrayLength;j++){
	                int seatLocationIndex = Integer.parseInt(""+inputArray[j].charAt(zeroIndex));
	                for(int k=zeroIndex;k<seatLocationIndex;k++){
	                    
	                    String seatKeyIndex = j+""+i+""+k;
	                    
	                    if(seatingMap.get(seatKeyIndex) != null) {
	                        String seatKeyData = seatingMap.get(seatKeyIndex);
	                        System.out.print(seatKeyData); 
	                        for(int space=zeroIndex;space<7-seatKeyData.toCharArray().length;space++) {
	                            System.out.print(" ");
	                        }
	                    }
	                    else {
	                        System.out.print("       "); 
	                    }
	                    
	                }
	                if(j<inputArrayLength-1) {
	                    System.out.print("        |        ");                     
	                }
	            }
	            System.out.println();
	        }
	        
	    }
	    
	}
