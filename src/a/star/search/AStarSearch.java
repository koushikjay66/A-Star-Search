/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star.search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Koushik
 */
public class AStarSearch {

    /**
     * @param args the command line arguments
     */
    
     static int number_of_cities;
    static int number_of_roads;
    static String start;
    static String end;
    static int broken_road_count;
    static String broken_roads="";
    static String city_list[];
    static int graph_matrix[][];
    static boolean visited[];
    static int tuni[];
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
                fileReader();
//            for (int i = 0; i < city_list.length; i++) {
//                System.out.print(city_list[i]+"->"+i+" , ");
//            }
//            System.out.println();
//            
//            for (int i = 0; i < graph_matrix.length; i++) {
//                for (int j = 0; j < graph_matrix.length; j++) {
//                    if(graph_matrix[i][j]!=0){
//                    System.out.println(city_list[i]+","+city_list[j]+","+graph_matrix[i][j]);
//                    }
//                    
//                }
//                System.out.println();
//        }
    }
    
    
    
   public static void fileReader() throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
        
        String line=br.readLine();
        String temp[]=line.split(",");
        number_of_cities=Integer.parseInt(temp[0]);
        number_of_roads=Integer.parseInt(temp[1]);
        city_list=new String[number_of_cities];
        tuni=new int[number_of_cities];
        System.out.println(city_list.length+" "+tuni.length);
        visited=new boolean[number_of_cities];
        graph_matrix=new int[number_of_cities][number_of_cities];
        
        start=br.readLine();
        end=br.readLine();

        int count=0;

        for (int i = 0; i <number_of_roads; i++) {
            String temp2=br.readLine();
            String roads[]=temp2.split(",");
            
            int row=count;
           int r=search(city_list, roads[0]);
           if(r==-1){
               city_list[count]=roads[0];
               count++;
           }else{
               row=r;
           }
           int col=count;
           r=search(city_list, roads[1]);
           if(r==-1){
               city_list[count]=roads[1];
               count++;
           }else{
               col=r;
           }
            
           
            graph_matrix[row][col]=graph_matrix[col][row]=Integer.parseInt(roads[2]);
            
            
            
        }
       
        for (int i = 0; i <number_of_cities; i++) {
           // System.out.println(br.readLine());
            String temp2[]=br.readLine().split(",");
            int index=search(city_list, temp2[0]);
            if(index==-1){
                System.err.println("Tuni is bulala");
            }else{
                tuni[index]=Integer.parseInt(temp2[1]);
            }
       }
        
        
    }// End of read File Method
    public static int search(String []arr, String val){
        //System.out.println(val);
        for (int i = 0; i < arr.length; i++) {
            
           if(arr[i]!=null){
                if( arr[i].equalsIgnoreCase(val)){
                   
                return i;     
            }
           }
        }
        return -1;
    }// End of function search
    
}
