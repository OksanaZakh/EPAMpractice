package com.oksana.zakharchenko.nestedclass;

public class ManageStore {

    public static  void runStoreManager() {
        Store store = new Store("EKO", 10000);
        System.out.println(store);
        System.out.println("******************");
        store.createDepartment("Literature", "Books", 100);
        store.createDepartment("Periodical literature", "Press", 50);
        store.createDepartment("For kids", "Toys", 20);
        System.out.println(store);
        System.out.println("******************");
        System.out.println("GetDepartments function:");
        System.out.println(store.getDepartments());
        System.out.println("******************");
        System.out.println("GetDepartmentsAndProducts function:");
        System.out.println(store.getDepartmentsAndProducts().values() + " " + store.getDepartmentsAndProducts().keySet());
        System.out.println("******************");
        System.out.println("Sort function:");
        store.sortDepartmentsByProducts();
        System.out.println(store);
        System.out.println("******************");
        System.out.println("Supply function:");
        store.supplyToDepartment("Literature", "Books", -2);
        store.supplyToDepartment("For kids", "Toys", 20);
        System.out.println(store);
        System.out.println("******************");
        System.out.println("Delete function:");
        store.deleteDepartment("For kids");
        System.out.println(store);
    }

}
