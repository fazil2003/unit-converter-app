package com.fazil.units.units;

import android.content.Context;

public class LengthUnits implements Units {

    public static String[] unitItems = {
            "Centimeter",
            "Kilometer",
            "Meter"
    };

    public float convertQuestionToCommon(String unit, Float value){
        float result = 0.0F;
        switch(unit){
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

    public float convertCommonToAnswer(String unit, Float value){
        float result = 0.0F;
        switch(unit){
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
