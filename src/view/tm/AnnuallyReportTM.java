package view.tm;

public class AnnuallyReportTM {
      private String year;
      private String head;
      private String income;

    public AnnuallyReportTM() {
    }

    public AnnuallyReportTM(String year, String head, String income) {
        this.year = year;
        this.head = head;
        this.income = income;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "AnnuallyReportTM{" +
                "year='" + year + '\'' +
                ", head='" + head + '\'' +
                ", income='" + income + '\'' +
                '}';
    }
}
