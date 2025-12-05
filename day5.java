import java.util.*;
import java.io.*;
class interval  implements Comparable<interval>{
  public long s;
  public long e;
  public interval(long s, long e){
    this.s = s;
    this.e = e;
  }
  public boolean ischill(long toCheck){
    return this.s <= toCheck && toCheck <= this.e;
  }

  public int compareTo(interval b) {
      if(this.s - b.s > 0){
        return 1;
      }else if(this.s == b.s){
        return 0;
      }else{
        return -1;
      }
  }

}


public class day5{

  public static void main(String[] args)
    throws IOException{
      BufferedReader in  = new BufferedReader(new FileReader("day5.txt"));
      int N = 177;
      ArrayList<interval> intervals = new ArrayList<interval>();
      for(int i = 0; i < N; i++ ){
        String[] line = in.readLine().split("-");
        // System.out.println(Arrays.toString(line));
        intervals.add(new interval(Long.parseLong(line[0]), Long.parseLong(line[1])));
      }

      Collections.sort(intervals);

      long total = 0;
      long lastEnded = 0;
      for(int i = 0; i < intervals.size(); i++ ){
          interval curr = intervals.get(i);
          if(curr.s <= lastEnded){
            curr.s = lastEnded + 1;
          }
          total += curr.e - curr.s + 1;
          lastEnded = curr.e;

        }




      System.out.println(total);
    }
}
