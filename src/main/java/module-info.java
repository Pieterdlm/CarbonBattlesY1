module com.example.carbonbattles {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.carbonbattles to javafx.fxml;
    exports com.example.carbonbattles;
}