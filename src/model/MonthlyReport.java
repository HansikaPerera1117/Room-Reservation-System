package model;

public class MonthlyReport {
    private String month;
    private String head;
    private double income;

    public MonthlyReport() {
    }

    public MonthlyReport(String month, String head, double income) {
        this.month = month;
        this.head = head;
        this.income = income;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "month='" + month + '\'' +
                ", head='" + head + '\'' +
                ", income=" + income +
                '}';
    }
}
