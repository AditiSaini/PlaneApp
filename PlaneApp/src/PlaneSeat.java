
public class PlaneSeat {
	private int seatId;
	private boolean assigned;
	private int customerId;
	
	public PlaneSeat(int seatId) {
		this.seatId = seatId;
	}
	
	public int getSeatID() {
		return seatId;
	}
	
	public int getCustomerID() {
		return customerId;
	}
	
	public boolean isOccupied() {
		return assigned;
	}
	
	public void assign(int cust_id) {
		if (!assigned) {
			this.customerId = cust_id;
			this.assigned = true;
		}
	}
	
	public void unAssign() {
		if (assigned) {
			this.assigned = false;
		}
	}

}
