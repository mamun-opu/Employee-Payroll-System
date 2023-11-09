import java.util.ArrayList;
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
    public void showEmployeeList(){
        System.out.println("Employees and their details...");
        for(Employee employee: employeeList){
            System.out.print(employee.getId() + " " + employee.getName());
        }
    }

}



public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
    }

}