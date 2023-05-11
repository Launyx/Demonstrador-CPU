import java.util.ArrayList;

public class Memoria {
    
    private ArrayList<Double> memoria = new ArrayList<>();

    public Memoria(){

    }

    public void registrar(double n1){
        memoria.add(n1);
    }

    public double getMemoria(int local){
        double valor = memoria.get(local);
        return valor;
    }

    @Override
    public String toString(){
        StringBuilder st = new StringBuilder();
        System.out.println("");
        for(int i=0; i < memoria.size(); i++){
            st.append("Local de memória " + (i + 701) + ": " + memoria.get(i) + "\n");
        }
        return st.toString();
    }

}
