//package Graph;
//
//import java.util.*;
//
//public class Maze {
//
//    static void findPathMaze(String[] maze) {
//        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
//        String start = "";
//        String end = "";
//
//        for (int i = 1; i < maze.length - 1; i++) {
//            for (int j = 1; j < maze[i].length() - 1; j++) {
//                String vertex = i + "," + j;
//
//                if (maze[i].charAt(j) != '#') {
//                    graph.addVertex(vertex);
//
//                    if (i + 1 < maze.length - 1 && maze[i + 1].charAt(j) != '#')
//                        graph.addEdge(vertex, ((i + 1) + "," + j));
//
//                    if (j + 1 < maze[i].length() - 1 && maze[i].charAt(j + 1) != '#')
//                        graph.addEdge(vertex, (i + "," + (j + 1)));
//
//                    if (maze[i].charAt(j) == 'S')
//                        start = vertex;
//                    else if (maze[i].charAt(j) == 'E')
//                        end = vertex;
//                }
//            }
//        }
//
//        graph.findPath(start, end);
//    }
//
//    public static void main(String[] args) {
//        String[] maze = new String[6];
//
//        maze[0] = "######";
//        maze[1] = "# # ##";
//        maze[2] = "# # S#";
//        maze[3] = "# # ##";
//        maze[4] = "# E  #";
//        maze[5] = "######";
//
//        findPathMaze(maze);
//
//
//    }
//
//}
