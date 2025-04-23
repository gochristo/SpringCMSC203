public class Plot {

    private int depth;
    private int width;
    private int x;
    private int y;

    public Plot(){
        depth = 1;
        width = 1;
        x = 0;
        y = 0;
    }

    public Plot(int x, int y, int width, int depth){
        this.depth = depth;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Plot(Plot otherplot){
        this.depth = otherplot.depth;
        this.width = otherplot.width;
        this.x = otherplot.x;
        this.y = otherplot.y;
    }

    public boolean encompasses(Plot plot) {
        return plot.x <= (x + width) &&
                plot.x >= x &&
                plot.y <= (y + depth) &&
                plot.y >= y &&

                plot.x + plot.width <= x + width &&
                plot.y + plot.depth <= y + depth;

    }
    public boolean overlaps(Plot otherplot){
        return !(otherplot.x + otherplot.width <= this.x ||
                otherplot.x >= this.x + this.width ||
                otherplot.y + otherplot.depth <= this.y ||
                otherplot.y >= this.y + this.depth);
    }

    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getX() {
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y){
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }


}
