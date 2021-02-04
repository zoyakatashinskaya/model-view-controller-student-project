public class Controller implements ControllerInterface {
    ModelInterface model;
    View view;

    public Controller(ModelInterface model){
        this.model = model;
        view = new View(this, model);
        view.createView();
        view.createController();
    }

    @Override
    public void createEmployee(String name, String surname){
        this.model.createEmployee(name, surname);
        view.createdNewEmployeeView();
        view.createController();
    }

    @Override
    public void printEmployeeInfo() {
        view.printEmployeeInfoScreen();
        view.createController();
    }

    @Override
    public void setEmployee(String ID) {
        model.setEmployee(ID);
    }

    @Override
    public void updateNameSurname(String name, String surname, Employee employee) {
        model.updateNameSurname(name, surname, employee);
        view.updateEmployeeView("1");
        view.createController();
    }

    @Override
    public void updateAddress(String Address, Employee employee) {
        model.updateAddress(Address, employee);
        view.updateEmployeeView("2");
        view.createController();
    }

    @Override
    public void updatePhone(String Phone, Employee employee) {
        model.updatePhone(Phone, employee);
        view.updateEmployeeView("3");
        view.createController();
    }
}
