package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;

public class Controller2 {
    @FXML
    private Label slideVal;
    @FXML
    private Label offsetVal;
    @FXML
    private Slider slider;
    @FXML
    private Slider offsetSlider;

//    @FXML
//    public void onSliderChanged() {
//        int sliderValue = (int) slider.getValue();
//        System.out.println(sliderValue + " ");
//        slideVal.setText(slider.getValue()+" ");
//    }

    @FXML
    public void handleStartButton(javafx.event.ActionEvent actionEvent) {
        System.out.println("werkt");

    }

    public void onSliderChanged(MouseEvent mouseEvent) {
        int sliderValue = (int) slider.getValue();
        slideVal.setText(sliderValue+" ");
    }

    public void onOffsetChanged(MouseEvent mouseEvent) {
        int sliderValue = (int) offsetSlider.getValue();
        offsetVal.setText(sliderValue+" ");
    }
}
