public class TaiNgheLoa extends SanPham{
    public TaiNgheLoa() {
    }

    public TaiNgheLoa(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia) {
        super(maSp, tenSp, soLuong, gia, moTa, mauSac, khuyenMai, loaiSp, giaBanDau);
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
            System.out.print("Nhap gia ban dau: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkGia(temp.trim()));
        setGiaBanDau(temp.trim());

        System.out.print("Nhap mo ta: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setMoTa(temp.trim());

        System.out.print("Nhap mau sac: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setMauSac(temp.trim());

        do {
            System.out.print("Nhap % khuyen mai: ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkKm(temp.trim()));
        setKhuyenMai(temp.trim());

        setGia(tinhGia(getGiaBanDau(), getKhuyenMai()));

        setLoaiSp("TAINGHELOA");
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
            setGiaBanDau(temp.trim());
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
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] values = {
                getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getMoTa(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(),"Khong co thong tin ve san pham nay"
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }

    @Override
    public void xuatThongTinSpCoStt(String soTt) {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] values = {
                getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getMoTa(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(),"Khong co thong tin ve san pham nay"
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
