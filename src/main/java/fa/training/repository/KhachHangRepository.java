package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.models.KhachHang;

//Định nghĩa một interface KhachHangRepository kế thừa từ JpaRepository,
//được sử dụng để thao tác với đối tượng KhachHang trong cơ sở dữ liệu
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

}
