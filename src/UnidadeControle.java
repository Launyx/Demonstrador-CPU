import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.channels.AsynchronousByteChannel;
import java.util.HashMap;
import java.util.Scanner;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;

public class UnidadeControle extends Application implements EventHandler<ActionEvent>{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField Registro1;

    @FXML
    private TextField Registro2;

    @FXML
    private TextField Resultado;

    @FXML
    private TextField ULAA;

    @FXML
    private TextField ULAB;

    @FXML
    private TextField barramentoA;

    @FXML
    private TextField barramentoB;

    @FXML
    private TextField barramentoC;

    @FXML
    private TextField memoria1;

    @FXML
    private TextField memoria2;

    @FXML
    private TextField memoria3;

    @FXML
    private TextField memoria4;

    @FXML
    private TextField memoria5;

    @FXML
    private TextField memoria6;

    @FXML
    private Button escolheMemoria;

    @FXML
    private Button escolheRegistrador;

    @FXML
    private Button retornar;

    @FXML
    private Button buttonIniciar;

    Button button;
     public static void main(String[] args) throws InterruptedException {

        launch(args);


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

    @Override
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("layout.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("escolha.fxml"));
        Parent root2 = fxmlLoader2.load();
        Scene tela2 = new Scene(root2);

        primaryStage.setTitle("Simulador de CPU");
        primaryStage.setScene(tela2);
        primaryStage.show();

    }

    @FXML
    void IniciarR(ActionEvent event){

        String registradores[] = new String[2];

        String reg1 = Registro1.getText();
        String reg2 = Registro2.getText();

        Array.set(registradores, 0, reg1);
        Array.set(registradores, 1, reg2);


        barramentoA.setText(Registro1.getText());
        barramentoB.setText(Registro2.getText());


        ULAA.setText(barramentoA.getText());
        ULAB.setText(barramentoB.getText());

        Soma(event);

    }

    @FXML
    void IniciarM(ActionEvent event) {

        String memoria[] = new String[6];

        String mem1 = memoria1.getText();
        String mem2 = memoria2.getText();
        String mem3 = memoria3.getText();
        String mem4 = memoria4.getText();
        String mem5 = memoria5.getText();
        String mem6 = memoria6.getText();

        Array.set(memoria, 0, mem1);
        Array.set(memoria, 1, mem2);
        Array.set(memoria, 2, mem3);
        Array.set(memoria, 3, mem4);
        Array.set(memoria, 4, mem5);
        Array.set(memoria, 5, mem6);

        Registro1.setText(mem1);
        Registro2.setText(mem2);

        barramentoA.setText(Registro1.getText());
        barramentoB.setText(Registro2.getText());


        ULAA.setText(barramentoA.getText());
        ULAB.setText(barramentoB.getText());
    }

    @FXML
    void ResetarR(ActionEvent event) {
        memoria1.setText(null);
        memoria2.setText(null);
        memoria3.setText(null);
        memoria4.setText(null);
        memoria5.setText(null);
        memoria6.setText(null);

        Registro1.setText(null);
        Registro2.setText(null);

        barramentoA.setText(null);
        barramentoB.setText(null);
        barramentoC.setText(null);

        ULAA.setText(null);
        ULAB.setText(null);

        Resultado.setText(null);
    }

    @FXML
    void ResetarM(ActionEvent event) {
        memoria1.setText(null);
        memoria2.setText(null);
        memoria3.setText(null);
        memoria4.setText(null);
        memoria5.setText(null);
        memoria6.setText(null);

        Registro1.setText(null);
        Registro2.setText(null);

        barramentoA.setText(null);
        barramentoB.setText(null);
        barramentoC.setText(null);

        ULAA.setText(null);
        ULAB.setText(null);

        Resultado.setText(null);
    }

    @FXML
    void Soma(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        int soma = n1 + n2;

        Resultado.setText(String.valueOf(soma));
        barramentoC.setText(String.valueOf(soma));
    }

    @FXML
    void Subtracao(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        int sub = n1 - n2;

        Resultado.setText(String.valueOf(sub));
        barramentoC.setText(String.valueOf(sub));
    }

    @FXML
    void multi(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        int mult = n1 * n2;

        Resultado.setText(String.valueOf(mult));
        barramentoC.setText(String.valueOf(mult));
    }

    @FXML
    void divisao(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        double div = n1 / n2;

        Resultado.setText(String.valueOf(div));
        barramentoC.setText(String.valueOf(div));
    }

    @FXML
    void potencia(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        double pot = Math.pow(n1, n2);

        Resultado.setText(String.valueOf(pot));
        barramentoC.setText(String.valueOf(pot));
    }

    @FXML
    void resto(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        int rest = n1 % n2;

        Resultado.setText(String.valueOf(rest));
        barramentoC.setText(String.valueOf(rest));
        
    }

    @Override
    public void handle(ActionEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }

    @FXML
    void escolheMemo(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void escolheRegis(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Layout2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void RetornaTelaR(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("escolha.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void retornaTelaM(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("escolha.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
