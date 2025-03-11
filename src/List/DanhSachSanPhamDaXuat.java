package List;

import Class.Laptop;
import Class.PhuKien;
import Class.SanPham;
import Class.TaiNgheLoa;
import Interface.IDanhSach;
import StaticMethod.StaticMethod;

import java.io.*;
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
        SanPham[] dsSanPhamTemp = new SanPham[0];
        try {
            File file = new File(StaticMethod.FILE_NAME_SPDX);

            if (!file.exists()) {
                file.createNewFile();
            }

            dsSanPhamTemp = Arrays.copyOf(dsSanPhamTemp, dsSanPham.length);

            BufferedReader ft = new BufferedReader(new FileReader(file));

            for (int i = 0; i < dsSanPhamTemp.length; i++) {
                dsSanPhamTemp[i] = dsSanPham[i];
                if (dsSanPham[i] instanceof Laptop) {
                    Laptop temp = (Laptop) dsSanPhamTemp[i];
                }
                if (dsSanPham[i] instanceof PhuKien) {
                    PhuKien temp = (PhuKien) dsSanPhamTemp[i];
                }
                if (dsSanPham[i] instanceof TaiNgheLoa) {
                    TaiNgheLoa temp = (TaiNgheLoa) dsSanPhamTemp[i];
                }
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            for (int i = 0; i < dsSanPhamTemp.length; i++) {
                if (dsSanPhamTemp[i] instanceof PhuKien || dsSanPhamTemp[i] instanceof TaiNgheLoa) {
                    fr.write(dsSanPhamTemp[i].toString() + ";" + "Khong co dung luong" + ";" + maHd);
                } else {
                    fr.write(dsSanPhamTemp[i].toString() + ";" + maHd);
                }
                fr.newLine();
            }

            fr.close();
            ft.close();
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
