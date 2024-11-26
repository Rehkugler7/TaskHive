import processing.core.PApplet;
import processing.core.PImage;

public class imageButtons {

    //Properties

    float x,y,r;
    int Color, Black;
    PImage icon;
    ColorPalette appColors;
    int strokeOne, strokeTwo;

    public imageButtons(PApplet pcs, PImage icon, float x, float y, float r) {
        this.icon = icon;
        this.x = x; this.y = y; this.r = r;
        appColors = new ColorPalette(pcs);
        this.Color = appColors.getPrimaryOne();
        this.Black = appColors.getBlack();
        strokeOne = 3; strokeTwo = 6;
    }

    public void setColor(int cFill){
        this.Color = cFill;
    }

    public void display(PApplet pcs){
        pcs.pushStyle();
        pcs.fill(Color);
        if(mouseOverButton(pcs)){
            pcs.strokeWeight(strokeTwo);
        }
        else{
            pcs.strokeWeight(strokeOne);
        }
        pcs.stroke(Black);
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
