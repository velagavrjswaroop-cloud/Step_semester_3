package week66assignment;

class Employe {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public Employe(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // increment count whenever a new employee is created
    }

    // Static method to print company info
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        // Create three Employee objects
        Employe e1 = new Employe("Ravi", 45000);
        Employe e2 = new Employe("Anitha", 55000);
        Employe e3 = new Employe("Karthik", 60000);

        // Call static method through class name
        Employe.printCompanyInfo();
    }
}

