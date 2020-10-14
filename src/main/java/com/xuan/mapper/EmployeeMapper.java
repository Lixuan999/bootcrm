package com.xuan.mapper;

import com.xuan.bean.Department;
import com.xuan.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeMapper {
    //模拟数据库中员工表的数据
    private static Map<Integer, Employee> employees;

    @Autowired
    private DepartmentMapper departmentMapper;

    static {
        employees = new HashMap<>();//创建一个员工表
        employees.put(1, new Employee(1, "帅轩", "1234@qq.com", 1, new Department(1, "林业局"), new Date()));
        employees.put(2, new Employee(2, "丑印", "1345@qq.com", 1, new Department(2, "农业局"), new Date()));
        employees.put(3, new Employee(3, "珍珍", "5665@qq.com", 0, new Department(3, "水利局"), new Date()));
        employees.put(4, new Employee(4, "阿花", "7688@qq.com", 1, new Department(4, "林业局"), new Date()));
        employees.put(5, new Employee(5, "磊磊", "8089@qq.com", 1, new Department(5, "林业局"), new Date()));
    }

    //主键自增
    private static Integer initialID = 6;

    //增加一个员工
    public void addEmployee(Employee employee){
        if(employee.getId() == null)
            employee.setId(initialID++);
            employee.setDepartment(departmentMapper.getDepartmentById(employee.getId()));
            employees.put(employee.getId(),employee);
    }
    //查询全部员工信息
    public Collection<Employee> findAllEmployees(){
        return employees.values();
    }

    //通过id查询员工信息
    public Employee findById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工信息
    public void deleteById(Integer id){
        employees.remove(id);
    }
}
