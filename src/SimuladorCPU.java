import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SimuladorCPU {

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
    private TextField memoria701;

    @FXML
    private TextField memoria702;

    @FXML
    private TextField memoria703;

    @FXML
    private TextField memoria704;

    @FXML
    private TextField memoria705;

    @FXML
    private TextField memoria706;

    @FXML
    void Iniciar(ActionEvent event) throws InterruptedException {
        String memoria1 = memoria701.getText();
        String memoria2 = memoria702.getText();

        setRegitradores(memoria1, memoria2);


        barramentoA.setText(Registro1.getText());
        barramentoB.setText(Registro2.getText());


        ULAA.setText(barramentoA.getText());
        ULAB.setText(barramentoB.getText());

    }

    @FXML
    void Resetar(ActionEvent event) {
        memoria701.setText(null);
        memoria702.setText(null);
        memoria703.setText(null);
        memoria704.setText(null);
        memoria705.setText(null);
        memoria706.setText(null);

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
    }

    @FXML
    void Subtracao(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        int sub = n1 - n2;

        Resultado.setText(String.valueOf(sub));
    }

    @FXML
    void multi(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        int mult = n1 * n2;

        Resultado.setText(String.valueOf(mult));
    }

    @FXML
    void divisao(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        double div = n1 / n2;

        Resultado.setText(String.valueOf(div));
    }

    @FXML
    void potencia(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        double pot = Math.pow(n1, n2);

        Resultado.setText(String.valueOf(pot));
    }

    @FXML
    void resto(ActionEvent event) {
        int n1 = Integer.parseInt(ULAA.getText());
        int n2 = Integer.parseInt(ULAB.getText());

        int rest = n1 % n2;

        Resultado.setText(String.valueOf(rest));
    }

    public void dorme() throws InterruptedException{
        Thread.sleep(1000);
    }

    public void setRegitradores(String memoria1, String memoria2){

        Registro1.setText(memoria1);
        Registro2.setText(memoria2);
    }
}