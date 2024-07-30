class Solution {
  public int solution(int n, int m, int[] section) {

    boolean[] wall = new boolean[n + 1];
    int roller = 0;

    for (int s : section) {
      wall[s] = true;
    }

    for (int i = 1; i <= n; i++) {
      if (wall[i]) {
        roller++;
        i += m - 1;
      }
    }
    return roller;
  }
}
    
