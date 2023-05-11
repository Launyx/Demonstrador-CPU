import java.util.Scanner;

public class UnidadeControle {
    public static void main(String[] args) throws InterruptedException {

        Memoria memoria = new Memoria();
        Barramentos barramentos = new Barramentos();
        ULA ULA = new ULA();

        Scanner tec = new Scanner(System.in);

        boolean perguntaRegistro = false;
        boolean perguntaSimbolo = false;
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

        // Loop para continuar o sistema até que o usuário saia
        while(sistema == false){

            // Condição para verificar se o usuario digitou "memoria" ou "registradores"
            if(localRegistro.equalsIgnoreCase("memoria")){

                // Loop para continuar o sistema pela memória
                while(continua == false){
                    System.out.print("Digite o primeiro número: ");
                    double n1 = Double.parseDouble(tec.nextLine());

                    // adiciona o primeiro valor à memória
                    memoria.registrar(n1);

                    System.out.print("Digite o segundo número: ");
                    double n2 = Double.parseDouble(tec.nextLine());

                    // adiciona o segundo valor à memória
                    memoria.registrar(n2);

                    Thread.sleep(1000);

                    System.out.println(memoria);

                    // Passa os valores presentes nos locais de memória para os barramentos A e B
                    barramentos.setBarramentoA(memoria.getMemoria(0));
                    barramentos.setBarramentoB(memoria.getMemoria(1));

                    Thread.sleep(1000);
                    
                    System.out.println(barramentos);

                    Thread.sleep(1000);

                    // Loop para certificar que o usuário digite um operador válido
                    while(resultado == 0.0){
                        System.out.print("Digite um dos seguintes operadores \"+ - * / ^ %\" : ");
                        char operador = tec.nextLine().charAt(0);

                        Thread.sleep(1000);

                        resultado = ULA.calcular(resultado, operador, n1, n2);
                    }

                    Thread.sleep(1000);
                    barramentos.setBarramentoC(resultado);

                    System.out.println("");
                    System.out.println(barramentos);

                    
                }
            }else if(localRegistro.equalsIgnoreCase("registradores")){

            }


        }

        tec.close();
    }
}
