package item18;

/**
* �Ե����ƿ��� �Ĵ� ���ִ� BigRib����
*/
public class BigRibBurger {
             private int price;
             private String description;
 
             public BigRibBurger(int price,String description) {
                           this.price = price;
                           this.description = description;
             }
             public BigRibBurger(int price) {
                           this(price,"best selling burger in 2002");
             }
             public BigRibBurger(String description) {
                           this(2500,description);
             }
             public BigRibBurger() {
                           this(2500,"best selling burger in 2002");
             }
             public int getPrice() {
                           return price;
             }
             public String getDescription() {
                           return description;
             }
}
