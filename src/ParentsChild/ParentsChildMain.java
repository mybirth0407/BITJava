package ParentsChild;

public class ParentsChildMain {
    public static void main(String args[]) {
        Child child = new Child();
        System.out.println(child.getChildName());
        System.out.println(child.getMomName());
        System.out.println(child.getFatherName());
    }
}