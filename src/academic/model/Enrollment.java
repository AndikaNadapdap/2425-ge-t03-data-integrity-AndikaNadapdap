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
   

    public Enrollment(String code, String nim, String years, String kejadian, String[] hal) {
        this.code = code;
        this.nim = nim;
        this.years = years;
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

    @Override
    public String toString() {
        return code + "|" + nim + "|" + years + "|" + kejadian + "|None";
    }

}
