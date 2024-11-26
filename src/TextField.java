import processing.core.PApplet;

import static processing.core.PConstants.BACKSPACE;

public class TextField {


    float x0, y0, w;

    int spacing;
    String purpose;


    int lineColor;


    public String text = "";
    int textSize = 24;

    boolean selected = false;

    public TextField(PApplet pcs, float x0, float y0, float w, int s, String p) {
        this.x0 = x0;
        this.y0 = y0;
        this.w = w;
        spacing=s;
        purpose = p;
        lineColor = pcs.color(200, 200, 200);
    }

    public void display(PApplet pcs) {
        pcs.pushStyle();
        pcs.strokeWeight(2);
        pcs.stroke(lineColor);
        pcs.line(x0, y0, w, y0);
        pcs.textSize(textSize);
        pcs.textAlign(pcs.LEFT, pcs.CENTER);
        pcs.fill(lineColor);
        pcs.text(purpose, x0 + 5, y0 - 15);
        pcs.fill(0);
        pcs.text(text, x0+spacing, y0-15);
        pcs.popStyle();
    }

    public void keyPressed(char key, int keyCode) {
        if (selected) {
            if (keyCode == (int)BACKSPACE) {
                removeText();
            } else if (keyCode == 32) {
                addText(' ');
            } else {
                    addText(key);
                }
            }
        }

    public void addText(char c) {
        if (this.text.length() + 1 < w) {
            this.text += c;
        }
    }

    public void removeText() {
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
        }
    }

    public void removeAllText() {
        this.text = "";
    }

    public String getText() {
        return this.text;
    }

    public void setText(String t) {
        this.text = t;
    }

    public boolean mouseOverTextField(PApplet pcs) {
        return (pcs.mouseX >= this.x0 && pcs.mouseX <= this.x0+this.w && pcs.mouseY <= this.y0 && pcs.mouseY >= this.y0-20);
    }

    public void isPressed(PApplet pcs) {
        if (mouseOverTextField(pcs)) {
            selected = true;
        } else {
            selected = false;
        }
    }
}
