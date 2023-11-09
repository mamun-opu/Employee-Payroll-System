import java.util.ArrayList;
import java.util.Scanner;


abstract class Employee{
    private String name;
    private int id;
    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    abstract double calculateSalary();

}

class FullTimeEmployee extends Employee{
    private double salary;
    FullTimeEmployee(String name, int id, double salary){
        super(name, id);
        this.salary = salary;
    }

    @Override
    double calculateSalary() {
        return salary;
    }
}

class PartTimeEmployee extends Employee{
    private double workingHours;
    private double hourlyPayRate;
    PartTimeEmployee(String name, int id, double workingHours, double hourlyPayRate){
        super(name, id);
        this.workingHours = workingHours;
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    double calculateSalary() {
        return workingHours*hourlyPayRate;
    }
}

class EmployeePayRoll{
    private ArrayList<Employee> employeeList;
    EmployeePayRoll(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee emp){
        employeeList.add(emp);
        System.out.println("new employee added");
    }
    public void removeEmployee(int id){
        Employee empToRemove = null;
        for(Employee employee: employeeList){
            if(employee.getId() == id){
                empToRemove = employee;
                break;
            }
        }
        if(empToRemove != null){
            employeeList.remove(empToRemove);
        }else {
            System.out.println("Invalid ID");
        }
    }
    public ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }
    public void showEmployeeList(){
        System.out.println("Employees and their details...");
        for(Employee employee: employeeList){
            System.out.print(employee.getId() + " " + employee.getName() + " " + employee.calculateSalary());
            System.out.println();
        }
    }

}



public class Main {
    public static void main(String[] args) {
        EmployeePayRoll emppr = new EmployeePayRoll();
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Welcome to Employee Payroll System ***");
        System.out.println();
        int option = -1;
        while (true){
            if(emppr.getEmployeeList().isEmpty()){
                System.out.println("---- No employee added in the system ----");
                System.out.println();
            }else emppr.showEmployeeList();

            System.out.println("enter 1 to add new employee, 2 to remove, other number to exit ");
            option = scanner.nextInt();
            if (option == 1){
                int option2 = -1;
                System.out.print("""
                        enter 1 to add part-time or\s
                         2 to add full-time employee or
                         3 to remove employee.""");
                System.out.println();
                option2 = scanner.nextInt();
                if (option2 == 1){
                    scanner.nextLine();
                    System.out.print("enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("working hours: ");
                    double workHours = scanner.nextDouble();
                    System.out.print("Hourly work rate: ");
                    double workRate = scanner.nextDouble();
                    PartTimeEmployee employee = new PartTimeEmployee(name, id, workHours, workRate);
                    emppr.addEmployee(employee);

                } else if (option2 == 2) {
                    scanner.nextLine();
                    System.out.print("enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("enter salary: ");
                    double salary = scanner.nextDouble();
                    FullTimeEmployee employee = new FullTimeEmployee(name, id, salary);
                    emppr.addEmployee(employee);
                }
            } else if (option == 2) {
                break;
            } else if (option == 3) {
                System.out.print("enter id to remove: ");
                int id = scanner.nextInt();
                emppr.removeEmployee(id);
            }else System.out.println("wrong input");
        }


    }

}