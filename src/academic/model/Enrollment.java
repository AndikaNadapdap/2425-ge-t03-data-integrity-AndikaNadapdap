package academic.model;
/**
 * @author 12S23013 Andika Immanuel Nadapdap
 * @author 12S23033 Oloan Nainggolan
 */
public class Enrollment {
    private String code;
    private String nim;
    private String years;
    private String kejadian;
    private String notes;

    public Enrollment(String code, String nim, String years, String kejadian, String notes) {
        this.code = code;
        this.nim = nim;
        this.years = years;
        this.notes = notes;
        this.kejadian = kejadian;
    }

    public String getCode() {
        return code;
    }

    public String getNim() {
        return nim;
    }

    public String getYears() {
        return years;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return code + "|" + nim + "|" + years + "|" + kejadian + "|" + notes;
    }

}
