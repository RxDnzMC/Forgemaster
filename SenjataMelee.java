public class SenjataMelee extends Senjata implements IForgeable {
    private String material;

    public SenjataMelee(String nama, int damage, String material) {
        super(nama, damage);
        this.material = material;
    }

    @Override
    public void serang() {
        System.out.println(nama + " menebas musuh dengan material " + material + "!");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Tipe: Melee]");
        super.tampilkanInfo();
        System.out.println("Bahan  : " + material);
        System.out.println("--------------------");
    }

    //Method Interface
    @Override
    public void reforge(String materialBaru) {
        this.material = materialBaru;
        System.out.println(nama + " telah ditempa ulang dengan " + materialBaru);
    }

    @Override
    public void cekKualitas() {
        System.out.println("Kualitas material " + material + " masih sangat tajam!");
    }
}