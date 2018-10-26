
public class Plane {
	private PlaneSeat[] seat = new PlaneSeat[12];
	private int numEmptySeat=12;   //info on the num of empty seats
	
	public Plane() {
		for (int i=0; i<12; i++) {
			seat[i]= new PlaneSeat(i+1);
		}
	}
	
	private PlaneSeat[] sortSeats() {
		PlaneSeat[] new_seat = new PlaneSeat[12-numEmptySeat];
		int n= 12-numEmptySeat;
		int k=0;
		for (int i=0; i<12; i++) {
			if (seat[i].isOccupied()) {
				new_seat[k++]= seat[i];
			}
		}
		PlaneSeat temp;
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (new_seat[j].getCustomerID()>new_seat[j+1].getCustomerID()) {
					temp = new_seat[j+1];
					new_seat[j+1]= new_seat[j];
					new_seat[j]= temp; 
				}
			}
		}
		
		return new_seat;
	}
	
	public void showNumEmptySeats() {
		System.out.println("There are "+ numEmptySeat + " empty seats");
	}
	
	public void showEmptySeats() {
		System.out.println("The following seats are empty:");
		for (int i=0; i<12; i++) {
			if (!seat[i].isOccupied()) {
				System.out.println("SeatID "+ (int)(i+1));
			}
		}
	}
	
	public void showAssignedSeats(boolean bySeatID) {
		System.out.println("The seat assignments are as follow:");
		PlaneSeat[] new_seat = sortSeats();
		if (bySeatID) {
		for (int i=0; i<12; i++) {
				if (seat[i].isOccupied()) {
						System.out.println("SeatID "+ (int)(i+1) + " assigned to CustomerID "+ seat[i].getCustomerID() +".");
				}
			}
		}
		
		else{
			for (int i=0; i<12-numEmptySeat; i++) {
				System.out.println("SeatID "+ new_seat[i].getSeatID() + " assigned to CustomerID "+ new_seat[i].getCustomerID() +".");
			}
		}
		
		
	}
	
	public void assignSeat(int seatID, int cust_id) {
		if (!seat[seatID-1].isOccupied()) {
			seat[seatID-1].assign(cust_id);
			System.out.println("Seat Assigned!");
			numEmptySeat--;
		}
		else {
			System.out.println("Seat already assigned to a customer.");
		}
	}
	
	
	public void unAssignSeat(int seatId) {
		seat[seatId-1].unAssign();
		numEmptySeat++;
	}


}
