public class EduFlex {
    private int id;
    private String name;
    private String email;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void login() {
        System.out.println(name + " logged in as EduFlex user.");
    }

    public void updateProfile() {
        System.out.println("Profile updated successfully.");
    }

    public void logout() {
        System.out.println(name + " logged out from EduFlex user.");
    }
}
