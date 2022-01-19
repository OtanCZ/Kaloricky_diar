package com.src.kaloricky_diar;

import java.util.ArrayList;

public class Main {
    static ArrayList<Meal> mealList = new ArrayList<>();

    public static void main(String[] args) {
        while(true){
            System.out.println("0 - Vypnout program (neuloží údaje)");
            System.out.println("1 - Zadat informace do diáře");
            System.out.println("2 - Zobrazit informace v diáři");

            switch(Utils.intFromConsole()){
                case 0 -> {System.exit(0);}
                case 1 -> addMealToDiary();
                case 2 -> showDiaryOptions();
                default -> {}
            }
        }
    }

    static void showDiaryOptions(){
        while(true){
            System.out.println("0 - Zpátky");
            System.out.println("1 - Zobrazit celý diář");
            System.out.println("2 - Zobrazit diář s filterem na čas");

            switch(Utils.intFromConsole()){
                case 0 -> {return;}
                case 1 -> {inspectDiary(); return;}
                case 2 -> {inspectDiaryWithTimeFilter(); return;}
                default -> {}
            }
        }
    }

    static void inspectDiary(){
        while(true){
            int totalCalories = 0;
            System.out.println("0 - Zpátky");
            for (int i = 0; i < mealList.size(); i++) {
                System.out.println(i+1 + " - " + mealList.get(i).toStringSmall());
                Utils.printToFile(mealList.get(i).toStringSmall());
                totalCalories += mealList.get(i).getCal();
            }
            System.out.println("Celkově " + totalCalories + " kalorií.");
            Utils.printToFile("Celkově " + totalCalories + " kalorií.");
            System.out.println("Jakou položku chceš zobrazit, upravit nebo smazat?");

            int choice = Utils.intFromConsole()-1;
            if(choice == -1){return;}
            else if(choice >= mealList.size() || choice < 0){}
            else{inspectMeal(mealList.get(choice));}
        }
    }

    static void inspectDiaryWithTimeFilter(){
        TimeOfDay filter = askForMealTime();

        while(true){
            int totalCalories = 0;
            System.out.println("0 - Zpátky");
            for (int i = 0; i < mealList.size(); i++) {
                if(mealList.get(i).getTimeOfDay() == filter){
                    System.out.println(i+1 + " - " + mealList.get(i).toStringSmall());
                    Utils.printToFile(mealList.get(i).toStringSmall());
                    totalCalories += mealList.get(i).getCal();
                }
            }

            Utils.printToFile("Celkově " + totalCalories + " kalorií.");
            System.out.println("Jakou položku chceš zobrazit, upravit nebo smazat?");

            int choice = Utils.intFromConsole()-1;
            if(choice == -1){return;}
            else if(choice >= mealList.size() || choice < 0){}
            else{inspectMeal(mealList.get(choice));}
        }
    }

    static void inspectMeal(Meal meal){
        while(true){
            System.out.println(meal.toString());

            System.out.println("0 - Zpátky");
            System.out.println("1 - Upravit záznam");
            System.out.println("2 - Smazat záznam");

            switch(Utils.intFromConsole()){
                case 0 -> {return;}
                case 1 -> {editMeal(meal); return;}
                case 2 -> {deleteMeal(meal); return;}
            }
        }
    }

    static void deleteMeal(Meal meal){
        System.out.println(meal.getFoodName() + " byl úspěšně smazán.");
        mealList.remove(meal);
    }

    static void editMeal(Meal meal){
        System.out.println("Co se ti na něm nelíbí?");
        System.out.println("0 - Zpátky");
        System.out.println("1 - Název");
        System.out.println("2 - Počet kalorií");
        System.out.println("3 - Čas v dnu");

        switch(Utils.intFromConsole()){
            case 0 -> {return;}
            case 1 -> {meal.setFoodName(askForMealName()); return;}
            case 2 -> {meal.setCal(askForMealCalories()); return;}
            case 3 -> {meal.setTimeOfDay(askForMealTime()); return;}
        }
    }

    static void addMealToDiary(){
        mealList.add(createMeal());
    }

    static Meal createMeal(){
        return new Meal(askForMealName(), askForMealCalories(), askForMealTime());
    }

    static String askForMealName(){
        System.out.println("Co jsi snědl(a)?");
        return Utils.lineFromConsole();
    }

    static int askForMealCalories(){
        System.out.println("Kolik to mělo kalorií?");
        return Utils.intFromConsole();
    }

    static TimeOfDay askForMealTime(){
        while(true){
            System.out.println("Kdy jsi to snědl(a)?");
            for (int i = 0; i < TimeOfDay.values().length; i++) {
                System.out.println(i+1 + " - " + TimeOfDay.values()[i].getName());
            }

            int choice = Utils.intFromConsole()-1;
            if(choice >= TimeOfDay.values().length || choice < 0){}
            else{return TimeOfDay.values()[choice];}
        }
    }
}
