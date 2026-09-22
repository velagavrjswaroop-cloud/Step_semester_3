package week66assignment;

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns (chains to the 3-arg constructor)
    public Employee(String empId, String empName) {
        this(empId, empName, 0); // salary set to 0
        this.isIntern = true;
    }

    // Method to print profile
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        // Permanent employee
        Employee e1 = new Employee("E-101", "Divya", 65000);
        e1.printProfile();

        // Intern
        Employee e2 = new Employee("E-102", "Arjun");
        e2.printProfile();
    }
}

