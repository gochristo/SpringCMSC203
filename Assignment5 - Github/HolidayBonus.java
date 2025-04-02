/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: Calaculates holiday bonus from data
 * Due: 04/02/2025
 * Platform/compiler: IntelliJ
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Christopher Andrews
 */

public class HolidayBonus {

    public static double[] calculateHolidayBonus(double[][] data){
        final double LOWEST_BONUS = 1000;
        final double NORMAL_BONUS = 2000;
        final double HIGHEST_BONUS = 5000;

        double[] bonuses = new double[data.length];

        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if (!(data[i][j] <= 0.0)) {
                    if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data,j)){
                        bonuses[i] += HIGHEST_BONUS;
                    }else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data,j)) {
                        bonuses[i] += LOWEST_BONUS;
                    }else{
                        bonuses[i] += NORMAL_BONUS;
                    }
                }
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data){
        final double LOWEST_BONUS = 1000;
        final double NORMAL_BONUS = 2000;
        final double HIGHEST_BONUS = 5000;
        double totalBonus = 0;

        double[] bonuses = new double[data.length];

        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if (!(data[i][j] <= 0.0)) {
                    if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data,j)){
                        bonuses[i] += HIGHEST_BONUS;
                    }else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data,j)) {
                        bonuses[i] += LOWEST_BONUS;
                    }else{
                        bonuses[i] += NORMAL_BONUS;
                    }
                }
            }
        }

        for(int i = 0; i < bonuses.length; i++){
            totalBonus += bonuses[i];
        }
        return totalBonus;
    }



}
