import java.util.Scanner;

public class View implements EmployeeObserver {
    ModelInterface model;
    ControllerInterface controller;
    Employee employee;

    public View(ControllerInterface pController, ModelInterface pModel){
        this.model = pModel;
        this.controller = pController;
        model.registerObserver((EmployeeObserver)this);
    }

    //VIEWS
    public void createView() {
        viewButton();
        System.out.println("This is the Best Company Management System.\n");
    }

    public void createdNewEmployeeView(){
        viewButton();
        System.out.println("\nNew employee has been successfully created.");
        System.out.println(this.employee.toString()+"\n");
    }

    public void printEmployeeInfo(String option){
        viewButton();
        if (option.equals("1")) {
            System.out.println(this.employee.toString() + "\n");
        } if (option.equals("2")) {
            System.out.println("Address is " + employee.getAddress());
        } if (option.equals("3")) {
            System.out.println("Phone number is " + employee.getPhone());
        }
    }

    public void updateEmployeeView(String option){
        viewButton();
        if (option.equals("1")) {
            System.out.println("Employee's new name and surname are: \n" + employee.toString());
        } if (option.equals("2")) {
            System.out.println("Employee's new address is " + employee.getAddress() + "\n");
        } if (option.equals("3")) {
            System.out.println("Employee's new phone number is " + employee.getPhone() + "\n");
        }
    }

    //CONTROLLER
    public void createController(){
        controllerButton();
        printInfoAboutNumberOfEmployees();
        controllerScreen();
        String choice = yourChoice();
        if (choice.equals("1")) {
            createEmployeeScreen();
        } if (choice.equals("2")) {
            controller.printEmployeeInfo();
        } if (choice.equals("3")) {
            updateEmployeeInfoScreen();
        }
    }

    private void createEmployeeScreen(){
        System.out.println("CREATING NEW EMPLOYEE: ");
        String name = stringInput("a name");
        String surname = stringInput("a surname");
        this.controller.createEmployee(name, surname);
    }

    private String yourChoice(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your choice: ");
            String choice = scanner.nextLine();

            //check for valid input
            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                return choice;
            } else {
                System.out.println("This is an invalid input. Please, enter 1, 2 or 3.");
            }
        }
    }

    public void printEmployeeInfoScreen(){
        System.out.println("PRINT EMPLOYEE INFO");
        chooseEmployee(); //choose the employee and sets it in view
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select what would you like to print out:");
        printingAndUpdatigOptions(); // 1-Name, 2-Address
        String option = scanner.nextLine();
        printEmployeeInfo(option); // prints the corresponding info
    }

    private void updateEmployeeInfoScreen(){
        System.out.println("UPDATE EMPLOYEE INFO");
        chooseEmployee();
        System.out.println("Select what would you like to update:");
        printingAndUpdatigOptions(); // 1-Name, 2-Address
        String choice = yourChoice();
        if (choice.equals("1")) {
            String name = stringInput("new name");
            String surname = stringInput("new surname");
            controller.updateNameSurname(name, surname, this.employee);
        } if (choice.equals("2")) {
            String address = stringInput(" new address");
            controller.updateAddress(address, employee);
        } if (choice.equals("3")) {
            String phone = stringInput("new phone");
            System.out.println("phone entered:" + phone);
            controller.updatePhone(phone, employee);
        }
    }

    @Override
    public void updateEmployee(Employee e){
        this.employee = e;
    }

    //helper small functions
    private void controllerScreen(){
        System.out.println("Please, select an action:\n" +
                "1) Create New Employee\n" +
                "2) Print information\n"
                + "3) Update information"
        );
    }

    private void printingAndUpdatigOptions(){
        System.out.println("1) Name & Surname\n" +
                "2) Address\n" +
                "3) Phone number"
        );
    }

    private void chooseEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter employee's ID: ");
        String ID = scanner.nextLine();
        controller.setEmployee(ID);
    }

    // BUTTONS
    private void viewButton(){
        System.out.println("########### VIEW ###########");
    }

    private void controllerButton(){
        System.out.println("########### CONTROLLER ###########");
    }

    private void printInfoAboutNumberOfEmployees(){
        if (model.getNumberOfEmployees()==0){
            System.out.println("There are no employees in the system. \n" +
                    "Please, create new entry.\n");
        } else {
            System.out.println("There are/is "+
                    this.model.getNumberOfEmployees()+
                    " employee(s) in the system. \n");
        }
    }

    private String stringInput(String kindOfInput){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + kindOfInput + " :");
        return scanner.nextLine();
    }
}
