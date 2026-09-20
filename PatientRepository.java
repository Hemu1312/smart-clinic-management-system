public class PatientRepository {

    public String findAllPatients() {
        return "List of all patients";
    }

    public String findPatientById(Long patientId) {
        return "Patient details for ID: " + patientId;
    }

    public String findPatientByEmail(String email) {
        return "Patient details for email: " + email;
    }

    public String savePatient(String name, String email, String phone) {
        return "Patient saved successfully";
    }

    public String deletePatient(Long patientId) {
        return "Patient deleted successfully";
    }
}
