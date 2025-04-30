package punto2D;

public class Segmento extends Punto2D {
    private Punto2D inicio;
    private Punto2D fin;

    public Segmento() {
        super();
    }

    public Segmento(Punto2D inicio, Punto2D fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public Punto2D getInicio() {
        return inicio;
    }

    public void setInicio(Punto2D inicio) {
        this.inicio = inicio;
    }

    public Punto2D getFin() {
        return fin;
    }

    public void setFin(Punto2D fin) {
        this.fin = fin;
    }

    public Punto2D vector(Punto2D inicio, Punto2D fin) {
        return new Punto2D(getxDiff(inicio, fin), getyDiff(inicio, fin));
    }

    public double longitud(Punto2D inicio, Punto2D fin) {
        int xDiff = fin.getX() - inicio.getX();
        int yDiff = fin.getY() - inicio.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double longitud() {
        return longitud(inicio, fin);
    }

    public Punto2D puntoMedio() {
        int xDiff = fin.getX() - inicio.getX();
        int yDiff = fin.getY() - inicio.getY();
        return new Punto2D(xDiff / 2, yDiff / 2);
    }

    public double productoEscalar(Segmento s) {
        return s.getxDiff(s.getInicio(), s.getFin()) * getxDiff(inicio, fin) +
                s.getyDiff(s.getInicio(), s.getFin()) * getyDiff(inicio, fin);
    }

    public boolean esOrtogonal(Segmento s) {
        return productoEscalar(s) == 0;
    }

    public double getPendiente() {
        int xDiff = fin.getX() - inicio.getX();
        int yDiff = fin.getY() - inicio.getY();
        return Math.atan2(yDiff, xDiff);
    }

    public boolean sonIguales(Segmento s, Segmento t) {
        return s.getInicio() == t.getInicio() && s.getFin() == t.getFin();
    }

    public boolean sonParalelos(Segmento s, Segmento t) {
        return !sonIguales(s, t) && s.getPendiente() == t.getPendiente();
    }
}

