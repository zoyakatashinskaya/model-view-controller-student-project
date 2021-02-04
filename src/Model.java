import java.util.ArrayList;

public class Model implements ModelInterface {
    ArrayList<Employee> employees = new ArrayList(); //list of all employees
    ArrayList employeeIdObservers = new ArrayList();

    @Override
    public void createEmployee(String pName, String pSurname) {
        Employee newEmployee = new Employee(pName, pSurname);
        employees.add(newEmployee);
        notifyEmployeeObservers(newEmployee);
    }

    @Override
    public void setEmployee(String pId) {
        for(Employee e : this.employees){
            if(e.getId().equals(pId)){
                notifyEmployeeObservers(e);
            }
        }
    }

    @Override
    public void updateNameSurname(String name, String surname, Employee employee) {
        employee.setName(name);
        employee.setSurname(surname);
    }

    @Override
    public void updateAddress(String address, Employee employee) {
        employee.setAddress(address);
    }

    @Override
    public void updatePhone(String phone, Employee employee) {
        employee.setPhone(phone);
    }

    public void registerObserver(EmployeeObserver o){
        employeeIdObservers.add(o);
    }

    public void notifyEmployeeObservers(Employee e) {
        for(int i = 0; i < employeeIdObservers.size(); i++){
            EmployeeObserver observer = (EmployeeObserver)employeeIdObservers.get(i);
            observer.updateEmployee(e);
        }
    }

    public void removeObserver(EmployeeObserver o){
        int i = employeeIdObservers.indexOf(o);
        if (i >= 0){
            employeeIdObservers.remove(i);
        }
    }

    //getters & setters
    @Override
    public int getNumberOfEmployees(){
        return this.employees.size();
    }


}
