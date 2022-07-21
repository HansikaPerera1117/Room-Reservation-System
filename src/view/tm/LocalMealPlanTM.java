package view.tm;

import javafx.scene.control.Button;

public class LocalMealPlanTM {
     private String mealNo;
     private String mealName;
     private double priceOfOnePotion;
     private Button btn;

    public LocalMealPlanTM() {
    }

    public LocalMealPlanTM(String mealNo, String mealName, double priceOfOnePotion, Button btn) {
        this.mealNo = mealNo;
        this.mealName = mealName;
        this.priceOfOnePotion = priceOfOnePotion;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "LocalMealPlanTM{" +
                "mealNo='" + mealNo + '\'' +
                ", mealName='" + mealName + '\'' +
                ", priceOfOnePotion=" + priceOfOnePotion +
                ", btn=" + btn +
                '}';
    }
}
