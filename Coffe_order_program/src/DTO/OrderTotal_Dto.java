package DTO;

public class OrderTotal_Dto {

	private int seq;
	private String id;
	private String drink;
	private String size;
	private String syrup;

	private String shot;
	private String cream;
	private int drinkCount;
	private int payTotal;
	private String orderDate;

	public OrderTotal_Dto() {
		super();
	}

	public OrderTotal_Dto(int seq, String id, String drink, String size, String syrup, String shot, String cream, int drinkCount,
			int payTotal, String orderDate) {
		super();
		this.seq = seq;
		this.id = id;
		this.drink = drink;
		this.size = size;
		this.syrup = syrup;
		this.shot = shot;
		this.cream = cream;
		this.drinkCount = drinkCount;
		this.payTotal = payTotal;
		this.orderDate = orderDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSyrup() {
		return syrup;
	}

	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public String getShot() {
		return shot;
	}

	public void setShot(String shot) {
		this.shot = shot;
	}

	public String getCream() {
		return cream;
	}

	public void setCream(String cream) {
		this.cream = cream;
	}

	public int getDrinkCount() {
		return drinkCount;
	}

	public void setDrinkCount(int drinkCount) {
		this.drinkCount = drinkCount;
	}

	public int getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(int payTotal) {
		this.payTotal = payTotal;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderTotal_Dto [seq=" + seq + ", id=" + id + ", drink=" + drink + ", size=" + size + ", syrup=" + syrup
				+ ", shot=" + shot + ", cream=" + cream + ", drinkCount=" + drinkCount + ", payTotal=" + payTotal
				+ ", orderDate=" + orderDate + "]";
	}

	
	
}