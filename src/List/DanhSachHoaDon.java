package List;

import Interface.IDanhSach;

import Class.HoaDon;
import StaticMethod.StaticMethod;

import java.io.*;
import java.util.Arrays;

public class DanhSachHoaDon implements IDanhSach {

    private HoaDon[] dsHoaDon = new HoaDon[1];
    private DanhSachSanPhamDaXuat dsSanPhamDaXuat = new DanhSachSanPhamDaXuat();

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
        try {
            String st;
            System.out.println("+--------------DANH SACH HOA DON-----------------+");
            StaticMethod.xuatHeaderHd();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[7].equals("Hoat dong")) {
                    HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    hd.xuatThongTinHd();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Các phương thức khác

    public String themHd(String maKh, String tongTien) {
        try {
            File file = new File(StaticMethod.FILE_NAME_HD);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            HoaDon hd = new HoaDon();
            System.out.println("--Nhap thong tin--");
            hd.nhap(maKh, tongTien);

            fr.write(hd.toString());
            fr.newLine();
            System.out.println("-Tao hoa don thanh cong-");

            fr.close();

            return hd.getMaHd();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDon timKiemTheoMaHdBool(String maHd) {
        try {
            String st;

            maHd = maHd.toUpperCase().trim();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                if(hd.getMaHd().equals(maHd)) {
                    return hd;
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void xuatDsHoaDonTheoMaKH(String maKh) {
        try {
            String st;
            System.out.println("+--------------DANH SACH HOA DON-----------------+");
            StaticMethod.xuatHeaderHd();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[7].equals("Hoat dong") && s[1].equals(maKh)) {
                    HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    hd.xuatThongTinHd();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatDsHoaDonTheoMaKHGiaThapDenCao(String maKh) {
        try {
            System.out.println("+--------------DANH SACH HOA DON-----------------+");
            StaticMethod.xuatHeaderHd();

            File file = new File(StaticMethod.FILE_NAME_HD);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsHoaDon = Arrays.copyOf(dsHoaDon, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsHoaDon.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if (s[7].equals("Hoat dong") && s[1].equals(maKh)) {
                        dsHoaDon[i] = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    }
                }

                for (int i = 0; i < dsHoaDon.length - 1; i++) {
                    for (int j = 0; j < dsHoaDon.length-i-1; j++) {
                        if (Double.parseDouble(dsHoaDon[j].getTongTien()) > Double.parseDouble(dsHoaDon[j + 1].getTongTien())) {
                            HoaDon temp = dsHoaDon[j];
                            dsHoaDon[j] = dsHoaDon[j + 1];
                            dsHoaDon[j + 1] = temp;
                        }
                    }
                }

                for (int i = 0; i < dsHoaDon.length; i++) {
                    dsHoaDon[i].xuatThongTinHd();
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach hoa don cua ban trong-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatDsHoaDonTheoMaKHGiaCaoDenThap(String maKh) {
        try {
            System.out.println("+--------------DANH SACH HOA DON-----------------+");
            StaticMethod.xuatHeaderHd();

            File file = new File(StaticMethod.FILE_NAME_HD);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsHoaDon = Arrays.copyOf(dsHoaDon, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsHoaDon.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if (s[7].equals("Hoat dong") && s[1].equals(maKh)) {
                        dsHoaDon[i] = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    }
                }

                for (int i = 0; i < dsHoaDon.length - 1; i++) {
                    for (int j = 0; j < dsHoaDon.length-i-1; j++) {
                        if (Double.parseDouble(dsHoaDon[j].getTongTien()) < Double.parseDouble(dsHoaDon[j + 1].getTongTien())) {
                            HoaDon temp = dsHoaDon[j];
                            dsHoaDon[j] = dsHoaDon[j + 1];
                            dsHoaDon[j + 1] = temp;
                        }
                    }
                }

                for (int i = 0; i < dsHoaDon.length; i++) {
                    dsHoaDon[i].xuatThongTinHd();
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach hoa don cua ban trong-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatDsHoaDonTheoMaKHThoiGianMoiNhat(String maKh) {
        try {
            System.out.println("+--------------DANH SACH HOA DON-----------------+");
            StaticMethod.xuatHeaderHd();

            File file = new File(StaticMethod.FILE_NAME_HD);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsHoaDon = Arrays.copyOf(dsHoaDon, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsHoaDon.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if (s[7].equals("Hoat dong") && s[1].equals(maKh)) {
                        dsHoaDon[i] = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    }
                }

                for (int i = 0; i < dsHoaDon.length - 1; i++) {
                    for (int j = 0; j < dsHoaDon.length-i-1; j++) {
                        if (StaticMethod.soSanhNgay(dsHoaDon[j].getNgayRaHd(), dsHoaDon[j+1].getNgayRaHd()) < 0) {
                            HoaDon temp = dsHoaDon[j];
                            dsHoaDon[j] = dsHoaDon[j + 1];
                            dsHoaDon[j + 1] = temp;
                        }
                    }
                }

                for (int i = 0; i < dsHoaDon.length; i++) {
                    dsHoaDon[i].xuatThongTinHd();
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach hoa don cua ban trong-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatDsHoaDonTheoMaKHThoiGianCuNhat(String maKh) {
        try {
            System.out.println("+--------------DANH SACH HOA DON-----------------+");
            StaticMethod.xuatHeaderHd();

            File file = new File(StaticMethod.FILE_NAME_HD);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsHoaDon = Arrays.copyOf(dsHoaDon, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsHoaDon.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if (s[7].equals("Hoat dong") && s[1].equals(maKh)) {
                        dsHoaDon[i] = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    }
                }

                for (int i = 0; i < dsHoaDon.length - 1; i++) {
                    for (int j = 0; j < dsHoaDon.length-i-1; j++) {
                        if (StaticMethod.soSanhNgay(dsHoaDon[j].getNgayRaHd(), dsHoaDon[j+1].getNgayRaHd()) > 0) {
                            HoaDon temp = dsHoaDon[j];
                            dsHoaDon[j] = dsHoaDon[j + 1];
                            dsHoaDon[j + 1] = temp;
                        }
                    }
                }

                for (int i = 0; i < dsHoaDon.length; i++) {
                    dsHoaDon[i].xuatThongTinHd();
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach hoa don cua ban trong-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoMaHd() {
        try {
            String st, maHd;
            boolean check = false;
            System.out.println("Nhap ma hoa don ban muon tim:");
            maHd = StaticMethod.sc.nextLine();
            maHd = maHd.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderHd();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[7].equals("Hoat dong")) {
                    HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(hd.getMaHd().equals(maHd)) {
                        check = true;
                        hd.xuatThongTinHd();
                        System.out.println("+--------------CHI TIET HOA DON-----------------+");
                        dsSanPhamDaXuat.xuatChiTietHoaDon(maHd);
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO HOA DON TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTongQuatHd() {
        try {
            String st, thongTin;
            boolean check = false;
            System.out.println("Nhap thong tin hoa don ban muon tim:");
            thongTin = StaticMethod.sc.nextLine();
            thongTin = thongTin.toLowerCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[7].equals("Hoat dong")) {
                    HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(hd.getMaHd().contains(thongTin) || hd.getMaKh().toLowerCase().contains(thongTin)
                            || hd.getMaKhuyenMai().contains(thongTin) || hd.getTongTien().toLowerCase().contains(thongTin)
                            || hd.getPhuongThucThanhToan().toLowerCase().contains(thongTin) || hd.getNgayRaHd().toLowerCase().contains(thongTin)
                            || hd.getTongTienBanDau().toLowerCase().contains(thongTin)) {
                        check = true;
                        hd.xuatThongTinHd();
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO HOA DON TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
