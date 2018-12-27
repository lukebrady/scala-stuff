object InventoryList {
    var root = new RootNode
    var maxLength = 25
    var currentLength = 0
    var currentSlot = 0

    // Print our current item to the screen.
    def getCurrentItem = {
        var current = root
        if (current.nextItem != null) {
        } else {
            println("Your inventory is empty.")
        }
    }
    // Get and return the next item.
    def getNextItem = {

    }

    protected class RootNode {var nextItem: ItemNode = null}
    protected class ItemNode(var nextItem: ItemNode, var itemID: Int, var itemName: String, 
        var weapon: Boolean, var food: Boolean, var potion: Boolean) {
    }
}


object Main extends App {
    var inventory = InventoryList
    inventory.getCurrentItem
}