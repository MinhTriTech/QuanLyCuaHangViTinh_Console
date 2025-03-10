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
        try {
            File file = new File(FILE_NAME_SP);

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

                boolean signal = false;
                String maSp;
                System.out.println("--Nhap ma san pham can sua--");
                QuanLyCuaHang.sc.nextLine();
                maSp = QuanLyCuaHang.sc.nextLine();
                maSp = maSp.toUpperCase().trim();

                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                for (int i = 0; i < dsSanPham.length; i++) {
                    if(!dsSanPham[i].getMaSp().equals(maSp)) {
                        fr.write(dsSanPham[i].toString());
                        fr.newLine();
                    } else{
                        dsSanPham[i].nhapDeSua();
                        fr.write(dsSanPham[i].toString());
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
            File file = new File(FILE_NAME_SP);

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

                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));
                boolean signal = false;
                String maSp;
                System.out.println("--Nhap ma san pham can xoa--");
                QuanLyCuaHang.sc.nextLine();
                maSp = QuanLyCuaHang.sc.nextLine();
                maSp = maSp.toUpperCase().trim();

                for (int i = 0; i < dsSanPham.length; i++) {
                    if(!dsSanPham[i].getMaSp().equals(maSp)) {
                        fr.write(dsSanPham[i].toString());
                        fr.newLine();
                    } else{
                        signal = true;
                    }
                }

                if(signal) {
                    System.out.println("-Xoa san pham thanh cong-");
                } else {
                    System.out.println("-Khong tim thay san pham tuong ung voi ma-");
                }

                fr.close();
                ft.close();
                fw.close();
            } else {
                System.out.println("-Dan sach dang trong vui long them san pham de thuc hien thao tac-");
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
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

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

    public void xuatTheoGiaThapDenCao() {
        try {
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            SanPham.xuatHeaderSp();

            File file = new File(FILE_NAME_SP);

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
                System.out.println("-Dan sach dang trong vui long them san pham de thuc hien thao tac-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatTheoGiaCaoDenThap() {
        try {
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            SanPham.xuatHeaderSp();

            File file = new File(FILE_NAME_SP);

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
                System.out.println("-Dan sach dang trong vui long them san pham de thuc hien thao tac-");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatTheoDmLaptop() {
        try {
            String st;
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

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
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

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
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

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
            QuanLyCuaHang.sc.nextLine();
            System.out.println("Nhap ma san pham ban muon tim:");
            maSp = QuanLyCuaHang.sc.nextLine();
            maSp = maSp.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

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
            QuanLyCuaHang.sc.nextLine();
            System.out.println("Nhap thong tin san pham ban muon tim:");
            thongTin = QuanLyCuaHang.sc.nextLine();
            thongTin = thongTin.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().contains(thongTin)
                            || sp.getMauSac().contains(thongTin) || sp.getLoaiSp().contains(thongTin)
                            || sp.getDungLuong().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().contains(thongTin)
                            || sp.getMauSac().contains(thongTin) || sp.getLoaiSp().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                if(s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().contains(thongTin)
                            || sp.getMauSac().contains(thongTin) || sp.getLoaiSp().contains(thongTin)) {
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

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

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

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

            for (int i = 1; (st = br.readLine()) != null; i++) {
                String s[] = st.split(";");
                if (s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8],s[9]);
                    if (sp.getMaSp().equals(maSp)) {
                        do {
                            if(checkToast) {
                                System.out.print("Nhap so luong san pham can mua: ");
                                checkToast = false;
                            } else {
                                System.out.print("Nhap lai so luong san pham can mua khong duoc lon hon so luong hien co " + "(" + sp.getSoLuong() + " san pham):");
                            }
                            soLuongSp = QuanLyCuaHang.sc.nextLine();}
                        while(Integer.parseInt(soLuongSp) > Integer.parseInt(sp.getSoLuong()));

                        spTemp = new Laptop(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8],s[9]);
                        return spTemp;
                    }
                }
                if (s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7],s[8]);
                    if (sp.getMaSp().equals(maSp)) {
                        do {
                            if(checkToast) {
                                System.out.print("Nhap so luong san pham can mua: ");
                                checkToast = false;
                            } else {
                                System.out.print("Nhap lai so luong san pham can mua khong duoc lon hon so luong hien co: ");
                            }
                            soLuongSp = QuanLyCuaHang.sc.nextLine();}
                        while(Integer.parseInt(soLuongSp) > Integer.parseInt(sp.getSoLuong()));

                        spTemp = new PhuKien(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7],s[8]);
                        return spTemp;
                    }
                }
                if (s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7],s[8]);
                    if (sp.getMaSp().equals(maSp)) {
                        do {
                            if(checkToast) {
                                System.out.print("Nhap so luong san pham can mua: ");
                                checkToast = false;
                            } else {
                                System.out.print("Nhap lai so luong san pham can mua khong duoc lon hon so luong hien co: ");
                            }
                            soLuongSp = QuanLyCuaHang.sc.nextLine();}
                        while(Integer.parseInt(soLuongSp) > Integer.parseInt(sp.getSoLuong()));

                        spTemp = new TaiNgheLoa(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7],s[8]);
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

}
