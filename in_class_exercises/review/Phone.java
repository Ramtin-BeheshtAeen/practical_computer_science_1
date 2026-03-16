

class Phone{
    String brand;
    // Parent Constructor
    Phone(String brand){
        this.brand = brand;
        System.out.println("Brand Set to:" + this.brand);
    }
}


class SmartPhone extends Phone{
    double screenSize;
    //Child Constructor
    SmartPhone(String brand, double screenSize) {
        super(brand);
        this.screenSize = screenSize;
        System.out.println("screen size set to: " + this.screenSize);
    }

}