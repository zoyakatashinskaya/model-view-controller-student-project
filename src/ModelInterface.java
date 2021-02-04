public interface ModelInterface {

    void createEmployee(String pName, String pSurname);

    void setEmployee(String pId);

    void updateNameSurname(String name, String surname, Employee employee);

    void updateAddress(String Address, Employee employee);

    void updatePhone(String Phone, Employee employee);

    int getNumberOfEmployees();

    void registerObserver(EmployeeObserver o);

    void removeObserver(EmployeeObserver o);
}
