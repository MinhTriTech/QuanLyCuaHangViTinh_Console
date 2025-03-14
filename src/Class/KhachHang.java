package Class;

import StaticMethod.StaticMethod;

public class KhachHang extends TaiKhoan {
    private String soDienThoai, email, diaChi;

    public KhachHang() {
    }

    public KhachHang(String maTk, String tenDn, String matKhau, String hoVaTen, String quyenTk, String soDienThoai, String email, String diaChi) {
        super(maTk, tenDn, matKhau, hoVaTen, quyenTk);
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

//    Các phương thức

    public boolean checkSoDienThoai(String temp) {
        if (temp == null || !temp.matches("\\d{10,11}")) {
            return false;
        }
        return true;
    }

    @Override
    public void nhap() {
        String temp;
        setRandomId();

        StaticMethod.sc.nextLine();
        do {
            System.out.print("--Nhap ten dang nhap: ");
            temp = StaticMethod.sc.nextLine();}
        while(checkTenDangNhap(temp));
        setTenDn(temp.trim());

        System.out.print("--Nhap ho va ten: ");
        temp = StaticMethod.sc.nextLine();
        setHoVaTen(temp.trim());

        System.out.print("--Nhap mat khau: ");
        temp = StaticMethod.sc.nextLine();

        String temp_test;
        do {
            System.out.print("--Nhap lai mat khau: ");
            temp_test = StaticMethod.sc.nextLine();}
        while(!temp.equals(temp_test));
        setMatKhau(temp.trim());

        setQuyenTk("KH");

        do {
            System.out.print("--Nhap so dien thoai: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkSoDienThoai(temp.trim()));
        setSoDienThoai(temp.trim());

        System.out.print("--Nhap email: ");
        temp = StaticMethod.sc.nextLine();
        setEmail(temp.trim());

        System.out.print("--Nhap dia chi: ");
        temp = StaticMethod.sc.nextLine();
        setDiaChi(temp.trim());

    }

    @Override
    public void nhapDeSua() {
        String temp;

        System.out.print("--Nhap ho va ten moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setHoVaTen(temp.trim());
        }

        System.out.print("--Nhap mat khau moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            String temp_test;
            do {
                System.out.print("--Nhap lai mat khau: ");
                temp_test = StaticMethod.sc.nextLine();}
            while(!temp.equals(temp_test));
            setMatKhau(temp);
        }

        do {
            System.out.print("--Nhap so dien thoai moi(Nhan Enter de giu thong tin cu): ");
            temp = StaticMethod.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!checkSoDienThoai(temp.trim()));
        setSoDienThoai(temp.trim());

        System.out.print("--Nhap email moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setEmail(temp.trim());
        }

        System.out.print("--Nhap dia chi moi (Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setDiaChi(temp.trim());
        }
    }

    @Override
    public void xuatThongTinTk() {
        int[] columnWidths = {10, 20, 10, 25, 10, 20, 30, 20};
        String[] values = {
                getMaTk(), getTenDn(), getMatKhau(),
                getHoVaTen(), getQuyenTk(), getSoDienThoai(),
                getEmail(), getDiaChi()
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public void nhapDeCapNhatMatKhau() {
        String temp, mkMoiConf;
        boolean checkMk = true, checkMk2 = true;

        do {
            if (checkMk) {
                System.out.print("--Nhap mat khau cu: ");
                checkMk = false;
            } else {
                System.out.print("--Khong trung khop!Vui long nhap lai: ");
            }
            temp = StaticMethod.sc.nextLine();
        }
        while(!temp.equals(getMatKhau()));

        System.out.print("--Nhap mat khau moi: ");
        mkMoiConf = StaticMethod.sc.nextLine();

        do {
            if (checkMk2) {
                System.out.print("--Nhap lai mat khau moi: ");
                checkMk2 = false;
            } else {
                System.out.print("--Khong trung khop!Vui long nhap lai: ");
            }
            temp = StaticMethod.sc.nextLine();
        }
        while(!temp.equals(mkMoiConf));

        setMatKhau(temp);
    }

    @Override
    public String toString() {
        return super.toString() + ";"
                + soDienThoai + ";"
                + email + ";"
                + diaChi ;
    }
}
