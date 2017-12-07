package com.sda.financialparadiseclient.controller;

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
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private  final String CODE_NUMBER = randomCode();

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerService customerService;

    @GetMapping("/find/all")
    public String users(ModelMap modelMap) throws Exception {
        //method 1
        //List<Map<String, Object>> userlist =  jdbcTemplate.queryForList("select * from users");

        List<Customer> userList = customerService.findAllCustomers();
        modelMap.addAttribute("customers", userList);
        return "customers";
    }


    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }


    @GetMapping("/customer")
    public String showForForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }


    @PostMapping("/customer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        customerService.addCustomer(customer);
        insertRoles(customer.getEmail(), customer.getPassword());
        return "redirect:/customers/find/all";
    }

    @PutMapping("/customer")
    public String sendUpdatedCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return "redirect:/customers/update";
        }
        customerService.updateCustomer(customer);
        return "redirect:/customers/find/all";
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestParam("customerId") int id) throws Exception {
        customerService.deleteCustomer(id);
        return "redirect:/customers/find/all";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) throws Exception {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute(customer);
        return "customer-update-form";
    }

    @GetMapping("/panel")
    public String customerPanel(){
        return "customer-panel";
    }

    @GetMapping("/panel/payment")
    public String sendTransfer(Model model){
        TransferReceiver transferReceiver = new TransferReceiver();
        model.addAttribute("transferReceiver", transferReceiver);
        return "payment-form";
    }

    @PostMapping("/panel/payment")
    public String sendATransfer(@ModelAttribute("transferReceiver") TransferReceiver transferReceiver,
                                HttpServletRequest httpServletRequest){

        String email = httpServletRequest.getUserPrincipal().getName();
        Customer customerFrom = customerService.findCustomerByEmail(email);
        CustomerWithTransferReceiver customerWithTransferReceiver = new CustomerWithTransferReceiver(customerFrom, transferReceiver);
        customerService.sendMoney(customerWithTransferReceiver);
        return "redirect:/customers/panel/payment/confirm";
    }

    @GetMapping("/panel/payment/confirm")
    public String confirmSMS(@ModelAttribute("transferReceiver") TransferReceiver transferReceiver,
                             HttpServletRequest request){
        sendSMS();
        return "payment-form-confirm";
    }

    @PostMapping("/panel/payment/confirm")
    public String confirmSMSCode(@ModelAttribute("transferReceiver") TransferReceiver transferReceiver,
                                 @RequestParam("code") String yourCode, Model model, HttpServletRequest request){

        System.out.println("----> " + transferReceiver.getName());
        String codeFromSms = CODE_NUMBER;
        if (codeFromSms.equals(yourCode)){
            System.out.println("HURA TWOJ KOD JEST POPRAWNY");
        } else{
            System.out.println("YOUR CODE JEST NIE POPRAWNY");
        }
        model.addAttribute("transferReceiver");
        return "redirect:/customers/panel/";
    }

    private  void insertRoles(String email, String password){
        String sqluser =
                String.format("INSERT INTO users (email, password, enabled) VALUES ('%s', '%s', true)",
                        email, password);
        jdbcTemplate.execute(sqluser);
        String sqlrole =
                String.format("INSERT INTO user_roles (email, role) VALUES ('%s', '%s')",
                        email, "ROLE_USER");
        jdbcTemplate.execute(sqlrole);
    }

    private void sendSMS(){
        String code = CODE_NUMBER;
        String body = "Your veryfication code is: " + code;
        SMSSender.sendMessage(body, "+48888760776");
    }

    private  String randomCode(){
        Random random = new Random();
        String randomCode = "";
        for (int i = 0; i < 5; i ++){
            randomCode += random.nextInt(10);
        }
        return randomCode;
    }

    @GetMapping("/panel/history")
    public String historyTransfer(ModelMap model, HttpServletRequest httpServletRequest) throws Exception {
        String email = httpServletRequest.getUserPrincipal().getName();
        Customer customer = customerService.findCustomerByEmail(email);
        List<TransferHistory> historyList = customerService.findAllTransferHistoryForSpecificAccount(customer.getAccount().getBankAccountNumber());
        model.addAttribute("historyList", historyList);
        return "transfer-history-list";
    }



}
