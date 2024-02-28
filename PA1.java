package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PA1 {
    private static List<List<Integer>> res = new ArrayList<>();
    private static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        try {
            String filePath = "/Users/yiranchen/Desktop/Backend/snowFlake/src/main/java/org/example/test1";
            char[][] graph = readColorMatrixFromFile(filePath);
            int[] start = new int[]{6, 2}; 
            solution(graph, 'X', 'g', start);
            System.out.println(res.size());
            for (List<Integer> pair : res) {
                System.out.println(pair);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        for (int[] direction : move) {
            int dx = x + direction[0];
            int dy = y + direction[1];
            dfs(array, target, replace, dx, dy);
        }
    }

    public static char[][] readColorMatrixFromFile(String filePath) throws IOException {
        List<char[]> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                char[] chars = line.replace(",", "").toCharArray();
                lines.add(chars);
            }
        }

        // Convert List<char[]> to char[][]
        char[][] matrix = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i);
        }

        return matrix;
    }
}
