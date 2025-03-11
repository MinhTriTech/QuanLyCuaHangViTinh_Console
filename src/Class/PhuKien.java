package Class;

import StaticMethod.StaticMethod;

public class PhuKien extends SanPham {
    public PhuKien() {
    }

    public PhuKien(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia, String giaVon) {
        super(maSp, tenSp, soLuong, giaBanDau, moTa, mauSac, loaiSp, khuyenMai, gia, giaVon);
    }

    public PhuKien(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia) {
        super(maSp, tenSp, soLuong, giaBanDau, moTa, mauSac, loaiSp, khuyenMai, gia);
    }

    //    Các phương thức

    //    Nhập chỉ nhập được tên, số lượng, giá ban đầu, mô tả, màu sắc, % khuyến mãi, dung lượng mới
    @Override
    public void nhap() {
        String temp;
        setRandomId();

        StaticMethod.sc.nextLine();

        System.out.print("Nhap ten san pham: ");
        temp = StaticMethod.sc.nextLine();
        setTenSp(temp.trim());

        do {
            System.out.print("Nhap so luong: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkSoLuong(temp.trim()));
        setSoLuong(temp.trim());

        do {
            System.out.print("Nhap gia ban dau: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkGia(temp.trim()));
        setGiaBanDau(temp.trim());

        System.out.print("Nhap mo ta: ");
        temp = StaticMethod.sc.nextLine();
        setMoTa(temp.trim());

        System.out.print("Nhap mau sac: ");
        temp = StaticMethod.sc.nextLine();
        setMauSac(temp.trim());

        do {
            System.out.print("Nhap % khuyen mai: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkKm(temp.trim()));
        setKhuyenMai(temp.trim());

        setGia(tinhGia(getGiaBanDau(), getKhuyenMai()));

        setLoaiSp("PHUKIEN");
    }

    //    Sửa chỉ sửa được tên mới, giá ban đầu mới, mô tả mới, màu sắc mới, dung lượng mới
    @Override
    public void nhapDeSua() {
        String temp;

        System.out.print("Nhap ten san pham moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setTenSp(temp.trim());
        }

        do {
            System.out.print("Nhap gia moi(Nhan Enter de giu thong tin cu): ");
            temp = StaticMethod.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!checkGia(temp.trim()));
        if(checkGiaNoPrint(temp.trim())) {
            setGiaBanDau(temp.trim());
        }

        System.out.print("Nhap mo ta moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setMoTa(temp.trim());
        }

        System.out.print("Nhap mau sac moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setMauSac(temp.trim());
        }

        setGia(tinhGia(getGiaBanDau(), getKhuyenMai()));
    }

    @Override
    public void xuatThongTinSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] values = {
                getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getMoTa(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(),"Khong co thong tin ve san pham nay"
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public void xuatThongTinSpCoStt(String soTt) {
        int[] columnWidths = {10, 10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] values = {
                soTt, getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getMoTa(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(),"Khong co thong tin ve san pham nay"
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
