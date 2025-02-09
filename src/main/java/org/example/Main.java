package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, "John", "Doe" ));
        employeeList.add(new Employee(1, "John", "Doe"));

        employeeList.add(new Employee(2, "Jane", "Doe"));

        employeeList.add(new Employee(3, "Josh", "Doe"));
        employeeList.add(new Employee(3, "Josh", "Doe"));

        employeeList.add(new Employee(4,"Jeremy", "Doe"));


        System.out.println(findDuplicates(employeeList));
        System.out.println(findUniques(employeeList));
        System.out.println(removeDuplicates(employeeList));

    }

    public static List<Employee> findDuplicates(List<Employee> employeeList){

        Map<Integer, Employee> employeeMap = new HashMap<>();
        Set<Employee> duplicates = new HashSet<>();

        Iterator<Employee> iterator = employeeList.iterator();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                duplicates.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }

        return duplicates.stream().toList() ;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employeeList){
        Map<Integer, Employee> map = new HashMap<>();

        Iterator<Employee> iterator = employeeList.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                continue;
            }
            if(!(map.containsKey(employee.getId()))){
                map.put(employee.getId(), employee);
            }
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList){

        List<Employee> duplicates = findDuplicates(employeeList);
        Map<Integer, Employee> uniques = findUniques(employeeList);



        List<Employee> justUniques = new LinkedList<>(uniques.values());
        justUniques.removeAll(duplicates);

        return justUniques;

    }
}