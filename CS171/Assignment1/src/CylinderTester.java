public class CylinderTester {
    public static void main(String[] args) {

        //tests default constructor, alternate constructor, getHeight, setHeight, getArea (Override), getVolume
        Cylinder cylinder = new Cylinder();
        Cylinder cylinder1 = new Cylinder(4.0,22.0,5.0,14.0, 13.0);
        Circle cylinder2 = new Cylinder();


        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getHeight());
        System.out.println(cylinder1.getHeight());
        cylinder.setHeight(10.0);
        System.out.println(cylinder.getHeight());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder1.getArea());

        //tests override function in getArea, getVolume
        System.out.println(cylinder2.getArea());
        System.out.println(cylinder.getVolume());
    }
}
