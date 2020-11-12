package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada) {
        if (pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException();
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaPripada = pocetnaPripada;
        this.krajnjaPripada = krajnjaPripada;
    }
    public Interval(){
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pocetnaPripada = false;
        krajnjaPripada = false;
    }
    public boolean isNull(){
        return this.equals(new Interval());
    }
    public boolean isIn(double tacka){
        boolean in = false;
        if (tacka>pocetnaTacka && tacka<krajnjaTacka) in = true;
        if (tacka == pocetnaTacka){
            if (pocetnaPripada) in = true;
        }
        if (tacka == krajnjaTacka){
            if (krajnjaPripada) in = true;
        }
        return in;
    }
   public Interval intersect(Interval a){
       if (this.isIn(a.getPocetnaTacka()) && this.isIn(a.getKrajnjaTacka())){
           return new Interval(a.getPocetnaTacka(), a.getKrajnjaTacka(), a.isPocetnaPripada(), a.isKrajnjaPripada());
       }
       if (this.isIn(a.getPocetnaTacka()) && !this.isIn(a.getKrajnjaTacka())){
           return new Interval(a.getPocetnaTacka(), this.getKrajnjaTacka(), a.isPocetnaPripada(), this.isKrajnjaPripada());
       }
       if (!this.isIn(a.getPocetnaTacka()) && this.isIn(a.getKrajnjaTacka())){
           return new Interval(this.getPocetnaTacka(), a.getKrajnjaTacka(), this.isPocetnaPripada(), a.isKrajnjaPripada());
       }
       if (!this.isIn(a.getPocetnaTacka()) && !this.isIn(a.getKrajnjaTacka())){
           return new Interval(this.getPocetnaTacka(), this.getKrajnjaTacka(), this.isPocetnaPripada(), this.isKrajnjaPripada());
       }
       return new Interval();
   }
   public static Interval intersect(Interval a, Interval b){
       if (b.isIn(a.getPocetnaTacka()) && b.isIn(a.getKrajnjaTacka())){
           return new Interval(a.getPocetnaTacka(), a.getKrajnjaTacka(), a.isPocetnaPripada(), a.isKrajnjaPripada());
       }
       if (b.isIn(a.getPocetnaTacka()) && !b.isIn(a.getKrajnjaTacka())){
           return new Interval(a.getPocetnaTacka(), b.getKrajnjaTacka(), a.isPocetnaPripada(), b.isKrajnjaPripada());
       }
       if (!b.isIn(a.getPocetnaTacka()) && b.isIn(a.getKrajnjaTacka())){
           return new Interval(b.getPocetnaTacka(), a.getKrajnjaTacka(), b.isPocetnaPripada(), a.isKrajnjaPripada());
       }
       if (!b.isIn(a.getPocetnaTacka()) && !b.isIn(a.getKrajnjaTacka())){
           return new Interval(b.getPocetnaTacka(), b.getKrajnjaTacka(), b.isPocetnaPripada(), b.isKrajnjaPripada());
       }
       return new Interval();
   }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Interval)) return false;
        Interval interval = (Interval) obj;
        return pocetnaTacka == interval.getPocetnaTacka() && krajnjaTacka == interval.getKrajnjaTacka() &&
                pocetnaPripada == interval.isPocetnaPripada() && krajnjaPripada == interval.isKrajnjaPripada();
    }
    @Override
    public String toString() {
        String p = "";
        String k = "";
        if (this.isNull()) return  "()";
        if (pocetnaPripada) p = "[";
        else p = "(";
        if (krajnjaPripada) k = "]";
        else k = ")";
        return (p + pocetnaTacka + "," + krajnjaTacka + k);
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isPocetnaPripada() {
        return pocetnaPripada;
    }

    public void setPocetnaPripada(boolean pocetnaPripada) {
        this.pocetnaPripada = pocetnaPripada;
    }

    public boolean isKrajnjaPripada() {
        return krajnjaPripada;
    }

    public void setKrajnjaPripada(boolean krajnjaPripada) {
        this.krajnjaPripada = krajnjaPripada;
    }
}
