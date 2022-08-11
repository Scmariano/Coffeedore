import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public CoffeeKiosk() {
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public ArrayList<Item> getMenu(){
        return menu;
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item();
        newItem.setName(name);
        newItem.setPrice(price);
        menu.add(newItem);
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }
    public void displayMenu() {
        for(Item i: this.menu) {
            System.out.println(i.getIndex() + " " + i.getName() + " -- $" + i.getPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Order newOrder = new Order(name);
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            int i = Integer.parseInt(itemNumber);
            if(i < this.menu.size()) {
                Item orderItem = menu.get(i);
                newOrder.addItem(orderItem);
            }
            else {
                System.out.println("Sorry it's now available at the moment!");
            }
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter the index of the coffee you would like to order, or press q to exit!");
            itemNumber = System.console().readLine();

        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        newOrder.display();
        this.orders.add(newOrder);
    }

}