module com.example.jogodavelha {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.jogodavelha to javafx.fxml;
    exports com.example.jogodavelha;
}