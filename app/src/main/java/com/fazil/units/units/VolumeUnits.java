package com.fazil.units.units;

import android.content.Context;

public class VolumeUnits implements Units {

    public static String[] unitItems = {
            "Acre-foot",
            "Cubic meter"
    };

    public static String primaryUnit = "Acre-foot";
    public static String secondaryUnit = "Cubic meter";

    // Common Unit: Meter
    public double convertQuestionToCommon(String unit, Double value){
        double result = 0.0;
        switch(unit){
            case "Acre-foot":
                result = value * 1233.481838;
                break;
            case "Cubic meter":
                result = value;
                break;
        }
        return result;
    }

    public double convertCommonToAnswer(String unit, Double value){
        double result = 0.0;
        switch(unit){
            case "Acre-foot":
                result = value / 1233.481838;
                break;
            case "Cubic meter":
                result = value;
                break;
        }
        return result;
    }

}
