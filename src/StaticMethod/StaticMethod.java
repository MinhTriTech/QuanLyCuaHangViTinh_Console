package StaticMethod;

import Class.SanPham;
import Class.Laptop;
import Class.PhuKien;
import Class.TaiNgheLoa;
import ActionClass.MuaHangAction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class StaticMethod {
    public static Scanner sc = new Scanner(System.in);

    public static final String FILE_NAME_SP = "DanhSachSanPham.txt";
    public static final String FILE_NAME_MGG = "DanhSachMaGiamGia.txt";
    public static final String FILE_NAME_TK = "DanhSachTaiKhoan.txt";
    public static final String FILE_NAME_HD = "DanhSachHoaDon.txt";
    public static final String FILE_NAME_SPDX = "DanhSachSanPhamDaXuat.txt";

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
        int[] columnWidths = {10, 10, 15, 30, 20};
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
                        sanPhamSanCo[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9]);
                    }
                    if(s[6].equals("PHUKIEN")) {
                        sanPhamSanCo[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    }
                    if(s[6].equals("TAINGHELOA")) {
                        sanPhamSanCo[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
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
}
