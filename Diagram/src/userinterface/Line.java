package userinterface;

import java.awt.Color;

import ecs100.UI;

public class Line implements Shape{

	private double x,y,x1,y1;
	private Color col;
	
	public void draw() {
UI.setLineWidth(5);
		UI.setColor(this.col);
		UI.drawLine(this.x1, this.y1, this.x, this.y);
	}
	public Line(double x1, double y1, double x, double y, Color color) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.col = color;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setCol(Color col) {
		this.col = col;
	}
	public double getY() {
		return y;
	}
	public double getX1() {
		return x1;
	}
	public double getY1() {
		return y1;
	}

}