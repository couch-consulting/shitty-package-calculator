package sample;

/**
 * @author Rick, Thore, Lennart
 * @version beschte Version
 */

/**
 * package class that is used to store different package options
 */
public class Package {
    public Double length;
    public Double width;
    public Double height;
    public Double weight;
    public Double prize;

    /**
     * package constructer
     * @param length
     * @param width
     * @param height
     * @param weight
     * @param prize
     */
    public Package(Double length, Double width, Double height, Double weight, Double prize) {
        this.length = length;
        this. width = width;
        this.height = height;
        this.weight = weight;
        this.prize = prize;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }
}
