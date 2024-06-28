module com.oop.mahadi.demoshoping {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.mahadi.demoshoping to javafx.fxml;
    exports com.oop.mahadi.demoshoping;
}