import java.util.ArrayList;

public class Registradores {
    
    private ArrayList<Double> registradores = new ArrayList<>();

    public Registradores(){

    }

    public void registrarVazio(double n1){
        registradores.add(n1);
    }

    public void registrarNovo(int local, double n1){
        registradores.set(local, n1);
    }

    public double getRegistrador(int local){
        double valor = registradores.get(local);
        return valor;
    }

    public int getArraySize(){
        return registradores.size();
    }

    @Override
    public String toString(){
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < registradores.size(); i++){
            st.append("Registrador " + (i + 1) + ": " + registradores.get(i) + "\n");
        }
        return st.toString();
    }
}