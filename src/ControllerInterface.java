public interface ControllerInterface {

    void createEmployee(String name, String surname);

    void updateNameSurname(String name, String surname, Employee employee);

    void updateAddress(String Address, Employee employee);

    void updatePhone(String Phone, Employee employee);

    void printEmployeeInfo();

    void setEmployee(String ID);

}
