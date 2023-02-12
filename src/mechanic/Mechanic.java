package mechanic;

public class Mechanic {
    private final String firstName, lastName;
    private String company;

    public Mechanic(String firstName, String lastName, String company) {
        String defaultValue = "default";
        if(firstName == null || firstName.isBlank()){
            this.firstName = defaultValue;
        }else{
            this.firstName = firstName;
        }
        if(lastName == null || lastName.isBlank()){
            this.lastName = defaultValue;
        }else{
            this.lastName = lastName;
        }
        setCompany(company);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        String defaultValue = "default";
        if(company == null || company.isBlank()){
            this.company = defaultValue;
        }else{
            this.company = company;
        }
    }

    public void maintenanceTheCar(){
        System.out.println("Проводится техническое обслуживание.");
    }

    public void fixTheCar(){
        System.out.println("Производится починка автомобиля.");
    }

    @Override
    public String toString() {
        return "Механик{" +
                "фамилия ='" + getLastName() + '\'' +
                " ,имя='" + getFirstName() + '\'' +
                ", компания='" + getCompany() + '\'' +
                '}';
    }
}
