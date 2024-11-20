main() {
    val app = EuroConnectApp()
    println("Welcome to EuroConnect MST Calculator")
    println("Please enter the filename containing city distances:")
    val filename = readLine() ?: return
    app.loadDataFromFile(filename)
}