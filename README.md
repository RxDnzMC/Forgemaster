# FORGEMASTER - Aplikasi Inventaris Senjata

**Mata Kuliah:** Pemrograman Berorientasi Objek (PBO)
**Topik:** Abstract Class, Interface, Inheritance, Polymorphism, Encapsulation

---

# Daftar Isi

* [Deskripsi Program](#deskripsi-program)
* [Fitur Program](#fitur-program)
* [Konsep OOP yang Diterapkan](#konsep-oop-yang-diterapkan)
* [Struktur Program](#struktur-program)
* [Diagram Inheritance](#diagram-inheritance)
* [Cara Menjalankan](#cara-menjalankan)
* [Contoh Penggunaan](#contoh-penggunaan)
* [Analisis Implementasi OOP](#analisis-implementasi-oop)
* [Error Handling](#error-handling)
* [Kelebihan Program](#kelebihan-program)
* [Pengembangan Selanjutnya](#pengembangan-selanjutnya)
* [Screenshot Program](#screenshot-program)
* [Identitas Pembuat](#identitas-pembuat)

---

# Deskripsi Program

**FORGEMASTER PRO** adalah aplikasi berbasis console untuk mengelola inventaris senjata. Program ini dirancang sebagai implementasi konsep-konsep Pemrograman Berorientasi Objek (PBO) seperti Abstract Class, Interface, Inheritance, Polymorphism, Encapsulation, Perulangan, Percabangan, dan Error Handling.

Program memungkinkan pengguna untuk:

* Menambahkan senjata melee (pedang, golok, kapak, dan sebagainya)
* Menambahkan senjata range (busur, panah, crossbow, dan sebagainya)
* Melihat inventaris senjata
* Melakukan simulasi serangan
* Melakukan upgrade damage
* Melakukan reforge atau tempa ulang senjata

---

# Fitur Program

| No | Fitur                | Keterangan                       |
| -- | -------------------- | -------------------------------- |
| 1  | Tambah Senjata Melee | Input nama, damage, dan material |
| 2  | Tambah Senjata Range | Input nama, damage, dan jarak    |
| 3  | Lihat Inventaris     | Menampilkan seluruh senjata      |
| 4  | Tes Serang           | Menjalankan method serang()      |
| 5  | Upgrade Senjata      | Menambah damage                  |
| 6  | Reforge Senjata      | Tempa ulang senjata              |
| 7  | Error Handling       | Menangani kesalahan input        |

---

# Konsep OOP yang Diterapkan

## 1. Abstract Class

Class `Senjata` digunakan sebagai abstract class yang menjadi parent dari seluruh jenis senjata.

## 2. Interface

Interface `IForgeable` digunakan untuk memberikan kemampuan reforge pada setiap senjata.

## 3. Inheritance

Class `SenjataMelee` dan `SenjataRange` mewarisi class `Senjata`.

## 4. Polymorphism

Program menerapkan:

* Method Overriding
* Method Overloading

## 5. Encapsulation

Data pada class disimpan menggunakan access modifier.

## 6. Looping

Menggunakan `while(true)` untuk menampilkan menu berulang.

## 7. Percabangan

Menggunakan:

* Switch Case
* If Else

## 8. Error Handling

Menggunakan `try-catch` untuk menangani kesalahan input.

---

# Struktur Program

```text
FORGEMASTER_PRO
│
├── Main.java
├── Senjata.java
├── SenjataMelee.java
├── SenjataRange.java
└── IForgeable.java
```

## Penjelasan File

| File              | Fungsi                    |
| ----------------- | ------------------------- |
| Main.java         | Program utama             |
| Senjata.java      | Abstract class            |
| SenjataMelee.java | Class senjata jarak dekat |
| SenjataRange.java | Class senjata jarak jauh  |
| IForgeable.java   | Interface reforge         |

---

# Diagram Inheritance

```text
                 +----------------+
                 |    Senjata     |
                 |   (Abstract)   |
                 +----------------+
                        ▲
            ┌───────────┴───────────┐
            │                       │
            │                       │
+--------------------+   +--------------------+
|   SenjataMelee     |   |   SenjataRange     |
+--------------------+   +--------------------+
            ▲                       ▲
            │                       │
            └───────────┬───────────┘
                        │
                +---------------+
                |  IForgeable   |
                | (Interface)   |
                +---------------+
```

---

# Cara Menjalankan

## Compile Program

```bash
javac *.java
```

## Jalankan Program

```bash
java Main
```

---

# Contoh Penggunaan

## Menu Utama

```text
--- FORGEMASTER PRO (Abstract & Interface) ---

1. Tambah Senjata Melee
2. Tambah Senjata Range
3. Lihat Inventaris & Tes Serang
4. Upgrade Senjata
5. Tempa Ulang / Reforge
6. Keluar
```

---

## Menambah Senjata Melee

```text
Nama Pedang : Excalibur
Damage      : 50
Bahan       : Mithril

✅ Senjata Melee berhasil ditambahkan!
```

---

## Menambah Senjata Range

```text
Nama Busur : Longbow
Damage     : 35
Jarak      : 100

✅ Senjata Range berhasil ditambahkan!
```

---

## Menampilkan Inventaris

```text
[Tipe: Melee]
Nama   : Excalibur
Damage : 50
Bahan  : Mithril

Excalibur menebas musuh dengan material Mithril!
```

---

## Upgrade Senjata

```text
Nomor senjata : 1
Tambahan damage : 10

✅ Upgrade berhasil! Damage +10
```

---

## Reforge Senjata

```text
Kualitas material Mithril masih sangat tajam!

Material baru : Dragon Steel

Excalibur telah ditempa ulang dengan Dragon Steel

✅ Reforge berhasil dilakukan!
```

---

# Analisis Implementasi OOP

## Abstract Class

Abstract class digunakan sebagai blueprint dasar seluruh senjata.

```java
public abstract class Senjata {
    protected String nama;
    protected int damage;

    public abstract void serang();
}
```

### Tujuan

* Menjadi kerangka dasar seluruh senjata
* Memaksa subclass membuat implementasi serang()

---

## Interface

```java
public interface IForgeable {
    void reforge(String materialBaru);
    void cekKualitas();
}
```

### Tujuan

Memberikan kemampuan reforge pada berbagai jenis senjata.

---

## Inheritance

```java
public class SenjataMelee extends Senjata
```

```java
public class SenjataRange extends Senjata
```

### Tujuan

Mewarisi atribut dan method dari class Senjata.

---

## Encapsulation

```java
protected String nama;
protected int damage;
```

```java
private String material;
```

```java
private int jarak;
```

### Tujuan

Melindungi data internal objek.

---

## Runtime Polymorphism

Method `serang()` dioverride oleh masing-masing subclass.

```java
@Override
public void serang() {
    System.out.println(nama +
    " menebas musuh dengan material " +
    material + "!");
}
```

```java
@Override
public void serang() {
    System.out.println(nama +
    " menembak dari jarak " +
    jarak + " meter!");
}
```

---

## Compile-Time Polymorphism

Method overloading pada upgrade.

```java
public void upgrade()
```

```java
public void upgrade(int tambahan)
```

---

## Looping

```java
while(true)
```

Digunakan untuk menampilkan menu berulang hingga user memilih keluar.

---

## Percabangan

### Switch Case

```java
switch(pilihanMenu)
```

Digunakan untuk navigasi menu.

### If Else

```java
if(listSenjata.isEmpty())
```

Digunakan untuk validasi kondisi.

---

# Error Handling

Program menggunakan `try-catch`.

Contoh:

```java
try {
    pilihanMenu = input.nextInt();
}
catch(Exception e) {
    System.out.println(
    "❌ Error: Harus memasukkan angka!"
    );
}
```

Validasi yang diterapkan:

* Nama tidak boleh kosong
* Damage minimal 1
* Jarak minimal 1
* Tambahan damage tidak boleh negatif
* Nomor senjata harus valid
* Material baru tidak boleh kosong

---

# Kelebihan Program

* Menerapkan seluruh konsep dasar PBO
* Menggunakan Abstract Class dan Interface sekaligus
* Terdapat Error Handling
* Mudah dipahami
* Struktur kode sederhana
* Mudah dikembangkan

---

# Pengembangan Selanjutnya

Beberapa fitur yang dapat ditambahkan:

1. Penyimpanan file
2. Database MySQL
3. Sistem rarity
4. Sistem durability
5. Hapus senjata
6. Edit senjata
7. Sorting inventaris
8. Searching senjata
9. GUI Java Swing
10. GUI JavaFX

---

# Kesimpulan

FORGEMASTER PRO berhasil mengimplementasikan berbagai konsep utama Pemrograman Berorientasi Objek (PBO) seperti Abstract Class, Interface, Inheritance, Polymorphism, Encapsulation, Looping, Percabangan, dan Error Handling.

Melalui aplikasi ini, pengguna dapat mengelola inventaris senjata, melakukan simulasi serangan, meningkatkan damage, dan melakukan reforge dengan struktur program yang modular dan mudah dikembangkan.

Program ini menunjukkan bagaimana konsep-konsep OOP dapat diterapkan secara nyata dalam pengembangan perangkat lunak sederhana.

---

# Identitas Pembuat

**Nama:** [Nama Mahasiswa]
**NIM:** [NIM Mahasiswa]
**Program Studi:** Teknik Informatika
**Mata Kuliah:** Pemrograman Berorientasi Objek
**Universitas:** Universitas Mulawarman

---
