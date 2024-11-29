data class City(val name: String)

data class Edge(val city1: City, val city2: City, val distance: Double)

class Graph {
    private val vertices = mutableSetOf<City>()
    private val edges = mutableListOf<Edge>()

    fun addCity(city: City) {
        vertices.add(city)
    }

    fun addEdge(edge: Edge) {
        edges.add(edge)
    }

    fun getVertices(): Set<City> = vertices.toSet()

    fun getEdges(): List<Edge> = edges.toList()
}