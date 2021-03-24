package com.company.objects;

public class Window {
    private int width;
    private int height;
    private String color;


    public Window(int width, int height, String color) {
        this.setWidth(width);
        this.setHeight(height);
        this.setColor(color);
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


