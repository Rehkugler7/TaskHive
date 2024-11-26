import processing.core.PApplet;
import processing.core.PConstants;

public class GUI {

    public enum Screen {LogIn, Calendar, TaskCreator}

    //public enum Screen {LogIn, Calendar, TaskCreator, Profile, Tracking, Admin}

    public Screen currentScreen;

   ColorPalette Colors;
   RectButtons CreateAccount;
   TextField UserName;
   TextField Password;
   TextField Hive;
   Icons Icons;
   Select Edit;
   String[] optionsEdit = {"User 1", "User 2", "User 3"};
   float w, h;


    public GUI(PApplet pcs, ColorPalette colorPalette){
        w = pcs.width;
        h = pcs.height;
        currentScreen=Screen.Calendar;
        this.Colors = colorPalette;
        this.Icons = Icons;
        CreateAccount = new RectButtons(pcs, "CREATE ACCOUNT", w/8+(w/8), 5*h/6-(h/16), w/4, h/8);
        UserName = new TextField(pcs,w/8, 2*h/3-(h/4), 3*w/8, 120, "Username:");
        Password = new TextField(pcs,w/8, 2*h/3-(h/6), 3*w/8, 120, "Password:");
        Hive = new TextField(pcs,w/8, 2*h/3-(h/12), 3*w/8, 100, "Hive:");
        Edit = new Select(optionsEdit, 100, 100, 200, 50, colorPalette);
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

        CreateAccount.display(pcs);
        CreateAccount.updateCursor(pcs);

        UserName.display(pcs);
        Password.display(pcs);
        Hive.display(pcs);

    }

    public void drawCalendar(PApplet pcs){

        pcs.background(Colors.getWhite());

        Edit.display(pcs);



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
