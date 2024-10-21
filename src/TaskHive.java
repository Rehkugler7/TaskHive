import processing.core.PApplet;

public class TaskHive extends PApplet {

    //NO ME FUNCIONA!!!

   ColorPalette appColors;

   PApplet pcs;

    public static void main(String[] args) {
    }

    public void settings(){
        size(800, 800, P2D);
        smooth(10);
    }

    public void setup(){
    }

    public void draw(){
        background(255);
        appColors.displayColors(pcs, 25, 50, 100);
    }

}
