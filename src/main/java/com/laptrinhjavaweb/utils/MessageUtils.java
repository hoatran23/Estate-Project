package com.laptrinhjavaweb.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageUtils {

	public Map<String, String> getMessage(String message) {
		Map<String, String> result = new HashMap<>();
		if (message.equals("update_success")) {
			result.put("message", "Cập nhật thành công");
			result.put("alert", "success");
		} else if (message.equals("insert_success")) {
			result.put("message", "Thêm thành công");
			result.put("alert", "success");
		} else if (message.equals("delete_success")) {
			result.put("message", "Xóa thành công");
			result.put("alert", "success");
		} else if (message.equals("error_system")) {
			result.put("message", "Lỗi hệ thống");
			result.put("alert", "danger");
		} else if (message.equals("error_syntax")) {
			result.put("message", "Lỗi định dạng khi nhập diện tích thuê");
			result.put("alert", "danger");
		} else if (message.equals("insert_transaction")) {
			result.put("message", "Thêm giao dịch thành công");
			result.put("alert", "success");
		} else if (message.equals("error_input")) {
			result.put("message", "Lỗi định dạng hoặc chưa nhập các trường cần thiết");
			result.put("alert", "danger");
		}
		return result;
	}
}
