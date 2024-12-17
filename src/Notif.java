import processing.core.PApplet;
import processing.core.PImage;

public class Notif {

    float x, y, w, h;
    String text;
    public imageButtons ok;
    float buttonW = 200, buttonH = 80;
    boolean notifOn = true;
    Icons Icons;


    public Notif(PApplet pcs,String message, float x, float y, float w, float h, int cStroke, int cFill){
        this.text = message;
        this.x = x; this.y = y;
        this.w = w; this.h = h;
        this.Icons= new Icons(pcs);
        this.ok = new imageButtons(pcs, Icons.getOkIcon(), x+w-100, y+h, 50, notifOn);
        this.ok.setColors(cStroke, cFill);
    }

    public void setText(String text){
        this.text = text;
    }

    public void setNotifOn(boolean b){
        this.notifOn = b;
        if(!this.notifOn){
            this.ok.setEnabled(false);
        }
        else {
            this.ok.setEnabled(true);
        }
    }

    public void display(PApplet pcs){

        if(this.notifOn){
            float lineSpacing = 40;

            pcs.pushStyle();

            pcs.stroke(0); pcs.strokeWeight(3);pcs.fill(250);
            pcs.rect(x, y, w, h);

            pcs.fill(0); pcs.textSize(24); pcs.textAlign(pcs.CENTER);
            pcs.text(text, x + w/2, y + lineSpacing);

            ok.display(pcs);
            pcs.popStyle();
        }
    }


}
