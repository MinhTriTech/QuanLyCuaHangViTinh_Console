# Ứng dụng Quản lý Bán hàng Laptop - Console

## Giới thiệu
Đây là một ứng dụng quản lý bán hàng laptop chạy trên console, hỗ trợ khách hàng mua sắm và quản lý hóa đơn, đồng thời cung cấp các chức năng quản lý sản phẩm, tài khoản, khuyến mãi và thống kê dành cho quản trị viên.

## Chức năng chính
### 1. Khách hàng
- **Quản lý sản phẩm**: Mua hàng, xem danh sách sản phẩm, lọc theo danh mục, xem giỏ hàng, thanh toán.
- **Tìm kiếm sản phẩm**: Theo mã hoặc tìm kiếm tổng quát.
- **Quản lý hóa đơn**: Xem danh sách, tìm kiếm theo mã.
- **Đổi mật khẩu**.
- **Đăng xuất**.

### 2. Quản lý
- **Quản lý sản phẩm**: Xem, thêm, sửa, xóa sản phẩm, nhập/xuất hàng.
- **Quản lý khuyến mãi**: Thêm, tìm kiếm, xóa mã khuyến mãi, cài đặt phần trăm giảm giá.
- **Quản lý hóa đơn**: Xem, tìm kiếm, xóa hóa đơn, khôi phục hóa đơn đã xóa.
- **Thống kê**: Doanh số bán hàng, nhập xuất theo tháng và khoảng thời gian.
- **Quản lý tài khoản**: Thêm, sửa, xóa tài khoản.
- **Đăng xuất**.

## Sơ đồ Class
Dưới đây là sơ đồ class minh họa cấu trúc của ứng dụng:

- **File chỉnh sửa được**: [class_diagram.drawio](class_diagrams.drawio)

## Hướng dẫn chạy ứng dụng
### 1. Clone Repository
Trước tiên, bạn cần clone repository về máy:
```sh
git clone https://github.com/MinhTriTech/QuanLyCuaHangViTinh_Console.git
cd your-repo
```

### 2. Sử dụng **VS Code**
#### Yêu cầu
- Cài đặt [VS Code](https://code.visualstudio.com/).
- Cài đặt [Java JDK](https://www.oracle.com/java/technologies/downloads/) (phiên bản 11 trở lên).
- Cài đặt **Extension Pack for Java** trong VS Code.

#### Các bước thực hiện
1. Mở **VS Code** và chọn **Open Folder** để mở thư mục chứa mã nguồn.
2. Mở terminal trong VS Code (**Ctrl + `**) và chạy lệnh:
   ```sh
   javac -d bin src/**/*.java
   java -cp bin QuanLyCuaHang
   ```
   (Giả sử `QuanLyCuaHang.java` là file chính của bạn).

### 3. Sử dụng **IntelliJ IDEA**
#### Yêu cầu
- Cài đặt [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows).
- Cài đặt [Java JDK](https://www.oracle.com/java/technologies/downloads/) (phiên bản 11 trở lên).

#### Các bước thực hiện
1. Mở IntelliJ IDEA và chọn **Open** để mở thư mục chứa mã nguồn.
2. Nếu chưa có, hãy tạo cấu hình chạy (**Run/Debug Configuration**) bằng cách:
   - Chọn **Add Configuration** > **Application**.
   - Chọn **Main class** (ví dụ: `QuanLyCuaHang`).
   - Nhấn **Apply** và **OK**.
3. Nhấn **Shift + F10** để chạy chương trình.

## Nhược điểm cần cải thiện
1. **Thêm thuộc tính ngày hết hạn cho mã khuyến mãi** để linh hoạt hơn.
2. **Làm tròn số tiền chính xác hơn**.
3. **Bổ sung bộ lọc thời gian** trong các danh sách có thuộc tính thời gian.
4. **Thống kê** chỉ tập trung vào doanh số bán hàng theo tháng và khoảng thời gian để tối ưu thời gian phát triển.
5. **Không hỗ trợ xuất sản phẩm**, chỉ tập trung vào phiếu xuất khi khách hàng mua hàng.
6. **Giao diện console đơn giản**, cần cải thiện trải nghiệm người dùng hoặc hướng tới giao diện đồ họa trong tương lai.

## Liên hệ
- Nếu bạn có bất kỳ câu hỏi hoặc góp ý nào, vui lòng liên hệ qua email: **hoangminhtri.ngo@gmail.com**.

---
Cảm ơn bạn đã sử dụng ứng dụng này! 🚀

