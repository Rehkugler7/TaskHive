import processing.core.PApplet;

public class GUI extends PApplet{

    public enum Screen {LogIn, Calendar, TaskCreator, Profile, Tracking, Admin}

    public Screen currentScreen;

   ColorPalette Colors;
   PApplet p5;

    //Constructor, (NO L'ENTENC!!!)

    public GUI(PApplet p5){
        this.p5 = p5;
        currentScreen=Screen.Calendar;
    }

    /* *************** SCREENS **************** */

    public void drawLogIn(PApplet pcs){

        pcs.background(255,255,255);
        // LES VUI TREURE DAFORA!
        float w = p5.width;
        float h = p5.height;

        pcs.line(w/2, 0, w/2, h);
        pcs.rectMode(pcs.CENTER);
        pcs.fill(Colors.getPrimaryOne());
        pcs.rect(w/4, h/4, w/6, h/6);

    }

    /* *************** COMMON PARTS **************** */

    public void ActionBar(){


    }
}
