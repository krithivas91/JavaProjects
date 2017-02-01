package draw;
public class Circle implements Shapes

{
	int radius;
	String name;
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String toString()
	{
		return "Circle with radius "+radius+" is drawn";
	}
}
