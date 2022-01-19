package com.src.kaloricky_diar;

public class Meal {
    private String foodName;
    private int cal;
    private TimeOfDay timeOfDay;

    public Meal(String foodName, int cal, TimeOfDay timeOfDay) {
        this.foodName = foodName;
        this.cal = cal;
        this.timeOfDay = timeOfDay;
    }

    public int getCal() {
        return cal;
    }

    public String getFoodName() {
        return foodName;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String toStringSmall() {
        return foodName + " | " + cal + " cal | " + timeOfDay.getName();
    }

    @Override
    public String toString() {
        return "Název jídla: '" + foodName + '\'' + "\n" +
                "Kalorie: " + cal + "\n" +
                "Čas dne: " + timeOfDay.getName();
    }
}
