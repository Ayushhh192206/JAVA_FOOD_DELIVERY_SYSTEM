import java.util.*;

class FoodItem {
    String name;
    double price;

    FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    FoodItem item;
    int quantity;

    OrderItem(FoodItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<FoodItem> menu = new ArrayList<>();
        menu.add(new FoodItem("Burger", 100));
        menu.add(new FoodItem("Pizza", 300));
        menu.add(new FoodItem("Pasta", 200));
        menu.add(new FoodItem("Sandwich", 150));

        ArrayList<OrderItem> orderList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Menu ---");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).name + " - ₹" + menu.get(i).price);
            }

            System.out.println("Select item (1-" + menu.size() + ") or 0 to finish:");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= menu.size()) {
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                if (qty <= 0) {
                    System.out.println("Invalid quantity!");
                    continue;
                }

                orderList.add(new OrderItem(menu.get(choice - 1), qty));
            }

        } while (choice != 0);

        // Bill Calculation
        double subtotal = 0;

        for (OrderItem o : orderList) {
            subtotal += o.item.price * o.quantity;
        }

        double delivery = subtotal > 500 ? 0 : 50;
        double tax = subtotal * 0.05;
        double total = subtotal + tax + delivery;

        // Print Bill
        System.out.println("\n===== Bill =====");
        for (OrderItem o : orderList) {
            System.out.println(o.item.name + " x" + o.quantity + " = ₹" + (o.item.price * o.quantity));
        }

        System.out.println("---------------------");
        System.out.println("Subtotal: ₹" + subtotal);
        System.out.println("Delivery: ₹" + delivery);
        System.out.println("Tax: ₹" + tax);
        System.out.println("Total: ₹" + total);

        sc.close();
    }
}
