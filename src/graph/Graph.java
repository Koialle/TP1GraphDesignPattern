package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graph implements IDirectedGraph {

    /**
     * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
     */
    protected Map<Node, List<Arc>> adjacence;

    public Graph() {
        adjacence = new HashMap<>();
    }

    @Override
    public List<Node> getAllNodes() {
        List<Node> nodes = new ArrayList();
        for (Map.Entry<Node, List<Arc>> entrySet : adjacence.entrySet()) {
            nodes.add(entrySet.getKey());
        }

        return nodes;
    }

    @Override
    public int getNbNodes() {
        return adjacence.size();
    }
    
    @Override
    public void addNode(Node _node) {
        adjacence.put(_node, new ArrayList<>());
    }

    /**
     *
     * @param _n1
     * @param _n2
     * @return vrai si graph possede arc de src _n1 et destination _n2
     */
    @Override
    public boolean hasArc(Node _n1, Node _n2) {
        List<Arc> arretesAdj = adjacence.get(_n1);
        for (Arc _a : arretesAdj) {
            if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addArc(Arc _edge) {
        if (!hasArc(_edge.getSource(), _edge.getDestination())) {
            adjacence.get(_edge.getSource()).add(_edge);
        }
    }

    /**
     *
     * @param _n
     * @return tous les arcs de source _n
     */
    @Override
    public List<Arc> getArc(Node _n) {
        return adjacence.get(_n);
    }

    /**
     * renvoie tous les noeuds qui sont destination d'un arc dont la source est _n
     *
     * @param _n
     * @return
     */
    @Override
    public List<Node> getAdjNodes(Node _n) {
        List<Node> nodes = new ArrayList();
        List<Arc> arcs = this.getArc(_n);
        for (Arc arc : arcs) {
            Node destination = arc.getDestination();
            if (!nodes.contains(destination)) {
                nodes.add(destination);
            }
        }

        return nodes;
    }

    @Override
    public String toString() {
        String s = "Graph \n";
        
        for (Node node : this.getAllNodes()) {
            s += "[noeud=" + node + " : ";
            s += this.getArc(node) + "\n";
        }

        return s;
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return new BSFIterator(this, n);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return new DFSIterator(this, n);
    }
}
