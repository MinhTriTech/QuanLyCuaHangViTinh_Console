package List;

import Interface.IDanhSach;
import Class.SanPham;
import Class.Laptop;
import Class.PhuKien;
import Class.TaiNgheLoa;
import StaticMethod.StaticMethod;

import java.io.*;
import java.util.Arrays;

public class DanhSachSanPham implements IDanhSach {
    private SanPham[] dsSanPham = new SanPham[1];

    @Override
    public void them() {
        try {
            File file = new File(StaticMethod.FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            System.out.println("--Nhap so luong san pham can them: ");
            int slTemp = StaticMethod.sc.nextInt();
            for (int i = 1; i<= slTemp; i++) {
                System.out.println("--Nhap thong tin san pham thu: " + i);
                System.out.println("===Chon loai san pham can them: ===");
                System.out.println("1. Laptop");
                System.out.println("2. Phu kien");
                System.out.println("3. Tai nghe/Loa");
                System.out.print("--Nhap:");
                int luaChonSp = StaticMethod.sc.nextInt();

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
        try {
            File file = new File(StaticMethod.FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsSanPham = Arrays.copyOf(dsSanPham, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsSanPham.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[6].equals("LAPTOP")) {
                        dsSanPham[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        dsSanPham[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        dsSanPham[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                }

                boolean signal = false;
                String maSp;
                System.out.println("--Nhap ma san pham can sua");
                maSp = StaticMethod.sc.nextLine();
                maSp = maSp.toUpperCase().trim();

                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                for (int i = 0; i < dsSanPham.length; i++) {
                    if(!dsSanPham[i].getMaSp().equals(maSp)) {
                        fr.write(dsSanPham[i].toStringGiaVon());
                        fr.newLine();
                    } else{
                        dsSanPham[i].nhapDeSua();
                        fr.write(dsSanPham[i].toStringGiaVon());
                        fr.newLine();
                        signal = true;
                    }
                }

                if(signal) {
                    System.out.println("-Sua san pham thanh cong-");
                } else {
                    System.out.println("-Khong tim thay san pham tuong ung voi ma-");
                }

                fr.close();
                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa() {
        try {
            File file = new File(StaticMethod.FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsSanPham = Arrays.copyOf(dsSanPham, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsSanPham.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[6].equals("LAPTOP")) {
                        dsSanPham[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        dsSanPham[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        dsSanPham[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                }

                boolean signal = false;
                boolean signal_1 = false;
                String maSp,checkConf;
                System.out.println("--Nhap ma san pham can xoa");
                maSp = StaticMethod.sc.nextLine();
                maSp = maSp.toUpperCase().trim();

                for (int i = 0; i < dsSanPham.length; i++) {
                    if(dsSanPham[i].getMaSp().equals(maSp)) {
                        System.out.println("--Ban co chac muon xoa san pham ma " + maSp + " khong?(Nhap Co hoac Khong)");
                        checkConf = StaticMethod.sc.nextLine();
                        do {
                            if(checkConf.toLowerCase().equals("co") || checkConf.toLowerCase().equals("c")) {
                                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));
                                for (int j = 0; j < dsSanPham.length; j++) {
                                    if(!dsSanPham[j].getMaSp().equals(maSp)) {
                                        fr.write(dsSanPham[j].toStringGiaVon());
                                        fr.newLine();
                                    } else{
                                        signal = true;
                                        signal_1 = true;
                                    }
                                }
                                fr.close();
                                break;
                            } else {
                                signal = true;
                                signal_1 = false;
                                break;
                            }
                        } while (checkConf.toLowerCase().equals("co") || checkConf.toLowerCase().equals("c")
                                || checkConf.toLowerCase().equals("khong") || checkConf.toLowerCase().equals("k"));
                        break;
                    } else{
                        signal = false;
                    }
                }

                if(signal && signal_1) {
                    System.out.println("-Xoa san pham thanh cong-");
                } else if (signal && !signal_1){
                    System.out.println("-Huy thao tac xoa-");
                } else {
                    System.out.println("-Khong tim thay san pham tuong ung voi ma-");
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xuat() {
        try {
            String st;
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            StaticMethod.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    sp.xuatThongTinSp();
                }
                if (s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    sp.xuatThongTinSp();
                }
                if (s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    sp.xuatThongTinSp();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Các phương thức khác

    public void xuatTheoGiaThapDenCao() {
        try {
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            StaticMethod.xuatHeaderSp();

            File file = new File(StaticMethod.FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsSanPham = Arrays.copyOf(dsSanPham, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsSanPham.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[6].equals("LAPTOP")) {
                        dsSanPham[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        dsSanPham[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        dsSanPham[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    }
                }

                for (int i = 0; i < dsSanPham.length - 1; i++) {
                    for (int j = 0; j < dsSanPham.length-i-1; j++) {
                        if (Double.parseDouble(dsSanPham[j].getGia()) > Double.parseDouble(dsSanPham[j + 1].getGia())) {
                            SanPham temp = dsSanPham[j];
                            dsSanPham[j] = dsSanPham[j + 1];
                            dsSanPham[j + 1] = temp;
                        }
                    }
                }

                for (int i = 0; i < dsSanPham.length; i++) {
                    dsSanPham[i].xuatThongTinSp();
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatTheoGiaCaoDenThap() {
        try {
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            StaticMethod.xuatHeaderSp();

            File file = new File(StaticMethod.FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsSanPham = Arrays.copyOf(dsSanPham, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsSanPham.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[6].equals("LAPTOP")) {
                        dsSanPham[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        dsSanPham[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        dsSanPham[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    }
                }

                for (int i = 0; i < dsSanPham.length - 1; i++) {
                    for (int j = 0; j < dsSanPham.length-i-1; j++) {
                        if (Double.parseDouble(dsSanPham[j].getGia()) < Double.parseDouble(dsSanPham[j + 1].getGia())) {
                            SanPham temp = dsSanPham[j];
                            dsSanPham[j] = dsSanPham[j + 1];
                            dsSanPham[j + 1] = temp;
                        }
                    }
                }

                for (int i = 0; i < dsSanPham.length; i++) {
                    dsSanPham[i].xuatThongTinSp();
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatTheoDmLaptop() {
        try {
            String st;
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            StaticMethod.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    sp.xuatThongTinSp();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatTheoDmPhuKien() {
        try {
            String st;
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            StaticMethod.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    sp.xuatThongTinSp();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatTheoDmTaiNgheLoa() {
        try {
            String st;
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            StaticMethod.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    sp.xuatThongTinSp();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoMaSp() {
        try {
            String st, maSp;
            boolean check = false;
            System.out.println("--Nhap ma san pham ban muon tim:");
            maSp = StaticMethod.sc.nextLine();
            maSp = maSp.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO SAN PHAM TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTongQuatSp() {
        try {
            String st, thongTin;
            boolean check = false;
            System.out.println("--Nhap thong tin san pham ban muon tim:");
            thongTin = StaticMethod.sc.nextLine();
            thongTin = thongTin.toLowerCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().toLowerCase().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().toLowerCase().contains(thongTin)
                            || sp.getMauSac().toLowerCase().contains(thongTin) || sp.getLoaiSp().toLowerCase().contains(thongTin)
                            || sp.getDungLuong().toLowerCase().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().toLowerCase().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().toLowerCase().contains(thongTin)
                            || sp.getMauSac().toLowerCase().contains(thongTin) || sp.getLoaiSp().toLowerCase().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().toLowerCase().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().toLowerCase().contains(thongTin)
                            || sp.getMauSac().toLowerCase().contains(thongTin) || sp.getLoaiSp().toLowerCase().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO SAN PHAM TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean timKiemTheoMaSpBool(String maSp) {
        try {
            String st;
            boolean check = false;

            maSp = maSp.toUpperCase().trim();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        return true;
                    }
                }
                if(s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        return true;
                    }
                }
                if(s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        return true;
                    }
                }
            }

            br.close();

            if(check == false) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public SanPham themSanPhamVaoGioHang(String maSp) {
        SanPham spTemp = null;
        try {

            String st,soLuongSp;
            boolean checkToast = true;

            maSp = maSp.toUpperCase().trim();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SP));

            for (int i = 1; (st = br.readLine()) != null; i++) {
                String s[] = st.split(";");
                if (s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                    if (sp.getMaSp().equals(maSp)) {
                        do {
                            if(checkToast) {
                                System.out.print("--Nhap so luong san pham can mua: ");
                                checkToast = false;
                            } else {
                                System.out.print("--Nhap lai so luong san pham can mua khong duoc lon hon so luong hien co " + "(" + sp.getSoLuong() + " san pham):");
                            }
                            soLuongSp = StaticMethod.sc.nextLine();}
                        while(Integer.parseInt(soLuongSp) > Integer.parseInt(sp.getSoLuong()));

                        spTemp = new Laptop(s[0],s[1],soLuongSp,s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                        return spTemp;
                    }
                }
                if (s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if (sp.getMaSp().equals(maSp)) {
                        do {
                            if(checkToast) {
                                System.out.print("--Nhap so luong san pham can mua: ");
                                checkToast = false;
                            } else {
                                System.out.print("--Nhap lai so luong san pham can mua khong duoc lon hon so luong hien co: " + "(" + sp.getSoLuong() + " san pham):");
                            }
                            soLuongSp = StaticMethod.sc.nextLine();}
                        while(Integer.parseInt(soLuongSp) > Integer.parseInt(sp.getSoLuong()));

                        spTemp = new PhuKien(s[0],s[1],soLuongSp,s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                        return spTemp;
                    }
                }
                if (s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if (sp.getMaSp().equals(maSp)) {
                        do {
                            if(checkToast) {
                                System.out.print("--Nhap so luong san pham can mua: ");
                                checkToast = false;
                            } else {
                                System.out.print("--Nhap lai so luong san pham can mua khong duoc lon hon so luong hien co: " + "(" + sp.getSoLuong() + " san pham):");
                            }
                            soLuongSp = StaticMethod.sc.nextLine();}
                        while(Integer.parseInt(soLuongSp) > Integer.parseInt(sp.getSoLuong()));

                        spTemp = new TaiNgheLoa(s[0], s[1], soLuongSp, s[3], s[4], s[5], s[6], s[7],s[8],s[9]);
                        return spTemp;
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return spTemp;
    }

    public void capNhatPhanTramKhuyenMaiTheoSp() {
        try {
            File file = new File(StaticMethod.FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsSanPham = Arrays.copyOf(dsSanPham, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsSanPham.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[6].equals("LAPTOP")) {
                        dsSanPham[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        dsSanPham[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        dsSanPham[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                }

                boolean signal = false;
                String maSp;
                System.out.println("--Nhap ma san pham can sua");
                maSp = StaticMethod.sc.nextLine();
                maSp = maSp.toUpperCase().trim();

                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                for (int i = 0; i < dsSanPham.length; i++) {
                    if(!dsSanPham[i].getMaSp().equals(maSp)) {
                        fr.write(dsSanPham[i].toStringGiaVon());
                        fr.newLine();
                    } else{
                        dsSanPham[i].capNhatPhanTramSanPham();
                        fr.write(dsSanPham[i].toStringGiaVon());
                        fr.newLine();
                        signal = true;
                    }
                }

                if(signal) {
                    System.out.println("-Cap nhat % khuyen mai thanh cong-");
                } else {
                    System.out.println("-Khong tim thay san pham tuong ung voi ma-");
                }

                fr.close();
                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void capNhatPhanTramKhuyenMaiTheoDm() {
        try {
            File file = new File(StaticMethod.FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                dsSanPham = Arrays.copyOf(dsSanPham, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsSanPham.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[6].equals("LAPTOP")) {
                        dsSanPham[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        dsSanPham[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        dsSanPham[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                }
                String loaiSp,khuyenMai;
                boolean signal = false;

                do {
                    System.out.print("--Nhap % khuyen mai: ");
                    khuyenMai = StaticMethod.sc.nextLine();}
                while(!StaticMethod.checkKm(khuyenMai.trim()));

                do {
                    System.out.println("===Chon loai san pham can cap nhat % khuyen mai: ===");
                    System.out.println("1. Laptop");
                    System.out.println("2. Phu kien");
                    System.out.println("3. Tai nghe/Loa");
                    System.out.print("--Nhap:");

                    loaiSp = StaticMethod.sc.nextLine().trim();

                    try {
                        int loai = Integer.parseInt(loaiSp);
                        if (loai >= 1 && loai <= 3) {
                            break;
                        }
                        System.out.println("-Lua chon khong hop le-");
                    } catch (NumberFormatException e) {
                        System.out.println("-Lua chon khong hop le-");
                    }
                } while(true);

                if(loaiSp.equals("1")){
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                    for (int i = 0; i < dsSanPham.length; i++) {
                        if(!dsSanPham[i].getLoaiSp().equals("LAPTOP")) {
                            fr.write(dsSanPham[i].toStringGiaVon());
                            fr.newLine();
                        } else{
                            dsSanPham[i].setKhuyenMai(khuyenMai);
                            dsSanPham[i].setGia(dsSanPham[i].tinhGia(dsSanPham[i].getGiaBanDau(), dsSanPham[i].getKhuyenMai()));
                            fr.write(dsSanPham[i].toStringGiaVon());
                            fr.newLine();
                            signal = true;
                        }
                    }

                    fr.close();
                }
                if(loaiSp.equals("2")){
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                    for (int i = 0; i < dsSanPham.length; i++) {
                        if(!dsSanPham[i].getLoaiSp().equals("PHUKIEN")) {
                            fr.write(dsSanPham[i].toStringGiaVon());
                            fr.newLine();
                        } else{
                            dsSanPham[i].setKhuyenMai(khuyenMai);
                            dsSanPham[i].setGia(dsSanPham[i].tinhGia(dsSanPham[i].getGiaBanDau(), dsSanPham[i].getKhuyenMai()));
                            fr.write(dsSanPham[i].toStringGiaVon());
                            fr.newLine();
                            signal = true;
                        }
                    }

                    fr.close();
                }
                if(loaiSp.equals("3")){

                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                    for (int i = 0; i < dsSanPham.length; i++) {
                        if(!dsSanPham[i].getLoaiSp().equals("TAINGHELOA")) {
                            fr.write(dsSanPham[i].toStringGiaVon());
                            fr.newLine();
                        } else{
                            dsSanPham[i].setKhuyenMai(khuyenMai);
                            dsSanPham[i].setGia(dsSanPham[i].tinhGia(dsSanPham[i].getGiaBanDau(), dsSanPham[i].getKhuyenMai()));
                            fr.write(dsSanPham[i].toStringGiaVon());
                            fr.newLine();
                            signal = true;
                        }
                    }

                    fr.close();
                }

                if(signal) {
                    System.out.println("-Cap nhat % khuyen mai thanh cong-");
                } else {
                    System.out.println("-Danh muc trong-");
                }


                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
