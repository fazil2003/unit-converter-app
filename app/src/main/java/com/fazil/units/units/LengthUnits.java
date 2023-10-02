package com.fazil.units.units;

import android.content.Context;

public class LengthUnits implements Units {

    public static String[] unitItems = {
            "Centimeter",
            "Decameter",
            "Decimeter",
            "Hectometer",
            "Inch",
            "Kilometer",
            "Meter",
            "Millimeter"
    };

    public double convertQuestionToCommon(String unit, Double value){
        double result = 0.0;
        switch(unit.toLowerCase()){
            case "centimeter":
                result = value / 100;
                break;
            case "decameter":
                result = value * 10;
                break;
            case "decimeter":
                result = value / 10;
                break;
            case "hectometer":
                result = value * 100;
                break;
            case "inch":
                result = value * 0.0254;
                break;
            case "kilometer":
                result = value * 1000;
                break;
            case "meter":
                result = value / 1;
                break;
            case "millimeter":
                result = value / 1000;
                break;
        }
        return result;
    }

    public double convertCommonToAnswer(String unit, Double value){
        double result = 0.0;
        switch(unit.toLowerCase()){
            case "centimeter":
                result = value * 100;
                break;
            case "decameter":
                result = value / 10;
                break;
            case "decimeter":
                result = value * 10;
                break;
            case "hectometer":
                result = value / 100;
                break;
            case "inch":
                result = value / 0.0254;
                break;
            case "kilometer":
                result = value / 1000;
                break;
            case "meter":
                result = value * 1;
                break;
            case "millimeter":
                result = value * 1000;
                break;
        }
        return result;
    }

}
