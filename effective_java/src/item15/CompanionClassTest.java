package item15;

public class CompanionClassTest {
	public static void main(String args[]) {
		MainCoffee mc1 = MainCoffee.makeMainCoffee();
		MainCoffee mc2 = mc1.plusOneShot();
		System.out.println(mc1);
		System.out.println(mc2);

		MainCoffee mc3 = MainCoffee.modifiableMainCoffee(mc1);
		System.out.println(mc3);
		/**
		 * [ 9floorCoffee, 1 ] [ 9floorCoffee, 2 ] [ 9floorCoffee, 2 ]
		 */
	}
}
