package userinterface;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import ecs100.UI;

public class UserInterface {
	ArrayList<Shape> shapes = new ArrayList<>();
	// ArrayList <Box> boxes = new ArrayList<>();
	public static final int TextDrawing = 1;
	public static final int BoxDrawing = 2;
	public static final int CircleDrawing = 3;
	public static final int LineDrawing = 4;
	public static final int RemoveDrawing = 5;
	public static final int ModifyDrawing = 6;
	public static final int MoveDrawing = 7;
	private int mode = 0;
	private Color color = Color.black;
	private double x1 = 0, y1 = 0;

	private Shape ModifyingShape;
	private Shape MoveShape;

	public void drawBox() {
		// Box b = new Box();
//  b.drawBox();
//  shapes.add(b);
		this.mode = BoxDrawing;
		// UI.println("Now choose the colours");
		this.color = JColorChooser.showDialog(null, "Box Colour", Color.white);
	}

	public void reDraw() {
		UI.clearGraphics();
		for (Shape s : shapes)
			s.draw();
	}

	public void drawText() {
		this.mode = TextDrawing;
		this.color = JColorChooser.showDialog(null, "Box Colour", Color.white);
	}

	public void drawCircle() {
		this.mode = CircleDrawing;
		this.color = JColorChooser.showDialog(null, "Box Colour", Color.white);
	}

	public void drawLines() {
		this.mode = LineDrawing;
		this.color = JColorChooser.showDialog(null, "Box Colour", Color.white);
	}

	public void remove() {
		this.mode = RemoveDrawing;
	}

	public void modifies() {
		this.mode = ModifyDrawing;
	}

	public void move() {
		this.mode = MoveDrawing;
	}

	public void domouse(String action, double x, double y) {
		if (action.equals("released")) {
			if (this.mode == BoxDrawing) {
				Box b = new Box(x1, y1, Math.abs(x1 - x), Math.abs(y1 - y), this.color);
				this.shapes.add(b);
				b.draw();

//	    UI.setColor(this.color);;
//	    UI.drawRect(x1, y1, Math.abs(x1 - x),Math.abs(y1 - y));
			}
			if (this.mode == CircleDrawing) {
				double rad = (Math.min(Math.abs(x1 - x) / 2, Math.abs(y1 - y) / 2));
				double cx = (x1 + x) / 2, cy = (y1 + y) / 2;
				Circle c = new Circle(cx, cy, rad, this.color);
				this.shapes.add(c);
				c.draw();
			}
			if (this.mode == LineDrawing) {
				Line l = new Line(x1, y1, x, y, this.color);
				this.shapes.add(l);
				l.draw();
			}

			if (this.mode == ModifyDrawing) {
				if (ModifyingShape instanceof Box) {
					Box b = (Box) ModifyingShape;
					
					b.setWidth(Math.abs(b.getX() - x));
					b.setHeight(Math.abs(b.getY() - y));

					b.draw();
					this.reDraw();

				}
				
				

			}

			if (this.mode == MoveDrawing) {
				
				
				
				
				if (MoveShape instanceof Box) {
					Box b = (Box) MoveShape;
					
					this.MoveShape.setX(x);
					this.MoveShape.setY(y);

					b.draw();
				this.reDraw();
				}
				
				if (MoveShape instanceof Text) {
					Text t = (Text) MoveShape;
					
					this.MoveShape.setX(x);
					this.MoveShape.setY(y);

					t.draw();
				this.reDraw();
				}
				
				if (MoveShape instanceof Circle) {
					Circle c = (Circle) MoveShape;
					
					this.MoveShape.setX(x);
					this.MoveShape.setY(y);
					c.draw();
					
				this.reDraw();
				}
				
				if (MoveShape instanceof Line) {
					Line l = (Line) MoveShape;
					
					this.MoveShape.setX(x);
					this.MoveShape.setY(y);
					
					l.draw();
					
				this.reDraw();
				}
				

			}
		}

		else if (action.equals("pressed")) {
			// System.out.println("Mode = " + this.mode);
			if (this.mode == BoxDrawing) {
//	    String text = UI.askString("enter a TXT");
//	    UI.drawString(text, x, y);
//	    Text t = new Text(text, x, y, Color.red);
//	    t.addText();
//	    shapes.add(t);
				x1 = x;
				y1 = y;
			}
			
			if (this.mode == TextDrawing) {
				String text = UI.askString("enter a TXT");

				Text t = new Text(text, x, y, this.color);
				t.draw();

				shapes.add(t);
			}
			if (this.mode == CircleDrawing) {
				x1 = x;

				y1 = y;
			}
			if (this.mode == LineDrawing) {
				{
					x1 = x;
					y1 = y;
				}
			}

			if (this.mode == ModifyDrawing) {

				for (int i = 0; i < shapes.size(); i++) {

					Shape s = shapes.get(i);
					if (s instanceof Box) {

						Box b = (Box) s;
						if (x >= b.getX() && x <= b.getX() + b.getWidth() && y >= b.getY()
								&& y <= b.getY() + b.getHeight()) 
							
						
						{
							
							ModifyingShape = s;
							
						}
						
						
					}
					
            if (s instanceof Text) {

            	Text t = (Text) s;
				int width = t.getText().length() * 10;
				int height = 50;
				if (x >= t.getX() && x <= t.getX() + width && y >= (t.getY() - height) && y <= t.getY()) {

				ModifyingShape=s;
				Color col = JColorChooser.showDialog(null, "Box Colour", Color.white);
				((Text) t).setCol(col);
				t.draw();
				
				String text2= UI.askString("Enter new text : ");
				((Text) s).setText(text2);
				  
				   this.reDraw();

				
				
				}	
					}
            if( s instanceof Circle)
			{
			
				 double distance = Math.sqrt(Math.pow((s.getX() - x), 2) + Math.pow((s.getY() - y), 2));
				 if(distance  < ((Circle)s).getRadius())
				 {
					 Color col = JColorChooser.showDialog(null, "circle Colour", Color.white);
					 ((Circle)s).setCol(col);
					 this.reDraw();
					 
				 }
			}

				}
			}

			if (this.mode == MoveDrawing) {

				for (int i = 0; i < shapes.size(); i++) {

					Shape s = shapes.get(i);
					if (s instanceof Box) {

						
						
						if (x >= s.getX() && x <= s.getX() + ((Box) s).getWidth() && y >= ((Box) s).getY()
								&& y <= ((Box) s).getY() + ((Box) s).getHeight())
						{
							
							this.MoveShape = s;
							//Color col = JColorChooser.showDialog(null, "Box Colour", Color.white);
							((Box) s).setCol(color.magenta);
							this.reDraw();
						}

						
					}
					
					if (s instanceof Text) {

						Text t = (Text) s;
						int width = t.getText().length() * 10;
						int height = 50;
						
						if (x >= t.getX() && x <= t.getX() + width && y >= (t.getY() - height) && y <= t.getY())
						{
							
							this.MoveShape = s;
						
							s.draw();
						}

						
					}
					
		            if( s instanceof Circle)
					{
						
						 double distance = Math.sqrt(Math.pow((s.getX() - x), 2) + Math.pow((s.getY() - y), 2));
						 if(distance  < ((Circle)s).getRadius())
						 {
							 
							 
							 this.MoveShape = s;
							 ((Circle)s).setCol(Color.ORANGE);
							 this.reDraw();
							 
						 }
					}
					
		            
		    		if (s instanceof Line) {

						Line l = (Line) s;
						if (Math.floor((x - l.getX1()) / (l.getX() - l.getX1()) * 10)
								/ 10 == Math.floor((y - l.getY1()) / (l.getY() - l.getY1()) * 10) / 10) {

							this.MoveShape = s;
							((Line)s).setCol(Color.ORANGE);
							this.reDraw();
						}
						}
					
//
//						
//					}
				}
			}

			if (mode == RemoveDrawing) {

				for (int i = 0; i < shapes.size(); i++) {

					Shape s = shapes.get(i);
					
					if (s instanceof Box) {
						if (x >= s.getX() && x <= s.getX() + ((Box) s).getWidth() && y >= ((Box) s).getY()
								&& y <= ((Box) s).getY() + ((Box) s).getHeight())
							shapes.remove(i);
					} 
					
					else if (s instanceof Text) {
						Text t = (Text) s;
						int width = t.getText().length() * 10;
						int height = 50;
						if (x >= t.getX() && x <= t.getX() + width && y >= (t.getY() - height) && y <= t.getY()) {

							shapes.remove(i);
							
						}
					}

					else if (s instanceof Circle) {
						Circle c = (Circle) s;
						double r = Math.sqrt(((x - c.getX()) * (x - c.getX())) + ((y - c.getY()) * (y - c.getY())));
						if (r <= c.getRadius()) {

							shapes.remove(i);
						}
					}

					else if (s instanceof Line) {
						Line l = (Line) s;
						if (Math.floor((x - l.getX1()) / (l.getX() - l.getX1()) * 10)
								/ 10 == Math.floor((y - l.getY1()) / (l.getY() - l.getY1()) * 10) / 10) {

							shapes.remove(i);
						}
					}
				}
				this.reDraw();

			}

		}
	}

	public void clear() {
		UI.clearPanes();
	}

	public UserInterface() {
		UI.initialise();
		UI.addButton("Draw Boxes", this::drawBox);
		UI.addButton("Draw Text", this::drawText);
		UI.addButton("Draw Lines", this::drawLines);
		UI.addButton("Draw Circle", this::drawCircle);
		// UI.addButton("Draw Shape", this::drawShape);
		UI.addButton("Modifies", this::modifies);
		UI.addButton("Move", this::move);
		UI.addButton("Remove", this::remove);
		UI.addButton("Clear", this::clear);
		UI.addButton("redraw", this::reDraw);
		UI.setMouseListener(this::domouse);
		//
	}

	public static void main(String[] args) {
		new UserInterface();
	}
}