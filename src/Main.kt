// Main entry point of the application
fun main() {
    // Initialize the EuroConnect application
    val app = EuroConnectApp()

    // Greet the user and prompt for the input file
    println("Welcome to EuroConnect MST Calculator")
    println("Please enter the filename containing city distances:")

    // Read the filename input from the user
    // If no filename is provided, the program exits gracefully
    val filename = readLine() ?: return

    // Load city and edge data from the specified file
    app.loadDataFromFile(filename)

    // Calculate the Minimum Spanning Tree (MST) from the loaded graph
    val mst = app.calculateMST()

    // Calculate the total cable length required for the MST
    val totalLength = app.getTotalCableLength(mst)

    // Display the MST edges with their respective distances
    println("\nMinimum Spanning Tree Edges:")
    mst.forEach { println("${it.city1.name} - ${it.city2.name}: ${it.distance} km") }

    // Display the total cable length required
    println("\nTotal cable length required: $totalLength km")
}