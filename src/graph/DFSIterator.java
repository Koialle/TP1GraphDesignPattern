
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Ophélie EOUZAN
 * @author Mélanie DUBREUIL
 */
public class DFSIterator implements Iterator<Node> {

    private final IGraph graph;
    private Stack<Node> stack = new Stack();
    private List<Node> visited = new ArrayList();

    DFSIterator(IGraph graph, Node root) {
        this.graph = graph;
        this.stack.push(root);
        this.visited.add(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        Node current = stack.pop();
        List<Node> adjacents = this.graph.getAdjNodes(current);
        for (Node adjacent : adjacents) {
            if (!visited.contains(adjacent)) {
                stack.push(adjacent);
                visited.add(adjacent);
            }
        }
        return current;
    }
}
