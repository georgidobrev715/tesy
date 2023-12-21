package com.example.SirmaProject1.Service;

import com.example.SirmaProject1.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployeesFromCSV() {
        List<Employee> employees = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getResourceAsStream("/database.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; // Skip header line
                }
                String[] values = line.split(",");
                Employee employee = new Employee();
                employee.setEmplId(Integer.parseInt(values[0].trim()));
                employee.setProjectId(Integer.parseInt(values[1].trim()));
                employee.setStartDate(values[2].trim());
                employee.setEndDate(values[3].trim());
                employees.add(employee);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions as needed
        }
        return employees;
    }
}

