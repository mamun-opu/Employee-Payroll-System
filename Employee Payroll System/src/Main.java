abstract class Employee{
    private String name;
    private double id;
    Employee(String name, double id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public double getId(){
        return id;
    }
    abstract double calculateSalary();

}





public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
    }

}