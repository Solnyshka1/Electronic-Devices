module com.example.e {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.e to javafx.fxml;
    exports com.example.e;
}