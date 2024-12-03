import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> newList = new ArrayList<>();

    public static void main(String[] args) {

        printActions();
        System.out.println("Thank you for using my grocery list program!");
        System.out.println("Your final grocery list is: " + newList);

    }

    public static void printActions() {
        while(true){
            System.out.println("-".repeat(30));
            System.out.printf("Available Actions%n" +
                    "0 - to shutdown%n" +
                    "1 - to add item(s) to list (comma delimited list)%n" +
                    "2 - to remove any items (comma delimited list)%n" +
                    "Enter a number for the action you want to take:");
            String action = scanner.nextLine();
            System.out.println("-".repeat(30));

            if("0".contains(action)) {
                newList.sort(Comparator.naturalOrder());
                System.out.println(newList);
                break;

            } else if("1".contains(action)) {

                System.out.println("Please type your list!");
                // Adds onto our List
                groceryListAdd(scanner.nextLine());

            }else if("2".contains(action)) {

                System.out.println("Please enter an item to remove");
                // Removes from our list
                groceryListRemove(scanner.nextLine());

            } else {
                System.out.println("Incorrect input, please try again.");
            }
        }
    }

    public static void groceryListAdd(String incomingArray) {

        String[] groceryList = incomingArray.toLowerCase().split(",");

        // This loop removes ALL white space in the array and checks
        // for duplicates
        for (int i = 0; i < groceryList.length; i ++){

            groceryList[i] = groceryList[i].trim();
            if(!newList.contains(groceryList[i])) {
                newList.add(groceryList[i]);
            }
        }

        newList.sort(Comparator.naturalOrder());
        System.out.println(newList);
    }

    public static void groceryListRemove(String incomingArray) {
        // This code takes the users info and splits it
        String[] groceryList = incomingArray.toLowerCase().split(",");

        // This loop removes ALL white space in the array
        for (int i = 0; i < groceryList.length; i ++){
            groceryList[i] = groceryList[i].trim();
        }

        newList.removeAll(Arrays.asList(groceryList));
        System.out.println(newList);
    }


}



