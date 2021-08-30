package leetcode.problem690;

import java.util.List;

public class EmployeeImportance {
    public static void main(String[] args) {
    }

    public int getImportance(List<Employee> employees, int id) {
        employees.sort((e1, e2) -> {
            return e1.id - e2.id;
        });

        return dfs(employees, id);
    }

    public int dfs(List<Employee> employees, int id) {
        Employee e = binsearch(employees, id);
        int sum = e.importance;
        for (Integer subid : e.subordinates) {
            sum += dfs(employees, subid);
        }
        return sum;
    }

    public Employee binsearch(List<Employee> employees, int id) {
        int i = 0;
        int j = employees.size() - 1;
        while (i <= j) {
            int mid = ((j - i) >> 1) + i;
            int m = employees.get(mid).id;
            if (m < id) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return employees.get(i);
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}