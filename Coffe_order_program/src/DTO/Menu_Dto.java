package DTO;
/*
DRINK VARCHAR2(50) PRIMARY KEY,
SMALL NUMBER(10) NOT NULL,
TALL NUBMER(10) NOT NULL,
GRANDE NUMBER(10) NOT NULL
*/
public class Menu_Dto {
	private int seq;
	private String drinkName;
	private int small;
	private int tall;
	private int grande;
	
	
	
	public Menu_Dto(int seq, String name, int small, int tall, int grande) {
		this.seq = seq;
		this.drinkName = name;
		this.small = small;
		this.tall = tall;
		this.grande = grande;
		
		
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public int getSmall() {
		return small;
	}
	public void setSmall(int small) {
		this.small = small;
	}
	public int getTall() {
		return tall;
	}
	public void setTall(int tall) {
		this.tall = tall;
	}
	public int getGrande() {
		return grande;
	}
	public void setGrande(int grande) {
		this.grande = grande;
	}
	
	
	@Override
	public String toString() {
		return "Menu_Dto [seq=" + seq + ", drinkName=" + drinkName + ", small=" + small + ", tall=" + tall + ", grande="
				+ grande + "]";
	}
	
	
	 
}
