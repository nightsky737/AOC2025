import java.util.*;
import java.io.*;


class link  implements Comparable<link>{
  public int j1idx;
  public int j2idx;
  public double dis;

  public link(double dis, int j1idx, int j2idx ){
    this.j1idx = j1idx;
    this.j2idx = j2idx;
    this.dis = dis;

  }




  public int compareTo(link b) {
      if(this.dis - b.dis > 0){
        return 1;
      }else if(this.dis == b.dis){
        return 0;
      }else{
        return -1;
      }
  }

}





public class day9{

   public static int dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int curr, int[] numConnected, int toSet ){
    int size = 1;
    numConnected[curr] = toSet;
    if( !visited[curr]){
      visited[curr] = true;
      for( int next : adj.get(curr)){
        size += dfs(adj, visited, next, numConnected, toSet);
      }
      return size;

    }else{
      return 0;
    }
  }

  public static double compute_distance(long[] a , long[] b){
      return Math.sqrt(Math.pow(a[0] - b[0], 2 ) + Math.pow(a[1] - b[1], 2 ) + Math.pow(a[2] - b[2], 2 ) );
  }

  public static void main(String[] args)
    throws IOException{
      BufferedReader in  = new BufferedReader(new FileReader("day9.txt"));
      int N = 8;
      boolean[] visited = new boolean[N];


      ArrayList<long[]> coords = new ArrayList<long[]>();

      for(int i = 0; i < N; i++ ){
        String[] line = in.readLine().split(",");
        long[] coord = new long[2];
        coord[0] = Long.parseLong(line[0]);
        coord[1] = Long.parseLong(line[1]);

        coords.add(coord);
      }

      long maxArea = 0;
      for(int i = 0; i < N; i++){
        for(int j = i + 1 ; j < N; j++){
          long area =( Math.abs(coords.get(i)[0] -  coords.get(j)[0]) + 1) * (Math.abs(coords.get(i)[1] -  coords.get(j)[1])  +1);
          maxArea = Math.max(area, maxArea);
        }
      }

      System.out.println(maxArea);
    }
}
