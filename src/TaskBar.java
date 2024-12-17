import processing.core.PApplet;

public class TaskBar {


    float x, y, w, h;

    String time;

    String[] taskName;

    TextArea notes;

    public TaskBar(PApplet pcs, float x, float y, float w, float h, String t, String[] tN, TextArea n) {

        this.x = x; this.y = y; this.w = w; this.h = h;
        time = t;
        tN = new String[8];
        taskName = tN;
        notes = n;

    }

    public static void display (PApplet pcs){

        pcs.pushStyle();

        //Rectangle

    }


}
