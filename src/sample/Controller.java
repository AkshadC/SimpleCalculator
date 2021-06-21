package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller
{
    @FXML
    private Label result;
    @FXML
    private Label history;
    private long number1 = 0;
    private String operator = "";
    private Boolean start = true;
    private modal model = new modal();

    @FXML
    public void processNos(ActionEvent event)
    {
        if(start)
        {
            result.setText("");
            start=false;
        }
        String value = ((Button)event.getSource()).getText();

        result.setText(result.getText()+ value);
    }

    @FXML
    public void processOperator(ActionEvent event)
    {
        String value = ((Button)event.getSource()).getText();
        if (!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator=value ;
            number1=Long.parseLong(result.getText());
            history.setText(result.getText()+ operator);
            result.setText("");
        }
        else
        {
            if(operator.isEmpty())
                return;
            long number2 = Long.parseLong(result.getText());
            float output = model.Calc(number1,number2,operator);
            result.setText(String.valueOf(output));
            history.setText(String.valueOf(output));
            operator = "";
            start = true;
        }}


}
