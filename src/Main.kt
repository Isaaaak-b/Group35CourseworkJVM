fun main() {
    val app = EuroConnectApp()
    println("Welcome to EuroConnect MST Calculator")
    println("Please enter the filename containing city distances:")
    val filename = readLine() ?: return
    app.loadDataFromFile(filename)
    val mst = app.calculateMST()
    val totalLength = app.getTotalCableLength(mst)

    println("\nMinimum Spanning Tree Edges:")
    mst.forEach { println("${it.city1.name} - ${it.city2.name}: ${it.distance} km") }
    println("\nTotal cable length required: $totalLength km")
} 