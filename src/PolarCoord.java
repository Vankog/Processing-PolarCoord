/* angle in right triangle: "SOHCAHTOA":
* Sin(theta) = Opposite / Hypothenuse
* Cos(theta) = Adjacent / Hypothenuse
* Tan(theta) = Opposite / Adjacent
* -> theta = angle in question
*
* cartesian (x,y) to polar (r, theta) coordinates:
* sin(th) = y/r -> y = r × sin(th)
* cos(th) = x/r -> x = r× cos(th)
*/

import processing.core.PApplet;

/**
 * Created by Vankog on 17.12.2016.
 */
public class PolarCoord extends PApplet {
	float angle = PI * 1.5f;
	float r = 50;

	float angVel = 0;
	float angAcc = 0;

	final int sizeX = 640;
	final int sizeY = 480;

	public static void main(String[] args) {
		PApplet.main("PolarCoord", args);
	}

	//setup screen
	public void settings() {
		size(sizeX, sizeY);
	}

	public void mouseClicked() {
	}

	public void draw() {
		background(0);

		translate(width / 2, height / 2);
		stroke(255);
		fill(255);

		angAcc = map(mouseX, 0, width, -0.001f, 0.001f);
		angVel += angAcc;
		angle += angVel;
		// convert polar to cartesian
		float x = r * cos(angle);
		float y = r * sin(angle);

		line(0, 0, x, y);
		ellipse(x, y, 10, 10);
	}
}
