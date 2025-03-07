public class PhuKien extends SanPham{
    public PhuKien() {
    }

    public PhuKien(String maSp, String tenSp, String soLuong, String gia, String moTa, String mauSac, String khuyenMai, String loaiSp) {
        super(maSp, tenSp, soLuong, gia, moTa, mauSac, khuyenMai, loaiSp);
    }

    @Override
    public void nhap() {
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

        setLoaiSp("PHUKIEN");
    }

    @Override
    public void nhapDeSua() {
        String temp;

        System.out.print("Nhap ten san pham moi(Nhan Enter de giu thong tin cu): ");
        temp = QuanLyCuaHang.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setTenSp(temp.trim());
        }

        do {
            System.out.print("Nhap gia moi(Nhan Enter de giu thong tin cu): ");
            temp = QuanLyCuaHang.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!checkGia(temp.trim()));
        if(checkGiaNoPrint(temp.trim())) {
            setGia(temp.trim());
        }

        System.out.print("Nhap mo ta moi(Nhan Enter de giu thong tin cu): ");
        temp = QuanLyCuaHang.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setMoTa(temp.trim());
        }

        System.out.print("Nhap mau sac moi(Nhan Enter de giu thong tin cu): ");
        temp = QuanLyCuaHang.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setMauSac(temp.trim());
        }
    }

    @Override
    public void xuatThongTinSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 12, 15, 10};
        String[] values = {
                getMaSp(), getTenSp(), getSoLuong(),
                getGia(), getMoTa(), getMauSac(),
                getKhuyenMai(), getLoaiSp(), ""
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
