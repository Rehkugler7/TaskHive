import processing.core.PApplet;
import processing.core.PConstants;

public class RectButtons {

    ColorPalette appColors;

    float x, y, w, h; //position and dimentions
    int colorButton;//color of text buttons
    int strokeOne, strokeTwo; // usual stroke vs stroke when mouse on the button
    String text;

    public RectButtons(PApplet pcs, String text, float x, float y, float w, float h){
        this.text=text;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        appColors = new ColorPalette(pcs);
        this.colorButton = pcs.color(appColors.getPrimaryOne());
        this.strokeOne = 3;
        this.strokeTwo= 6;
    }

    //text setter

    public void setText(String text){
        this.text=text;
    }

    // display

    public void display(PApplet pcs){

        pcs.pushStyle();
        if(mouseOnButton(pcs)){
            pcs.strokeWeight(strokeTwo);
        }else{
            pcs.strokeWeight(strokeOne);
        }
        pcs.rectMode(pcs.CENTER);
        pcs.rect(this.x, this.y, this.w, this.h);
        pcs.textAlign(pcs.CENTER);
        pcs.fill(appColors.getBlack());
        pcs.textSize(50);
        pcs.text(text, this.x, this.y+20);

    }

    public boolean mouseOnButton(PApplet pcs){
        return (pcs.mouseX >= this.x-this.w/2) && (pcs.mouseX <= this.x+this.w/2) &&
                (pcs.mouseY >= this.y-this.h/2) && (pcs.mouseY <= this.y+this.h/2);
    }

    public boolean updateCursor(PApplet pcs){
        return mouseOnButton(pcs);
    }

    //update coursor falta

}
