public class TaiNgheLoa extends SanPham{
    public TaiNgheLoa() {
    }

    public TaiNgheLoa(String maSp, String tenSp, String soLuong, String gia, String moTa, String mauSac, String khuyenMai, String loaiSp) {
        super(maSp, tenSp, soLuong, gia, moTa, mauSac, khuyenMai, loaiSp);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    void nhap() {
        String temp;
        setRandomId();

        QuanLyCuaHang.sc.nextLine();

        System.out.print("Nhap ten san pham: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setTenSp(temp);

        do {
            System.out.print("Nhap so luong: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkSoLuong(temp));
        setSoLuong(temp);

        do {
            System.out.print("Nhap gia: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkGia(temp));
        setGia(temp);

        System.out.print("Nhap mo ta: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setMoTa(temp);

        System.out.print("Nhap mau sac: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setMauSac(temp);

        do {
            System.out.print("Nhap gia khuyen mai: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkGia(temp));
        setKhuyenMai(temp);

        setLoaiSp("TAINGHELOA");
    }
}
