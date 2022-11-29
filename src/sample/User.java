package sample;

public class User {
    private String dad;
    private String email;
    private String family;
    private String name;
    private String password;
    private String phone;

    public User(String dad, String email, String family, String name,
                String password, String phone) {
        this.dad = dad;
        this.email = email;
        this.family = family;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getDad() {
        return dad;
    }

    public void setDad(String dad) {
        this.dad = dad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}