import java.util.Scanner;

public class UnidadeControle {
    public static void main(String[] args) throws InterruptedException {

        Registradores registradores = new Registradores();
        Barramentos barramentos = new Barramentos();
        Memoria memoria = new Memoria();
        ULA ULA = new ULA();

        Scanner tec = new Scanner(System.in);

        boolean perguntaRegistro = false;
        boolean sistema = false;
        boolean continua = false;
        
        String localRegistro = "";
        double resultado = 0.0;
        
        System.out.println("Gostaria de regitrar os valores na MEMORIA ou direto nos REGISTRADORES?");
        while(perguntaRegistro == false){
            
            localRegistro = tec.nextLine().toUpperCase();

            if(localRegistro.equalsIgnoreCase("memoria")){
                perguntaRegistro = true;
            }else if(localRegistro.equalsIgnoreCase("registradores")){
                perguntaRegistro = true;
            }else{
                System.out.println("Opção inválida, digite \"MEMORIA\" ou \"REGISTRADORES\"!");
            }
        }

        // Loop para sistemar o sistema até que o usuário saia

            // Condição para verificar se o usuario digitou "memoria" ou "registradores"
            if(localRegistro.equalsIgnoreCase("memoria")){

                // Loop para sistemar o sistema pela memória
                while(sistema == false){
                    System.out.print("Digite o primeiro número: ");
                    double n1 = Double.parseDouble(tec.nextLine());

                    // adiciona o primeiro valor à memória
                    memoria.registrar(n1);

                    System.out.print("Digite o segundo número: ");
                    double n2 = Double.parseDouble(tec.nextLine());

                    // adiciona o segundo valor à memória
                    memoria.registrar(n2);

                    Thread.sleep(1000);

                    System.out.println("");
                    System.out.println(memoria);

                    System.out.println("----" + registradores.getArraySize());
                    if(registradores.getArraySize() > 0){
                        registradores.registrarNovo(0, memoria.getMemoria(memoria.getTamanhoMemoria() - 2));
                        registradores.registrarNovo(1, memoria.getMemoria(memoria.getTamanhoMemoria() - 1));
                    }else{
                        registradores.registrarVazio(memoria.getMemoria(0));
                        registradores.registrarVazio(memoria.getMemoria(1));
                    }
                    

                    Thread.sleep(1000);

                    System.out.println(registradores);

                    // Passa os valores presentes nos locais de memória para os barramentos A e B
                    barramentos.setBarramentoA(registradores.getRegistrador(0));
                    barramentos.setBarramentoB(registradores.getRegistrador(1));

                    Thread.sleep(1000);
                    
                    System.out.println(barramentos);

                    Thread.sleep(1000);

                    // Loop para certificar que o usuário digite um operador válido
                    while(resultado == 0.0){
                        System.out.print("Digite um dos seguintes operadores \"+ - * / ^ %\" : ");
                        char operador = tec.nextLine().charAt(0);

                        Thread.sleep(1000);

                        resultado = ULA.calcular(resultado, operador, barramentos.getBarramentoA(), barramentos.getBarramentoB());
                    }

                    Thread.sleep(1000);
                    barramentos.setBarramentoC(resultado);

                    System.out.println("");
                    System.out.println(barramentos);

                    Thread.sleep(1000);

                    registradores.registrarNovo(0, barramentos.getBarramentoC());

                    System.out.println(registradores);

                    Thread.sleep(1000);

                    memoria.registrar(registradores.getRegistrador(0));

                    System.out.println(memoria);

                    Thread.sleep(1000);                    

                    while(continua == false){

                        System.out.println("Gostaria de continuar? S/N");
                        String sair = tec.nextLine();
                        
                        if(sair.equalsIgnoreCase("n")){
                            sistema = true;
                            continua = true;
                        }else if(sair.equalsIgnoreCase("s")){
                            continua = true;
                            resultado = 0.0;
                        }else{
                            System.out.println("Opção inválida");
                        }
                    }
                    continua = false;
                
                }
            }else if(localRegistro.equalsIgnoreCase("registradores")){
                while(sistema == false){
                    System.out.print("Digite o primeiro número: ");
                    double n1 = Double.parseDouble(tec.nextLine());

                    System.out.print("Digite o segundo número: ");
                    double n2 = Double.parseDouble(tec.nextLine());

                    if(registradores.getArraySize() > 0){
                        registradores.registrarNovo(0, n1);
                        registradores.registrarNovo(1, n2);
                    }else{
                        registradores.registrarVazio(n1);
                        registradores.registrarVazio(n2);
                    }
                    
                    Thread.sleep(1000);

                    System.out.println("");
                    System.out.println(registradores);
                    
                    Thread.sleep(1000);
                    barramentos.setBarramentoA(registradores.getRegistrador(0));
                    barramentos.setBarramentoB(registradores.getRegistrador(1));

                    System.out.println(barramentos);

                    Thread.sleep(1000);

                    while(resultado == 0.0){
                        System.out.print("Digite um dos seguintes operadores \"+ - * / ^ %\" : ");
                        char operador = tec.nextLine().charAt(0);

                        Thread.sleep(1000);

                        resultado = ULA.calcular(resultado, operador, barramentos.getBarramentoA(), barramentos.getBarramentoB());
                    }

                    Thread.sleep(1000);

                    barramentos.setBarramentoC(resultado);

                    System.out.println("");
                    System.out.println(barramentos);


                    Thread.sleep(1000);
                    registradores.registrarNovo(0, barramentos.getBarramentoC());

                    System.out.println(registradores);

                    Thread.sleep(1000);

                    while(continua == false){

                        System.out.println("Gostaria de continuar? S/N");
                        String sair = tec.nextLine();
                        
                        if(sair.equalsIgnoreCase("n")){
                            sistema = true;
                            continua = true;
                        }else if(sair.equalsIgnoreCase("s")){
                            continua = true;
                            resultado = 0.0;
                        }else{
                            System.out.println("Opção inválida");
                        }
                    }
                    continua = false;
                }
            }

        tec.close();
    }
}