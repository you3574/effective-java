package item15;

final class MainCoffee {
	final private String basicCoffee;
	final private int basicShot;

	MainCoffee(String basicCoffee, int basicShot) {
		this.basicCoffee = basicCoffee;
		this.basicShot = basicShot;
	}

	public String kindOfCoffee() {
		return this.basicCoffee;
	}

	public int countOfShot() {
		return this.basicShot;
	}

	public static MainCoffee makeMainCoffee() {
		return new MainCoffee("asdad", 1);
	}

	public MainCoffee plusOneShot() {
		return new MainCoffee(this.basicCoffee, this.basicShot + 1);
	}

	public ChainCoffee makeChainCoffee() {
		return new ChainCoffee(this.basicCoffee, this.basicShot);
	}

	public static MainCoffee modifiableMainCoffee(MainCoffee mc) {
		ChainCoffee cc = mc.makeChainCoffee();
		cc.plusOneShot();
		return cc.makeMainCoffee();
	}

}
