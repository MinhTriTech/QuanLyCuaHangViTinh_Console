import java.io.*;
import java.util.Scanner;

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

    void setRandomId() {
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

    abstract void nhap();
}
