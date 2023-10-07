package com.fazil.units.units;

import android.content.Context;

public class AreaUnits implements Units {

    public static String[] unitItems = {
            "Acre",
            "Hectare",
            "Square Centimeter",
            "Square Foot",
            "Square Inch",
            "Square Kilometer",
            "Square Meter",
            "Square Mile",
            "Square Millimeter",
            "Square Yard",
    };

    public static String primaryUnit = "Square Meter";
    public static String secondaryUnit = "Square Centimeter";

    // Common Unit: Square Meter
    public double convertQuestionToCommon(String unit, Double value){
        double result = 0.0;
        switch(unit){
            case "Acre":
                result = value * 4046.8564224;
                break;
            case "Hectare":
                result = value * 10000;
                break;
            case "Square Centimeter":
                result = value * 0.0001;
                break;
            case "Square Foot":
                result = value * 0.09290304;
                break;
            case "Square Inch":
                result = value * 0.00064516;
                break;
            case "Square Kilometer":
                result = value * 1000000;
                break;
            case "Square Meter":
                result = value;
                break;
            case "Square Mile":
                result = value * 2589988.110336;
                break;
            case "Square Millimeter":
                result = value * 0.000001;
                break;
            case "Square Yard":
                result = value * 0.83612736;
                break;
        }
        return result;
    }

    public double convertCommonToAnswer(String unit, Double value){
        double result = 0.0;
        switch(unit){
            case "Acre":
                result = value / 4046.8564224;
                break;
            case "Hectare":
                result = value / 10000;
                break;
            case "Square Centimeter":
                result = value / 0.0001;
                break;
            case "Square Foot":
                result = value / 0.09290304;
                break;
            case "Square Inch":
                result = value / 0.00064516;
                break;
            case "Square Kilometer":
                result = value / 1000000;
                break;
            case "Square Meter":
                result = value;
                break;
            case "Square Mile":
                result = value / 2589988.110336;
                break;
            case "Square Millimeter":
                result = value / 0.000001;
                break;
            case "Square Yard":
                result = value / 0.83612736;
                break;
        }
        return result;
    }

}
