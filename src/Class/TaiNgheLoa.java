package Class;

import StaticMethod.StaticMethod;

public class TaiNgheLoa extends SanPham {
    public TaiNgheLoa() {
    }

    public TaiNgheLoa(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia, String giaVon) {
        super(maSp, tenSp, soLuong, giaBanDau, moTa, mauSac, loaiSp, khuyenMai, gia, giaVon);
    }

    public TaiNgheLoa(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia) {
        super(maSp, tenSp, soLuong, giaBanDau, moTa, mauSac, loaiSp, khuyenMai, gia);
    }

    public TaiNgheLoa(String maSp, String tenSp, String soLuong, String giaBanDau, String giaVon, String loaiSp) {
        super(maSp, tenSp, soLuong, giaBanDau, giaVon, loaiSp);
    }

    public TaiNgheLoa(String maSp, String tenSp, String soLuong, String giaBanDau, String mauSac, String loaiSp, String khuyenMai, String gia) {
        super(maSp, tenSp, soLuong, giaBanDau, mauSac, loaiSp, khuyenMai, gia);
    }

    public TaiNgheLoa(String loaiSp) {
        super(loaiSp);
    }

    //    Các phương thức

    //    Nhập chỉ nhập được tên, số lượng, giá ban đầu, mô tả, màu sắc, % khuyến mãi, dung lượng mới (không nhập được giá vốn hạn chế sử dụng)
    @Override
    public void nhap() {
        String temp;
        setRandomId();

        StaticMethod.sc.nextLine();

        System.out.print("--Nhap ten san pham: ");
        temp = StaticMethod.sc.nextLine();
        setTenSp(temp.trim());

        do {
            System.out.print("--Nhap so luong: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkSoLuong(temp.trim()));
        setSoLuong(temp.trim());

        do {
            System.out.print("--Nhap gia ban dau: ");
            temp = StaticMethod.sc.nextLine();}
        while(!StaticMethod.checkGia(temp.trim()));
        setGiaBanDau(temp.trim());

        System.out.print("--Nhap mo ta: ");
        temp = StaticMethod.sc.nextLine();
        setMoTa(temp.trim());

        System.out.print("--Nhap mau sac: ");
        temp = StaticMethod.sc.nextLine();
        setMauSac(temp.trim());

        do {
            System.out.print("--Nhap % khuyen mai: ");
            temp = StaticMethod.sc.nextLine();}
        while(!StaticMethod.checkKm(temp.trim()));
        setKhuyenMai(temp.trim());

        setGia(tinhGia(getGiaBanDau(), getKhuyenMai()));

        setLoaiSp("TAINGHELOA");

        setGiaVon("0");
    }

    //    Sửa chỉ sửa được tên mới, giá ban đầu mới, mô tả mới, màu sắc mới, dung lượng mới
    @Override
    public void nhapDeSua() {
        String temp;

        System.out.print("--Nhap ten san pham moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setTenSp(temp.trim());
        }

        do {
            System.out.print("--Nhap gia moi(Nhan Enter de giu thong tin cu): ");
            temp = StaticMethod.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!StaticMethod.checkGia(temp.trim()));
        if(checkGiaNoPrint(temp.trim())) {
            setGiaBanDau(temp.trim());
        }

        System.out.print("--Nhap mo ta moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setMoTa(temp.trim());
        }

        System.out.print("--Nhap mau sac moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setMauSac(temp.trim());
        }

        setGia(tinhGia(getGiaBanDau(), getKhuyenMai()));
    }

    @Override
    public void nhapDeNhapHang() {
        String temp;
        setRandomId();

        StaticMethod.sc.nextLine();

        System.out.print("--Nhap ten san pham: ");
        temp = StaticMethod.sc.nextLine();
        setTenSp(temp.trim());

        do {
            System.out.print("--Nhap so luong: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkSoLuong(temp.trim()));
        setSoLuong(temp.trim());

        do {
            System.out.print("--Nhap gia ban dau: ");
            temp = StaticMethod.sc.nextLine();}
        while(!StaticMethod.checkGia(temp.trim()));
        setGiaBanDau(temp.trim());

        System.out.print("--Nhap mo ta: ");
        temp = StaticMethod.sc.nextLine();
        setMoTa(temp.trim());

        System.out.print("--Nhap mau sac: ");
        temp = StaticMethod.sc.nextLine();
        setMauSac(temp.trim());

        setLoaiSp("LAPTOP");

        do {
            System.out.print("--Nhap gia von: ");
            temp = StaticMethod.sc.nextLine();}
        while(!StaticMethod.checkGia(temp.trim()));
        setGiaVon(temp.trim());

        setKhuyenMai("0");

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
    public void xuatThongTinSpCoGiaVon() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 15, 12, 20, 20, 40};
        String[] values = {
                getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getMoTa(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(),getGiaVon(),"Khong co thong tin ve san pham nay"
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public void capNhatPhanTramSanPham() {
        String temp;

        do {
            System.out.print("--Nhap % khuyen mai: ");
            temp = StaticMethod.sc.nextLine();}
        while(!StaticMethod.checkKm(temp.trim()));
        setKhuyenMai(temp.trim());

        setGia(tinhGia(getGiaBanDau(), getKhuyenMai()));
    }

    @Override
    public void xuatThongTinSpThongKe() {
        String giaBanDau = "", giaVon = "", loiNhuan = "";
        double giaDoubleBd= Double.parseDouble(getSoLuong()) * Double.parseDouble(getGiaBanDau());
        giaBanDau =  String.format("%.2f", giaDoubleBd);

        double giaDoubleVon= Double.parseDouble(getSoLuong()) * Double.parseDouble(getGiaVon());
        giaVon =  String.format("%.2f", giaDoubleVon);

        double giaDoubleLn = giaDoubleBd - giaDoubleVon;
        loiNhuan =  String.format("%.2f", giaDoubleLn);

        int[] columnWidths = {10, 20, 20, 20, 30, 30, 30, 30, 30};
        String[] values = {
                getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getGiaVon(),getLoaiSp(),
                giaBanDau, giaVon, loiNhuan
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public void xuatThongTinSpCoTongGia() {
        double tongGia = Double.parseDouble(getSoLuong())*Double.parseDouble(getGia());
        String tongGiaString =  String.format("%.2f", tongGia);
        int[] columnWidths = {10, 20, 10, 10, 10, 15, 12, 20, 20};
        String[] values = {
                getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(), tongGiaString
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public void xuatThongTinSpThongKeDm(String tongSoLuong, String tongGiaBd, String tongGiaVon) {
        String loiNhuan = "";

        double giaDoubleLn= Double.parseDouble(tongGiaBd) - Double.parseDouble(tongGiaVon);
        loiNhuan =  String.format("%.2f", giaDoubleLn);

        int[] columnWidths = {30, 30, 30, 30, 30};
        String[] values = {
                getLoaiSp(),
                tongSoLuong, tongGiaBd, tongGiaVon, loiNhuan
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toStringCoTongGia() {
        return super.toStringCoTongGia();
    }

    @Override
    public String toStringGiaVon() {
        return super.toStringGiaVon();
    }
}
