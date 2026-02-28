import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Expense> expenses = new ArrayList<>();
        HashMap<String, Double> categoryTotal = new HashMap<>();

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Category-wise Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Date (dd-mm-yyyy): ");
                    String date = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    Expense e = new Expense(date, category, amount);
                    expenses.add(e);

                    if (categoryTotal.containsKey(category)) {
                        categoryTotal.put(category,
                                categoryTotal.get(category) + amount);
                    } else {
                        categoryTotal.put(category, amount);
                    }

                    System.out.println("Expense added successfully.");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        for (int i = 0; i < expenses.size(); i++) {
                            //System.out.print((i + 1) + ". ");
                            expenses.get(i).display();
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (Expense ex : expenses) {
                        total += ex.amount;
                    }
                    System.out.println("Total Expense: " + total);
                    break;

                case 4:
                    if (categoryTotal.isEmpty()) {
                        System.out.println("No category data available.");
                    } else {
                        for (String key : categoryTotal.keySet()) {
                            System.out.println(key + " → "+ categoryTotal.get(key));
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter the expense number to delete: ");
                    int index=sc.nextInt()-1;
                    if(index>=0 && index <expenses.size()){
                        Expense removed=expenses.remove(index);
                        categoryTotal.put(removed.category,categoryTotal.get(removed.category)-removed.amount);
                        System.out.println("Expense removed successfully");
                    }else{
                        System.out.println("Invalid index number");
                    }
                    break;
                case 6:
                    System.out.println("Exiting....");
                    System.out.println("ThankYou");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
        
    }
}
