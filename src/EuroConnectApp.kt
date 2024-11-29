
import java.io.File

class EuroConnectApp {
    private val graph = Graph()

    fun loadDataFromFile(filename: String) {
        File(filename).useLines { lines ->
            lines.forEach { line ->
                val (city1Name, city2Name, distanceStr) = line.split(", ")
                val city1 = City(city1Name)
                val city2 = City(city2Name)
                val distance = distanceStr.toDouble()

                graph.addCity(city1)
                graph.addCity(city2)
                graph.addEdge(Edge(city1, city2, distance))
            }
        }
    }

    fun calculateMST(): List<Edge> {
        return MSTAlgorithm.calculateMST(graph)
    }

    fun getTotalCableLength(mst: List<Edge>): Double {
        return mst.sumOf { it.distance }
    }
}