
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager extends Validation {

    List<Employee> list = new ArrayList<>();

    public void userAdd() {
        list.add(new Employee("0001", "John", "Sena", "0888456147", "johnsena1412@gmail.com", "USA", "14/1/1992", "Male", 99.99, "Medium"));
        list.add(new Employee("0101", "Sarah", "Blue", "0357981258", "sarah654@vtv.gov.vn", "Australia", "23/3/1990", "Female", 129.99, "High"));
        list.add(new Employee("0002", "Aaron", "Kane", "0366645198", "aarondaxua@hotmail.com", "England", "15/12/1993", "Male", 89.49, "Low"));
        list.add(new Employee("0011", "Jessica", "Lord", "0888999444", "jessicaop888@gmail.com", "Canada", "12/12/1991", "Female", 79.99, "Low"));
    }

    public int searchID(String ID) {
        int pos = -1;

        for (int i = 0; i < list.size(); i++) {
            if (ID.equalsIgnoreCase(list.get(i).getId())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public boolean yesNo(String string) {
        System.out.print(string);
        char c = sc.nextLine().toLowerCase().charAt(0);
        while (c != 'y' && c != 'n') {
            System.out.print("Please enter (Y/N): ");
            c = sc.nextLine().toLowerCase().charAt(0);
        }
        return c == 'y';
    }

    public void add() {
        System.out.println("========Add========");
        System.out.print("Enter ID: ");
        String ID = checkID();
        while (searchID(ID) != -1) {
            System.out.print("ID has existed!!! Re-enter: ");
            ID = checkID();
        }

        System.out.print("Enter FirstName: ");
        String firstName = checkName();
        System.out.print("Enter LastName: ");
        String lastName = checkName();
        System.out.print("Enter Phone number: ");
        String phoneNumber = checkPhone();
        System.out.print("Enter Email: ");
        String email = checkEmail();
        System.out.print("Enter Address: ");
        String address = sc.nextLine().trim();
        System.out.print("Enter Date of birth: ");
        String dob = checkDOB();
        System.out.print("Enter Sex: ");
        String sex = checkSex();
        System.out.print("Enter Salary: ");
        double salary = checkSalary();
        System.out.print("Enter Egency: ");
        String egency = checkEgency();

        list.add(new Employee(ID, firstName, lastName, phoneNumber, email, address, dob, sex, salary, egency));
        System.out.println("Add Successfully!!!");
        System.out.println("After add: ");
        showList();

    }

    public void update() {
        System.out.println("======Update======");
        showList();
        System.out.print("Enter ID: ");
        String ID = sc.nextLine().trim();
        if (searchID(ID) == -1) {
            System.out.println("Not found!!!");
            return;
        } else {
            System.out.println(list.get(searchID(ID)).toString());
            if (yesNo("Update ID (Y/N)? ")) {
                list.get(searchID(ID)).setId(checkID());
            }
            if (yesNo("Update First Name (Y/N)? ")) {
                list.get(searchID(ID)).setFirstName(checkName());
            }
            if (yesNo("Update Last Name (Y/N)? ")) {
                list.get(searchID(ID)).setLastName(checkName());
            }
            if (yesNo("Update Phone (Y/N)? ")) {
                list.get(searchID(ID)).setPhone(checkPhone());
            }
            if (yesNo("Update Email (Y/N)? ")) {
                list.get(searchID(ID)).setEmail(checkEmail());
            }
            if (yesNo("Update Address (Y/N)? ")) {
                list.get(searchID(ID)).setAddress(sc.nextLine().trim());
            }
            if (yesNo("Update Salary (Y/N)? ")) {
                list.get(searchID(ID)).setSalary(checkSalary());
            }
            if (yesNo("Update Egency (Y/N)? ")) {
                list.get(searchID(ID)).setEgency(checkEgency());
            }

        }
        System.out.println("Update Successfully!!!");
        System.out.println("After update:");
        System.out.println(list.get(searchID(ID)).toString());

    }

    public void remove() {
        System.out.println("======Remove======");
        showList();
        System.out.print("Enter ID: ");
        String ID = sc.nextLine().trim();
        if (searchID(ID) == -1) {
            System.out.println("Not found!!!");
        } else {
            System.out.println(list.get(searchID(ID)).toString());
            if (yesNo("Remove employee (Y/N)? ")) {
                list.remove(searchID(ID));
                System.out.println("Remove Successfully!!!");
                System.out.println("After remove:");
                showList();
            }
        }
    }

    public void searchName() {
        System.out.println("===Search by name===");
        int choice = 0;
        System.out.println( "1. First Name\n"
                + "2. Last Name"); 
                System.out.print("Your choice < 1 -> 2 >: ");
                choice = Main.checkInt(1, 2);
        switch (choice) {
              case 1:
                System.out.print("Enter First Name: ");
                String firstname = sc.nextLine().trim();
                int count1 = 0;
                for (Employee employee : list) {
                    if (firstname.equalsIgnoreCase(employee.getFirstName())) {
                        count1++;
                        if (count1 == 1) {
                            System.out.println("All employees found: ");
                        }
                        System.out.println(employee.toString());
                    }
                }
                if (count1 == 0) {
                    System.out.println("Not found!!!");
                }
                break;
            case 2:
                System.out.print("Enter Last Name: ");
                String lastname = sc.nextLine().trim();
                int count2 = 0;
                for (Employee employee : list) {
                    if (lastname.equalsIgnoreCase(employee.getFirstName())) {
                        count2++;
                        if (count2 == 1) {
                            System.out.println("All employees found: ");
                        }
                        System.out.println(employee.toString());
                    }
                }
                if (count2 == 0) {
                    System.out.println("Not found!!!");
                }
                break;
            case 3:
                 String fullname = sc.nextLine().toLowerCase().trim();
                 int count = 0;
                 for (Employee employee : list) {
                        if (fullname.contains(employee.getFirstName().toLowerCase()) || fullname.contains(employee.getLastName().toLowerCase())) {
                                count++;
                                if (count == 1) {
                                System.out.println("All employees found:");
                             }
                         System.out.println(employee.toString());
                   }
                   }
                if (count == 0) {
                        System.out.println("Not Found!!");
                    }
                    }
                break;
               }

    public void sortBySalary() {
        System.out.println("=======Sort=======");
        if (list.isEmpty()) {
            System.out.println("List is empty. Please add employee");
            System.out.println();
            return;
        }
       
        Collections.sort(list, (Employee t, Employee t1) -> {
            if (t.getSalary() > t1.getSalary()) {
                return 1;
            } else if (t.getSalary() < t1.getSalary()) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("After sort:");
        showList();
    }

    public void showList() {
        System.out.printf("%-8s %-12s %-11s %-13s %-25s %-15s %-13s %-8s %-8s %s\n",
                "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency");
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }

}
