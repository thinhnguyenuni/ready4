package fa.training.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.models.MauDat;
import fa.training.service.KhuDoThiService;
import fa.training.service.MauDatService;

//Đánh dấu lớp này là một Controller trong Spring Framework và xác định route chính cho các phương thức trong Controller này
@Controller
@RequestMapping(value = "/maudat")
public class MauDatController {

	// Autowired để Spring tự động inject các instance của các service
	@Autowired
	private MauDatService maudatService;

	// Autowired để Spring tự động inject các instance của các service
	@Autowired
	private KhuDoThiService khuDoThiService;

	// Danh sách các kích thước trang cho phân trang
	List<Integer> pageSizes = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 10));

	// Xử lý request GET đến đường dẫn "/maudat/create"
	@GetMapping("/create")
	public String getMauDat(Model model) {
		// Thêm một đối tượng MauDat mới vào Model để hiển thị trên view
		model.addAttribute("maudat", new MauDat());
		// Thêm các thông tin cần thiết vào Model
		model.addAttribute("urlPage", "/maudat/add");
		model.addAttribute("jqPage", "maudat");
		// Trả về đường dẫn của view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request POST đến đường dẫn "/maudat/create"
	@PostMapping("/create")
	public String createMauDat(@ModelAttribute("maudat") @Validated MauDat mauDat, BindingResult result, Model model) {
		// Kiểm tra xem mã khu đô thị có tồn tại không, nếu không tồn tại thì reject giá
		// trị và thông báo lỗi
		if (!khuDoThiService.existByID(mauDat.getKhuDoThi().getId())) {
			result.rejectValue("khuDoThi.id", "khuDoThi.idInvalid", "Mã khu đô thị này không tồn tại");
		}

		// Nếu có lỗi thì trả về view tạo mới mẫu đất
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/maudat/add");
			model.addAttribute("jqPage", "maudat");
			return "/base/view";
		}

		// Lưu hoặc cập nhật thông tin mẫu đất và chuyển hướng về danh sách giao dịch
		maudatService.saveOrUpdate(mauDat);
		return "redirect:/giaodich/list";
	}
}
