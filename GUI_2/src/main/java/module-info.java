module com.example.gui_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui_2 to javafx.fxml;
    exports com.example.gui_2;
}