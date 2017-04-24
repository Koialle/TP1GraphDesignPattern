
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Ophélie EOUZAN
 * @author Mélanie DUBREUIL
 */
public class BSFIterator implements Iterator<Node> {

    private final IGraph graph;
    private final Queue<Node> queue = new LinkedList();
    private final List<Node> visited = new ArrayList();

    BSFIterator(IGraph graph, Node root) {
        this.graph = graph;
        this.queue.add(root);
        this.visited.add(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Node next() {
        List<Node> adjacents = this.graph.getAdjNodes(queue.peek());
        for (Node adjacent : adjacents) {
            if (!visited.contains(adjacent)) {
                queue.add(adjacent);
                visited.add(adjacent);
            }
        }
        return queue.poll();
    }
}
