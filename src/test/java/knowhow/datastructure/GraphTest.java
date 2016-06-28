package knowhow.datastructure;

import know.how.datastructure.graph.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test Graph
 *
 *       1 --- 3
 *     /   \  /  \
 *    0     4     6
 *     \         /
 *      2 ----- 5
 */
public class GraphTest {
    private Graph<String> graph;
    private String[] elements;

    @Before
    public void setUp() throws Exception {
        elements = new String[]{"zero","one","two","three","four","five","six"};
        graph = new Graph<>(elements);

        graph.addEdges(0, new int[]{1,2});
        graph.addEdges(1, new int[]{0,3,4});
        graph.addEdges(2, new int[]{0,5});
        graph.addEdges(3, new int[]{1,4,6});
        graph.addEdges(4, new int[]{1,3});
        graph.addEdges(5, new int[]{2,6});
        graph.addEdges(6, new int[]{3,5});
    }

    @Test
    public void testAdd() throws Exception {
        Assert.assertEquals(7, graph.getSize());
        Assert.assertNotEquals(6, graph.getSize());
        Assert.assertNotEquals(8, graph.getSize());
    }

    @Test
    public void testDepthFirstSearch() throws Exception {
        Object[] search = graph.depthFirstSearch();

        System.out.println("DFS: " + Arrays.toString(search));
        Assert.assertArrayEquals(new String[]{"zero","one","three","four","six","five","two"},
                search);
    }

    @Test
    public void testBreadthFirstSearch() throws Exception {
        Object[] search = graph.breadthFirstSearch();

        System.out.println("BFS: " + Arrays.toString(search));
        Assert.assertArrayEquals(elements, search);
    }
}
