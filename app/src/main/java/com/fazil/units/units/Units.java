package com.fazil.units.units;

public interface Units {

    String[] unitItems = {};

    float convertQuestionToCommon(String unit, Float value);
    float convertCommonToAnswer(String unit, Float value);

}
