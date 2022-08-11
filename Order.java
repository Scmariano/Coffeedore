import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items = new ArrayList<Item>(); // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        this.ready = false;
    }
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        this.ready = false;
    }
    // ORDER METHODS
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    // addItem
    public void addItem(Item item) {
        this.items.add(item);
    }
    

    // getStatusMessage
    public String getStatusMessage() {
        if(this.ready==true) {
            return "Your order is ready!";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    // getOrderTotal
    public double getOrderTotal () {
        double total = 0.00;
        for(Item i: this.items) {
            total += i.getPrice();
        }
        return total;
    }

    // display

    public void display() {
        System.out.println("Customer Name:" + this.name);
        for(Item i: this.items) {
            System.out.println(i.getName() + ": $" + i.getPrice());
        }
        System.out.println("Total: $" +this.getOrderTotal());
    }
}

