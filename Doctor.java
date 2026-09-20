public class Doctor {

    private Long doctorId;
    private String name;
    private String speciality;
    private String email;
    private String phone;
    private String password;

    public Doctor() {
    }

    public Doctor(Long doctorId, String name, String speciality,
                  String email, String phone, String password) {
        this.doctorId = doctorId;
        this.name = name;
        this.speciality = speciality;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
