import java.io.*;
import java.util.Arrays;

public class DanhSachSanPham implements IDanhSach{
    private static final String FILE_NAME_SP = "DanhSachSanPham.txt";

    SanPham[] dsSanPham = new SanPham[1];

    @Override
    public void them() {
        try {
            File file = new File(FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            System.out.println("Nhap so luong san pham can them: ");
            int slTemp = QuanLyCuaHang.sc.nextInt();
            for (int i = 1; i<= slTemp; i++) {
                System.out.println("===Chon loai san pham can them: ===");
                System.out.println("1. Laptop");
                System.out.println("2. Phu kien");
                System.out.println("3. Tai nghe/Loa");
                System.out.print("Nhap:");
                int luaChonSp = QuanLyCuaHang.sc.nextInt();

                if (luaChonSp == 1) {
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

                    Laptop sp = new Laptop();
                    sp.nhap();

                    fr.write(sp.toString());
                    fr.newLine();
                    fr.close();

                    System.out.println("-Them san pham thanh cong-");
                }
                if (luaChonSp == 2) {
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

                    PhuKien sp = new PhuKien();
                    sp.nhap();

                    fr.write(sp.toString());
                    fr.newLine();
                    fr.close();

                    System.out.println("-Them san pham thanh cong-");
                }
                if (luaChonSp == 3) {
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

                    TaiNgheLoa sp = new TaiNgheLoa();
                    sp.nhap();

                    fr.write(sp.toString());
                    fr.newLine();
                    fr.close();

                    System.out.println("-Them san pham thanh cong-");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua() {

    }

    @Override
    public void xoa() {

    }

    @Override
    public void xuat() {

    }
}
