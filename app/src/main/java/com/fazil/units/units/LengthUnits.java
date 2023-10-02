package com.fazil.units.units;

import android.content.Context;

public class LengthUnits implements Units {

    public float convertQuestionToCommon(String unit, Float value){
        float result = 0.0F;
        switch(unit){
            case "centimeter":
                result = value / 100;
                break;
            case "kilometer":
                result = value * 1000;
                break;
            case "meter":
                result = value;
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
            case "kilometer":
                result = value / 1000;
                break;
            case "meter":
                result = value;
                break;
        }
        return result;
    }

}
