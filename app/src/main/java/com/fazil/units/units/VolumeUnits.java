package com.fazil.units.units;

import android.content.Context;

public class VolumeUnits implements Units {

    public static String[] unitItems = {
            "Centimeter",
            "Decameter",
            "Decimeter",
            "Fathom",
            "Foot",
            "Furlong",
            "Hectometer",
            "Inch",
            "Kilometer",
            "Meter",
            "Mile",
            "Millimeter",
            "Nautical Mile",
            "Rod",
            "Yard"
    };

    public static String primaryUnit = "Kilometer";
    public static String secondaryUnit = "Centimeter";

    // Common Unit: Meter
    public double convertQuestionToCommon(String unit, Double value){
        double result = 0.0;
        switch(unit){
            case "Centimeter":
                result = value / 100;
                break;
            case "Decameter":
                result = value * 10;
                break;
            case "Decimeter":
                result = value / 10;
                break;
            case "Fathom":
                result = value * 1.829;
                break;
            case "Foot":
                result = value * 0.3048;
                break;
            case "Furlong":
                result = value * 201;
                break;
            case "Hectometer":
                result = value * 100;
                break;
            case "Inch":
                result = value * 0.0254;
                break;
            case "Kilometer":
                result = value * 1000;
                break;
            case "Meter":
                result = value / 1;
                break;
            case "Mile":
                result = value * 1609;
                break;
            case "Millimeter":
                result = value / 1000;
                break;
            case "Nautical Mile":
                result = value * 1852;
                break;
            case "Rod":
                result = value * 5.029;
                break;
            case "Yard":
                result = value * 0.9144;
                break;
        }
        return result;
    }

    public double convertCommonToAnswer(String unit, Double value){
        double result = 0.0;
        switch(unit){
            case "Centimeter":
                result = value * 100;
                break;
            case "Decameter":
                result = value / 10;
                break;
            case "Decimeter":
                result = value * 10;
                break;
            case "Fathom":
                result = value / 1.829;
                break;
            case "Foot":
                result = value / 0.3048;
                break;
            case "Furlong":
                result = value / 201;
                break;
            case "Hectometer":
                result = value / 100;
                break;
            case "Inch":
                result = value / 0.0254;
                break;
            case "Kilometer":
                result = value / 1000;
                break;
            case "Meter":
                result = value * 1;
                break;
            case "Mile":
                result = value / 1609;
                break;
            case "Millimeter":
                result = value * 1000;
                break;
            case "Nautical Mile":
                result = value / 1852;
                break;
            case "Rod":
                result = value / 5.029;
                break;
            case "Yard":
                result = value / 0.9144;
                break;
        }
        return result;
    }

}
