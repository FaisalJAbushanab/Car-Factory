package carFactory;

public class Worker implements Employee {

    private final int SALARY = 20;

    @Override
    public int getSalary() {
        return SALARY;
    }
}

