package know.how.datastructure;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * My implementation of graph (edges can have weight)
 * Adjacency list is used to represent the graph
 * Graph contain array of objects (Vertices), every element of array is
 * a Vertex object and have linked list inside with vertices
 * (really Edge objects are used and there are pointing to the specific Vertex)
 *
 * @param <E> element that is store in the graph vertex
 */
public final class Graph<E> {
    private final Object[] adjacencyList;
    private int size;

    /**
     * Constructor initiate adjacency list based on the size of array
     *
     * @param vertices array of objects that are stored in the graph
     */
    public Graph(E[] vertices) {
        adjacencyList = new Object[vertices.length];
        for (E elem : vertices) {
            adjacencyList[size++] = new Vertex<>(elem);
        }
    }

    /**
     * Indexes are used to map numbers to specific Vertices
     *
     * @param index
     * @param neighbors
     */
    public final void addEdges(int index, int[] neighbors) {
        if (neighbors != null) {
            List<Edge<E>> edges = new LinkedList<>();
            for (int id : neighbors) {
                edges.add(new Edge<E>((Vertex<E>) adjacencyList[id]));
            }
            ((Vertex<E>) adjacencyList[index]).setEdges(edges);
        }
    }

    public int getSize() {
        return size;
    }

    public void printGraph() {
        for (Object obj : adjacencyList) {
            System.out.println(((Vertex<E>) obj).elem);
        }
    }

    /**
     * Depth first search algorithm
     * It traverse the graph from root to leaves
     * At the beginning first Vertex are push to stack,
     * then we iterate through the linked list of this Vertex and
     * search for unvisited Vertex, when founded we iterate
     * though linked list of founded Vertex and so on
     */
    public Object[] depthFirstSearch() {
        Object[] result = new Object[size];
        Deque<Vertex<E>> stack = new ArrayDeque<>();
        stack.push((Vertex<E>) adjacencyList[0]);
        ((Vertex<E>) adjacencyList[0]).visited = true;

        int i = 0;
        result[i++] = ((Vertex<E>) adjacencyList[0]).elem;

        while (!stack.isEmpty()) {
            Vertex<E> v = stack.peek();
            Vertex<E> child = getUnvisitedChildVertex(v);

            if (child != null) {
                child.visited = true;
                result[i++] = child.elem;
                stack.push(child);
            } else {
                stack.pop();
            }
        }

        //clear visited property of all vertices
        clearVisitedVertex();

        return result;
    }

    private Vertex<E> getUnvisitedChildVertex(Vertex<E> v) {
        for (Edge<E> edge : v.edges) {
            if (edge.to.visited == true)
                continue;
            return edge.to;
        }
        return null;
    }

    /**
     * Breadth First Search
     * It traverse the graph level by level
     * At the beginning first Vertex are add to the linked list,
     * then we iterate through whole list of Vertex and
     * adding founded Vertex to the linked list, then we get (and remove)
     * the first Vertex from linked list and iterate through whole
     * list of this Vertex and adding new Vertex to the end of linked list
     * and so on until the linked list is not empty
     */
    public Object[] breadthFirstSearch() {
        Object[] result = new Object[size];
        LinkedList<Vertex<E>> list = new LinkedList<>();
        list.add((Vertex<E>) adjacencyList[0]);
        ((Vertex<E>) adjacencyList[0]).visited = true;

        int i = 0;
        result[i++] = ((Vertex<E>) adjacencyList[0]).elem;

        while (!list.isEmpty()) {
            Vertex<E> v = list.remove();
            Vertex<E> child = null;

            while ((child = getUnvisitedChildVertex(v)) != null) {
                child.visited = true;
                result[i++] = child.elem;
                list.add(child);
            }
        }
        //clear visited property of all vertices
        clearVisitedVertex();

        return result;
    }

    private void clearVisitedVertex() {
        for (Object obj : adjacencyList) {
            ((Vertex<E>) obj).visited = false;
        }
    }

    private static class Vertex<E> {
        E elem;
        boolean visited;
        List<Edge<E>> edges;

        Vertex(E elem) {
            this.elem = elem;
        }

        public void setEdges(List<Edge<E>> edges) {
            this.edges = edges;
        }
    }

    private static class Edge<E> {
        Vertex<E> to;

        public Edge(Vertex<E> to) {
            this.to = to;
        }
    }
}
