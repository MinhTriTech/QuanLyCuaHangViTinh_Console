public class Laptop extends SanPham{
    String dungLuong;

    public Laptop() {
    }

    public Laptop(String maSp, String tenSp, String soLuong, String gia, String moTa, String mauSac, String khuyenMai, String loaiSp, String dungLuong) {
        super(maSp, tenSp, soLuong, gia, moTa, mauSac, khuyenMai, loaiSp);
        this.dungLuong = dungLuong;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + dungLuong;
    }

    @Override
    void nhap() {
        String temp;
        setRandomId();

        QuanLyCuaHang.sc.nextLine();

        System.out.print("Nhap ten san pham: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setTenSp(temp.trim());

        do {
            System.out.print("Nhap so luong: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkSoLuong(temp.trim()));
        setSoLuong(temp.trim());

        do {
            System.out.print("Nhap gia: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkGia(temp.trim()));
        setGia(temp.trim());

        System.out.print("Nhap mo ta: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setMoTa(temp.trim());

        System.out.print("Nhap mau sac: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setMauSac(temp.trim());

        do {
            System.out.print("Nhap gia khuyen mai: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkGiaKm(temp.trim()));
        setKhuyenMai(temp.trim());

        System.out.print("Nhap dung luong: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setDungLuong(temp.trim());

        setLoaiSp("LAPTOP");
    }

    @Override
    void xuatThongTinSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 12, 15, 10};
        String[] values = {
                getMaSp(), getTenSp(), getSoLuong(),
                getGia(), getMoTa(), getMauSac(),
                getKhuyenMai(), getLoaiSp(), getDungLuong()
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }
}
