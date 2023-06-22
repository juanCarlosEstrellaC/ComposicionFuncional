package func;

public class Par {
	
	private String x;
	private Integer y;
	
	public Par(String x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Par (" + x + "," + y + ")";
	}

	// GET Y SET
	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	
	
	
	

}
