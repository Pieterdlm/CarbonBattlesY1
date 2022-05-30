module com.example.carbonbattles {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.carbonbattles to javafx.fxml;
    exports com.example.carbonbattles;
    exports com.example.carbonbattles.Models;
    opens com.example.carbonbattles.Models to javafx.fxml;
    exports com.example.carbonbattles.Models.Achievements;
    opens com.example.carbonbattles.Models.Achievements to javafx.fxml;
}