public class DoctorController {

    public String getAllDoctors() {
        return "List of all doctors";
    }

    public String getDoctorById(Long doctorId) {
        return "Doctor details for ID: " + doctorId;
    }

    public String searchDoctorsBySpeciality(String speciality) {
        return "Doctors with speciality: " + speciality;
    }

    public String addDoctor(String name, String speciality, String email) {
        return "Doctor added successfully";
    }

    public String updateDoctor(Long doctorId, String name, String speciality) {
        return "Doctor updated successfully";
    }

    public String deleteDoctor(Long doctorId) {
        return "Doctor deleted successfully";
    }
}
