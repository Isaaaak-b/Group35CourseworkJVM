object MSTAlgorithm {
    fun calculateMST(graph: Graph): List<Edge> {
        val sortedEdges = graph.getEdges().sortedBy { it.distance }
        val mst = mutableListOf<Edge>()
        val disjointSet = DisjointSet(graph.getVertices())

        for (edge in sortedEdges) {
            if (disjointSet.find(edge.city1) != disjointSet.find(edge.city2)) {
                mst.add(edge)
                disjointSet.union(edge.city1, edge.city2)
            }
        }

        return mst
    }
}

class DisjointSet(vertices: Set<City>) {
    private val parent = mutableMapOf<City, City>()

    init {
        vertices.forEach { parent[it] = it }
    }

    fun find(city: City): City {
        if (parent[city] != city) {
            parent[city] = find(parent[city]!!)
        }
        return parent[city]!!
    }

    fun union(city1: City, city2: City) {
        val root1 = find(city1)
        val root2 = find(city2)
        parent[root1] = root2
    }
}