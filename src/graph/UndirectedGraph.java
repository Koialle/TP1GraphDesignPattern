package graph;

import java.util.List;

public class UndirectedGraph extends Graph implements IUndirectedGraph {

    @Override
    public void addEdge(Node _node1, Node _node2) {
        List<Arc> adjacentsNode1 = this.adjacence.get(_node1);
        List<Arc> adjacentsNode2 = this.adjacence.get(_node2);
        adjacentsNode1.add(new Arc(_node1, _node2, null));
        adjacentsNode2.add(new Arc(_node2, _node1, null));

        this.adjacence.put(_node1, adjacentsNode1);
        this.adjacence.put(_node2, adjacentsNode2);
    }

    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return this.adjacence.get(_node1).contains(new Arc(_node1, _node2, null));
    }
}
