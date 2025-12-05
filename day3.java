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
        int startidx = 0;

        String finalthing = "";
        for(int digitNum = 12; digitNum > 0; digitNum--){
          int firstLargest = -1;
          System.out.println("reset starting from" + startidx);
          for(int i = startidx; i < num.length() - digitNum + 1; i++){

            if( Integer.parseInt( num.substring(i, i+ 1)) > firstLargest){
              firstLargest = Integer.parseInt( num.substring(i, i+ 1));
              startidx = i + 1;

            }
          }
        finalthing += firstLargest;
        total += (long) ( Math.pow(10, digitNum - 1) * firstLargest);

        }
        
        System.out.println(finalthing);


      }
      System.out.println(total);
    }



}
