public class SenjataRange extends Senjata implements IForgeable {
    private int jarak;

    public SenjataRange(String nama, int damage, int jarak) {
        super(nama, damage);
        this.jarak = jarak;
    }

    // Getter (Encapsulation)
    public int getJarak() {
        return jarak;
    }

    @Override
    public void serang() {
        System.out.println(nama + " menembak dari jarak " + jarak + " meter!");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Tipe: Range]");
        super.tampilkanInfo();
        System.out.println("Jarak  : " + jarak + " meter");
        System.out.println("--------------------");
    }

    // Implementasi Method Interface
    @Override
    public void reforge(String tipeString) {
        this.damage += 10;
        System.out.println(nama + " telah dikalibrasi ulang! Damage meningkat.");
    }

    @Override
    public void cekKualitas() {
        System.out.println("Tali busur/mekanisme " + nama + " dalam kondisi prima.");
    }
}