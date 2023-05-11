import java.lang.reflect.Array;
import java.util.Scanner;


public class CPU {
    public static void main(String[] args) throws Exception {
        
        Scanner tec = new Scanner(System.in);
        double Memoria[] = new double[3];
        double Registradores[] = new double[2];
        double ULA[] = new double[2];
        double resultado = 0.0;
        String registrar = "";
        
        boolean localRegistro = false;
        boolean sistema = false;
        boolean continua = false;
        boolean testaSimbolo = false;
        
        System.out.println("Gostaria de regitrar os valores na MEMORIA ou direto nos REGISTRADORES?");
        while(localRegistro == false){
            
            registrar = tec.nextLine().toUpperCase();

            if(registrar.equalsIgnoreCase("memoria")){
                localRegistro = true;
            }else if(registrar.equalsIgnoreCase("registradores")){
                localRegistro = true;
            }else{
                System.out.println("Opção inválida, digite \"MEMORIA\" ou \"REGISTRADORES\"!");
            }
        }

        while(sistema == false){
            if (registrar.equalsIgnoreCase("memoria")){
                while(continua == false){
                
                    // Obtenção dos valores digitados pelo usuário
                    System.out.print("Digite um número:");
                    double n1 = Double.parseDouble(tec.nextLine());
        
                    System.out.print("Digite outro numero: ");
                    Double n2 = Double.parseDouble(tec.nextLine());
        
                    // Alocação dos valores na memória
                    Array.set(Memoria, 0, n1);
                    Array.set(Memoria, 1, n2);
        
                    Thread.sleep(1000);
                    System.out.println("-------------------------------------");
                    System.out.println("Local de memoria 701: " + Memoria[0]);
                    System.out.println("Local de memoria 702: " + Memoria[1]);
        
                    Thread.sleep(1000);
                    // Representação dos valores passando da memória para os registradores
                    Array.set(Registradores, 0, Memoria[0]);
                    Array.set(Registradores, 1, Memoria[1]);
        
                    // Demonstração do estado dos registradores
                    System.out.println("-------------------------------------");
                    for (int i = 0; i < Registradores.length; i ++){
                        System.out.println("Registrador " + (i + 1) + ": " + Registradores[i]);
        
                    }
        
                    // Representação dos valores passando dos registradores para os barramentos
                    double barramentoA = Registradores[0];
                    double barramentoB = Registradores[1];
        
                    Thread.sleep(1000);
                    // Demonstração do estado dos barramentos A e B
                    System.out.println("-------------------------------------");
                    System.out.println("Barramento A: " + barramentoA);
                    System.out.println("Barramento B: " + barramentoB);
                    System.out.println("-------------------------------------");
                    // Representação da ULA recebendo os valores dos barramentos A e B
                    ULA[0] = barramentoA;
                    ULA[1] = barramentoB;
        
                    Thread.sleep(1000);
        
                    // Switch case para obter a operação desejada pelo usuário
                    while(testaSimbolo == false){
                        System.out.print("Digite o operador: ");
                        char op = tec.nextLine().charAt(0);
        
                        Thread.sleep(1000);
                        System.out.println("-------------------------------------");
                        switch(op){
        
                            case '+':
                                resultado = ULA[0] + ULA[1];
                                System.out.println("ULA: " + ULA[0] + " + " + ULA[1] + " = " + resultado + "\n");
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
        
                            case '-':
                                resultado = ULA[0] - ULA[1];
                                System.out.println("ULA: " + ULA[0] + " - " + ULA[1] + " = " + resultado + "\n");
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '*':
                                resultado = ULA[0] * ULA[1];
                                System.out.println("ULA: " + ULA[0] + " * " + ULA[1] + " = " + resultado + "\n");
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '/':
                                resultado = ULA[0] / ULA[1];
                                System.out.println("ULA: " + ULA[0] + " / " + ULA[1] + " = " + resultado + "\n");
        
                                // Condições para mostrar se o número é positivo, zero ou negativo
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '%':
                                resultado = ULA[0] % ULA[1];
                                System.out.println("ULA: " + ULA[0] + " % " + ULA[1] + " = " + resultado + "\n");
        
                                // Condições para mostrar se o número é positivo, zero ou negativo
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '^':
                                resultado = Math.pow(ULA[0], ULA[1]);
                                System.out.println("ULA: " + ULA[0] + " ^ " + ULA[1] + " = " + resultado + "\n");
        
                            // Condições para mostrar se o número é positivo, zero ou negativo
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            default:
                                System.out.println("Símbolo invalido!");
                                break;
                        }
                    }
        
                    Thread.sleep(1000);
                    double barramentoC = resultado;
        
                    System.out.println("-------------------------------------");
                    System.out.println("Barramento C: " + barramentoC);
                    Array.set(Registradores, 0, resultado);
        
                    System.out.println("-------------------------------------");
                    Thread.sleep(1000);
                    for (int i = 0; i < Registradores.length; i ++){
                        System.out.println("Registrador " + (i + 1) + ": " + Registradores[i]);
        
                    }
        
                    Thread.sleep(1000);
        
                    Array.set(Memoria, 2, Registradores[0]);
        
                    System.out.println("-------------------------------------");
                    System.out.println("Local de memoria 701: " + Memoria[0]);
                    System.out.println("Local de memoria 702: " + Memoria[1]);
                    System.out.println("Local de memoria 703: " + Memoria[2]);
                    System.out.println("-------------------------------------");
                    testaSimbolo = false;
        
                    boolean booSaida = false;
                    while(booSaida == false){
                        System.out.println("Gostaria de sair? S/N");
                        char saida = Character.toUpperCase(tec.nextLine().charAt(0));
                    
                        if (saida == 'S'){
                            continua = true;
                            booSaida = true;
                            sistema = true;
                        }else if(saida != 'N'){
                            System.out.println("Opção inválida, digite \'S\' ou \'N\'");
                        }else{
                            booSaida = true;
                        }
                    }
                }
                
                tec.close();
    
            }else if(registrar.equalsIgnoreCase("registradores")){
                while(continua == false){
                
                    // Obtenção dos valores digitados pelo usuário
                    System.out.print("Digite um número:");
                    double n1 = Double.parseDouble(tec.nextLine());
        
                    System.out.print("Digite outro numero: ");
                    Double n2 = Double.parseDouble(tec.nextLine());
        
                    Thread.sleep(1000);
                    // Alocação dos valores nos registradores
                    Array.set(Registradores, 0, n1);
                    Array.set(Registradores, 1, n2);
        
                    // Demonstração do estado dos registradores
                    System.out.println("-------------------------------------");
                    for (int i = 0; i < Registradores.length; i ++){
                        System.out.println("Registrador " + (i + 1) + ": " + Registradores[i]);
        
                    }
        
                    // Representação dos valores passando dos registradores para os barramentos
                    double barramentoA = Registradores[0];
                    double barramentoB = Registradores[1];
        
                    Thread.sleep(1000);
                    // Demonstração do estado dos barramentos A e B
                    System.out.println("-------------------------------------");
                    System.out.println("Barramento A: " + barramentoA);
                    System.out.println("Barramento B: " + barramentoB);
                    System.out.println("-------------------------------------");
                    // Representação da ULA recebendo os valores dos barramentos A e B
                    ULA[0] = barramentoA;
                    ULA[1] = barramentoB;
        
                    Thread.sleep(1000);
        
                    // Switch case para obter a operação desejada pelo usuário
                    while(testaSimbolo == false){
                        System.out.print("Digite o operador: ");
                        char op = tec.nextLine().charAt(0);
        
                        Thread.sleep(1000);
                        System.out.println("-------------------------------------");
                        switch(op){
        
                            case '+':
                                resultado = ULA[0] + ULA[1];
                                System.out.println("ULA: " + ULA[0] + " + " + ULA[1] + " = " + resultado);
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
        
                            case '-':
                                resultado = ULA[0] - ULA[1];
                                System.out.println("ULA: " + ULA[0] + " - " + ULA[1] + " = " + resultado);
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '*':
                                resultado = ULA[0] * ULA[1];
                                System.out.println("ULA: " + ULA[0] + " * " + ULA[1] + " = " + resultado);
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '/':
                                resultado = ULA[0] / ULA[1];
                                System.out.println("ULA: " + ULA[0] + " / " + ULA[1] + " = " + resultado);
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '%':
                                resultado = ULA[0] % ULA[1];
                                System.out.println("ULA: " + ULA[0] + " % " + ULA[1] + " = " + resultado);
        
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
        
                                Thread.sleep(1000);
                                testaSimbolo = true;
                                break;
                            case '^':
                            resultado = Math.pow(ULA[0], ULA[1]);
                            System.out.println("ULA: " + ULA[0] + " ^ " + ULA[1] + " = " + resultado);
        
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
        
                            Thread.sleep(1000);
                            testaSimbolo = true;
                                break;
                            default:
                                System.out.println("Símbolo invalido!");
                                break;
        
                        }
                    }
        
                    Thread.sleep(1000);
                    double barramentoC = resultado;
        
                    System.out.println("-------------------------------------");
                    System.out.println("Barramento C: " + barramentoC);
                    Array.set(Registradores, 0, resultado);
        
                    System.out.println("-------------------------------------");
                    Thread.sleep(1000);
                    for (int i = 0; i < Registradores.length; i ++){
                        System.out.println("Registrador " + (i + 1) + ": " + Registradores[i]);
        
                    }
        
                    Thread.sleep(1000);
        
                    Array.set(Memoria, 0, Registradores[0]);
        
                    System.out.println("-------------------------------------");
                    System.out.println("Local de memoria 701: " + Memoria[0]);
                    System.out.println("-------------------------------------");
                    
                    testaSimbolo = false;
        
                    boolean booSaida = false;
                    while(booSaida == false){
                        System.out.println("Gostaria de sair? S/N");
                        char saida = Character.toUpperCase(tec.nextLine().charAt(0));
                    
                        if (saida == 'S'){
                            continua = true;
                            booSaida = true;
                            sistema = true;
                        }else if(saida != 'N'){
                            System.out.println("Opção inválida, digite \'S\' ou \'N\'");
                        }else{
                            booSaida = true;
                        }
                    }
                }
                
                tec.close();
                
            }
        }
    }
}
  