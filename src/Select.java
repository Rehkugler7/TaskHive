import processing.core.PApplet;

public class Select {

    float x, y, w, h;
    String[] options;
    String selectedValue;
    boolean collapsed = true;
    float lineSpace = 15;
    ColorPalette appColors;

    public Select(String[] options, float x, float y, float w, float h, ColorPalette colorPalette){

        this.options = options;
        this.selectedValue = "";
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.collapsed = true;
        this.appColors = colorPalette;
    }

    public  boolean isCollapsed(){
        return  this.collapsed;
    }

    public String getSelectedValue(){
        return  this.selectedValue;
    }

    public void display(PApplet pcs){
        pcs.pushStyle();
        pcs.stroke(appColors.getBlack()); pcs.strokeWeight(2); pcs.fill(appColors.getWhite());
        pcs.rect(x, y, w, h);

        pcs.fill(appColors.getPrimaryTwo());
        pcs.rect(x + w - 30, y, 30, h);

        pcs.fill(appColors.getBlack()); pcs.stroke(appColors.getBlack());
        pcs.triangle(x + w - 25, y+5, x + w - 15, y + 25, x + w - 5 , y+5);

        pcs.fill(0); pcs.textSize(14);
        pcs.text(selectedValue, x + 10, y + 20);

        if(!this.collapsed){

            pcs.fill(appColors.getWhite()); pcs.stroke(appColors.getBlack());
            pcs.rect(x, y+h, w, (h + lineSpace)*options.length);

            for(int i=0; i<options.length; i++){

                if(i== clickedOption(pcs)){
                    pcs.fill(200); pcs.noStroke();
                    pcs.rect(x+4, y+4 + h + (h + lineSpace)*i - 2, w -8, h + lineSpace - 8);
                }

                pcs.fill(0);
                pcs.text(options[i], x + 10, y + h + 25 + (h + lineSpace)*i);
            }
        }
        pcs.popStyle();
    }

    public void setCollapsed(boolean b){
        this.collapsed = b;
    }

    public void toggle(){
        this.collapsed = !this.collapsed;
    }

    public void update(PApplet pcs){
        int option = clickedOption(pcs);
        selectedValue = options[option];
    }

    public boolean mouseOverSelect(PApplet pcs){
        if(this.collapsed){
            return (pcs.mouseX >= x) &&
                    (pcs.mouseX <= x + w) &&
                    (pcs.mouseY >= y) &&
                    (pcs.mouseY <= y + h);
        }
        else {
            return (pcs.mouseX>= x) &&
                    (pcs.mouseX<= x + w) &&
                    (pcs.mouseY>= y) &&
                    (pcs.mouseY<= y + h + (h + lineSpace)*options.length);
        }
    }

    int clickedOption(PApplet pcs){
        int i = (int)pcs.map(pcs.mouseY, y + h, y + h + (h + lineSpace)*options.length,
                0, options.length);
        return i;
    }
}
