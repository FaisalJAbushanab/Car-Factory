package phase1;

public class Technician implements Employee {

    private final int SALARY = 12;

    @Override
    public int getSalary() {
        return SALARY;
    }
}
