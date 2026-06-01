//keyword abstract
public abstract class Senjata {
    protected String nama;
    protected int damage;

    public Senjata(String nama, int damage) {
        this.nama = nama;
        this.damage = damage;
    }

    //overload
    public void upgrade() {
        this.damage += 5;
    }

    //overload
    public void upgrade(int tambahan) {
        this.damage += tambahan;
    }

    public void tampilkanInfo() {
        System.out.println("Nama   : " + nama);
        System.out.println("Damage : " + damage);
    }

    //abstract: setiap subclasss wajib implemen cara nyerang yang beda
    public abstract void serang();
}