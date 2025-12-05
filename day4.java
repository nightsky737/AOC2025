import java.util.*;
import java.io.*;


public class day4{
  public static void checkedIncrement(int[][] numadj, int i, int j){
    if( 0 <= i && i < numadj.length && 0 <= j && j < numadj.length){
      numadj[i][j] ++;
    }
  }

  public static void checkedDecrement(int[][] numadj, int i, int j){
  if( 0 <= i && i < numadj.length && 0 <= j && j < numadj.length){

    numadj[i][j] --;
  }
  
  }
  public static void remove(int[][] numadj, boolean[][] towels, int i, int j){
    for(int ioff = -1; ioff <= 1; ioff++){
              for(int joff = -1; joff <= 1; joff++){
                if(ioff == 0 && joff == 0){
                  continue;
                }
                checkedDecrement(numadj, i + ioff, j+ joff);
              }
    towels[i][j] = false;
  }}
  public static void main(String[] args)
    throws IOException{
      BufferedReader in  = new BufferedReader(new FileReader("day4.txt"));
      int N = 140;
      boolean[][] towels = new boolean[N][N]; //0 is unoccupied
      int[][] numadj = new int[N][N]; //0 is unoccupied

      for(int i = 0; i < N; i++ ){
        String line = in.readLine();
        for(int j = 0; j < N; j++){
          if (line.charAt(j) == '@'){
            towels[i][j] = true;
            for(int ioff = -1; ioff <= 1; ioff++){
              for(int joff = -1; joff <= 1; joff++){
                if(ioff == 0 && joff == 0){
                  continue;
                }
                checkedIncrement(numadj, i + ioff, j+ joff);
              }
            }
          }
        }
      }


      int total = 0;

      boolean found = true;
      while(found){
        found = false;
        for(int i = 0; i < N; i++){
          for(int j = 0; j < N; j++){
      
            if(numadj[i][j] < 4 && towels[i][j]){
              total++;
              remove(numadj, towels, i, j);
              found = true;
            }

          }
        }
 
      }


    System.out.println(total);

    }



}
