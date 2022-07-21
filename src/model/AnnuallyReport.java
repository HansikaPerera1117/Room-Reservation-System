package model;

public class AnnuallyReport {
      private String year;
      private String head;
      private String income;

    public AnnuallyReport() {
    }

    public AnnuallyReport(String year, String head, String income) {
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
        return "AnnuallyReport{" +
                "year='" + year + '\'' +
                ", head='" + head + '\'' +
                ", income='" + income + '\'' +
                '}';
    }
}
