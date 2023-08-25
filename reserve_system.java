public import java.util.Scanner;

class ReservationSystem {
    private static String username = "admin";
    private static String password = "password";
    private static boolean loggedIn = false;
    private static String reservationDetails;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Reservation System!");

            if (!loggedIn) {
                System.out.print("Username: ");
                String inputUsername = scanner.nextLine();

                System.out.print("Password: ");
                String inputPassword = scanner.nextLine();

                if (login(inputUsername, inputPassword)) {
                    loggedIn = true;
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                    continue;
                }
            }

            System.out.println("1. Fill Details");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    fillDetails(scanner);
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    logout();
                    break;
                case 4:
                    System.out.println("Thank you for using the Reservation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    private static void fillDetails(Scanner scanner) {
        System.out.print("Enter your reservation details: ");
        reservationDetails = scanner.nextLine();
        System.out.println("Reservation details saved: " + reservationDetails);
    }

    private static void cancelReservation() {
        if (reservationDetails != null) {
            reservationDetails = null;
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("No reservation found.");
        }
    }

    private static void logout() {
        loggedIn = false;
        System.out.println("Logout successful!");
    }
}

