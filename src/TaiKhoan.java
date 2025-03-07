import java.io.*;

public abstract class TaiKhoan {
    private String maTk;
    private String tenDn;
    private String matKhau;
    private String hoVaTen;
    private String quyenTk;

    private static final String FILE_NAME = "DanhSachTaiKhoan.txt";

    public TaiKhoan() {
    }

    public TaiKhoan(String maTk, String tenDn, String matKhau, String hoVaTen, String quyenTk) {
        this.maTk = maTk;
        this.tenDn = tenDn;
        this.matKhau = matKhau;
        this.hoVaTen = hoVaTen;
        this.quyenTk = quyenTk;
    }

    public String getMaTk() {
        return maTk;
    }

    public void setMaTk(String maTk) {
        this.maTk = maTk;
    }

    public String getTenDn() {
        return tenDn;
    }

    public void setTenDn(String tenDn) {
        this.tenDn = tenDn;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getQuyenTk() {
        return quyenTk;
    }

    public void setQuyenTk(String quyenTk) {
        this.quyenTk = quyenTk;
    }

    @Override
    public String toString() {
        return maTk + ";"
                + tenDn + ";"
                + matKhau + ";"
                + hoVaTen + ";"
                + quyenTk;
    }

    public void setRandomId() {
        String lastId = "TK00000";
        File file = new File(FILE_NAME);

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

        int num = Integer.parseInt(lastId.substring(2)) + 1;
        String newId = String.format("TK%05d", num);
        setMaTk(newId);
    }

    public boolean checkTenDangNhap(String tenDn) {
        try {
            String st, tenDnCheck = "";
            boolean signal = false;
            File file = new File(FILE_NAME);

            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                while((st = br.readLine()) != null){
                    String []mang = st.split(";");

                    tenDnCheck = mang[1].toLowerCase();

                    tenDn = tenDn.toLowerCase();

                    if (tenDnCheck.equals(tenDn)){
                        System.out.println("Ten dang nhap da ton tai");
                        signal = true;
                        return true;
                    }
                }
                br.close();
            }

            if (signal == false){
                System.out.println("Ten dang nhap co the su dung !!!");
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void xuatHeaderTk() {
        int[] columnWidths = {10, 20, 10, 25, 10, 20, 30, 20};
        String[] headers = {"Ma TK", "Ten TK", "Mat khau", "Ho và ten", "Quyen TK", "So dien thoai", "Email", "Đia chi"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
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

    public abstract void nhap();
    public abstract void nhapDeSua();
    public abstract void xuatThongTinTk();
}
