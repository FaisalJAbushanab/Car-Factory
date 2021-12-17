package phase2;

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

