package hotelreservation.entities;

public class Reservation implements Comparable<Reservation> {
    
    private Integer reservationId;
    private Long created;
    private String startDate;
    private String endDate;
	private String customerName;
	private String customerEmail;
	private String customerPhoneNr;
	private Integer numCostumers;

    public Reservation(Integer reservationId, Long created, String startDate, String endDate,
					   String customerName, String customerEmail, String customerPhoneNr,
					   Integer numCostumers) {
        this.reservationId = reservationId;
        this.created = created;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNr = customerPhoneNr;
		this.numCostumers = numCostumers;
    }
 
    @Override
    public int compareTo(Reservation o) {
        return 0;
    }

	public String toString() {
		String allInfo = "";
		allInfo += "reservationId: " + this.reservationId + "\n";
		allInfo += "created: " + this.created + "\n";
		allInfo += "startDate: " + this.startDate + "\n";
		allInfo += "endDate: " + this.endDate + "\n";
		allInfo += "customerName: " + this.customerName + "\n";
		allInfo += "customerEmail: " + this.customerEmail + "\n";
		allInfo += "customerPhoneNr: " + this.customerPhoneNr + "\n";
		allInfo += "numCostumers: " + this.numCostumers + "\n";
		return allInfo;
	}
    
<<<<<<< HEAD
    // Getters
	public Integer getReservationId() {
        return this.reservationId;
    }
    
    public Long getCreated() {
        return this.created;
    }
    
    public Long getStartDate() {
        return this.startDate;
    }
    
    public Long getEndDate() {
        return this.endDate;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public String getCustomerEmail() {
        return this.customerEmail;
    }
    
    public String getCustomerPhoneNr() {
        return this.customerPhoneNr;
    }
    
    public Integer getNumCostumers() {
        return this.numCostumers;
    }
    
    // Setters
    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
    
    public void setCreated(Long created) {
        this.created = created;
    }
    
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    public void setCustomerPhoneNr(String customerPhoneNr) {
        this.customerPhoneNr = customerPhoneNr;
    }
    
    public void setNumCostumers(Integer numCostumers) {
        this.numCostumers = numCostumers;
    }
=======
    public Integer getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Long getCreated() {
		return this.created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Sring getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
>>>>>>> ae1d53480c5ee3830cb85c024649cb13bfe538fa

}
