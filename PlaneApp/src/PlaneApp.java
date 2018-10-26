import java.util.*;
public class PlaneApp {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		boolean choice= true;
		Plane p = new Plane();
		do {
			System.out.println("(1) Show number of empty seats");
			System.out.println("(2) Show the list of empty seats");
			System.out.println("(3) Show the list of seat assignments by seat ID");
			System.out.println("(4) Show the list of seat assignments by customer ID");
			System.out.println("(5) Assign a customer to a seat");
			System.out.println("(6) Remove a seat assignment");
			System.out.println("(7) Exit");
			System.out.println("Enter the number of your choice: ");
			int input= sc.nextInt();
			switch (input) {
				case 1: 
					p.showNumEmptySeats();
					break;
				case 2: 
					p.showEmptySeats();
					break;
				case 3: 
					p.showAssignedSeats(true);
					break;
				case 4: 
					p.showAssignedSeats(false);
					break;
				case 5:
					System.out.println("Assigning Seat ..");
					System.out.println("Please enter SeatID: ");
					int s = sc.nextInt();
					System.out.println("Please enter CustomerID: ");
					int c = sc.nextInt();
					p.assignSeat(s, c);
					break;
				case 6:
					System.out.println("Enter SeatID to unassign customer from:");
					int s1 = sc.nextInt();
					p.unAssignSeat(s1);
					System.out.println("Seat Unassigned!");
					break;
				case 7: 
					choice = false;
					break;
			}
		}while(choice);
	}

}
