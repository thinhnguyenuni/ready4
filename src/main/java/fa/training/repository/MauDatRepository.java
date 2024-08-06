package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.MauDat;

//Định nghĩa một interface MauDatRepository kế thừa từ JpaRepository,
//được sử dụng để thao tác với đối tượng MauDat trong cơ sở dữ liệu
public interface MauDatRepository extends JpaRepository<MauDat, String> {
	
	// Định nghĩa một phương thức truy vấn tùy chỉnh sử dụng JPQL để lấy danh sách các đối tượng MauDat dựa trên một chuỗi tìm kiếm
	@Query(value = "select md From MauDat md where md.id LIKE %?1%")
	
	// Phương thức này nhận vào một chuỗi tìm kiếm và một đối tượng Pageable để phục vụ cho việc phân trang
	Page<MauDat> findAllWithSearch(String searchInput, Pageable pageable);
}

