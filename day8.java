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





public class day8{

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
      BufferedReader in  = new BufferedReader(new FileReader("day8.txt"));
      int N = 20;
      boolean[] visited = new boolean[N];

      ArrayList<  ArrayList<Integer>> adj = new ArrayList<  ArrayList<Integer>>();
      for(int i = 0; i < N; i++ ){
        adj.add(new ArrayList<Integer>());
      }

      ArrayList<long[]> junctions = new ArrayList<long[]>();

      for(int i = 0; i < N; i++ ){
        String[] line = in.readLine().split(",");
        long[] coords = new long[3];
        coords[0] = Long.parseLong(line[0]);
        coords[1] = Long.parseLong(line[1]);
        coords[2] = Long.parseLong(line[2]);
        junctions.add(coords);
      }

      ArrayList<link> distances = new ArrayList<link>();
      for(int i = 0; i < N; i++){
        for(int j = i + 1; j < N; j++){
          distances.add(new link(compute_distance(junctions.get(i), junctions.get(j)), i, j));
        }
      }

      Collections.sort(distances);
      int[] numConnected = new int[N];

      for(int i = 0; i < N; i++){
        numConnected[i] = 1;
      }

      for(int i = 0; i < 10; i++){
       link curr = distances.get(i);
       System.out.println(Arrays.toString(numConnected));
       System.out.println(curr.j1idx);
       System.out.println(curr.j2idx);

       int newSum = numConnected[curr.j1idx] + numConnected[curr.j2idx];
      visited = new boolean[N];
        if(newSum == N){
          System.out.println(curr.j1idx);
          System.out.println(curr.j2idx);
          break;
        }
       dfs( adj, visited, curr.j1idx, numConnected, newSum );


       adj.get(curr.j1idx).add(curr.j2idx );
       adj.get(curr.j2idx ).add(curr.j1idx );

      }



    }
}
