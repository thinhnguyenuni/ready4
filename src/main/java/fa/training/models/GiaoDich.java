package fa.training.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class GiaoDich {
	 // ID của giao dịch, được ánh xạ với cột "MaGiaoDich" trong cơ sở dữ liệu
    @Id
    @Pattern(regexp = "^GD\\d{3}$", message = "Nhập không đúng định dạng (GDxxx)")
    private String id;

    // Giá giao dịch, không âm
    @Positive(message = "Số phải lớn hơn 0")
    private Long price;

    // Tiền đặt cọc, không âm
    @Positive(message = "Số phải lớn hơn 0")
    private Long tienDatCoc;

    // Ngày đặt cọc, định dạng yyyy-MM-dd
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayDatCoc;

    // Ngày thanh toán, định dạng yyyy-MM-dd
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayThanhToan;

    // Phương thức giao dịch, cột có định nghĩa dạng nvarchar(50)
    private String method;

    // Trạng thái của giao dịch, cột có định nghĩa dạng nvarchar(50)
    private String status;

    // Mối quan hệ nhiều-đến-một với đối tượng KhachHang
    @ManyToOne(fetch = FetchType.LAZY)
    private KhachHang khachHang;

    // Mối quan hệ nhiều-đến-một với đối tượng MauDat
    @ManyToOne(fetch = FetchType.LAZY)
    private MauDat mauDat;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(Long tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}

	public LocalDate getNgayDatCoc() {
		return ngayDatCoc;
	}

	public void setNgayDatCoc(LocalDate ngayDatCoc) {
		this.ngayDatCoc = ngayDatCoc;
	}

	public LocalDate getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(LocalDate ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public MauDat getMauDat() {
		return mauDat;
	}

	public void setMauDat(MauDat mauDat) {
		this.mauDat = mauDat;
	}

	public GiaoDich() {
	}

	public GiaoDich(@Pattern(regexp = "^GD\\d{3}$", message = "Nhập không đúng định dạng (GDxxx)") String id,
			@Positive(message = "Số phải lớn hơn 0") Long price,
			@Positive(message = "Số phải lớn hơn 0") Long tienDatCoc, LocalDate ngayDatCoc, LocalDate ngayThanhToan,
			String method, String status, KhachHang khachHang, MauDat mauDat) {
		this.id = id;
		this.price = price;
		this.tienDatCoc = tienDatCoc;
		this.ngayDatCoc = ngayDatCoc;
		this.ngayThanhToan = ngayThanhToan;
		this.method = method;
		this.status = status;
		this.khachHang = khachHang;
		this.mauDat = mauDat;
	}

	public GiaoDich(@Pattern(regexp = "^GD\\d{3}$", message = "Nhập không đúng định dạng (GDxxx)") String id,
			@Positive(message = "Số phải lớn hơn 0") Long price,
			@Positive(message = "Số phải lớn hơn 0") Long tienDatCoc, LocalDate ngayDatCoc, LocalDate ngayThanhToan,
			String method, String status) {
		this.id = id;
		this.price = price;
		this.tienDatCoc = tienDatCoc;
		this.ngayDatCoc = ngayDatCoc;
		this.ngayThanhToan = ngayThanhToan;
		this.method = method;
		this.status = status;
	}

	@Override
	public String toString() {
		return "GiaoDich [id=" + id + ", price=" + price + ", tienDatCoc=" + tienDatCoc + ", ngayDatCoc=" + ngayDatCoc
				+ ", ngayThanhToan=" + ngayThanhToan + ", method=" + method + ", status=" + status + "]";
	}

}
