package com.xuan.controller;

import com.xuan.bean.Department;
import com.xuan.bean.Employee;
import com.xuan.mapper.DepartmentMapper;
import com.xuan.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @RequestMapping("/find")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.findAllEmployees();
        model.addAttribute("employees",employees);
        //返回到list页面
        return "emp/list";
    }

    @GetMapping("/insert")
    public String insert(Model model) {
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentMapper.department();
        model.addAttribute("departments", departments);
        return "emp/insert";//返回到添加员工页面
    }

    @PostMapping("/insert")
    public String save(Employee employee) {
        System.err.println("debug=======>"+employee);
        employeeMapper.addEmployee(employee);//添加一个员工
        return "redirect:find";//重定向到/emps,刷新列表,返回到list页面
    }

}
