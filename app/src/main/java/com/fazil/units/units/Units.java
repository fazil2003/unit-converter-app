package com.fazil.units.units;

public interface Units {

    String[] unitItems = {};

    double convertQuestionToCommon(String unit, Double value);
    double convertCommonToAnswer(String unit, Double value);

}
