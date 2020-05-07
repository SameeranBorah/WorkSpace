package Miscellaneous;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.util.Pair;

import javax.swing.table.TableCellEditor;
import java.util.*;

public class RottenOranges {
    public static void main(String[] args) {
        int [][]Arr={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting3(Arr));
    }
//    public static class Oranges{
//        int x;
//        int y;
//        int val;
//        Oranges(int x,int y,int val){
//            this.x=x;
//            this.y=y;
//            this.val=val;
//        }
//    }
    public static int orangesRotting(int[][] grid) {
//        Map<Oranges,Integer> map=new HashMap();
//        Queue<Oranges> queue=new ArrayDeque<>();
        int count_2=0;
        int count_1=0;

        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    count_2++;
                if(grid[i][j]==1)
                    count_1++;
            }
        }
        if(count_1==0) return 0;
//        System.out.println(queue);
        int count=0;
        while(count_2!=0){
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                visited[i][j]=false;
                }
            }
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==2&&!visited[i][j]){
                        grid[i][j]=0;
                        count_2--;
                        visited[i][j]=true;
                        if(i+1<grid.length&&grid[i+1][j]==1)
                        {
                            grid[i+1][j]=2;
                            count_2++;
                            visited[i+1][j]=true;
                        }
                        if(j+1<grid[0].length&&grid[i][j+1]==1){
                            grid[i][j+1]=2;
                            count_2++;
                            visited[i][j+1]=true;
                        }
                        if(i-1>=0&&grid[i-1][j]==1) {
                            grid[i - 1][j] = 2;
                            count_2++;
                            visited[i-1][j]=true;
                        }
                        if(j-1>=0&&grid[i][j-1]==1){
                            grid[i][j-1]=2;
                            count_2++;
                            visited[i][j-1]=true;
                        }

                    }

                }
            }
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    System.out.print(visited[i][j]+" ");
                }
                System.out.println();
            }
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
            count++;
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }

        return count-1;
    }
    public static class Oranges{
        int x;
        int y;
        int val;
        boolean isLast=false;
        Oranges(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
        Oranges(boolean isLast){
            this.isLast=isLast;
        }
    }
    public static int orangesRotting3(int[][] grid) {
        Queue<Oranges> q1 = new ArrayDeque<>();
        int count_1=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q1.add(new Oranges(i, j, grid[i][j]));
                if(grid[i][j]==1)
                    count_1++;
            }
        }
        q1.add(new Oranges(true));
        if(count_1==0) return 0;
        int count = 0;
        while (!q1.isEmpty()) {
            Oranges temp = q1.poll();
            if(temp.isLast){
                count++;
                q1.add(new Oranges(true));
                Oranges temp1=q1.peek();
                if(temp1.isLast) break;
            }

            else{
                grid[temp.x][temp.y] = 0;
                if (temp.x + 1 < grid.length && grid[temp.x + 1][temp.y] == 1) {
                    q1.add(new Oranges(temp.x + 1, temp.y, 2));
                    grid[temp.x + 1][temp.y] = 2;
                }
                if (temp.y + 1 < grid[0].length && grid[temp.x][temp.y + 1] == 1) {
                    q1.add(new Oranges(temp.x, temp.y + 1, 2));
                    grid[temp.x][temp.y + 1] = 2;
                }
                if (temp.x - 1 >= 0 && grid[temp.x - 1][temp.y] == 1) {
                    q1.add(new Oranges(temp.x - 1, temp.y, 2));
                    grid[temp.x - 1][temp.y] = 2;
                }
                if (temp.y - 1 >= 0 && grid[temp.x][temp.y - 1] == 1) {
                    q1.add(new Oranges(temp.x, temp.y - 1, 2));
                    grid[temp.x][temp.y - 1] = 2;
                }

                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        System.out.print(grid[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println(count);

            }

        }

        return count-1;
    }
    public static int orangesRotting2(int[][] grid) {
        Queue<Oranges> q1 = new ArrayDeque<>();
        int count_1=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q1.add(new Oranges(i, j, grid[i][j]));
                if(grid[i][j]==1)
                    count_1++;
            }
        }
        q1.add(new Oranges(true));
        if(count_1==0) return 0;
        int count = 0;
        while (!q1.isEmpty()) {
            int levelSize=q1.size();
            while(levelSize>0) {
                Oranges temp = q1.poll();
                levelSize--;
                grid[temp.x][temp.y] = 0;
                if (temp.x + 1 < grid.length && grid[temp.x + 1][temp.y] == 1) {
                    q1.add(new Oranges(temp.x + 1, temp.y, 2));
                    grid[temp.x + 1][temp.y] = 2;
                }
                if (temp.y + 1 < grid[0].length && grid[temp.x][temp.y + 1] == 1) {
                    q1.add(new Oranges(temp.x, temp.y + 1, 2));
                    grid[temp.x][temp.y + 1] = 2;
                }
                if (temp.x - 1 >= 0 && grid[temp.x - 1][temp.y] == 1) {
                    q1.add(new Oranges(temp.x - 1, temp.y, 2));
                    grid[temp.x - 1][temp.y] = 2;
                }
                if (temp.y - 1 >= 0 && grid[temp.x][temp.y - 1] == 1) {
                    q1.add(new Oranges(temp.x, temp.y - 1, 2));
                    grid[temp.x][temp.y - 1] = 2;
                }
                //System.out.println(levelSize);
//                for (int i = 0; i < grid.length; i++) {
//                    for (int j = 0; j < grid[0].length; j++) {
//                        System.out.print(grid[i][j] + " ");
//                    }
//                    System.out.println();
//                }
            }
            count++;
            //System.out.println(levelSize);
            //System.out.println(count);

        }
        //return count+1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return count-1;
    }
}