package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class Controller {


    private long number1;
    private String operator= "";
    private boolean start = true ;

    @FXML
    private Label output;

    @FXML
    private void processNumPad(ActionEvent event){

        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }


    @FXML
    private void pocessOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if (!value.equals("=")){
            if (!operator.isEmpty()){
                return;
            }
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }else{
            if (operator.isEmpty()){
                return;
            }
            if(output.getText().isEmpty()){
                output.setText("Error");
                operator="";
                start = true;
            }
            output.setText(calculate(number1, Long.parseLong(output.getText()), operator));
            operator ="";

            start = true;
        }

    }

    @FXML
    private void clearOutput(ActionEvent event){
        output.setText("0");
        start = true ;
        operator ="";
    }




    private String calculate(long number1 ,long number2,String op){
        switch (op) {
            case "+":
                return String.valueOf(number1  + number2);
            case "-":
                return String.valueOf(number1 - number2);
            case "x":
                return String.valueOf(number1 * number2);
            case "/":
                if (number2 == 0){
                    return "Error";
                }
                return String.valueOf(number1 / number2);


        }
        return "Error";
    }
}


