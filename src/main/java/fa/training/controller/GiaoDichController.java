package fa.training.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.models.GiaoDich;
import fa.training.models.dto.SumInfoDTO;
import fa.training.service.GiaoDichService;

//Đánh dấu lớp này là một Controller trong Spring Framework
@Controller
//Xác định route chính cho các phương thức trong Controller này
@RequestMapping(value = "/giaodich")
public class GiaoDichController {
	// Autowired để Spring tự động inject các instance của các service
//	@Autowired
//	private MauDatService maudatService;

	@Autowired
	private GiaoDichService giaoDichService;

	// Danh sách các kích thước trang cho phân trang
	List<Integer> pageSizes = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 10));

	// Xử lý request GET đến đường dẫn "/giaodich/list"
	@GetMapping("/list")
	public String showAllGiaoDich(Model model,
			// RequestParam để lấy các tham số từ URL
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "3") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		
		// Tạo Pageable object để phục vụ cho việc phân trang
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		// Gọi service để lấy danh sách giao dịch theo các tham số truyền vào
		Page<SumInfoDTO> sumInfos = giaoDichService.findAllWithSearch(search.trim(), pageable);
		// Thêm các thông tin cần thiết vào Model để hiển thị trên view
		model.addAttribute("sumInfos", sumInfos.getContent());
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", sumInfos.getTotalElements());
		model.addAttribute("totalPages", sumInfos.getTotalPages());
		model.addAttribute("search", search);
		model.addAttribute("urlPage", "/giaodich/list");
		model.addAttribute("jqPage", "list");
		// Trả về view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request GET đến đường dẫn "/giaodich/update"
	@GetMapping("/update")
	public String getUpdateGiaoDich(@RequestParam(name = "id") String id, Model model) {
		// Lấy thông tin giao dịch cần cập nhật và thêm vào Model
		model.addAttribute("giaodich", giaoDichService.findById(id));
		model.addAttribute("urlPage", "/giaodich/update");
		// Trả về view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request POST đến đường dẫn "/giaodich/update"
	@PostMapping("/update")
	public String updateGiaoDich(@ModelAttribute("giaodich") @Validated GiaoDich giaoDich, BindingResult result,
			Model model) {
		// Kiểm tra xem có trùng mã khách hàng hay không, nếu có thì reject giá trị và
		// thông báo lỗi
		if (giaoDichService.duplicateMaKH(giaoDich)) {
			System.out.println("trùng");
			result.rejectValue("khachHang.id", "khachHang.idInvalid",
					"Mã khách hàng đang chọn trùng mã chủ sở hữu. Vui lòng chọn lại");
		}

		// Nếu có lỗi thì trả về view cập nhật
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/giaodich/update");
			return "/base/view";
		}

		// Lưu hoặc cập nhật thông tin giao dịch và chuyển hướng về danh sách giao dịch
		giaoDichService.saveOrUpdate(giaoDich);
		return "redirect:/giaodich/list";
	}

	// Xử lý request GET đến đường dẫn "/giaodich/delete/{id}"
	@GetMapping("/delete/{id}")
	public String deleteDetail(@PathVariable(name = "id") String maudatId, Model model) {
		// Xóa thông tin mẫu đất với id được cung cấp và chuyển hướng về danh sách mẫu
		// đất
		giaoDichService.deleteById(maudatId);
		return "redirect:/giaodich/list";
	}
}
