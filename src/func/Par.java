package func;

public class Par {
	
	private String x;
	private Long y;
	
	public Par(String x, Long y) {
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

	public Long getY() {
		return y;
	}

	public void setY(Long y) {
		this.y = y;
	}
	
}
