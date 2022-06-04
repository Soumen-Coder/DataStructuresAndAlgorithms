package Graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjacencyList {

    List<GraphNode> nodeList = new ArrayList<>();

    public AdjacencyList(List<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j){
        nodeList.get(i).neighbours.add(nodeList.get(j));
        nodeList.get(j).neighbours.add(nodeList.get(i));
    }

    public static class GraphNode {
        private String name;
        private int index;
        private boolean isVisited = false;

        List<GraphNode> neighbours = new ArrayList<>();

        public GraphNode(String name, int index){
            this.name=name;
            this.index=index;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<nodeList.size();i++){
            sb.append(nodeList.get(i).name + ":");
            for (int j = 0; j < nodeList.get(i).neighbours.size(); j++) {
                if(j == nodeList.get(i).neighbours.size()-1)
                    sb.append(nodeList.get(i).neighbours.get(j).name);
                else
                    sb.append(nodeList.get(i).neighbours.get(j).name + "->");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();

            if(!currentNode.isVisited){
               currentNode.isVisited = true;
               System.out.println(currentNode.name + " ");

            for(GraphNode neighbour : currentNode.neighbours){
                    stack.push(neighbour);
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

