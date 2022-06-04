package Graphs;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class AdjacencyMatrix {

    List<GraphNode> nodeList = new ArrayList<>();
    static int matrix[][];

    public static class GraphNode{
        private String name;
        private int index;
        private boolean isVisited;

        public GraphNode(String name, int index, boolean isVisited){
            this.name = name;
            this.index = index;
            this.isVisited = false;
        }
    }

    public AdjacencyMatrix(List<GraphNode> nodeList){
        this.nodeList = nodeList;
        this.matrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j){
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < matrix.length; i++) {
            sb.append(nodeList.get(i).name + " ");
        }
        sb.append("\n");
        for (int i = 0; i < matrix.length; i++) {
            sb.append(nodeList.get(i).name + ":");
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]+ " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    void bfs(){
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    List<GraphNode> bfsVisit(GraphNode node){
        List<GraphNode> list = new ArrayList<>();
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            list.add(currentNode);
            if(!currentNode.isVisited){
                currentNode.isVisited = true;
                List<GraphNode> neighbours = getNeighbours(currentNode);
                for(GraphNode neighbour : neighbours){
                    if(!neighbour.isVisited){
                        queue.add(neighbour);
                        neighbour.isVisited = true;
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).name+ " ");
        }

        return list;
    }

    List<GraphNode> getNeighbours(GraphNode node){
        List<GraphNode> neighbours = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[nodeIndex][i] == 1){
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited=true;
            System.out.println(currentNode.name + " ");

            List<GraphNode> neighbours = getNeighbours(currentNode);
            for(GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void dfs(){
        for(GraphNode node : nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }

}
