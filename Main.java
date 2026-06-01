import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Senjata> listSenjata = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- FORGEMASTER PRO (Abstract & Interface) ---");
            System.out.println("1. Tambah Senjata Melee");
            System.out.println("2. Tambah Senjata Range");
            System.out.println("3. Lihat Inventaris & Tes Serang (Abstract)");
            System.out.println("4. Upgrade Senjata (Overload)");
            System.out.println("5. Tempa Ulang / Reforge (Interface)");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            
            int pilihanMenu = 0;
            // Error handling untuk input menu
            try {
                pilihanMenu = input.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Error: Harus memasukkan angka!");
                input.nextLine();
                continue;
            }
            input.nextLine();

            switch (pilihanMenu) {
                case 1: {
                    try {
                        System.out.print("Nama Pedang: "); 
                        String namaPedang = input.nextLine();
                        
                        // Validasi nama tidak boleh kosong
                        if (namaPedang.trim().isEmpty()) {
                            System.out.println("❌ Error: Nama pedang tidak boleh kosong!");
                            break;
                        }
                        
                        System.out.print("Damage: "); 
                        int damagePedang = input.nextInt();
                        
                        // Validasi damage minimal 1
                        if (damagePedang < 1) {
                            System.out.println("❌ Error: Damage minimal 1!");
                            input.nextLine();
                            break;
                        }
                        
                        input.nextLine();
                        System.out.print("Bahan: "); 
                        String bahanPedang = input.nextLine();
                        
                        // Validasi bahan tidak boleh kosong
                        if (bahanPedang.trim().isEmpty()) {
                            System.out.println("❌ Error: Bahan pedang tidak boleh kosong!");
                            break;
                        }
                        
                        listSenjata.add(new SenjataMelee(namaPedang, damagePedang, bahanPedang));
                        System.out.println("✅ Senjata Melee berhasil ditambahkan!");
                    } catch (Exception e) {
                        System.out.println("❌ Error: Input tidak valid! Damage harus berupa angka.");
                        input.nextLine();
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Nama Busur: "); 
                        String namaBusur = input.nextLine();
                        
                        if (namaBusur.trim().isEmpty()) {
                            System.out.println("❌ Error: Nama busur tidak boleh kosong!");
                            break;
                        }
                        
                        System.out.print("Damage: "); 
                        int damageBusur = input.nextInt();
                        
                        if (damageBusur < 1) {
                            System.out.println("❌ Error: Damage minimal 1!");
                            input.nextLine();
                            break;
                        }
                        
                        System.out.print("Jarak: "); 
                        int jarakBusur = input.nextInt();
                        
                        if (jarakBusur < 1) {
                            System.out.println("❌ Error: Jarak minimal 1 meter!");
                            input.nextLine();
                            break;
                        }
                        
                        input.nextLine();
                        listSenjata.add(new SenjataRange(namaBusur, damageBusur, jarakBusur));
                        System.out.println("✅ Senjata Range berhasil ditambahkan!");
                    } catch (Exception e) {
                        System.out.println("❌ Error: Input tidak valid! Damage dan Jarak harus berupa angka.");
                        input.nextLine();
                    }
                    break;
                }
                case 3: {
                    if (listSenjata.isEmpty()) {
                        System.out.println("⚠️ Inventaris kosong! Tambahkan senjata terlebih dahulu.");
                    } else {
                        System.out.println("\n=== DAFTAR INVENTARIS SENJATA ===");
                        for (int i = 0; i < listSenjata.size(); i++) {
                            System.out.println("\n[" + (i+1) + "]");
                            listSenjata.get(i).tampilkanInfo();
                            listSenjata.get(i).serang();
                        }
                    }
                    break;
                }
                case 4: {
                    if (listSenjata.isEmpty()) {
                        System.out.println("⚠️ Tidak ada senjata untuk di-upgrade!");
                        break;
                    }
                    
                    try {
                        System.out.print("Nomor senjata (1-" + listSenjata.size() + "): "); 
                        int indeksSenjata = input.nextInt() - 1;
                        
                        // Validasi indeks
                        if (indeksSenjata < 0 || indeksSenjata >= listSenjata.size()) {
                            System.out.println("❌ Error: Nomor senjata tidak valid!");
                            break;
                        }
                        
                        System.out.print("Tambahan damage (0 untuk default +5): ");
                        int tambahanDamage = input.nextInt();
                        
                        // Validasi tambahan damage tidak boleh negatif
                        if (tambahanDamage < 0) {
                            System.out.println("❌ Error: Tambahan damage tidak boleh negatif!");
                            break;
                        }
                        
                        if (tambahanDamage > 0) {
                            listSenjata.get(indeksSenjata).upgrade(tambahanDamage);
                            System.out.println("✅ Upgrade berhasil! Damage +" + tambahanDamage);
                        } else {
                            listSenjata.get(indeksSenjata).upgrade();
                            System.out.println("✅ Upgrade berhasil! Damage +5 (default)");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Error: Input tidak valid! Harus memasukkan angka.");
                        input.nextLine();
                    }
                    break;
                }
                case 5: {
                    if (listSenjata.isEmpty()) {
                        System.out.println("⚠️ Tidak ada senjata untuk di-reforge!");
                        break;
                    }
                    
                    try {
                        System.out.print("Nomor senjata (1-" + listSenjata.size() + "): "); 
                        int indeksReforge = input.nextInt() - 1;
                        
                        if (indeksReforge < 0 || indeksReforge >= listSenjata.size()) {
                            System.out.println("❌ Error: Nomor senjata tidak valid!");
                            break;
                        }
                        
                        input.nextLine();
                        
                        Senjata senjataPilihan = listSenjata.get(indeksReforge);
                        if (senjataPilihan instanceof IForgeable) {
                            IForgeable forgeable = (IForgeable) senjataPilihan;
                            forgeable.cekKualitas();
                            System.out.print("Material baru: ");
                            String materialBaru = input.nextLine();
                            
                            if (materialBaru.trim().isEmpty()) {
                                System.out.println("❌ Error: Material baru tidak boleh kosong!");
                                break;
                            }
                            
                            forgeable.reforge(materialBaru);
                            System.out.println("✅ Reforge berhasil dilakukan!");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Error: Input tidak valid!");
                        input.nextLine();
                    }
                    break;
                }
                case 6: {
                    System.out.println("👋 Terima kasih telah menggunakan FORGEMASTER PRO!");
                    input.close();
                    return;
                }
                default: {
                    System.out.println("❌ Pilihan tidak valid! Silakan pilih 1-6.");
                }
            }
        }
    }
}