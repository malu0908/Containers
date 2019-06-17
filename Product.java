
public class Product implements Comparable<Product> {
	private int id;
	private double volume;
	private double weight;
	private double value;

	public Product(int id, double volume, double weight, double value) {
		this.id = id;
		this.volume = volume;
		this.weight = weight;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}

	public double getVolume() {
		return volume;
	}

	public double getWeight() {
		return weight;
	}

	public double getValue() {
		return value;
	}

	@Override
	public int compareTo(Product product) {
		if (this.value < product.value)
			return -1;
		else if (this.value > product.value)
			return 1;
		return 0;
	}
}
