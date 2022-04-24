package com.example.TestTask.controller;

import com.example.TestTask.exeptions.CustomerNotFoundException;
import com.example.TestTask.model.Customer;
import com.example.TestTask.service.imp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CostumerController {
     @Autowired
     private CustomerServiceImp customerService;

    @GetMapping(value = {"/create"})
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("customerModel", new Customer());
            modelAndView.setViewName("registration");
        } catch (Exception exception) {
        }
        return modelAndView;
    }
    @PostMapping("/create")
    public String registration(@ModelAttribute("customerModel") @Valid Customer customerModel,
                               BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            model.addAttribute("emailError", "Email address is wrong");
            return "create";
        }
        return "/deleteCustomer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCategory(Model model) {

        List<Customer> categoryList = customerService.allCustomers();
        model.addAttribute("categories",categoryList);
        return "deleteCustomer";
    }

    @PostMapping("/deleteCustomer")
    public String  deleteCategoryGet(@RequestParam(required = true, defaultValue = "" ) Long customerId,
                                     @RequestParam(required = true, defaultValue = "" ) String action,
                                     Model model) {

        if (action.equals("delete")){
            customerService.deleteCustomerId(customerId);
        }
        return "/deleteCustomer";
    }



    @GetMapping("/id/{id}")
    public Optional<Customer> getBook(@PathVariable long id) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer= customerService.findCustomerById(id);
        if(!optionalCustomer.isPresent())
        {
            throw new CustomerNotFoundException("id: "+ id);
        }
        return optionalCustomer;
    }

    @GetMapping("/api/customers")
    public String allCustomers(Model model) {

        List<Customer> categoryList = customerService.allCustomers();
        model.addAttribute("customers",categoryList);
        return "api/customers";
    }
    @GetMapping("/update/customer{id}")
    public void updateCustomer(Model model, @RequestBody Customer customer, long id) {

        customerService.updateCustomer(customer,id);
    }

}
