package StaticMethod;

import Class.SanPham;
import Class.Laptop;
import Class.PhuKien;
import Class.TaiNgheLoa;
import Class.TaiKhoan;
import Class.KhachHang;
import Class.QuanLy;
import ActionClass.MuaHangAction;
import Class.HoaDon;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class StaticMethod {
    public static Scanner sc = new Scanner(System.in);

    public static final String FILE_NAME_SP = "DanhSachSanPham.txt";
    public static final String FILE_NAME_MGG = "DanhSachMaGiamGia.txt";
    public static final String FILE_NAME_TK = "DanhSachTaiKhoan.txt";
    public static final String FILE_NAME_HD = "DanhSachHoaDon.txt";
    public static final String FILE_NAME_SPDX = "DanhSachSanPhamDaXuat.txt";
    public static final String FILE_NAME_PX = "DanhSachPhieuXuat.txt";
    public static final String FILE_NAME_PN = "DanhSachPhieuNhap.txt";

    public static TaiKhoan[] dsTaiKhoanStatic = new TaiKhoan[0];

    public static void printMultiLineRow(String[] row, int[] columnWidths) {
        int maxLines = 1;
        String[][] wrappedColumns = new String[row.length][];

        for (int i = 0; i < row.length; i++) {
            wrappedColumns[i] = wrapText(row[i], columnWidths[i]);
            maxLines = Math.max(maxLines, wrappedColumns[i].length);
        }

        for (int line = 0; line < maxLines; line++) {
            for (int i = 0; i < row.length; i++) {
                String text = (line < wrappedColumns[i].length) ? wrappedColumns[i][line] : "";
                System.out.printf("| %-" + columnWidths[i] + "s ", text);
            }
            System.out.println("|");
        }
    }

    public static String[] wrapText(String text, int width) {
        int lines = (int) Math.ceil((double) text.length() / width);
        String[] result = new String[lines];

        for (int i = 0; i < lines; i++) {
            int start = i * width;
            int end = Math.min(start + width, text.length());
            result[i] = text.substring(start, end);
        }

        return result;
    }

    public static void printSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+-" + "-".repeat(width) + "-");
        }
        System.out.println("+");
    }

    public static void printRow(String[] row, int[] columnWidths) {
        for (int i = 0; i < row.length; i++) {
            System.out.printf("| %-" + columnWidths[i] + "s ", row[i]);
        }
        System.out.println("|");
    }

    public static void xuatHeaderHd() {
        int[] columnWidths = {10, 10, 30, 15, 30, 20, 10, 20};
        String[] headers = {"Ma HD", "Ma KH", "Tong tien ban dau", "Ma KM", "Tong tien", "PTTT", "Ngay ra HD", "Trang thai"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void xuatHeaderMgg() {
        int[] columnWidths = {20, 20, 20, 30, 20};
        String[] headers = {"Ma MGG", "Ma", "% giam", "Gia tri toi da", "Trang thai"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void xuatHeaderSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] headers = {"Ma SP", "Ten SP", "So luong", "Gia", "Mo ta", "Mau sac", "Loai SP", "Khuyen mai", "Gia sau khuyen mai", "Dung luong"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void xuatHeaderCtHdCoTongGia() {
        int[] columnWidths = {10, 20, 10, 10, 10, 15, 12, 20, 20};
        String[] headers = {"Ma SP", "Ten SP", "So luong", "Gia", "Mau sac", "Loai SP", "Khuyen mai", "Gia sau khuyen mai", "Tong gia"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void xuatHeaderSpCoStt() {
        int[] columnWidths = {10, 10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] headers ={"STT","Ma SP", "Ten SP", "So luong", "Gia", "Mo ta", "Mau sac", "Loai SP", "Khuyen mai", "Gia sau khuyen mai", "Dung luong"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void xuatHeaderTk() {
        int[] columnWidths = {10, 20, 10, 25, 10, 20, 30, 20};
        String[] headers = {"Ma TK", "Ten TK", "Mat khau", "Ho và ten", "Quyen TK", "So dien thoai", "Email", "Đia chi"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static MuaHangAction checkDsSanPhamTrongGio(SanPham[] dsSanPham) {
        SanPham[] sanPhamSanCo = new SanPham[0];
        SanPham[] sanPhamKhongDatDieuKien = new SanPham[0];

//        Tạo danh sách sản phẩm hiện tại
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
                sanPhamSanCo = Arrays.copyOf(sanPhamSanCo, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < sanPhamSanCo.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[6].equals("LAPTOP")) {
                        sanPhamSanCo[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        sanPhamSanCo[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        sanPhamSanCo[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Thực hiện kiểm tra danh sách sản phẩm hiện tại
        for (int i = 0; i < dsSanPham.length; i++) {
            for (int j = 0; j < sanPhamSanCo.length; j++) {
                if(dsSanPham[i].getMaSp().equals(sanPhamSanCo[j].getMaSp())) {

//                    Kiểm tra sau khi trừ có không hợp lệ không
                    if (Integer.parseInt(sanPhamSanCo[j].getSoLuong()) - Integer.parseInt(dsSanPham[i].getSoLuong()) < 0) {

//                        Nếu không hợp lệ thì gán số lượng mới và thêm sản phẩm vào danh sách không hợp lệ
                        sanPhamSanCo[j].setSoLuong(String.valueOf(Integer.parseInt(sanPhamSanCo[j].getSoLuong()) - Integer.parseInt(dsSanPham[i].getSoLuong())));

//                        Tăng kích thước của danh sách sản phẩm không hợp lệ
                        SanPham[] sanPhamKhongDatDieuKienTemp = new SanPham[sanPhamKhongDatDieuKien.length + 1];

                        for (int n = 0; n < sanPhamKhongDatDieuKien.length; n++) {
                            sanPhamKhongDatDieuKienTemp[n] = sanPhamKhongDatDieuKien[n];
                        }

                        sanPhamKhongDatDieuKien = Arrays.copyOf(sanPhamKhongDatDieuKien, sanPhamKhongDatDieuKienTemp.length);

                        for (int n = 0; n < sanPhamKhongDatDieuKienTemp.length; n++) {
                            sanPhamKhongDatDieuKien[n] = sanPhamKhongDatDieuKienTemp[n];
                        }

                        sanPhamKhongDatDieuKien[sanPhamKhongDatDieuKien.length-1] = dsSanPham[i];
                    }
                    else {

//                        Nếu hợp lệ thì chỉ gán số lượng mới
                        sanPhamSanCo[j].setSoLuong(String.valueOf(Integer.parseInt(sanPhamSanCo[j].getSoLuong()) - Integer.parseInt(dsSanPham[i].getSoLuong())));
                    }
                }
            }
        }

        MuaHangAction muaHangAction = new MuaHangAction(sanPhamKhongDatDieuKien, sanPhamSanCo);

        return muaHangAction;
    }

    public static String layTienVonSp(String maSp) {
        String temp = "";
        try {
            String st;

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[6].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);
                    if(sp.getMaSp().equals(maSp)) {
                        return sp.getGiaVon();
                    }
                }
                if(s[6].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if(sp.getMaSp().equals(maSp)) {
                        return sp.getGiaVon();
                    }
                }
                if(s[6].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    if(sp.getMaSp().equals(maSp)) {
                        return sp.getGiaVon();
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static LocalDate chuyenChuoiThanhFormatDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    public static int soSanhNgay(String chuoi1, String chuoi2) {
        LocalDate date1 = chuyenChuoiThanhFormatDate(chuoi1);
        LocalDate date2 = chuyenChuoiThanhFormatDate(chuoi2);
        return date1.compareTo(date2);
    }

    public static void doiMatKhauTaiKhoan(String maTk) {
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
                dsTaiKhoanStatic = Arrays.copyOf(dsTaiKhoanStatic, count);

                boolean signal = false;

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsTaiKhoanStatic.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[4].equals("KH")) {
                        dsTaiKhoanStatic[i] = new KhachHang(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
                    } else {
                        dsTaiKhoanStatic[i] = new QuanLy(s[0], s[1], s[2], s[3], s[4]);
                    }
                }

                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                for (int i = 0; i < dsTaiKhoanStatic.length; i++) {
                    if(!dsTaiKhoanStatic[i].getMaTk().equals(maTk)) {
                        fr.write(dsTaiKhoanStatic[i].toString());
                        fr.newLine();
                    } else{
                        dsTaiKhoanStatic[i].nhapDeCapNhatMatKhau();
                        fr.write(dsTaiKhoanStatic[i].toString());
                        fr.newLine();
                        signal = true;
                    }
                }

                if(signal) {
                    System.out.println("-Cap nhat mat khau thanh cong-");
                } else {
                    System.out.println("-That bai-");
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

    public static boolean checkNgayTaoHd(String chuoiNgay) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";

        if (chuoiNgay.matches(regex)) {
            return true;
        } else {
            System.out.println("-Sai dinh dang, vui long nhap dung dinh dang dd-mm-yyyy -");
            return false;
        }
    }

    public static boolean checkThangHopLe(String chuoiThang) {
        String regex = "^(0[1-9]|1[0-2])$"; // Chỉ cho phép từ "01" đến "12"

        if (chuoiThang.matches(regex)) {
            return true;
        } else {
            System.out.println("- Sai định dạng, vui lòng nhập tháng từ 01 đến 12 -");
            return false;
        }
    }

    public static boolean checkNamHopLe(String chuoiNam) {
        String regex = "^\\d{4}$"; // Năm phải có đúng 4 chữ số

        if (chuoiNam.matches(regex)) {
            int nam = Integer.parseInt(chuoiNam);
            if (nam >= 1900 && nam <= 2100) { // Giới hạn khoảng hợp lệ
                return true;
            } else {
                System.out.println("- Năm không hợp lệ, vui lòng nhập năm từ 1900 đến 2100 -");
                return false;
            }
        } else {
            System.out.println("- Sai định dạng, năm phải có đúng 4 chữ số -");
            return false;
        }
    }

    public static boolean checkKm(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("-Vui long nhap lai phan tram khuyen mai-");
            return false;
        } else {
            try {
                double number = Double.parseDouble(string);
                if (number >= 0 && number <= 100) {
                    return true;
                } else {
                    System.out.println("-Vui long nhap lai phan tram khuyen mai-");
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    public static boolean checkGia(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("-Vui long nhap lai gia-");
            return false;
        } else {
            try {
                double number = Double.parseDouble(string);
                if (number > 0) {
                    return true;
                } else {
                    System.out.println("-Vui long nhap lai gia-");
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }


    }

    public static void xuatHeaderSpCoSttThongKe() {
        int[] columnWidths = {10, 20, 20, 20, 30, 30, 30, 30, 30};
        String[] headers ={"Ma SP", "Ten SP", "So luong", "Gia", "Gia von", "Loai SP", "Tong gia ban dau", "Tong gia von", "Tong loi nhuan"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void xuatHeaderDmCoSttThongKe() {
        int[] columnWidths = {30, 30, 30, 30, 30};
        String[] headers ={"Loai SP", "Tong so luong", "Tong gia ban dau", "Tong gia von", "Tong loi nhuan"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void thongKeTheoSoBan_theoThang_theoSp() {
        String thangSoSanh, namSoSanh;

        do {
            System.out.print("--Nhap thang thong ke(Nhan Enter de lay thang hien tai): ");
            thangSoSanh = sc.nextLine();
            if (thangSoSanh.isEmpty()) {
                break;
            }
        }
        while(!checkThangHopLe(thangSoSanh));
        if (thangSoSanh.isEmpty()) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
            thangSoSanh = today.format(formatter);
        }

        do {
            System.out.print("--Nhap nam thong ke(Nhan Enter de lay nam hien tai): ");
            namSoSanh = sc.nextLine();
            if (namSoSanh.isEmpty()) {
                break;
            }
        }
        while(!checkNamHopLe(namSoSanh));
        if (namSoSanh.isEmpty()) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
            namSoSanh = today.format(formatter);
        }

        String st;
        boolean check = false;

        xuatHeaderSpCoSttThongKe();

        try {
            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            String thongTin = thangSoSanh + "-" + namSoSanh;

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[7].equals("Hoat dong")) {
                    HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(hd.getNgayRaHd().toLowerCase().contains(thongTin)) {
                        check = true;
                        thongKeTheoSoBan_theoThang_theoSp_xuatTt(hd.getMaHd());
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

    public static void thongKeTheoSoBan_theoThang_theoSp_xuatTt(String maHd) {
        try {
            String st;

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SPDX));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[5].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],StaticMethod.layTienVonSp(s[0]),s[6]);
                    if(s[9].equals(maHd)) {
                        sp.xuatThongTinSpThongKe();
                    }
                }
                if(s[5].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],StaticMethod.layTienVonSp(s[0]),s[6]);
                    if(s[9].equals(maHd)) {
                        sp.xuatThongTinSpThongKe();
                    }
                }
                if(s[5].equals("TAINGHELOA")) {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],StaticMethod.layTienVonSp(s[0]),s[6]);
                    if(s[9].equals(maHd)) {
                        sp.xuatThongTinSpThongKe();
                    }
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void thongKeTheoSoBan_theoThang_theoDm() {
        String thangSoSanh, namSoSanh;

        do {
            System.out.print("--Nhap thang thong ke(Nhan Enter de lay thang hien tai): ");
            thangSoSanh = sc.nextLine();
            if (thangSoSanh.isEmpty()) {
                break;
            }
        }
        while(!checkThangHopLe(thangSoSanh));
        if (thangSoSanh.isEmpty()) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
            thangSoSanh = today.format(formatter);
        }

        do {
            System.out.print("--Nhap nam thong ke(Nhan Enter de lay nam hien tai): ");
            namSoSanh = sc.nextLine();
            if (namSoSanh.isEmpty()) {
                break;
            }
        }
        while(!checkNamHopLe(namSoSanh));
        if (namSoSanh.isEmpty()) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
            namSoSanh = today.format(formatter);
        }

        String st;
        boolean check = false;
        xuatHeaderDmCoSttThongKe();

        ThongKeData thongKeData = new ThongKeData();

        try {
            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            String thongTin = thangSoSanh + "-" + namSoSanh;
            String lastMaHd = "";

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[7].equals("Hoat dong")) {
                    HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(hd.getNgayRaHd().toLowerCase().contains(thongTin)) {
                        check = true;
                        lastMaHd = hd.getMaHd();

                        thongKeTheoSoBan_theoThang_theoDm_xuatTt(hd.getMaHd(), false,
                                thongKeData);
                    }
                }
            }

            thongKeTheoSoBan_theoThang_theoDm_xuatTt(lastMaHd, true,
                    thongKeData);

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO HOA DON TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void thongKeTheoSoBan_theoThang_theoDm_xuatTt(String maHd, boolean check,
                                                                ThongKeData thongKeData) {
        try {
            String st, tongSlLaptop, tongGiaBdLaptop, tongGiaVonLaptop, tongSlPhukien, tongGiaBdPhukien, tongGiaVonPhukien,tongSlTainghe, tongGiaBdTainghe, tongGiaVonTainghe;

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SPDX));

            if(!check) {
                for(int i=1; (st = br.readLine()) != null ; i++) {
                    String s[] = st.split(";");
                    if(s[5].equals("LAPTOP") && s[9].equals(maHd)) {
                        thongKeData.tongSlLaptop += Double.parseDouble(s[2]);
                        thongKeData.tongGiaBdLaptop += Double.parseDouble(s[8]);
                        thongKeData.tongGiaVonLaptop += Double.parseDouble(StaticMethod.layTienVonSp(s[0]))*Double.parseDouble(s[2]);
                    }
                    if(s[5].equals("PHUKIEN") && s[9].equals(maHd)) {
                        thongKeData.tongSlPhukien += Double.parseDouble(s[2]);
                        thongKeData.tongGiaBdPhukien += Double.parseDouble(s[8]);
                        thongKeData.tongGiaVonPhukien += Double.parseDouble(StaticMethod.layTienVonSp(s[0]))*Double.parseDouble(s[2]);
                    }
                    if(s[5].equals("TAINGHELOA") && s[9].equals(maHd)) {
                        thongKeData.tongSlTainghe += Double.parseDouble(s[2]);
                        thongKeData.tongGiaBdTainghe += Double.parseDouble(s[8]);
                        thongKeData.tongGiaVonTainghe += Double.parseDouble(StaticMethod.layTienVonSp(s[0]))*Double.parseDouble(s[2]);
                    }
                }
            } else {
                tongSlLaptop = String.format("%.2f", thongKeData.tongSlLaptop);
                tongGiaBdLaptop = String.format("%.2f", thongKeData.tongGiaBdLaptop);
                tongGiaVonLaptop = String.format("%.2f", thongKeData.tongGiaVonLaptop);

                tongSlPhukien = String.format("%.2f", thongKeData.tongSlPhukien);
                tongGiaBdPhukien = String.format("%.2f", thongKeData.tongGiaBdPhukien);
                tongGiaVonPhukien = String.format("%.2f", thongKeData.tongGiaVonPhukien);

                tongSlTainghe = String.format("%.2f", thongKeData.tongSlTainghe);
                tongGiaBdTainghe = String.format("%.2f", thongKeData.tongGiaBdTainghe);
                tongGiaVonTainghe = String.format("%.2f", thongKeData.tongGiaVonTainghe);

                Laptop laptop = new Laptop("LAPTOP");
                PhuKien phuKien = new PhuKien("PHUKIEN");
                TaiNgheLoa taiNgheLoa = new TaiNgheLoa("TAINGHELOA");

                laptop.xuatThongTinSpThongKeDm(tongSlLaptop, tongGiaBdLaptop, tongGiaVonLaptop);
                phuKien.xuatThongTinSpThongKeDm(tongSlPhukien, tongGiaBdPhukien, tongGiaVonPhukien);
                taiNgheLoa.xuatThongTinSpThongKeDm(tongSlTainghe, tongGiaBdTainghe, tongGiaVonTainghe);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
