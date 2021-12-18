package phase2;
/**
 * Class Worker implements Employee interface
 */
public class Worker implements Employee {

    private int SALARY = 6;

    @Override
    public int getSalary() {
        return SALARY;
    }
    public void setSalary(int salary) {
        SALARY = salary;
    }
}

