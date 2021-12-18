package phase1;
/**
 * Class Worker implements Employee interface
 */
public class Worker implements Employee {

    private final int SALARY = 6;

    @Override
    public int getSalary() {
        return SALARY;
    }
}

