import processing.core.PApplet;

public class ColorPalette {

    int[] palette;

    public ColorPalette(PApplet pcs){
        this.setColorPalette(pcs);
    }

    void setColorPalette(PApplet pcs){

        this.palette= new int[7];

        //Primary colors: Yellow and orange, respectively
        this.palette[0] = pcs.color(255, 195, 11);
        this.palette[1] = pcs.color(255, 166, 43);

        //Secondary colors: Blue --> dark, then light
        this.palette[2] = pcs.color(0, 64, 128);
        this.palette[3] = pcs.color(112, 171, 231);

        //Tertiary color: Red
        this.palette[4] = pcs.color(181, 0, 0);

        //Black and white
        this.palette[5] = pcs.color(0, 0, 0);
        this.palette[6] = pcs.color(255, 255, 255);

    }

    //Getters for each color and more

    int getPrimaryOne(){
        return this.palette[0];
    }

    int getPrimaryTwo(){
        return this.palette[1];
    }

    int getSecondaryOne(){
        return this.palette[2];
    }

    int getSecondaryTwo(){
        return this.palette[3];
    }

    int getTertiary(){
        return this.palette[4];
    }

    int getBlack(){
        return this.palette[5];
    }

    int getWhite(){
        return this.palette[6];
    }

    int getColorAt(int i){
        return this.palette[i];
    }

    int getHowManyColors(){
        return this.palette.length;
    }

    void displayColors(PApplet pcs, float x, float y, float w){
        pcs.pushStyle();

        float wc = w / getHowManyColors();
        for(int i=0; i<getHowManyColors(); i++){
            pcs.fill(getColorAt(i)); pcs.stroke(0); pcs.strokeWeight(3);
            pcs.rect(x + i*wc, y, wc, wc);
        }
        pcs.popStyle();
    }

}
