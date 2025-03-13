package List;

import Interface.IDanhSach;
import StaticMethod.StaticMethod;
import Class.Laptop;
import Class.PhuKien;
import Class.TaiNgheLoa;
import Class.PhieuNhap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DanhSachPhieuNhap implements IDanhSach {
    @Override
    public void them() {

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

    public void themPn(String maQl) {
        try {
            File file_sp = new File(StaticMethod.FILE_NAME_SP);
            File file_pn = new File(StaticMethod.FILE_NAME_PN);

            if (!file_sp.exists()) {
                file_sp.createNewFile();
            }

            if (!file_pn.exists()) {
                file_pn.createNewFile();
            }

            System.out.println("--Nhap so luong san pham can nhap: ");
            int slTemp = StaticMethod.sc.nextInt();
            for (int i = 1; i <= slTemp; i++) {
                System.out.println("--Nhap thong tin san pham thu: " + i);
                System.out.println("===Chon loai san pham can them: ===");
                System.out.println("1. Laptop");
                System.out.println("2. Phu kien");
                System.out.println("3. Tai nghe/Loa");
                System.out.print("--Nhap:");
                int luaChonSp = StaticMethod.sc.nextInt();

                if (luaChonSp == 1) {
                    BufferedWriter fr_sp = new BufferedWriter(new FileWriter(file_sp, true));
                    BufferedWriter fr_pn = new BufferedWriter(new FileWriter(file_pn, true));

                    Laptop sp = new Laptop();
                    sp.nhapDeNhapHang();

                    PhieuNhap pn = new PhieuNhap();
                    pn.nhapKhiQLNhap(sp.getMaSp(), sp.getTenSp(), sp.getSoLuong(), sp.getGiaBanDau(), sp.getMoTa(), sp.getMauSac(), sp.getLoaiSp(), sp.getGiaVon(), maQl);

                    fr_sp.write(sp.toStringGiaVon());
                    fr_sp.newLine();
                    fr_sp.close();

                    fr_pn.write(pn.toString());
                    fr_pn.newLine();
                    fr_pn.close();

                    System.out.println("-Nhap san pham thanh cong-");
                }
                if (luaChonSp == 2) {
                    BufferedWriter fr_sp = new BufferedWriter(new FileWriter(file_sp, true));
                    BufferedWriter fr_pn = new BufferedWriter(new FileWriter(file_pn, true));

                    PhuKien sp = new PhuKien();
                    sp.nhapDeNhapHang();

                    PhieuNhap pn = new PhieuNhap();
                    pn.nhapKhiQLNhap(sp.getMaSp(), sp.getTenSp(), sp.getSoLuong(), sp.getGiaBanDau(), sp.getMoTa(), sp.getMauSac(), sp.getLoaiSp(), sp.getGiaVon(), maQl);

                    fr_sp.write(sp.toStringGiaVon());
                    fr_sp.newLine();
                    fr_sp.close();

                    fr_pn.write(pn.toString());
                    fr_pn.newLine();
                    fr_pn.close();

                    System.out.println("-Nhap san pham thanh cong-");
                }
                if (luaChonSp == 3) {
                    BufferedWriter fr_sp = new BufferedWriter(new FileWriter(file_sp, true));
                    BufferedWriter fr_pn = new BufferedWriter(new FileWriter(file_pn, true));

                    TaiNgheLoa sp = new TaiNgheLoa();
                    sp.nhapDeNhapHang();

                    PhieuNhap pn = new PhieuNhap();
                    pn.nhapKhiQLNhap(sp.getMaSp(), sp.getTenSp(), sp.getSoLuong(), sp.getGiaBanDau(), sp.getMoTa(), sp.getMauSac(), sp.getLoaiSp(), sp.getGiaVon(), maQl);

                    fr_sp.write(sp.toStringGiaVon());
                    fr_sp.newLine();
                    fr_sp.close();

                    fr_pn.write(pn.toString());
                    fr_pn.newLine();
                    fr_pn.close();

                    System.out.println("-Nhap san pham thanh cong-");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
