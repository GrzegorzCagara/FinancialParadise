package com.sda.financialparadiseclient.controller;

import com.sda.financialparadiseclient.config.SMSConfiguration;
import com.sda.financialparadiseclient.config.SMSSender;
import com.sda.financialparadiseclient.dto.Customer;
import com.sda.financialparadiseclient.dto.CustomerWithTransferReceiver;
import com.sda.financialparadiseclient.dto.TransferHistory;
import com.sda.financialparadiseclient.dto.TransferReceiver;
import com.sda.financialparadiseclient.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private HashMap<String, String> phoneNumbers = SMSConfiguration.getPhoneNumbers();
    private String CODE_NUMBER;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }


//    @GetMapping("/new")
//    public String showForForAdd(Model model) {
//        Customer customer = new Customer();
//        model.addAttribute("customer", customer);
//        return "customer-register";
//    }
//
//    @PostMapping("/new")
//    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) throws Exception {
//        if (bindingResult.hasErrors()) {
//            return "customer-register";
//        }
//        customerService.addCustomer(customer);
//        insertRoles(customer.getEmail(), customer.getPassword());
//        return "redirect:/";
//    }

    @GetMapping("/panel")
    public String customerPanel() {
        return "customer-panel";
    }

    @GetMapping("/panel/payment")
    public String sendTransfer(Model model) {
        TransferReceiver transferReceiver = new TransferReceiver();
        model.addAttribute("transferReceiver", transferReceiver);
        return "customer-payment";
    }

    @GetMapping(value = "/panel/payment/final")
    public String sendATransfer(HttpServletRequest request) {
        TransferReceiver tr = (TransferReceiver) request.getSession().getAttribute("transferReceiver");
        String email = request.getUserPrincipal().getName();
        System.out.println(email);
        Customer customerFrom = customerService.findCustomerByEmail(email);
        System.out.println(customerFrom.getEmail());
        CustomerWithTransferReceiver customerWithTransferReceiver = new CustomerWithTransferReceiver(customerFrom, tr);
        System.out.println(customerWithTransferReceiver.getCustomer().getAccount().getBankAccountNumber());
        customerService.sendMoney(customerWithTransferReceiver);
        return "redirect:/customers/panel/payment/successfull";
    }

    @PostMapping("/panel/payment/confirm")
    public String confirmSMS(@ModelAttribute("transferReceiver") TransferReceiver transferReceiver,
                             HttpServletRequest request) {
        request.getSession().setAttribute("transferReceiver", transferReceiver);
        String email = request.getUserPrincipal().getName();
        sendSMS(email);
        return "customer-payment-confirm";
    }

    @PostMapping("/panel/payment/confirm-sms")
    public String confirmSMSCode(@RequestParam("code") String yourCode, Model model, HttpServletRequest request) {
        TransferReceiver tr = (TransferReceiver) request.getSession().getAttribute("transferReceiver");
        request.getSession().setAttribute("transferReceiver", tr);
        String codeFromSms = CODE_NUMBER;
        if (codeFromSms.equals(yourCode)) {
            model.addAttribute("transferReceiver");
            return "redirect:/customers/panel/payment/final";
        } else {
            return "redirect:/customers/panel/payment/wrong-sms-code";
        }
    }

    @GetMapping("/panel/history")
    public String historyTransfer(ModelMap model, HttpServletRequest httpServletRequest) throws Exception {
        String email = httpServletRequest.getUserPrincipal().getName();
        Customer customer = customerService.findCustomerByEmail(email);
        List<TransferHistory> historyList = customerService.findAllTransferHistoryForSpecificAccount(customer.getAccount().getBankAccountNumber());
        model.addAttribute("historyList", historyList);
        return "customer-transfer-history";
    }

    @GetMapping("/panel/payment/successfull")
    public String successfullTransfer() {
        return "successfull";
    }

    @GetMapping("/panel/payment/wrong-sms-code")
    public String badSmsCode() {
        return "bad-sms-code";
    }

    private void insertRoles(String email, String password) {
        String sqluser =
                String.format("INSERT INTO users (email, password, enabled) VALUES ('%s', '%s', true)",
                        email, password);
        jdbcTemplate.execute(sqluser);
        String sqlrole =
                String.format("INSERT INTO user_roles (email, role) VALUES ('%s', '%s')",
                        email, "ROLE_USER");
        jdbcTemplate.execute(sqlrole);
    }

    private void sendSMS(String email) {
        CODE_NUMBER = generateVerificationCode();
        String body = "Your veryfication code is: " + CODE_NUMBER;
        String phoneNumber = phoneNumbers.get(email);
        SMSSender.sendMessage(body, phoneNumber);
    }

    private String generateVerificationCode() {
        Random random = new Random();
        String randomCode = "";
        for (int i = 0; i < 6; i++) {
            randomCode += random.nextInt(10);
        }
        return randomCode;
    }
}
