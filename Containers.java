import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Containers {
	private Product products[];
	private static Containers containers = new Containers();

	private Containers() {}

	public static Containers getContainers() {
		return containers;
	}

	public Product[] getProducts() throws IOException {
		if (products == null) {
			Informations.getInfo().beginInfo();
			products = new Product[Informations.getInfo().getN()];
			Informations.getInfo().beginProducts();
		}
		return products;
	}

	public double calculaPreco(ArrayList<Product> container) {
		double soma = 0.0;
		for (int w = 0; w < container.size(); w++) {
			soma += container.get(w).getValue();
		}
		return soma;
	}

	public void startAlgorithm() throws IOException {
		boolean alreadyGone[] = new boolean[products.length];

		if (products != null) {
			Arrays.sort(products);

			ArrayList<Product> container = new ArrayList<Product>();
			double pesoTotal = 0.0;
			double volumeTotal = 0.0;

			double somaTotal = 0.0;
			for (int j = 0; j < Informations.getInfo().getK(); j++) {
				for (int i = products.length - 1; i >= 0; i--) {
					if (pesoTotal + products[i].getWeight() <= Informations.getInfo().getCc()
							&& volumeTotal + products[i].getVolume() <= Informations.getInfo().getCv()
							&& alreadyGone[i] == false) {
						container.add(products[i]);

						alreadyGone[i] = true;
						pesoTotal += products[i].getWeight();
						volumeTotal += products[i].getVolume();

					}
				}
				System.out.println("Printando container " + (j + 1) + "...");
				System.out.println();
				System.out.println("Peso total: " + pesoTotal);
				System.out.println("Volume total: " + volumeTotal);
				int w;
				for (w = 0; w < container.size(); w++) {
					System.out.println("Product " + container.get(w).getId() + ": " + container.get(w).getVolume() + " "
							+ container.get(w).getWeight() + " " + container.get(w).getValue());
				}
				double value = calculaPreco(container);
				System.out.println("Total de produtos no container " + (j + 1) + ": " + w);
				System.out.println("Valor total no container " + (j + 1) + ": " + value);
				System.out.println();
				somaTotal += value;
				container.clear();
				pesoTotal = 0;
				volumeTotal = 0;
			}
			System.out.println();
			System.out.println("Valor total transportado: " + somaTotal);

			System.out.println();
			System.out.println("Os seguintes produtos não foram transportados");
			for (int i = 0; i < products.length; i++) {
				if (alreadyGone[i] == false)
					System.out.print(products[i].getId() + " ");
			}
		}
	}
}
