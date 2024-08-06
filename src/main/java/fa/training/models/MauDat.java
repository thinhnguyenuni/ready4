package fa.training.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
public class MauDat {
	@Id
	@Pattern(regexp = "^MD\\d{3}$", message = "Nhập không đúng định dạng (MDxxx)")
	private String id;

	@Positive(message = "Số phải lớn hơn 0")
	private Integer number;

	@Positive(message = "Số phải lớn hơn 0")
	private Integer width;

	@Positive(message = "Số phải lớn hơn 0")
	private Integer length;

	@Positive(message = "Số phải lớn hơn 0")
	private Long price;

	@ManyToOne(fetch = FetchType.LAZY)
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	private KhuDoThi khuDoThi;

	@OneToMany(mappedBy = "mauDat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<GiaoDich> giaoDichs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public KhuDoThi getKhuDoThi() {
		return khuDoThi;
	}

	public void setKhuDoThi(KhuDoThi khuDoThi) {
		this.khuDoThi = khuDoThi;
	}

	public Set<GiaoDich> getGiaoDichs() {
		return giaoDichs;
	}

	public void setGiaoDichs(Set<GiaoDich> giaoDichs) {
		this.giaoDichs = giaoDichs;
	}

	public MauDat() {
	}

	public MauDat(@Pattern(regexp = "^MD\\d{3}$", message = "Nhập không đúng định dạng (MDxxx)") String id,
			@Positive(message = "Số phải lớn hơn 0") Integer number,
			@Positive(message = "Số phải lớn hơn 0") Integer width,
			@Positive(message = "Số phải lớn hơn 0") Integer length,
			@Positive(message = "Số phải lớn hơn 0") Long price) {
		this.id = id;
		this.number = number;
		this.width = width;
		this.length = length;
		this.price = price;
	}

	@Override
	public String toString() {
		return "MauDat [id=" + id + ", number=" + number + ", width=" + width + ", length=" + length + ", price="
				+ price + "]";
	}

}
