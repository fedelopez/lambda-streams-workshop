package io.pivotal.lsw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class _05GroupBy {

    @Data
    @AllArgsConstructor
    static class Department {
        String name;
    }

    @Data
    @AllArgsConstructor
    @ToString(exclude = "department")
    static class Employee {
        String name;
        Department department;
    }

    static Map<Department, List<Employee>> groupByDepartmentImperative(List<Employee> employees) {
        Map<Department, List<Employee>> map = new HashMap<>();
        for (Employee employee : employees) {
            List<Employee> departmentEmployees = map.get(employee.getDepartment());
            if (departmentEmployees == null) {
                departmentEmployees = new ArrayList<>();
            }
            departmentEmployees.add(employee);
            map.put(employee.getDepartment(), departmentEmployees);
        }
        return map;
    }

    static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.department));
    }
}
