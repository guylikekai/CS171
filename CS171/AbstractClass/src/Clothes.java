public abstract class Clothes {

    protected String material;

    public Clothes(){

    }

    public void setMaterial (String material) {
        this.material = material;
    }

    public abstract void upperBodyWear(); //shirt, blouse, etc

    public abstract void lowerBodyWear(); //pants, shorts, etc

}
