import java.io.*;

public class TaiKhoan {
    private String maTk;
    private String tenDn;
    private String matKhau;
    private String soDienThoai;
    private String email;
    private String quyenTk;

    private static final String FILE_NAME = "DanhSachTaiKhoan.txt";

    public TaiKhoan() {
        setRandomId();
    }

    public TaiKhoan(String maTk, String tenDn, String matKhau, String soDienThoai, String email, String quyenTk) {
        this.maTk = maTk;
        this.tenDn = tenDn;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
        this.email = email;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuyenTk() {
        return quyenTk;
    }

    public void setQuyenTk(String quyenTk) {
        this.quyenTk = quyenTk;
    }

    void setRandomId() {
        String lastId = "TK00000";
        File file = new File(FILE_NAME);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null) {
                    lastId = line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            int num = Integer.parseInt(lastId.substring(2)) + 1;
            String newId = String.format("ID%05d", num);
            setMaTk(newId);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                writer.write(newId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
