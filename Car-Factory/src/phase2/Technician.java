package phase2;
/**
 * Class Technician implements Employee interface
 */
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
