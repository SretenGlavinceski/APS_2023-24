package Labs.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Edge {
    private int fromVertex, toVertex;
    private int weight;
    public Edge(int from, int to, int weight) {
        this.fromVertex = from;
        this.toVertex = to;
        this.weight = weight;
    }

    public int getFrom() {
        return this.fromVertex;
    }
    public int getTo() {
        return this.toVertex;
    }
    public int getWeight() {
        return this.weight;
    }
}

class AdjacencyMatrixGraph<T> {
    private int numVertices;
    private int[][] matrix;
    private T[] vertices;

    @SuppressWarnings("unchecked")
    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrix[i][j] = 0;
            }
        }
        vertices = (T[]) new Object[numVertices];
    }

    public void addVertex(int index, T data) {
        vertices[index] = data;
    }

    public T getVertex(int index) {
        return vertices[index];
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight; // For undirected graph
    }

    public boolean isEdge(int source, int destination) {
        return matrix[source][destination] != 0;
    }


    public void removeEdge(int source, int destination) {
        matrix[source][destination] = 0;
        matrix[destination][source] = 0; // For undirected graph
    }

    @SuppressWarnings("unchecked")
    public void removeVertex(int vertexIndex) {
        if (vertexIndex < 0 || vertexIndex >= numVertices) {
            throw new IndexOutOfBoundsException("Vertex index out of bounds!");
        }
        int[][] newMatrix = new int[numVertices - 1][numVertices - 1];
        T[] newVertices = (T[]) new Object[numVertices - 1];
        // Copy the vertices and matrix excluding the given vertex
        int ni = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i == vertexIndex) continue;
            int nj = 0;
            for (int j = 0; j < numVertices; j++) {
                if (j == vertexIndex) continue;
                newMatrix[ni][nj] = matrix[i][j];
                nj++;
            }
            newVertices[ni] = vertices[i];
            ni++;
        }
        // Replace the old matrix and vertices with the new ones
        matrix = newMatrix;
        vertices = newVertices;
        numVertices--;
    }

    public List<T> getNeighbors(int vertexIndex) {
        List<T> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix[vertexIndex].length; i++) {
            if (matrix[vertexIndex][i] != 0) {
                neighbors.add(vertices[i]);
            }
        }
        return neighbors;
    }

    private List<Edge> getAllEdges() {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (isEdge(i, j)) {
                    edges.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }

        return edges;
    }

    private void union(int u, int v, int[] trees) {
        int findWhat, replaceWith;
        if (u < v) {
            findWhat = trees[v];
            replaceWith = trees[u];
        } else {
            findWhat = trees[u];
            replaceWith = trees[v];
        }

        for (int i = 0; i < trees.length; i++) {
            if (trees[i] == findWhat) {
                trees[i] = replaceWith;
            }
        }
    }

    public List<Edge> kruskal() {
        List<Edge> mstEdges = new ArrayList<>();
        List<Edge> allEdges = getAllEdges();

        allEdges.sort(Comparator.comparingInt(Edge::getWeight));

        int trees[] = new int[numVertices];

        for (int i = 0; i < numVertices; i++)
            trees[i] = i;

        for (Edge e : allEdges) {
            if (trees[e.getFrom()] != trees[e.getTo()]) {
                mstEdges.add(e);

                union(e.getFrom(), e.getTo(), trees);
            }
        }

        return mstEdges;
    }

    public List<Edge> prim(int startVertexIndex) {
        List<Edge> mstEdges = new ArrayList<>();
        Queue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        boolean included[] = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            included[i] = false;
        }

        included[startVertexIndex] = true;

        for (int i = 0; i < numVertices; i++) {
            if (isEdge(startVertexIndex, i)) {
                q.add(new Edge(startVertexIndex, i, matrix[startVertexIndex][i]));
            }
        }

        while (!q.isEmpty()) {
            Edge e = q.poll();

            if (!included[e.getTo()]) {
                included[e.getTo()] = true;
                mstEdges.add(e);
                for (int i = 0; i < numVertices; i++) {
                    if (!included[i] && isEdge(e.getTo(), i)) {
                        q.add(new Edge(e.getTo(), i, matrix[e.getTo()][i]));
                    }
                }
            }
        }

        return mstEdges;
    }

    public List<Edge> adaptedKruskal(int trees[]) {
        List<Edge> mstEdges = new ArrayList<>();
        List<Edge> allEdges = getAllEdges();

        allEdges.sort(Comparator.comparingInt(Edge::getWeight));

        for (Edge e : allEdges) {
            if (trees[e.getFrom()] != trees[e.getTo()]) {
                mstEdges.add(e);

                union(e.getFrom(), e.getTo(), trees);
            }
        }

        return mstEdges;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("  ");
        for (int i = 0; i < numVertices; i++)
            ret.append(vertices[i]).append(" ");
        ret.append("\n");
        for (int i = 0; i < numVertices; i++) {
            ret.append(vertices[i]).append(" ");
            for (int j = 0; j < numVertices; j++)
                ret.append(matrix[i][j]).append(" ");
            ret.append("\n");
        }
        return ret.toString();
    }

}


public class OrganisationHierarchy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> members = new HashMap<>();
        int people = Integer.parseInt(br.readLine());
        int connections = Integer.parseInt(br.readLine());

        AdjacencyMatrixGraph<Integer> graph = new AdjacencyMatrixGraph<>(people);

        for (int i = 0; i < connections; i++) {

            String [] parts = br.readLine().split("\\s+");
            int id1 = Integer.parseInt(parts[0]);
            int id2 = Integer.parseInt(parts[2]);
            String name1 = parts[1];
            String name2 = parts[3];

            members.putIfAbsent(name1, id1);
            members.putIfAbsent(name2, id2);

            int cooperation = Integer.parseInt(parts[4]);
            graph.addEdge(id1, id2, cooperation);

        }

        String start = br.readLine();
        List<Edge> organisation = graph.prim(members.get(start));

        System.out.println(
                organisation.stream().mapToInt(Edge::getWeight).sum()
        );

    }
}

// input:

//8
//14
//0 ilinka 1 magdalena 9
//0 ilinka 2 igor 2
//0 ilinka 4 anastas 5
//1 magdalena 2 igor 7
//1 magdalena 3 vladimir 8
//1 magdalena 6 slobodan 4
//2 igor 3 vladimir 1
//2 igor 4 anastas 3
//3 vladimir 4 anastas 1
//4 anastas 5 ana 2
//4 anastas 6 slobodan 2
//4 anastas 7 igorT 8
//5 ana 6 slobodan 3
//5 ana 7 igorT 1
//anastas

// output:
// 13


// input:

//6
//5
//0 magdalena 1 ilinka 7
//1 ilinka 2 igor 5
//2 igor 3 vladimir 6
//3 vladimir 4 anastas 1
//4 anastas 5 slobodan 2
//igor

// output:
// 21


//input
//4
//4
//0 magdalena 1 igor 5
//0 magdalena 2 ilinka 3
//1 igor 3 igorK 1
//2 ilinka 3 igorK 2
//igor

// output
//6