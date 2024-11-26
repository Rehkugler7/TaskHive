import processing.core.PApplet;

public class TaskHive extends PApplet {

    /*Para mañana:
    - mejorar calidad user y logo
    - cambiar tipografia logo
    - textfield añadir boolean contraseña
    - añadir cursor boton
    - añadir icons del banner
    - añadir tipografía por todo, selects
     */

    ColorPalette appColors;

   Fonts appFonts;

   GUI gui;

   Icons icons;


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
    }

    public void draw(){
        //background(255);
        //appColors.displayColors(this, 25, 50, 600);
        //appFonts.displayFonts(this, 500, 500, 50);
        

        switch(gui.currentScreen){
            case LogIn: gui.drawLogIn(this);

            break;

            case Calendar: gui.drawCalendar(this);
            break;

            case TaskCreator: gui.drawTaskEditor(this);
            break;


        }

        /*rectMode(CENTER);
        image(icons.getUserIcon(), width/4, height/5);*/

    }


    public void mousePressed(){
        gui.UserName.isPressed(this);
        gui.Password.isPressed(this);
        gui.Hive.isPressed(this);
        gui.CreateAccount.updateCursor(this);

        if(gui.Edit.mouseOverSelect(this)){
            if(!gui.Edit.isCollapsed()){
                gui.Edit.update(this);      // Actualitzar valor
            }
            gui.Edit.toggle();        // Plegar o desplegar
        }
    }

    public void keyPressed(){
        gui.UserName.keyPressed(key, keyCode);
        gui.Password.keyPressed(key, keyCode);
        gui.Hive.keyPressed(key, keyCode);
    }

}
