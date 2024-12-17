import processing.core.PApplet;

import static java.lang.Math.min;
import static processing.core.PApplet.constrain;
import static processing.core.PConstants.BACKSPACE;
import static processing.core.PConstants.CODED;

public class TextArea {

    float x, y, h, w;
    int columnN, rowN;
    ColorPalette appColors;
    int color;
    int stroke = 3;
    String text = "";
    String[] lines;
    boolean selected = false;


    public TextArea(PApplet pcs, float x, float y, float w, float h, int nc, int nr) {
        this.x = x; this.y = y; this.w = w; this.h = h;
        this.columnN = nc; this.rowN = nr;
        this.lines = new String[nr];
        appColors = new ColorPalette(pcs);
        this.color = pcs.color(appColors.getSecondaryTwo());
    }

    public void display(PApplet pcs) {
        pcs.pushStyle();
        pcs.fill(color);
        pcs.strokeWeight(stroke);
        pcs.stroke(appColors.getBlack());
        pcs.rectMode(pcs.CORNER);
        pcs.rect(x, y, w, h);

        pcs.fill(0);
        pcs.textSize(30);
        for(int i=0; i<lines.length; i++){
            if(lines[i]!=null){
                pcs.text(lines[i], x + 20, y + i* 40 + 50);
            }
        }
        pcs.popStyle();
    }

    public void updateLines(){
        if(text.length()>0){
            int numLines = constrain(text.length() / columnN, 0, this.rowN -1);
            for(int i=0; i<=numLines; i++){
                int start = i* columnN;
                int end = min(text.length(), (i+1)* columnN);
                lines[i] = text.substring(start, end);
            }
        }
        else {
            for(int i=0; i<lines.length; i++){
                lines[i] ="";
            }
        }
    }

    public void keyPressed(char key, int keyCode) {
        if (selected) {
            System.out.println("Selected!");
            if (keyCode == (int)BACKSPACE) {
                removeLetter();
            } else if (keyCode == 32) {
                addLetter(' ');
            } else if(key!=CODED){
                addLetter(key);
                System.out.println("Letter:" + key);
            }
        }
    }

    public void addLetter(char l) {
        if (this.text.length() < this.columnN * this.rowN) {
            this.text += l;
        }
        updateLines();
    }

    public void removeLetter() {
        if (text.length()> 0) {
            text = text.substring(0, text.length()-1);
        }
        updateLines();
    }

    public boolean mouseOverTextArea(PApplet pcs) {
        return (pcs.mouseX >= this.x && pcs.mouseX <= this.x + this.w && pcs.mouseY >= this.y && pcs.mouseY <= this.y + this.h);
    }

    public void isPressed(PApplet pcs) {
        if (mouseOverTextArea(pcs)) {
            selected = true;
        } else {
            selected = false;
        }
    }
}
