
// DFS Solution
public class NumberOfIslandsDFS {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                  count++;
                  dfs(grid,i,j,m,n);   
                }
            }
        }
        return count;
    }
        
        private void dfs(char[][] grid, int i,int j,int m, int n){
            if(i<0 || i==m || j<0|| j==n|| grid[i][j]=='0') return;
            
            //logic
            grid[i][j]='0';
            for(int[] dir:dirs){
                int nr = i+dir[0];
                int nc = j+dir[1];
                dfs(grid,nr,nc,m,n);
            }
        }
}

// Time Complexity - O(m*n)
// Space Complexity - O(min(m,n))

public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int count = 0;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    rq.add(i);
                    cq.add(j);
                    
                    while(!rq.isEmpty()){
                        int cr = rq.poll();
                        int cc = cq.poll();
                        
                        for(int[] dir:dirs){
                            int nr = dir[0]+cr;
                            int nc = dir[1]+cc;
                            
                            // bounds check
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                                rq.add(nr);
                                cq.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                        
                    }
                }
            }
            
        }
        return count;
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(min(m,n))