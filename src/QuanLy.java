public class QuanLy extends TaiKhoan{
    public QuanLy() {
    }

    public QuanLy(String maTk, String tenDn, String matKhau, String hoVaTen, String quyenTk) {
        super(maTk, tenDn, matKhau, hoVaTen, quyenTk);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    void nhap() {
        String temp;
        setRandomId();

        do {
            System.out.print("Nhap ten dang nhap: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(checkTenDangNhap(temp)==true);
        setTenDn(temp);

        System.out.print("Nhap ho va ten khach hang: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setHoVaTen(temp);

        System.out.print("Nhap mat khau: ");
        temp = QuanLyCuaHang.sc.nextLine();

        String temp_test;
        do {
            System.out.print("Nhap lai mat khau: ");
            temp_test = QuanLyCuaHang.sc.nextLine();}
        while(temp.equals(temp_test));
        setMatKhau(temp);

        setQuyenTk("KH");
    }
}
