package academic.model;

/**
 * @author 12S23013 Andika Immanuel Nadapdap
 * @author 12S23033 Oloan Nainggolan
 */

public class Course {
    private String code;
    private String name;
    private String credit;
    private String passingGrade;

    public Course(String code, String name, String credit, String passingGrade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.passingGrade = passingGrade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCredit() {
        return credit;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    @Override
    public String toString() {
        return  code + '|' + name + '|' + credit +'|' + passingGrade;
            }
}
