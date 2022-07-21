package model;

public class LocalMealPlan {
    private String mealNo;
    private String mealName;
    private double priceOfOnePotion;

    public LocalMealPlan() {
    }

    public LocalMealPlan(String mealNo, String mealName, double priceOfOnePotion) {
        this.mealNo = mealNo;
        this.mealName = mealName;
        this.priceOfOnePotion = priceOfOnePotion;
    }

    public String getMealNo() {
        return mealNo;
    }

    public void setMealNo(String mealNo) {
        this.mealNo = mealNo;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getPriceOfOnePotion() {
        return priceOfOnePotion;
    }

    public void setPriceOfOnePotion(double priceOfOnePotion) {
        this.priceOfOnePotion = priceOfOnePotion;
    }

    @Override
    public String toString() {
        return "LocalMealPlan{" +
                "mealNo='" + mealNo + '\'' +
                ", mealName='" + mealName + '\'' +
                ", priceOfOnePotion=" + priceOfOnePotion +
                '}';
    }
}
