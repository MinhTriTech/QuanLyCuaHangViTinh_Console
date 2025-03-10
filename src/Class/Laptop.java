package Class;

import StaticMethod.StaticMethod;

public class Laptop extends SanPham {
    private String dungLuong;

    public Laptop() {
    }

    public Laptop(String maSp, String tenSp, String soLuong, String gia, String moTa, String mauSac, String khuyenMai, String loaiSp, String giaBanDau, String dungLuong) {
        super(maSp, tenSp, soLuong, gia, moTa, mauSac, khuyenMai, loaiSp, giaBanDau);
        this.dungLuong = dungLuong;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

//    Các phương thức

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

        System.out.print("Nhap dung luong: ");
        temp = StaticMethod.sc.nextLine();
        setDungLuong(temp.trim());

        setGia(tinhGia(getGiaBanDau(), getKhuyenMai()));

        setLoaiSp("LAPTOP");
    }

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

        System.out.print("Nhap dung luong moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setDungLuong(temp.trim());
        }
    }

    @Override
    public void xuatThongTinSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] values = {
                getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getMoTa(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(),getDungLuong()
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public void xuatThongTinSpCoStt(String soTt) {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 15, 12, 20, 40};
        String[] values = {
                soTt, getMaSp(),getTenSp(),getSoLuong(),getGiaBanDau(),getMoTa(),
                getMauSac(),getLoaiSp(),getKhuyenMai(),getGia(),getDungLuong()
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + dungLuong;
    }
}
