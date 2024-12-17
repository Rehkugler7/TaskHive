import processing.core.PApplet;
import processing.core.PImage;

public class imageButtons {

    //Properties

    float x,y,r;
    int Color, Black;
    PImage icon;
    int strokeCol, fillCol;
    int strokeOne, strokeTwo;
    boolean enabled;

    public imageButtons(PApplet pcs, PImage icon, float x, float y, float r, boolean enabled) {
        this.icon = icon;
        this.x = x; this.y = y; this.r = r;
        strokeOne = 3; strokeTwo = 6;
        this.enabled=enabled;
    }

    public void setColors(int cStroke, int cFill){
        this.strokeCol = cStroke;
        this.fillCol = cFill;
    }

    public void setEnabled(boolean b){
        this.enabled = b;
    }

    public void display(PApplet pcs){
        pcs.pushStyle();
        pcs.fill(fillCol);
        if(mouseOverButton(pcs)){
            pcs.strokeWeight(strokeTwo);
        }
        else{
            pcs.strokeWeight(strokeOne);
        }
        pcs.stroke(strokeCol);
        pcs.circle(x, y, r);
        pcs.imageMode(pcs.CENTER);
        pcs.image(this.icon, this.x, this.y, 2*this.r, 2*this.r);
        pcs.popStyle();
    }

    public boolean mouseOverButton(PApplet p5){
        return p5.dist(p5.mouseX, p5.mouseY, this.x, this.y)<= this.r;
    }

    public boolean updateHandCursor(PApplet p5){
        return mouseOverButton(p5);
    }



}
