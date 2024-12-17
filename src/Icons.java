import processing.core.PApplet;
import processing.core.PImage;

public class Icons {

    //pendiente mejora de calidad

    PImage[] Icons;

    public Icons(PApplet pcs){
        this.setIcons(pcs);
    }

    void setIcons(PApplet pcs){
        this.Icons = new PImage[3];

        //Log In Icons: First two

        this.Icons[0] = pcs.loadImage("UserIcon.png");
        this.Icons[1] = pcs.loadImage("logo.png");

        //Notif Icon: ok, no
        this.Icons[2] = pcs.loadImage("cuzNoPic4now.png");
    }

    //Getters for each icon

    PImage getUserIcon(){
        return this.Icons[0];
    }

    PImage getLogoIcon() {
        return this.Icons[1];
    }

    PImage getOkIcon() {
        return this.Icons[2];
    }
}
