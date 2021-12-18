package phase1;
/**
 * Class Technicnian implements Employee interface
 */
public class Technician implements Employee {

    private final int SALARY = 12;

    @Override
    public int getSalary() {
        return SALARY;
    }
}
