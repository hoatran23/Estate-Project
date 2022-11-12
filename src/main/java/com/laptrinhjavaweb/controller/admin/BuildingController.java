package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.BuildingTypesDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.RentAreaService;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

	@Autowired
	private IBuildingService buildingService;

	@Autowired
	private IUserService userService;

	@Autowired
	private MessageUtils messageUtils;

	@Autowired
	private RentAreaService rentAreaService;

	@RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingRequestDTO buildingRequestDTO,
									 HttpServletRequest request
									/*@RequestParam("page") int currentPage,
									 @RequestParam("limit") int limit*/) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		// mav.addObject("modelSearch", buildingDTO);
		mav.addObject("staffmaps", userService.getStaffMaps());
		mav.addObject("districtmaps", buildingService.getDistricts());
		mav.addObject("renttypemaps", buildingService.getAllBuildingTypes());
		mav.addObject("buildingsSearch", buildingService.findAllBuildingSearch());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}

	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingAddOrUpdate(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		List<BuildingTypesDTO> buildingTypesDTOs = buildingService.getAllBuildingTypes();
		BuildingRequestDTO buildingRequestDTO = new BuildingRequestDTO();
		mav.addObject("modelEdit", buildingRequestDTO);
		mav.addObject("staffmaps", userService.getStaffMaps());
		mav.addObject("districtmaps", buildingService.getDistricts());
		mav.addObject("renttypemaps", buildingService.getBuildingTypesWithCheck(buildingTypesDTOs,
				buildingRequestDTO.getTypes()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}

	@RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
	public ModelAndView buildingUpdate(@PathVariable(value = "id", required = false) Long id,
											HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		List<BuildingTypesDTO> buildingTypesDTOs = buildingService.getAllBuildingTypes();
		BuildingRequestDTO buildingRequestDTO = new BuildingRequestDTO();
		if (id != null) {
			buildingRequestDTO = buildingService.findById(id);
			mav.addObject("modelEdit", buildingRequestDTO);

			List<RentAreaDTO> rentAreaDTOS = rentAreaService.findRentAreaByBuilding(id);
			mav.addObject("rentArea", rentAreaService.getRentAreas(rentAreaDTOS));
		}
		mav.addObject("modelEdit", buildingRequestDTO);
		mav.addObject("staffmaps", userService.getStaffMaps());
		mav.addObject("districtmaps", buildingService.getDistricts());
		mav.addObject("renttypemaps", buildingService.getBuildingTypesWithCheck(buildingTypesDTOs,
				buildingRequestDTO.getTypes()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}

	/*@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingAddOrUpdate(@RequestParam(value = "id", required = false) Long id,
											HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		List<BuildingTypesDTO> buildingTypesDTOs = buildingService.getAllBuildingTypes();
		BuildingRequestDTO buildingRequestDTO = new BuildingRequestDTO();
		if (id != null) {
			buildingRequestDTO = buildingService.findById(id);
			mav.addObject("modelEdit", buildingRequestDTO);

			List<RentAreaDTO> rentAreaDTOS = rentAreaService.findRentAreaByBuilding(id);
			mav.addObject("rentArea", rentAreaService.getRentAreas(rentAreaDTOS));
		}
		mav.addObject("modelEdit", buildingRequestDTO);
		mav.addObject("staffmaps", userService.getStaffMaps());
		mav.addObject("districtmaps", buildingService.getDistricts());
		mav.addObject("renttypemaps", buildingService.getBuildingTypesWithCheck(buildingTypesDTOs,
				buildingRequestDTO.getTypes()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}*/
}
