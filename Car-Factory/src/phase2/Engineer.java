package phase2;

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
