public class SummerClothes extends Clothes{
     //material = "cotton";

    public SummerClothes(){
    };

    @Override
    public void setMaterial(String mat) {
        material = "cotton";
        System.out.println("cotton");
    }

    public void upperBodyWear(){
        System.out.println("upper body wear");
    }

    public void lowerBodyWear() {
        System.out.println("lower body wear");
    }
}
