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

}



public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
    }

}