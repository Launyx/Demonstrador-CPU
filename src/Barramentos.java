public class Barramentos {
    private double barramentoA = 0.0;
    private double barramentoB = 0.0;
    private double barramentoC = 0.0;

    public Barramentos(){

    }

    public double getBarramentoA() {
        return barramentoA;
    }

    public void setBarramentoA(double barramentoA) {
        this.barramentoA = barramentoA;
    }

    public double getBarramentoB() {
        return barramentoB;
    }

    public void setBarramentoB(double barramentoB) {
        this.barramentoB = barramentoB;
    }

    public double getBarramentoC() {
        return barramentoC;
    }

    public void setBarramentoC(double barramentoC) {
        this.barramentoC = barramentoC;
    }

    @Override
    public String toString(){
        StringBuilder st = new StringBuilder();
        st.append("Barramento A: " + getBarramentoA());
        st.append("\nBarramento B: " + getBarramentoB());
        st.append("\nBarramento C: " + getBarramentoC() + "\n");

        return st.toString();
    }
}
