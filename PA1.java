import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PA1 {
    private static List<List<Integer>> res = new ArrayList<>();
    private static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] graph = {
                {'B', 'B', 'B', 'R', 'R', 'R', 'R', 'R', 'R'},
                {'B', 'B', 'B', 'B', 'R', 'R', 'X', 'X', 'X'},
                {'R', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'X'},
                {'Y', 'Y', 'Y', 'Y', 'R', 'R', 'R', 'X', 'X'},
                {'Y', 'G', 'G', 'G', 'G', 'R', 'X', 'X', 'X'},
                {'Y', 'G', 'G', 'G', 'R', 'R', 'X', 'X', 'X'},
                {'Y', 'G', 'X', 'G', 'G', 'G', 'G', 'X', 'X'},
                {'Y', 'G', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };
        int[] start = new int[]{6, 2}; // Corrected initialization
        solution(graph, 'X', 'g', start);
        for (List<Integer> pair : res) {
            System.out.println(pair);
        }
    }

    public static void solution(char[][] array, char target, char replace, int[] start) {
        if (array == null || array.length == 0) return;
        int x = start[0];
        int y = start[1];
        dfs(array, target, replace, x, y);
    }

    private static void dfs(char[][] array, char target, char replace, int x, int y) {
        if (x < 0 || x >= array.length || y < 0 || y >= array[0].length || array[x][y] != target) {
            return;
        }
        res.add(Arrays.asList(x, y));
        array[x][y] = replace;
        for (int i = 0; i < move.length; i++) {
            int dx = move[i][0];
            int dy = move[i][1];
            dfs(array, target, replace, x + dx, y + dy);
        }
    }
}
