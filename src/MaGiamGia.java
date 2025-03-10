import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MaGiamGia {
    private String maGg, maChu, phanTramGiam, giaTriToiDa, trangThai;

    private static final String FILE_NAME_MGG = "DanhSachMaGiamGia.txt";

    public MaGiamGia() {
    }

    public MaGiamGia(String maGg, String maChu, String phanTramGiam, String giaTriToiDa, String trangThai) {
        this.maGg = maGg;
        this.maChu = maChu;
        this.phanTramGiam = phanTramGiam;
        this.giaTriToiDa = giaTriToiDa;
        this.trangThai = trangThai;
    }

    public String getMaGg() {
        return maGg;
    }

    public void setMaGg(String maGg) {
        this.maGg = maGg;
    }

    public String getMaChu() {
        return maChu;
    }

    public void setMaChu(String maChu) {
        this.maChu = maChu;
    }

    public String getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(String phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public String getGiaTriToiDa() {
        return giaTriToiDa;
    }

    public void setGiaTriToiDa(String giaTriToiDa) {
        this.giaTriToiDa = giaTriToiDa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double tinhSoTienDuocGiam(double tongGiaTri) {
        double discount = tongGiaTri * Double.parseDouble(phanTramGiam) / 100;
        return Math.min(discount, Double.parseDouble(giaTriToiDa));
    }

    public void setRandomId() {
        String lastId = "MGG00000";
        File file = new File(FILE_NAME_MGG);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] mang = line.split(";");
                    lastId = mang[0];
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int num = Integer.parseInt(lastId.substring(3)) + 1;
        String newId = String.format("MGG%05d", num);
        setMaGg(newId);
    }

    public boolean checkGia(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("Vui long nhap lai gia !!!");
            return false;
        }

        try {
            double number = Double.parseDouble(string);
            if (number > 0) {
                return true;
            } else {
                System.out.println("Vui long nhap lai gia !!!");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkKm(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("Vui long nhap lai phan tram khuyen mai !!!");
            return false;
        }

        try {
            double number = Double.parseDouble(string);
            if (number >= 0 && number <= 100) {
                return true;
            } else {
                System.out.println("Vui long nhap lai phan tram khuyen mai !!!");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkMaKm(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("Vui long nhap lai ma khuyen mai !!!");
            return false;
        }

        if (string.length() <= 6) {
            return true;
        } else {
            System.out.println("Vui long nhap lai ma khuyen mai toi da 6 ki tu !!!");
            return false;
        }
    }

    public void nhap() {
        String temp;
        setRandomId();

        QuanLyCuaHang.sc.nextLine();

        do {
            System.out.print("Nhap ma khuyen mai: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkMaKm(temp));
        setMaChu(temp.trim().toUpperCase());

        do {
            System.out.print("Nhap % khuyen mai: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkKm(temp));
        setPhanTramGiam(temp.trim());

        do {
            System.out.print("Nhap gia tri toi da: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkGia(temp));
        setGiaTriToiDa(temp.trim());

        setTrangThai("Hoat dong");
    }

    public static void xuatHeaderMgg() {
        int[] columnWidths = {10, 10, 15, 30, 20};
        String[] headers = {"Ma MGG", "Ma", "% giam", "Gia tri toi da", "Trang thai"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public void xuatThongTinMgg() {
        int[] columnWidths = {10, 10, 15, 30, 20};
        String[] values = {
                getMaGg(), getMaChu(), getPhanTramGiam(),
                getGiaTriToiDa(), getTrangThai()
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }

    public void printMultiLineRow(String[] row, int[] columnWidths) {
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

    public String[] wrapText(String text, int width) {
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

    @Override
    public String toString() {
        return maGg + ";"
                + maChu + ";"
                + phanTramGiam + ";"
                + giaTriToiDa + ";"
                + trangThai;
    }
}
