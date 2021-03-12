package userinterface;

import java.awt.Color;

import ecs100.UI;

public class Circle implements Shape {
	private double x,y,radius;
	private Color col;

	public Circle(double cx, double cy, double rad, Color color) {
		this.x = cx;
		this.y = cy;
		this.radius = rad;
		
		this.col = color;
	}


	public void setX(double x) {
		this.x = x;
	}


	public void setY(double y) {
		this.y = y;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	public void setCol(Color col) {
		this.col = col;
	}


	public void draw() {
		UI.setColor(col);
		UI.fillOval(x-radius, y-radius, radius*2, radius*2);
		
	}


	public double getY() {
		return y;
	}


	public double getRadius() {
		return radius;
	}


	public double getX() {
				return x;
	}

}
