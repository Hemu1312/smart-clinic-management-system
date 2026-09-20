public class PrescriptionController {

    public String getAllPrescriptions() {
        return "List of all prescriptions";
    }

    public String getPrescriptionById(Long prescriptionId) {
        return "Prescription details for ID: " + prescriptionId;
    }

    public String createPrescription(Long doctorId, Long patientId,
                                     Long appointmentId, String medicine,
                                     String dosage, String instructions) {
        return "Prescription created successfully";
    }

    public String getPrescriptionsByPatient(Long patientId) {
        return "Prescriptions for patient ID: " + patientId;
    }

    public String getPrescriptionsByDoctor(Long doctorId) {
        return "Prescriptions for doctor ID: " + doctorId;
    }
}
