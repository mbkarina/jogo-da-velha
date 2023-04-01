package com.example.jogodavelha;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;



public class HelloController implements Initializable {

    private Button[][] M = new Button[3][3];
    private int contador = 0;
    @FXML
    private Button botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, fechar;

    private String Jogador = "o";

    public void click(ActionEvent actionEvent) {
        contador++;
        Button b = (Button)actionEvent.getSource();
        System.out.println(b);
        b.setText(Jogador);
        if (Jogador.equals("o")){
            Jogador = "x";
        } else {
            Jogador = "o";
        }
        if (verificaVencedor()) {
            alerta("PARABÉNS", "Você ganhou o game!");

        } else if(contador == 9) {
            alerta("EMPATE!", "O jogo terminou empatado!");
        }
    }
    public void close(ActionEvent event){
        Platform.exit();
    }
    public void alerta(String txt1, String txt2){
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle(txt1);
        dialogoInfo.setHeaderText(txt2);
        dialogoInfo.setContentText("Obrigade por jogar nosso game.");
        dialogoInfo.showAndWait();
        Platform.exit();
    }

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        M[0][0] = botao1;
        M[0][1] = botao2;
        M[0][2] = botao3;
        M[1][0] = botao4;
        M[1][1] = botao5;
        M[1][2] = botao6;
        M[2][0] = botao7;
        M[2][1] = botao8;
        M[2][2] = botao9;
    }
     public boolean verificaVencedor(){
            for(int i = 0; i < 3; i++){
                if(((M[i][0]).getText() == (M[i][1]).getText()) && ((M[i][1]).getText() == (M[i][2]).getText()) && !((M[i][1]).getText().equals(""))){
                    return true;
                }
                if(((M[0][i]).getText() == (M[1][i]).getText()) && ((M[1][i]).getText() == (M[2][i]).getText()) && !((M[1][i]).getText().equals(""))){
                    return true;
                }
            }
            if(((M[0][0]).getText() == (M[1][1]).getText()) && ((M[1][1]).getText() == (M[2][2]).getText()) && !((M[1][1]).getText().equals(""))){
                return true;
            }
            if(((M[0][2]).getText() == (M[1][1]).getText()) && ((M[1][1]).getText() == (M[2][0]).getText()) && !((M[1][1]).getText().equals(""))){
                return true;
            }
            return false;
        }
}
