package com.example.SirmaProject1.Controller;

import com.example.SirmaProject1.Model.Employee;
import com.example.SirmaProject1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showEmployeeList(Model model) {
        List<Employee> employees = employeeService.getEmployeesFromCSV();
        model.addAttribute("employees", employees);
        return "index.html"; // Return the name of your Thymeleaf template file
    }
}
