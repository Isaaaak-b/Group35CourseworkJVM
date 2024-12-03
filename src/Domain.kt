// Represents a city (or vertex) in the graph
data class City(val name: String)

// Represents an edge in the graph, connecting two cities with a specified distance
data class Edge(val city1: City, val city2: City, val distance: Double)

// Class representing a graph with cities as vertices and roads as edges
class Graph {
    // Set to store all unique cities (vertices) in the graph
    private val vertices = mutableSetOf<City>()

    // List to store all edges in the graph
    private val edges = mutableListOf<Edge>()

    // Function to add a city (vertex) to the graph
    fun addCity(city: City) {
        vertices.add(city)
    }

    // Function to add an edge (connection) between two cities to the graph
    fun addEdge(edge: Edge) {
        edges.add(edge)
    }

    // Function to retrieve all cities (vertices) in the graph as an immutable set
    fun getVertices(): Set<City> = vertices.toSet()

    // Function to retrieve all edges in the graph as an immutable list
    fun getEdges(): List<Edge> = edges.toList()
}