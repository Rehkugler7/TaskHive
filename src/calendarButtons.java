import processing.core.PApplet;

public class calendarButtons {

        ColorPalette appColors;
        float x, y, w, h;
        int day, month, year;
        boolean selected, enabled;
        int colorButton;



        public calendarButtons(PApplet pcs, float x, float y, float w, float h, int d, int m, int a){
            this.x = x; this.y=y; this.w = w; this.h = h;
            this.day = d; this.month = m; this.year = a;
            this.selected = false;
            this.enabled = true;
            appColors = new ColorPalette(pcs);
            this.colorButton = pcs.color(appColors.getPrimaryOne());
        }

        public void setSelected(boolean b){
            this.selected = b;
        }

        public void setEnabled(boolean b){
        this.enabled = b;
        }

        public void display(PApplet pcs){
            pcs.pushStyle();
            if(enabled){
                pcs.fill(appColors.getWhite());
            }
            else{
                pcs.fill(appColors.getGrey());
            }
            pcs.stroke(appColors.getBlack()); pcs.strokeWeight(3);
            pcs.rect(x, y, w, h, 5);
            if(selected){
                pcs.fill(appColors.getPrimaryOne()); pcs.strokeWeight(3);
                pcs.circle(x + w/2, y+h/2, 120);
            }
            pcs.fill(appColors.getBlack()); pcs.textSize(24); pcs.textAlign(pcs.CENTER);
            pcs.text(day, x + w/2, y + h/2 + 10);
            pcs.popStyle();
        }


        public boolean mouseOver(PApplet pcs){
            return pcs.mouseX>=this.x && pcs.mouseX<=this.x+this.w &&
                    pcs.mouseY>=this.y && pcs.mouseY<=this.y+this.h;
        }
}
