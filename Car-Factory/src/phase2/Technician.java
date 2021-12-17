package phase2;

public class Technician implements Employee {

    private int SALARY = 12;

    @Override
    public int getSalary() {
        return SALARY;
    }
    public void setSalary(int salary) {
        SALARY = salary;
    }
}
