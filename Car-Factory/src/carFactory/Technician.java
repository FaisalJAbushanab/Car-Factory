package carFactory;

public class Technician implements Employee {

    private final int SALARY = 40;

    @Override
    public int getSalary() {
        return SALARY;
    }
}
