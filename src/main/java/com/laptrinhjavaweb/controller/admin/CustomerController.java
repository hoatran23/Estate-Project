package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private MessageUtils messageUtils;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView customerList(@ModelAttribute("modelSearch") CustomerDTO customerDTO,
                                     HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("customers", customerService.getCustomers());
        mav.addObject("customerSearch", customerService.getCustomers());
        mav.addObject("staffmaps", userService.getStaffMaps());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit", method = RequestMethod.GET)
    public ModelAndView addCustomer(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        CustomerDTO customerDTO = new CustomerDTO();
        mav.addObject("modelEdit", customerDTO);
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit-{id}", method = RequestMethod.GET)
    public ModelAndView buildingUpdate(@PathVariable(value = "id", required = false) Long id,
                                       HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        CustomerDTO customerDTO = customerService.findById(id);
        mav.addObject("modelEdit", customerDTO);

        TransactionDTO transactionDTO = new TransactionDTO();
        mav.addObject("modelTransaction", transactionDTO);
        mav.addObject("transactionTypeMap", customerService.getTransactionsType());

        mav.addObject("transactions", customerService.getTransactionsByCustomer(id));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        return mav;
    }
}
