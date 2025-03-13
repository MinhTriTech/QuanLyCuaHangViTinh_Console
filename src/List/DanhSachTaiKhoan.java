package List;

import Interface.IDanhSach;
import StaticMethod.StaticMethod;
import Class.TaiKhoan;
import Class.QuanLy;
import Class.KhachHang;

import java.io.*;
import java.util.Arrays;

public class DanhSachTaiKhoan implements IDanhSach {
    private TaiKhoan[] dsTaiKhoan = new TaiKhoan[1];

    @Override
    public void them() { // Them tai khoan QL
        try {
            File file = new File(StaticMethod.FILE_NAME_TK);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            TaiKhoan tk = new QuanLy();
            System.out.println("--Nhap thong tin");
            tk.nhap();

            fr.write(tk.toString());
            fr.newLine();
            System.out.println("-Thanh cong-");

            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua() {
        try {
            File file = new File(StaticMethod.FILE_NAME_TK);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsTaiKhoan = Arrays.copyOf(dsTaiKhoan, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsTaiKhoan.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[4].equals("QL")) {
                        dsTaiKhoan[i] = new QuanLy(s[0], s[1], s[2], s[3], s[4]);
                    }
                    if(s[4].equals("KH")) {
                        dsTaiKhoan[i] = new KhachHang(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
                    }
                }

                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));
                boolean signal = false;
                String maTk;
                System.out.println("--Nhap ma tai khoan can sua");
                StaticMethod.sc.nextLine();
                maTk = StaticMethod.sc.nextLine();
                maTk = maTk.toUpperCase().trim();

                for (int i = 0; i < dsTaiKhoan.length; i++) {
                    if(!dsTaiKhoan[i].getMaTk().equals(maTk)) {
                        fr.write(dsTaiKhoan[i].toString());
                        fr.newLine();
                    } else{
                        dsTaiKhoan[i].nhapDeSua();
                        fr.write(dsTaiKhoan[i].toString());
                        fr.newLine();
                        signal = true;
                    }
                }

                if(signal) {
                    System.out.println("-Sua tai khoan thanh cong-");
                } else {
                    System.out.println("-Khong tim thay tai khoan tuong ung voi ma-");
                }

                fr.close();
                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them tai khoan de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa() {
        try {
            File file = new File(StaticMethod.FILE_NAME_TK);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsTaiKhoan = Arrays.copyOf(dsTaiKhoan, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsTaiKhoan.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[4].equals("QL")) {
                        dsTaiKhoan[i] = new QuanLy(s[0], s[1], s[2], s[3], s[4]);
                    }
                    if(s[4].equals("KH")) {
                        dsTaiKhoan[i] = new KhachHang(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
                    }
                }

                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));
                boolean signal = false;
                String maTk;
                System.out.println("--Nhap ma tai khoan can xoa");
                StaticMethod.sc.nextLine();
                maTk = StaticMethod.sc.nextLine();
                maTk = maTk.toUpperCase().trim();

                for (int i = 0; i < dsTaiKhoan.length; i++) {
                    if(!dsTaiKhoan[i].getMaTk().equals(maTk)) {
                        fr.write(dsTaiKhoan[i].toString());
                        fr.newLine();
                    } else{
                        signal = true;
                    }
                }

                if(signal) {
                    System.out.println("-Xoa tai khoan thanh cong-");
                } else {
                    System.out.println("-Khong tim thay tai khoan tuong ung voi ma-");
                }

                fr.close();
                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them tai khoan de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xuat() {
        try {
            String st;
            System.out.println("+--------------DANH SACH TAI KHOAN-----------------+");
            StaticMethod.xuatHeaderTk();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_TK));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[4].equals("QL")) {
                    QuanLy tk = new QuanLy(s[0],s[1],s[2],s[3],s[4]);
                    tk.xuatThongTinTk();
                }
                if (s[4].equals("KH")) {
                    KhachHang tk = new KhachHang(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    tk.xuatThongTinTk();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Các phương thức khác

    public void dangKyKh() { // Them tai khoan KH
        try {
            File file = new File(StaticMethod.FILE_NAME_TK);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            TaiKhoan tk = new KhachHang();
            System.out.println("--Nhap thong tin");
            tk.nhap();

            fr.write(tk.toString());
            fr.newLine();
            System.out.println("-Thanh cong-");

            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TaiKhoan dangNhap() {
        TaiKhoan check = null;
        boolean check_2 = false;
        try {
            File file = new File(StaticMethod.FILE_NAME_TK);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            System.out.println("--Nhap thong tin dang nhap");
            System.out.print("--Nhap ten dang nhap: ");
            String tenDn = StaticMethod.sc.nextLine();
            System.out.print("--Nhap mat khau: ");
            String matKhau = StaticMethod.sc.nextLine();

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[4].equals("KH")) {
                    TaiKhoan tk = new KhachHang(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
                    if (tk.getTenDn().equals(tenDn) && tk.getMatKhau().equals(matKhau)) {
                        check = tk;
                        check_2 = true;
                        System.out.println("-Dang nhap thanh cong-");
                        System.out.println("-Xin chao khach hang " + tk.getHoVaTen() + "-");
                    }
                } else {
                    TaiKhoan tk = new QuanLy(s[0], s[1], s[2], s[3], s[4]);
                    if (tk.getTenDn().equals(tenDn) && tk.getMatKhau().equals(matKhau)) {
                        check = tk;
                        check_2 = true;
                        System.out.println("-Dang nhap thanh cong-");
                        System.out.println("-Xin chao quan ly " + tk.getHoVaTen() + "-");
                    }
                }
            }

            br.close();

            if(!check_2) {
                System.out.println("-Sai ten dang nhap hoac mat khau-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public void xuatDanhSachTkQlFirst() {
        try {
            String st;
            System.out.println("+--------------DANH SACH TAI KHOAN-----------------+");
            StaticMethod.xuatHeaderTk();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_TK));
            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[4].equals("QL")) {
                    QuanLy tk = new QuanLy(s[0],s[1],s[2],s[3],s[4]);
                    tk.xuatThongTinTk();
                }
            }
            br.close();

            BufferedReader br_temp = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_TK));
            for(int i=1; (st = br_temp.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[4].equals("KH")) {
                    KhachHang tk = new KhachHang(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    tk.xuatThongTinTk();
                }
            }
            br_temp.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatDanhSachTkKhFirst() {
        try {
            String st;
            System.out.println("+--------------DANH SACH TAI KHOAN-----------------+");
            StaticMethod.xuatHeaderTk();

            BufferedReader br_temp = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_TK));
            for(int i=1; (st = br_temp.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[4].equals("KH")) {
                    KhachHang tk = new KhachHang(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    tk.xuatThongTinTk();
                }
            }
            br_temp.close();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_TK));
            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[4].equals("QL")) {
                    QuanLy tk = new QuanLy(s[0],s[1],s[2],s[3],s[4]);
                    tk.xuatThongTinTk();
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoMaTk() {
        try {
            String st, maTk;
            boolean check = false;
            StaticMethod.sc.nextLine();
            System.out.println("--Nhap ma tai khoan ban muon tim:");
            maTk = StaticMethod.sc.nextLine();
            maTk = maTk.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderTk();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_TK));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[4].equals("QL")) {
                    QuanLy tk = new QuanLy(s[0],s[1],s[2],s[3],s[4]);
                    if(tk.getMaTk().equals(maTk)) {
                        check = true;
                        tk.xuatThongTinTk();
                    }
                }
                if (s[4].equals("KH")) {
                    KhachHang tk = new KhachHang(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(tk.getMaTk().equals(maTk)) {
                        check = true;
                        tk.xuatThongTinTk();
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO TAI KHOAN TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTongQuatTk() {
        try {
            String st, thongTin;
            boolean check = false;
            StaticMethod.sc.nextLine();
            System.out.println("--Nhap thong tin tai khoan ban muon tim:");
            thongTin = StaticMethod.sc.nextLine();
            thongTin = thongTin.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderTk();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_TK));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[4].equals("QL")) {
                    QuanLy tk = new QuanLy(s[0],s[1],s[2],s[3],s[4]);
                    if(tk.getMaTk().toUpperCase().contains(thongTin) || tk.getTenDn().toUpperCase().contains(thongTin)
                            || tk.getHoVaTen().toUpperCase().contains(thongTin) || tk.getQuyenTk().toUpperCase().contains(thongTin)) {
                        check = true;
                        tk.xuatThongTinTk();
                    }
                }
                if (s[4].equals("KH")) {
                    KhachHang tk = new KhachHang(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(tk.getMaTk().toUpperCase().contains(thongTin) || tk.getTenDn().toUpperCase().contains(thongTin)
                            || tk.getHoVaTen().toUpperCase().contains(thongTin) || tk.getQuyenTk().toUpperCase().contains(thongTin)
                                || tk.getSoDienThoai().toUpperCase().contains(thongTin) || tk.getEmail().toUpperCase().contains(thongTin)
                                    || tk.getDiaChi().toUpperCase().contains(thongTin)) {
                        check = true;
                        tk.xuatThongTinTk();
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO TAI KHOAN TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
