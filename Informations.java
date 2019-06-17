import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Informations {
	private int n;
	private int k;
	private int cc;
	private int cv;
	private int b = 4;
	private static Informations info = new Informations();

	private Informations() {}

	public void beginInfo() throws IOException {

		FileReader arq = new FileReader("C:\\Users\\maluf\\Desktop\\Bagunça\\Containers\\src\\enviroment_01");

		BufferedReader lerArq = new BufferedReader(arq);

		String[] info = lerArq.readLine().split(",");

		this.n = Integer.parseInt(info[0]);
		this.k = Integer.parseInt(info[1]);
		this.cc = Integer.parseInt(info[2]);
		this.cv = Integer.parseInt(info[3]);

		lerArq.close();
	}

	public void beginProducts() throws IOException {

		FileReader arq = new FileReader("C:\\Users\\maluf\\Desktop\\Bagunça\\Containers\\src\\products_01");

		BufferedReader lerArq = new BufferedReader(arq);
		int i = 0;
		String linha = lerArq.readLine();

		while (linha != null) {
			String[] infoProduct = linha.split(",");

			double volume = Double.parseDouble(infoProduct[0]);
			double weight = Double.parseDouble(infoProduct[1]);
			double value = Double.parseDouble(infoProduct[2]);

			Containers.getContainers().getProducts()[i] = new Product(i, volume, weight, value);

			linha = lerArq.readLine();
			i++;
		}

		lerArq.close();
	}

	public int getN() {
		return n;
	}

	public int getK() {
		return k;
	}

	public int getCc() {
		return cc;
	}

	public int getCv() {
		return cv;
	}

	public int getB() {
		return b;
	}

	public static Informations getInfo() {
		return info;
	}
}
