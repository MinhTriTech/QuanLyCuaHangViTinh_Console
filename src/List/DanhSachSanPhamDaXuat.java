package List;

import Class.Laptop;
import Class.PhuKien;
import Class.SanPham;
import Class.TaiNgheLoa;
import Interface.IDanhSach;
import StaticMethod.StaticMethod;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DanhSachSanPhamDaXuat implements IDanhSach {
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

    public void themDanhSachVaoFile(SanPham[] dsSanPham, String maHd) {
        try {
            File file = new File(StaticMethod.FILE_NAME_SPDX);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            for (SanPham sp : dsSanPham) {
                if (sp instanceof Laptop) {
                    Laptop laptop = (Laptop) sp;
                    fr.write(laptop.toString() + ";" + maHd);
                } else if (sp instanceof PhuKien || sp instanceof TaiNgheLoa) {
                    fr.write(sp.toString() + ";" + "Khong co dung luong" + ";" + maHd);
                }
                fr.newLine();
            }

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatChiTietHoaDon(String maHd) {
        StaticMethod.xuatHeaderSp();
        try {
            String st;

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SPDX));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if(s[10].equals(maHd)) {
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(s[10].equals(maHd)) {
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(s[10].equals(maHd)) {
                        sp.xuatThongTinSp();
                    }
                }
            }

            br.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
