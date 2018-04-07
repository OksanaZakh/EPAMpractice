package com.oksana.zakharchenko.nestedclass;

import java.util.*;

public class Store {
    private String name;
    private List<Department> departments;
    private int productsInSore;

    public Store(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        productsInSore = 0;
    }

    public Store(String name, int productsInSore) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.productsInSore = productsInSore;

    }

    public void setProductsInSore(int productsInSore) {
        this.productsInSore = productsInSore;
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public int getProductsInSore() {
        return productsInSore;
    }

    public Map<String, String> getDepartmentsAndProducts() {
        Map<String, String> departmentsAndProducts = new HashMap<>();
        for (Department department : departments) {
            departmentsAndProducts.put(department.departmentName, department.productType);
        }
        return departmentsAndProducts;
    }

    private boolean isDepartmentStore(String name) {
        for (Department department : departments) {
            if (department.departmentName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean createDepartment(String name, String productType, int location) {
        if (!isDepartmentStore(name)) {
            departments.add(new Department(name, productType, location));
            return true;
        } else return false;
    }

    public boolean deleteDepartment(String name) {
        if (isDepartmentStore(name)) {
            for (int k = 0; k < departments.size(); k++) {
                Department department = departments.get(k);
                if (department.departmentName.equals(name)) {
                    productsInSore += department.productsCount;
                    departments.remove(department);
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public void sortDepartmentsByProducts(){
         departments.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.productsCount-o2.productsCount;
            }
        });
    }


    public boolean supplyToDepartment(String depName, String type, int count) {
        if (count < 0 && productsInSore > count) {
            System.out.println("It is not possible to make supply of " + count + " products");
            return false;
        } else {
            for (Department department : departments) {
                if (department.departmentName.equals(depName) && department.productType.equals(type)) {
                    department.productsCount +=count;
                    productsInSore -= count;
                    return true;
                } else return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\n' +
                ", departments=" + departments +"\n"+
                ", productsInSore=" + productsInSore +
                '}';
    }

    private class Department {
        String departmentName;
        String productType;
        int productsCount;

        Department(String departmentName, String productType, int productsCount) {
            this.departmentName = departmentName;
            this.productType = productType;
            this.productsCount = productsCount;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "departmentName='" + departmentName + '\'' +
                    ", productType='" + productType + '\'' +
                    ", productsCount=" + productsCount +
                    '}'+"\n";
        }
    }
}
