public class KhachHang extends TaiKhoan{
    String soDienThoai, email, diaChi;

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

    @Override
    void nhap() {
        String temp;
        setRandomId();

        QuanLiCuaHang.sc.nextLine();
        do {
            System.out.print("Nhap ten dang nhap: ");
            temp = QuanLiCuaHang.sc.nextLine();}
        while(checkTenDangNhap(temp));
        setTenDn(temp.trim());

        System.out.print("Nhap ho va ten: ");
        temp = QuanLiCuaHang.sc.nextLine();
        setHoVaTen(temp.trim());

        System.out.print("Nhap mat khau: ");
        temp = QuanLiCuaHang.sc.nextLine();

        String temp_test;
        do {
            System.out.print("Nhap lai mat khau: ");
            temp_test = QuanLiCuaHang.sc.nextLine();}
        while(!temp.equals(temp_test));
        setMatKhau(temp.trim());

        setQuyenTk("KH");

        do {
            System.out.print("Nhap so dien thoai: ");
            temp = QuanLiCuaHang.sc.nextLine();}
        while(!checkSoDienThoai(temp));
        setSoDienThoai(temp.trim());

        System.out.print("Nhap email: ");
        temp = QuanLiCuaHang.sc.nextLine();
        setEmail(temp.trim());

        System.out.print("Nhap dia chi: ");
        temp = QuanLiCuaHang.sc.nextLine();
        setDiaChi(temp.trim());

    }

    private boolean checkSoDienThoai(String temp) {
        if (temp == null || !temp.matches("\\d{10,11}")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ";"
                + soDienThoai + ";"
                + email + ";"
                + diaChi ;
    }
}
