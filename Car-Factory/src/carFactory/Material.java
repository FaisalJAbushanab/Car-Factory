package carFactory;

// using java.util.Random;

import java.util.Random;

public class Material {

	// [alamnuim, plastic, glass, silicon, gold, copper, iron, chrome, silver]

	private int[] materialQuantity = new int[9];
	private double[] materialPrice = new double[9];

	public Material() {

		// Generate random materialQuantity value for [alamnuim]
		materialQuantity[0] = random_materialQuantity(100000, 800000);

		// Generate random materialQuantity value for [plastic]
		materialQuantity[1] = random_materialQuantity(100000, 800000);

		// Generate random materialQuantity value for [ glass]
		materialQuantity[2] = random_materialQuantity(100000, 800000);

		// Generate random materialQuantity value for [ silicon]
		materialQuantity[3] = random_materialQuantity(100000, 800000);

		// Generate random materialQuantity value for [ gold]
		materialQuantity[4] = random_materialQuantity(50000, 100000);

		// Generate random materialQuantity value for [ copper]
		materialQuantity[5] = random_materialQuantity(100000, 400000);

		// Generate random materialQuantity value for [ iron]
		materialQuantity[6] = random_materialQuantity(10000, 800000);

		// Generate random materialQuantity value for [ chrom ]
		materialQuantity[7] = random_materialQuantity(100000, 500000);

		// Generate random materialQuantity value for [ silver]
		materialQuantity[8] = random_materialQuantity(200000, 400000);

		// -----------------------------------------------------------------------------//

		// Generate random materialPrice value for [alamnuim]
		materialPrice[0] = random_materialPrice(0.02, 0.05);

		// Generate random materialPrice value for [ plastic]
		materialPrice[1] = random_materialPrice(0.01, 0.03);

		// Generate random materialPrice value for [ glass]
		materialPrice[2] = random_materialPrice(0.05, 0.08);

		// Generate random materialPrice value for [ silicon]
		materialPrice[3] = random_materialPrice(0.03, 0.06);

		// Generate random materialPrice value for gold]
		materialPrice[4] = random_materialPrice(570, 600);

		// Generate random materialPrice value for [ copper]
		materialPrice[5] = random_materialPrice(0.09, 0.15);

		// Generate random materialPrice value for [ iron]
		materialPrice[6] = random_materialPrice(0.007, 0.009);

		// Generate random materialPrice value for [ chrome]
		materialPrice[7] = random_materialPrice(0.3, 0.8);

		// Generate random materialPrice value for[silver]
		materialPrice[8] = random_materialPrice(7.5, 9.5);

	}

	public int random_materialQuantity(int min, int max) {

		return (int) Math.floor(Math.random() * (max - min + 1) + min);

	}

	public double random_materialPrice(double min, double max) {

		double random = new Random().nextDouble();
		return min + (random * (max - min));
	}

	public int[] getMaterialQuantity() {

		return materialQuantity;
	}

	public void setMaterialQuantity(int[] materialQuantity) {

		this.materialQuantity = materialQuantity;
	}

	public double[] getMaterialPrice() {

		return materialPrice;
	}

	public void setMaterialPrice(double[] MaterialPrice) {

		this.materialPrice = MaterialPrice;

	}
}
