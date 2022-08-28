public class Device {
    private String name;
    private String kind;
    private String brand;

    public Device(String name, String kind, String brand) {
        this.name = name;
        this.kind = kind;
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getBrand() {
        return brand;
    }

    public void showInfo() {
        System.out.println("Nombre: " + name);
        System.out.println("Tipo: " + kind);
        System.out.println("Marca: " + brand);
    }
}
