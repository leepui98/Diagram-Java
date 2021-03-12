package userinterface;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Box implements Shape {

private double x;
private double y;
private double width;
private double height;
private Color col;

//double x1, y1, x2, y2;




public Color getCol() {
return col;
}

public void setCol(Color col) {
this.col = col;
}



public double getX() {
return x;
}

// public void setX(double x) {
// this.x = x;
// }
//
public double getY() {
return y;
}
//
// public void setY(double y) {
// this.y = y;
// }

public double getWidth() {
return width;
}

public void setWidth(double width) {
this.width = width;
}

public double getHeight() {
return height;
}


public void setHeight(double height) {
this.height = height;
}


public Box() {

super();
}


public Box(double x, double y, double width, double height, Color col) {
super();
this.x = x;
this.y = y;
this.width = width;
this.height = height;
this.col = col;

}


public void draw() {
UI.setColor(this.col);
UI.fillRect(this.x, this.y, this.width,this.height);
}

public void setX(double x) {
	this.x = x;
}

public void setY(double y) {
	this.y = y;
}

}
