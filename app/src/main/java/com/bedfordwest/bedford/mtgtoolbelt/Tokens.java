package com.bedfordwest.bedford.mtgtoolbelt;

/**
 * Created by bedfordwest on 8/25/14.
 */
public class Tokens {

    private int power = 1;
    private int toughness = 1;
    private enum Color { GREEN, WHITE, BLUE, BLACK, RED, MULTI, COLORLESS }
    private Color color = Color.COLORLESS;

    public int getPower() {
        return power;
    }

    public int getToughness() {
        return toughness;
    }

    public Color getColor () {
        return color;
    }

    public void setPower(int set_power) {
        power = set_power;
        return;
    }

    public void setToughness(int set_toughness) {
        toughness = set_toughness;
        return;
    }

    public void setColor(Color set_color) {
        color = set_color;
    }

}
