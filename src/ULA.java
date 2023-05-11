public class ULA {
    
    double ULA[] = new double[2];

    public double calcular(double resultado, char operador, double n1, double n2){

        ULA[0] = n1;
        ULA[1] = n2;

        // no programa principal, se resultado != 0.0, testasimbolo = true;
        switch(operador){
        
            case '+':
                resultado = ULA[0] + ULA[1];
                System.out.println("\nULA: " + ULA[0] + " + " + ULA[1] + " = " + resultado + "\n");

                if (resultado > 0){
                    System.out.println("[X] Positivo");
                }else{
                    System.out.println("[ ] Positivo");
                }

                if (resultado == 0){
                    System.out.println("[X] Zero");
                }else{
                    System.out.println("[ ] Zero");
                }
                
                if (resultado < 0){
                    System.out.println("[X] Negativo");
                }else{
                    System.out.println("[ ] Negativo");
                }

                break;

            case '-':
                resultado = ULA[0] - ULA[1];
                System.out.println("\nULA: " + ULA[0] + " - " + ULA[1] + " = " + resultado + "\n");

                if (resultado > 0){
                    System.out.println("[X] Positivo");
                }else{
                    System.out.println("[ ] Positivo");
                }

                if (resultado == 0){
                    System.out.println("[X] Zero");
                }else{
                    System.out.println("[ ] Zero");
                }
                
                if (resultado < 0){
                    System.out.println("[X] Negativo");
                }else{
                    System.out.println("[ ] Negativo");
                }

                break;

            case '*':
                resultado = ULA[0] * ULA[1];
                System.out.println("\nULA: " + ULA[0] + " * " + ULA[1] + " = " + resultado + "\n");

                if (resultado > 0){
                    System.out.println("[X] Positivo");
                }else{
                    System.out.println("[ ] Positivo");
                }

                if (resultado == 0){
                    System.out.println("[X] Zero");
                }else{
                    System.out.println("[ ] Zero");
                }
                
                if (resultado < 0){
                    System.out.println("[X] Negativo");
                }else{
                    System.out.println("[ ] Negativo");
                }

                break;

            case '/':
                resultado = ULA[0] / ULA[1];
                System.out.println("\nULA: " + ULA[0] + " / " + ULA[1] + " = " + resultado + "\n");

                if (resultado > 0){
                    System.out.println("[X] Positivo");
                }else{
                    System.out.println("[ ] Positivo");
                }

                if (resultado == 0){
                    System.out.println("[X] Zero");
                }else{
                    System.out.println("[ ] Zero");
                }
                
                if (resultado < 0){
                    System.out.println("[X] Negativo");
                }else{
                    System.out.println("[ ] Negativo");
                }

                break;

            case '%':
                resultado = ULA[0] % ULA[1];
                System.out.println("\nULA: " + ULA[0] + " % " + ULA[1] + " = " + resultado + "\n");

                if (resultado > 0){
                    System.out.println("[X] Positivo");
                }else{
                    System.out.println("[ ] Positivo");
                }

                if (resultado == 0){
                    System.out.println("[X] Zero");
                }else{
                    System.out.println("[ ] Zero");
                }
                
                if (resultado < 0){
                    System.out.println("[X] Negativo");
                }else{
                    System.out.println("[ ] Negativo");
                }

                break;

            case '^':
                resultado = Math.pow(ULA[0], ULA[1]);
                System.out.println("\nULA: " + ULA[0] + " ^ " + ULA[1] + " = " + resultado + "\n");

                if (resultado > 0){
                    System.out.println("[X] Positivo");
                }else{
                    System.out.println("[ ] Positivo");
                }

                if (resultado == 0){
                    System.out.println("[X] Zero");
                }else{
                    System.out.println("[ ] Zero");
                }
                
                if (resultado < 0){
                    System.out.println("[X] Negativo");
                }else{
                    System.out.println("[ ] Negativo");
                }

                break;
                
            default:
                System.out.println("Símbolo invalido!");
                resultado = 0.0;
                break;

        }
        return resultado;
    }
        
}
