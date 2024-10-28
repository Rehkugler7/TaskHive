import processing.core.PApplet;
import processing.core.PConstants;

public class GUI {

    public enum Screen {LogIn, Calendar, TaskCreator}

    //public enum Screen {LogIn, Calendar, TaskCreator, Profile, Tracking, Admin}

    public Screen currentScreen;

   ColorPalette Colors;
    Icons Icons;
    float w, h;



    //Constructor, (NO L'ENTENC!!!)

    public GUI(PApplet pcs, ColorPalette colorPalette){
        w = pcs.width;
        h = pcs.height;
        currentScreen=Screen.LogIn;
        this.Colors = colorPalette;
        this.Icons = Icons;
    }

    /* *************** SCREENS **************** */

    public void drawLogIn(PApplet pcs){

        Icons = new Icons(pcs);

        pcs.background(Colors.getWhite());

        pcs.strokeWeight(3);

        pcs.rectMode(pcs.CENTER);
        pcs.fill(Colors.getPrimaryOne());
        pcs.circle(w/4,h/5,200);

        pcs.line(w/2, 0, w/2, h);

        pcs.image(Icons.getUserIcon(), w/4-(125/2), h/5-(125/2), 125,125);

        pcs.image(Icons.getLogoIcon(), 3*w/4-500, h/2-500, 1000,1000);

    }

    public void drawCalendar(PApplet pcs){

        //too complex as for now

    }

    public void drawTaskEditor(PApplet pcs){

        //too complex as for now

    }

    /* *************** COMMON PARTS **************** */

    /*public void ActionBar(PApplet pcs){

        pcs.fill(Colors.getBlack());
        pcs.strokeWeight(5);
        pcs.rect(0,0, w, (7/100)*h);
        //faltan botones

    }

    public void TaskList(PApplet pcs){

        pcs.fill(Colors.getWhite());
        pcs.strokeWeight(4);
        pcs.rect(0,(7/100)*h, (3/10)*w, h-((7/100)*h));
        pcs.rectMode(pcs.CENTER);
        pcs.fill(Colors.getPrimaryOne());
        pcs.rect((float) ((1.5/10)*w), (79/100)*h, (27/100)*w, (17/100)*h);

    }*/
}
