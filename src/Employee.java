import java.security.SecureRandom;
import java.util.ArrayList;

public class Employee {
    String name;
    String surname;
    String Id;
    String address;
    String phone;
    static ArrayList<String> employeesId = new ArrayList();

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.Id = generateId();
    }

    private String generateId(){
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(8);

        while (true){
            for (int i = 0; i < 8; i++) {
                // 0-62 (exclusive), random returns 0-61
                int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
                char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

                sb.append(rndChar);
            }
            String id = sb.toString();
            if(employeesId.contains(id)){
                continue;
            } else {
                employeesId.add(id);
                return id;
            }
        }
    }

    @Override
    public String toString() {
        return "Name :'" + name + '\'' +
                ", Surname :'" + surname + '\'' +
                ", Id :'" + Id + '\'';
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return Id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
