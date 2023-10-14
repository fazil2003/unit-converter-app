package com.fazil.units.units;

import android.content.Context;

public class VolumeUnits implements Units {

    public static String[] unitItems = {
            "Acre-foot",
            "Barrel (Imperial)",
            "Barrel (Petroleum)",
            "Barrel (U.S. dry)",
            "Barrel (U.S. fluid)",
            "Bushel (Imperial)",
            "Bushel (U.S. dry)",
            "Cord (Firewood)",
            "Cubic foot",
            "Cubic inch",
            "Cubic centimeter",
            "Cubic meter",
            "Cubic mile",
            "Cubic yard",
            "Cup (Breakfast)",
            "Cup (Canadian)",
            "Cup (U.S.)",
            "Ounce (Imperial fluid)",
            "Ounce (U.S. fluid)",
            "Gallon (Imperial)",
            "Gallon (U.S. dry)",
            "Gallon (U.S. fluid)",
            "Gill (Imperial)",
            "Gill (U.S.)",
            "Hogshead (Imperial)",
            "Hogshead (U.S.)",
            "Liter",
            "Milliliter",
            "Peck (Imperial)",
            "Peck (U.S. dry)",
            "Pint (Imperial)",
            "Pint (U.S. dry)",
            "Pint (U.S. fluid)",
            "Quart (Imperial)",
            "Quart (U.S. dry)",
            "Quart (U.S. fluid)",
            "Tablespoon (Canadian)",
            "Tablespoon (Imperial)",
            "Tablespoon (U.S.)",
            "Teaspoon (Canadian)",
            "Teaspoon (Imperial)",
            "Teaspoon (U.S.)"
    };

    public static String primaryUnit = "Cubic meter";
    public static String secondaryUnit = "Liter";

    // Common Unit: Meter
    public double convertQuestionToCommon(String unit, Double value){
        double result = 0.0;
        switch(unit){
            case "Acre-foot":
                result = value * 1233.481838;
                break;
            case "Barrel (Imperial)":
                result = value * 0.16365924;
                break;
            case "Barrel (Petroleum)":
                result = value * 0.158987295;
                break;
            case "Barrel (U.S. dry)":
                result = value * 0.115628199;
                break;
            case "Barrel (U.S. fluid)":
                result = value * 0.119240471;
                break;
            case "Bushel (Imperial)":
                result = value * 0.03636872;
                break;
            case "Bushel (U.S. dry)":
                result = value * 0.03523907;
                break;
            case "Cord (Firewood)":
                result = value * 3.624556364;
                break;
            case "Cubic foot":
                result = value * 0.028316847;
                break;
            case "Cubic inch":
                result = value * 1.63871E-05;
                break;
            case "Cubic centimeter":
                result = value * 0.000001;
                break;
            case "Cubic meter":
                result = value;
                break;
            case "Cubic mile":
                result = value * 4168181825L;
                break;
            case "Cubic yard":
                result = value * 0.764554858;
                break;
            case "Cup (Breakfast)":
                result = value * 0.000284131;
                break;
            case "Cup (Canadian)":
                result = value * 0.000227305;
                break;
            case "Cup (U.S.)":
                result = value * 0.000236588;
                break;
            case "Ounce (Imperial fluid)":
                result = value * 2.84131E-05;
                break;
            case "Ounce (U.S. fluid)":
                result = value * 2.95735E-05;
                break;
            case "Gallon (Imperial)":
                result = value * 0.00454609;
                break;
            case "Gallon (U.S. dry)":
                result = value * 0.004404884;
                break;
            case "Gallon (U.S. fluid)":
                result = value * 0.003785412;
                break;
            case "Gill (Imperial)":
                result = value * 0.000142065;
                break;
            case "Gill (U.S.)":
                result = value * 0.000118294;
                break;
            case "Hogshead (Imperial)":
                result = value * 0.32731848;
                break;
            case "Hogshead (U.S.)":
                result = value * 0.238480942;
                break;
            case "Liter":
                result = value * 0.001;
                break;
            case "Milliliter":
                result = value * 0.000001;
                break;
            case "Peck (Imperial)":
                result = value * 0.00909218;
                break;
            case "Peck (U.S. dry)":
                result = value * 0.008809768;
                break;
            case "Pint (Imperial)":
                result = value * 0.000568261;
                break;
            case "Pint (U.S. dry)":
                result = value * 0.00055061;
                break;
            case "Pint (U.S. fluid)":
                result = value * 0.000473176;
                break;
            case "Quart (Imperial)":
                result = value * 0.001136523;
                break;
            case "Quart (U.S. dry)":
                result = value * 0.001101221;
                break;
            case "Quart (U.S. fluid)":
                result = value * 0.000946353;
                break;
            case "Tablespoon (Canadian)":
                result = value * 1.42065E-05;
                break;
            case "Tablespoon (Imperial)":
                result = value * 1.77582E-05;
                break;
            case "Tablespoon (U.S.)":
                result = value * 1.47868E-05;
                break;
            case "Teaspoon (Canadian)":
                result = value * 4.73551E-06;
                break;
            case "Teaspoon (Imperial)":
                result = value * 5.91939E-06;
                break;
            case "Teaspoon (U.S.)":
                result = value * 4.92892E-06;
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
            case "Barrel (Imperial)":
                result = value / 0.16365924;
                break;
            case "Barrel (Petroleum)":
                result = value / 0.158987295;
                break;
            case "Barrel (U.S. dry)":
                result = value / 0.115628199;
                break;
            case "Barrel (U.S. fluid)":
                result = value / 0.119240471;
                break;
            case "Bushel (Imperial)":
                result = value / 0.03636872;
                break;
            case "Bushel (U.S. dry)":
                result = value / 0.03523907;
                break;
            case "Cord (Firewood)":
                result = value / 3.624556364;
                break;
            case "Cubic foot":
                result = value / 0.028316847;
                break;
            case "Cubic inch":
                result = value / 1.63871E-05;
                break;
            case "Cubic centimeter":
                result = value / 0.000001;
                break;
            case "Cubic meter":
                result = value;
                break;
            case "Cubic mile":
                result = value / 4168181825L;
                break;
            case "Cubic yard":
                result = value / 0.764554858;
                break;
            case "Cup (Breakfast)":
                result = value / 0.000284131;
                break;
            case "Cup (Canadian)":
                result = value / 0.000227305;
                break;
            case "Cup (U.S.)":
                result = value / 0.000236588;
                break;
            case "Ounce (Imperial fluid)":
                result = value / 2.84131E-05;
                break;
            case "Ounce (U.S. fluid)":
                result = value / 2.95735E-05;
                break;
            case "Gallon (Imperial)":
                result = value / 0.00454609;
                break;
            case "Gallon (U.S. dry)":
                result = value / 0.004404884;
                break;
            case "Gallon (U.S. fluid)":
                result = value / 0.003785412;
                break;
            case "Gill (Imperial)":
                result = value / 0.000142065;
                break;
            case "Gill (U.S.)":
                result = value / 0.000118294;
                break;
            case "Hogshead (Imperial)":
                result = value / 0.32731848;
                break;
            case "Hogshead (U.S.)":
                result = value / 0.238480942;
                break;
            case "Liter":
                result = value / 0.001;
                break;
            case "Milliliter":
                result = value / 0.000001;
                break;
            case "Peck (Imperial)":
                result = value / 0.00909218;
                break;
            case "Peck (U.S. dry)":
                result = value / 0.008809768;
                break;
            case "Pint (Imperial)":
                result = value / 0.000568261;
                break;
            case "Pint (U.S. dry)":
                result = value / 0.00055061;
                break;
            case "Pint (U.S. fluid)":
                result = value / 0.000473176;
                break;
            case "Quart (Imperial)":
                result = value / 0.001136523;
                break;
            case "Quart (U.S. dry)":
                result = value / 0.001101221;
                break;
            case "Quart (U.S. fluid)":
                result = value / 0.000946353;
                break;
            case "Tablespoon (Canadian)":
                result = value / 1.42065E-05;
                break;
            case "Tablespoon (Imperial)":
                result = value / 1.77582E-05;
                break;
            case "Tablespoon (U.S.)":
                result = value / 1.47868E-05;
                break;
            case "Teaspoon (Canadian)":
                result = value / 4.73551E-06;
                break;
            case "Teaspoon (Imperial)":
                result = value / 5.91939E-06;
                break;
            case "Teaspoon (U.S.)":
                result = value / 4.92892E-06;
                break;
        }
        return result;
    }

}
