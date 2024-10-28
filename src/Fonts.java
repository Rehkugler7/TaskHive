import processing.core.PApplet;
import processing.core.PFont;

public class Fonts {

    PFont[] fonts;

    public Fonts(PApplet pcs){
        this.setFonts(pcs);
    }

    void setFonts(PApplet pcs){
        this.fonts = new PFont[4];
        this.fonts[0] = pcs.createFont("data/Quagi.ttf", 100);
        this.fonts[1] = pcs.createFont("data/Louis George Cafe.ttf",25);
        this.fonts[2] = pcs.createFont("data/Louis George Cafe.ttf",30);
        this.fonts[3] = pcs.createFont("data/Louis George Cafe.ttf",40);
    }

    //Getters for each color and more

    PFont getLogoFont(){
        return this.fonts[0];
    }

    PFont getMainFontS(){
        return this.fonts[1];
    }

    PFont getMainFontM(){
        return this.fonts[2];
    }

    PFont getMainFontL(){
        return this.fonts[3];
    }

    PFont getFontAt(int i){
        return this.fonts[i];
    }



    void displayFonts(PApplet pcs, float x, float y, float h){
        pcs.pushStyle();
        for(int i=0; i<4; i++){
            pcs.fill(0); pcs.stroke(0); pcs.strokeWeight(3);
            pcs.textFont(getFontAt(i));
            pcs.text("Tipografia" + i, x, y + i*h);
        }
    }
}
