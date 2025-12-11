import java.util.*;
import java.io.*;





public class day10{



  public static double compute_distance(long[] a , long[] b){
      return Math.sqrt(Math.pow(a[0] - b[0], 2 ) + Math.pow(a[1] - b[1], 2 ) + Math.pow(a[2] - b[2], 2 ) );
  }

  public static int readLine(String line){
    String[] parts = line.split(" ");
    ArrayList<ArrayList<Integer>> buttons = new ArrayList<ArrayList<Integer>>();

    buttons.add(new ArrayList<Integer>());

    for(int i = 1; i < parts.length - 1; i++){
      buttons.add(new ArrayList<Integer>());
      String[] buttonparts = parts[i].split(",");
      if(buttonparts.length  == 1){
        buttons.get(i - 1).add(Integer.parseInt(buttonparts[buttonparts.length - 1].substring(1,buttonparts[buttonparts.length - 1].length() -1)));
      }else{

      for(int j = 0; j < buttonparts.length ; j++){
        if( j ==  0){
          buttons.get(i - 1).add(Integer.parseInt(buttonparts[0].substring(1)));
        }else if (j ==  buttonparts.length - 1){
        buttons.get(i -1).add(Integer.parseInt(buttonparts[buttonparts.length -1].substring(0,buttonparts[buttonparts.length -1 ].length() -1)));

        }
        else {
          buttons.get(i - 1).add(Integer.parseInt(buttonparts[j]));

        }
      }}
      System.out.println(buttons.get(i - 1));
    }

    String[] goal_str = parts[0].split("");
    boolean[] goal = new boolean[goal_str.length -2];
    boolean[] curr = new boolean[goal_str.length -2];

    for(int i = 1; i < goal_str.length -1; i++){
      if(goal_str[i].equals("#")){
        goal[i - 1] = true;
      }
    }
    System.out.println("g"  +Arrays.toString(goal));
    return compute(buttons, 0, 0, goal, curr);

  }

  public static int compute(ArrayList<ArrayList<Integer>> buttons, int idx, int total, boolean[] goal, boolean[] curr ){
    // System.out.println(Arrays.toString(curr));
    //base cases:
    if(idx == buttons.size()){
      return Integer.MAX_VALUE;
    }
    if(Arrays.equals(curr, goal)){
      return total;
    }

    //u dont press button at idx
    int dontPush = compute(buttons, idx + 1, total, goal, curr);

    //u press button at idx
    for(int button : buttons.get(idx)){
      curr[button] = !curr[button];
    }
    int push =  compute(buttons, idx + 1, total + 1, goal, curr);

    return Math.min(push, dontPush);
  }


  public static void main(String[] args)
    throws IOException{
      BufferedReader in  = new BufferedReader(new FileReader("day10.txt"));
      int N = 3;
      boolean[] visited = new boolean[N];


      ArrayList<long[]> coords = new ArrayList<long[]>();
      int total = 0;
      for(int i = 0; i < N; i++ ){
        total += readLine(in.readLine());
        System.out.println(total);
      //
      // long maxArea = 0;
      // for(int i = 0; i < N; i++){
      //   for(int j = i + 1 ; j < N; j++){
      //     long area =( Math.abs(coords.get(i)[0] -  coords.get(j)[0]) + 1) * (Math.abs(coords.get(i)[1] -  coords.get(j)[1])  +1);
      //     maxArea = Math.max(area, maxArea);
      //   }
      // }
      //
      // System.out.println(maxArea);
    }
}
}
