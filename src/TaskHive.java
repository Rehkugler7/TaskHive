import processing.core.PApplet;

public class TaskHive extends PApplet {

    /*Para mañana:
    - mejorar calidad user y logo
    - cambiar tipografia logo
    - botones redondos
    - textfield
     */

    ColorPalette appColors;

   Fonts appFonts;

   GUI gui;

   Icons icons;

   RectButtons CreateAccount;


    public static void main(String[] args) {
        PApplet.main("TaskHive", args);
    }

    public void settings(){
        fullScreen();
        smooth(10);
    }

    public void setup(){
        appColors = new ColorPalette(this);
        appFonts = new Fonts(this);
        gui = new GUI(this, appColors);
        icons = new Icons(this);
        CreateAccount = new RectButtons(this, "CREATE ACCOUNT", width/8+(width/8), 5*height/6-(height/16), width/4, height/8);
    }

    public void draw(){
        //background(255);
        //appColors.displayColors(this, 25, 50, 600);
        //appFonts.displayFonts(this, 500, 500, 50);
        

        switch(gui.currentScreen){
            case LogIn: gui.drawLogIn(this);
            CreateAccount.display(this);
            CreateAccount.updateCursor(this);

            break;

            case Calendar: gui.drawCalendar(this);
            break;

            case TaskCreator: gui.drawTaskEditor(this);
            break;


        }

        /*rectMode(CENTER);
        image(icons.getUserIcon(), width/4, height/5);*/

    }

}
