public class RectangleTester {
    public static void main (String[] args) {
        //tests default constructor, getLength, getHeight, area, perimeter
        Rectangle Test1 = new Rectangle();
        System.out.println(Test1.getLength());
        System.out.println(Test1.getHeight());
        System.out.println(Test1.area());
        System.out.println(Test1.perimeter());

        //tests alternate constructor, setLength, setHeight
        Rectangle Test2 = new Rectangle(10.0, 5.0, 3.0, 2.0);
        System.out.println(Test2.getLength());
        System.out.println(Test2.getHeight());
        Test2.setLength(12.0);
        Test2.setHeight(16.2);
        System.out.println(Test2.getLength());
        System.out.println(Test2.getHeight());

    }
}
