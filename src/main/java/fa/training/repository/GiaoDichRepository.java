package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.GiaoDich;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface GiaoDichRepository kế thừa từ JpaRepository, 
//được sử dụng để thao tác với đối tượng GiaoDich trong cơ sở dữ liệu
public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {

	// Định nghĩa một phương thức truy vấn tùy chỉnh sử dụng JPQL để lấy danh sách
	// các đối tượng SumInfoDTO
	@Query(value = "select new fa.training.models.dto.SumInfoDTO(md.id, kh.name, md.width, md.length, md.price, "
			+ "gd.id, kh.id, gd.price, gd.tienDatCoc, gd.ngayDatCoc, gd.ngayThanhToan, gd.status) "
			+ "FROM GiaoDich gd " 
			+ "JOIN gd.khachHang kh " 
			+ "JOIN gd.mauDat md " 
			+ "WHERE md.id LIKE %?1%")
	// Phương thức này nhận vào một chuỗi tìm kiếm và một đối tượng Pageable để phục
	// vụ cho việc phân trang
	Page<SumInfoDTO> findAllWithSearch(String searchInput, Pageable pageable);
}
