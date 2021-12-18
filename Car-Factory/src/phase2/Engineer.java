package phase2;
/**
 * Class Engineer implements Employee interface
 */
public class Engineer implements Employee {

    private int SALARY = 18;

    @Override
    public int getSalary() {
        return SALARY;
    }
    public void setSalary(int salary) {
        SALARY = salary;
    }
}
