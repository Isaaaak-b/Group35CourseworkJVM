import java.io.File

// Main application class for calculating the Minimum Spanning Tree (MST)
class EuroConnectApp {
    // Instance of the Graph class to store cities and edges
    private val graph = Graph()

    // Function to load city and edge data from a file
    fun loadDataFromFile(filename: String) {
        // Read each line from the specified file
        File(filename).useLines { lines ->
            lines.forEach { line ->
                // Split the line into city names and distance (format: "City1, City2, Distance")
                val (city1Name, city2Name, distanceStr) = line.split(", ")

                // Create City objects for both cities in the edge
                val city1 = City(city1Name)
                val city2 = City(city2Name)

                // Parse the distance between the cities
                val distance = distanceStr.toDouble()

                // Add the cities and the edge to the graph
                graph.addCity(city1)
                graph.addCity(city2)
                graph.addEdge(Edge(city1, city2, distance))
            }
        }
    }

    // Function to calculate the Minimum Spanning Tree (MST) for the loaded graph
    fun calculateMST(): List<Edge> {
        return MSTAlgorithm.calculateMST(graph)
    }

    // Function to calculate the total length of the MST's edges
    fun getTotalCableLength(mst: List<Edge>): Double {
        // Sum the distances of all edges in the MST
        return mst.sumOf { it.distance }
    }
}