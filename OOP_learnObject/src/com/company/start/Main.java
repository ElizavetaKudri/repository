package com.company.start;

import com.company.objects.Door;
import com.company.objects.House;
import com.company.objects.Window;

public class Main {

    public static void main(String[] args) {
	House house1 =new House();
	House house2 =new House();
	Door door1=new Door();
	door1.setColor("red");
	System.out.println("door1.getColor() = " + door1.getColor());


	Window window1 = new Window(34,20,"white");
	System.out.println("window.getColor() = " + window1.getColor());

    }
}
