import java.util.*;
import java.io.*;


public class day3{

  public static void main(String[] args)
    throws IOException{
      BufferedReader in  = new BufferedReader(new FileReader("day3.txt"));
      int N = 200;
      ArrayList<String> numbers = new ArrayList<String>();
      for(int i = 0; i < N; i++ ){
        String line = in.readLine();
        numbers.add(line);
      }
      long total = 0;
      for (String num : numbers){

        int firstLargest = -1;
        int firstIdx = 0;
        for(int i = 0; i < num.length() - 1; i++){
          if( Integer.parseInt( num.substring(i, i+ 1)) > firstLargest){
            firstLargest = Integer.parseInt( num.substring(i, i+ 1));
            firstIdx = i;
          }
        }
        int secondLargest = -1;
        for(int i = firstIdx + 1; i < num.length(); i++){
          if( Integer.parseInt( num.substring(i, i+ 1)) > secondLargest){
            secondLargest = Integer.parseInt( num.substring(i, i+ 1));
          }
        }

        System.out.println(firstLargest);
        System.out.println(secondLargest);

        total += (long) ( 10 * firstLargest + secondLargest);
      }
      System.out.println(total);
    }



}
