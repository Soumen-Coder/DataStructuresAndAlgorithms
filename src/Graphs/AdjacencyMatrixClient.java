package Graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixClient {

    public static void main(String[] args) {

        List<AdjacencyMatrix.GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new AdjacencyMatrix.GraphNode("A", 0, false));
        nodeList.add(new AdjacencyMatrix.GraphNode("B", 1, false));
        nodeList.add(new AdjacencyMatrix.GraphNode("C", 2, false));
        nodeList.add(new AdjacencyMatrix.GraphNode("D", 3, false));
        nodeList.add(new AdjacencyMatrix.GraphNode("E", 4, false));

        AdjacencyMatrix g = new AdjacencyMatrix(nodeList);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(2,3);
        g.addUndirectedEdge(3,4);
        g.addUndirectedEdge(1,4);

        System.out.println(g);

        //System.out.println("*******************BFS****************");
        //g.bfs();

        System.out.println();

        System.out.println("*******************DFS****************");
        g.dfs();
    }
}
