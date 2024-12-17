import processing.core.PApplet;
import processing.core.PConstants;

public class GUI {

    public enum Screen {LogIn, Calendar, TaskCreator}

    //public enum Screen {LogIn, Calendar, TaskCreator, Profile, Tracking, Admin}

    public Screen currentScreen;

   ColorPalette Colors;
   Fonts Font;
   RectButtons CreateAccount;
   TextField UserName;
   TextField Password;
   TextField Hive;
   Icons Icons;
   Select Edit;
   String[] optionsEdit = {"User 1", "User 2", "User 3"};
   float w, h;
   Calendar Calendar;
   TextArea Notes;
   Notif TaskDone;


    public GUI(PApplet pcs, ColorPalette colorPalette, Fonts font){
        w = pcs.width;
        h = pcs.height;
        currentScreen=Screen.LogIn;
        this.Colors = colorPalette;
        this.Font = font;
        this.Icons = Icons;
        CreateAccount = new RectButtons(pcs, "CREATE ACCOUNT", w/8+(w/8), 5*h/6-(h/16), w/4, h/8);
        UserName = new TextField(pcs,w/8, 2*h/3-(h/4), 3*w/8,30, 120, "Username:");
        Password = new TextField(pcs,w/8, 2*h/3-(h/6), 3*w/8,30, 120, "Password:");
        Hive = new TextField(pcs,w/8, 2*h/3-(h/12), 3*w/8, 30,100, "Hive:");
        Edit = new Select(optionsEdit, 300, 400, 100, 25, colorPalette);
        Calendar = new Calendar(pcs,(3*w/8), 2*h/19, (w-3*w/8)-20, 17*h/19-20);
        Notes = new TextArea(pcs, 50F, 2*h/3, (w-150)-((w-3*w/8)-20), h/4, 50,6);
        TaskDone = new Notif(pcs, "USUARIO 1 ha completado LAVAR PLATOS", 50F, 5*h/12,(w-150)-((w-3*w/8)-20), h/8, this.Colors.getBlack(), this.Colors.getWhite());
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

        pcs.textFont(Font.getMainFontM());

        CreateAccount.display(pcs);
        CreateAccount.updateCursor(pcs);

        UserName.display(pcs);
        Password.display(pcs);
        Hive.display(pcs);

    }

    public void drawCalendar(PApplet pcs){

        pcs.background(Colors.getWhite());

        Calendar.display(pcs);

        drawTaskBar(pcs);

        TaskDone.display(pcs);





    }

    /* *************** COMMON PARTS **************** */

    public void drawTaskBar(PApplet pcs){

        Notes.display(pcs);

        pcs.fill(0); pcs.textSize(50);
        pcs.text("LISTA DE TAREAS", 50,100);
        Edit.display(pcs);

    }

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
