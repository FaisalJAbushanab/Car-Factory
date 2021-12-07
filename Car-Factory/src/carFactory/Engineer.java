package carFactory;

public class Engineer implements Employee {

    private final int SALARY = 60;

    @Override
    public int getSalary() {
        return SALARY;
    }
}
