package userinterface;

import java.awt.Color;

import ecs100.UI;

public class Text implements Shape{

private String text;
private double X;
private double Y;


private Color col;

public Text(String text, double x1, double y1, Color col) {
super();
this.text = text;
this.X = x1;
this.Y = y1;
this.col = col;
}
public String getText() {
return text;
}
public void setText(String text) {
this.text = text;
}
public double getX() {
return X;
}
public void setX(double x) {
this.X = x;
}
public double getY() {
return Y;
}
public void setY(double y) {
this.Y = y;
}
public Color getCol() {
return col;
}
public void setCol(Color col) {
this.col = col;
}




public void draw()
{
UI.setColor(this.col);
UI.drawString(text, X, Y);

//UI.drawRect(X, Y, this.text.length()*10, 50);
}

}

