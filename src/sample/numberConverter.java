package sample;

public class numberConverter {
    /**
     * calculates correct dimension unit for our calculation returns always kg
     *
     * @param dimension dimension that needs to be transformed  into cm
     * @param currentValue currently selected dimension
     * @return dimension in cm
     */
    public double numberConversionDimensions(double dimension, String currentValue) {
        if (currentValue.equals("cm")) {
            return dimension;
        } else if (currentValue.equals("mm")) {
            return dimension / 10;
        } else if (currentValue.equals("m")) {
            return dimension * 10;
        }
        return dimension;
    }

    /**
     * calculates correct weight unit for our calculation returns always kg
     *
     * @param weight weight that needs to be transformed
     * @param currentValue currently selected dimension
     * @return weight in kg
     */
    public double numberConversionWeight(double weight, String currentValue) {
        if (currentValue.equals("kg")) {
            return weight;
        } else if (currentValue.equals("g")) {
            return weight / 1000;

        }
        return weight;
    }
}
