package punto2D;
public class Punto2D {
    private int x;
    private int y;

    public Punto2D() {
        x = 0;
        y = 0;
    }

    public Punto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int[] getXY() {
        return new int[]{x, y};
    }

    public int getxDiff(Punto2D p1, Punto2D p2){
        return p2.getX() - p1.getX();
    }
    public int getyDiff(Punto2D p1, Punto2D p2) {
        return p2.getY() - p1.getY();
    }

    @Override
    public String toString(){
        return String.format("[%d,%d]", x, y);
    }
}
