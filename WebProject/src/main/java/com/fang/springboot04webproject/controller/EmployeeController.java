package com.fang.springboot04webproject.controller;

import com.fang.springboot04webproject.dao.DepartmentDao;
import com.fang.springboot04webproject.dao.EmployeeDao;
import com.fang.springboot04webproject.entities.Department;
import com.fang.springboot04webproject.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查出所有员工并返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        //获取所有员工
        Collection<Employee> emp = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",emp);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //获取所有部门
        Collection<Department> departments = departmentDao.getDepartments();

        //放在请求域中
        model.addAttribute("depts",departments);

        //跳转到add页面
        return "emp/add";
    }

    //实现员工添加功能
    //SpringMVC会自动将入参数据与请求参数进行绑定：要求是请求参数的名字和javabean入参对象的里面属性名是一样的（下面的Employee就是这样）
    @PostMapping("/emp")
    public String addFunction(Employee employee){
        //保存员工
        employeeDao.save(employee);
        //redirect表示重定向，这样就可以自定重定向到员工列表页面
        return "redirect:/emps";
    }

    // 接收修改请求跳转到修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.get(id);      //通过传入的id获取到指定的employee

        model.addAttribute("emp",employee);
        //获取所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        //放在请求域中
        model.addAttribute("depts",departments);

        return "emp/edit";
    }

    //员工修改功能
    @PutMapping("/emp")
    public String updateFunction(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除功能
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
