public class AppointmentService {

    public String getAllAppointments() {
        return "List of all appointments";
    }

    public String getAppointmentById(Long appointmentId) {
        return "Appointment details for ID: " + appointmentId;
    }

    public String bookAppointment(Long doctorId, Long patientId,
                                  String appointmentDate, String appointmentTime) {
        return "Appointment booked successfully";
    }

    public String cancelAppointment(Long appointmentId) {
        return "Appointment cancelled successfully";
    }

    public String getAppointmentsByPatient(Long patientId) {
        return "Appointments for patient ID: " + patientId;
    }

    public String getAppointmentsByDoctor(Long doctorId) {
        return "Appointments for doctor ID: " + doctorId;
    }
}
