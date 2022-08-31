
public class RiverItem {

	private int position;
	private int strength;
	private String symbol;
	
	public RiverItem() {
		position = (int)(Math.random()*98)+1;
	}
	
	public RiverItem(int position, int strength, String symbol) {
		this.position = position;
		this.strength = strength;
		this.symbol = symbol;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getStrength() {
		return strength = (int)(Math.random()*6)+1;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
