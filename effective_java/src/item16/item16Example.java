package item16;

public class item16Example {
    private static class InnerNested {
        public String memberField="Asdasd";
    }
    public void somePrint() {
        InnerNested instance = new InnerNested();
        System.out.println(instance.memberField);
    }
}
