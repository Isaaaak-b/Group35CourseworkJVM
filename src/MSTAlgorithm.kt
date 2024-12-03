// Object that implements Kruskal's algorithm to calculate the Minimum Spanning Tree (MST)
object MSTAlgorithm {
    // Function to calculate the MST of a given graph
    fun calculateMST(graph: Graph): List<Edge> {
        // Step 1: Sort all edges by their distances (ascending order)
        val sortedEdges = graph.getEdges().sortedBy { it.distance }

        // Step 2: Initialize a list to store edges that make up the MST
        val mst = mutableListOf<Edge>()

        // Step 3: Create a Disjoint Set to track connected components
        val disjointSet = DisjointSet(graph.getVertices())

        // Step 4: Iterate over sorted edges to build the MST
        for (edge in sortedEdges) {
            // If the edge connects two unconnected components, add it to the MST
            if (disjointSet.find(edge.city1) != disjointSet.find(edge.city2)) {
                mst.add(edge)
                disjointSet.union(edge.city1, edge.city2) // Merge the components
            }
        }

        // Step 5: Return the edges included in the MST
        return mst
    }
}

// Class representing a Disjoint Set (Union-Find) data structure
// Used to track and merge connected components of the graph
class DisjointSet(vertices: Set<City>) {
    // Map to track the parent of each city
    private val parent = mutableMapOf<City, City>()

    // Initialize each city as its own parent (individual components)
    init {
        vertices.forEach { parent[it] = it }
    }

    // Function to find the root (or representative) of a city
    // Uses path compression to optimize future lookups
    fun find(city: City): City {
        if (parent[city] != city) {
            parent[city] = find(parent[city]!!) // Update the parent to the root directly
        }
        return parent[city]!!
    }

    // Function to union (merge) two components by connecting their roots
    fun union(city1: City, city2: City) {
        val root1 = find(city1) // Find the root of the first city
        val root2 = find(city2) // Find the root of the second city
        parent[root1] = root2  // Connect the root of one to the other
    }
}