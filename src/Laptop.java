public class Laptop extends SanPham{
    private String dungLuong;

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

        System.out.print("Nhap dung luong: ");
        temp = QuanLyCuaHang.sc.nextLine();
        setDungLuong(temp.trim());

        setLoaiSp("LAPTOP");
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

        System.out.print("Nhap dung luong moi(Nhan Enter de giu thong tin cu): ");
        temp = QuanLyCuaHang.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setDungLuong(temp.trim());
        }
    }

    @Override
    public void xuatThongTinSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 12, 15, 10};
        String[] values = {
                getMaSp(), getTenSp(), getSoLuong(),
                getGia(), getMoTa(), getMauSac(),
                getKhuyenMai(), getLoaiSp(), getDungLuong()
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }

    @Override
    public void xuatThongTinSpCoStt(String soTt) {
        int[] columnWidths = {10, 10, 20, 10, 10, 30, 10, 12, 15, 10};
        String[] values = {
                soTt, getMaSp(), getTenSp(), getSoLuong(),
                getGia(), getMoTa(), getMauSac(),
                getKhuyenMai(), getLoaiSp(), getDungLuong()
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + dungLuong;
    }
}
