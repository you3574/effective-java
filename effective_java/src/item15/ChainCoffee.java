package item15;

public class ChainCoffee {
	final private String basicCoffee;
	private int basicShot;

	public ChainCoffee(String basicCoffee, int basicShot) {
		this.basicCoffee = basicCoffee;
		this.basicShot = basicShot;
	}

	public ChainCoffee plusOneShot() {
		this.basicShot += 1;
		return this;
	}

	// support Immutable class
	public MainCoffee makeMainCoffee() {
		return new MainCoffee(this.basicCoffee, this.basicShot);
	}

	public ChainCoffee makeChainCoffee() {
		return new ChainCoffee(this.basicCoffee, this.basicShot);
	}
}
