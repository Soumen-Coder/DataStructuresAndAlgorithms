package Graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListClient {
    public static void main(String[] args) {

        List<AdjacencyList.GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new AdjacencyList.GraphNode("A", 0));
        nodeList.add(new AdjacencyList.GraphNode("B", 1));
        nodeList.add(new AdjacencyList.GraphNode("C", 2));
        nodeList.add(new AdjacencyList.GraphNode("D", 3));
        nodeList.add(new AdjacencyList.GraphNode("E", 4));

        AdjacencyList g = new AdjacencyList(nodeList);
        /*g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(2,3);
        g.addUndirectedEdge(3,4);
        g.addUndirectedEdge(1,4);*/
        g.addUndirectedEdge(1, 0);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(2, 1);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);

        System.out.println(g);

        g.dfs();
    }
}
