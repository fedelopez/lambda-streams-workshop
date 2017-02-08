package io.pivotal.lsw;

import io.pivotal.lsw._05GroupBy.Department;
import io.pivotal.lsw._05GroupBy.Employee;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class _05GroupByTest {

    @Test
    public void groupByDepartmentImperative() throws Exception {
        Department sales = new Department("sales");
        Department marketing = new Department("marketing");
        List<Employee> employees = asList(new Employee("john", sales), new Employee("mary", sales), new Employee("frank", marketing));
        Map<Department, List<Employee>> map = _05GroupBy.groupByDepartmentImperative(employees);
        System.out.println(map);
        assertThat(map).hasSize(2);
    }

    @Test
    public void groupByDepartment() throws Exception {
        Department sales = new Department("sales");
        Department marketing = new Department("marketing");
        List<Employee> employees = asList(new Employee("john", sales), new Employee("mary", sales), new Employee("frank", marketing));
        Map<Department, List<Employee>> map = _05GroupBy.groupByDepartment(employees);
        System.out.println(map);
        assertThat(map).hasSize(2);
    }
}
