package nl.inholland.ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import nl.inholland.model.Person;

public class Teachers {
    Stage window;

    public Teachers(Person user) {
        window = new Stage();

        // Set Window properties
        window.setHeight(800);
        window.setWidth(1024);
        window.setTitle("Dashboard");

        // Set container
        BorderPane container = new BorderPane();

        // Create components
        Label welcomeLabel = new Label(String.format("Welcome %s", user.firstName));
        MenuBar menuBar = new MenuBar();
        Menu dashboardMenu = new Menu("Dashboard");
        Menu studentsMenu = new Menu("Students");
        Menu teachersMenu = new Menu("Teachers");

        // Add attributes
        welcomeLabel.setFont(new Font(50));
        onAction(dashboardMenu);
        onAction(studentsMenu);
        onAction(teachersMenu);

        // When button is clicked
        dashboardMenu.setOnAction(actionEvent -> {
            new Teachers(user);
            window.close();
        });

        studentsMenu.setOnAction(actionEvent -> {
            new Students(user);
            window.close();
        });

        teachersMenu.setOnAction(actionEvent -> {
            new Teachers(user);
            window.close();
        });

        // Add components to its container
        menuBar.getMenus().addAll(dashboardMenu, studentsMenu, teachersMenu);
        container.setTop(menuBar);
        container.setCenter(welcomeLabel);

        // Set scene
        window.setScene(new Scene(container));

        // Show window
        window.show();
    }

    public static void onAction(Menu menu)
    {
        final MenuItem menuItem = new MenuItem();

        menu.getItems().add(menuItem);
        menu.addEventHandler(Menu.ON_SHOWN, event -> menu.hide());
        menu.addEventHandler(Menu.ON_SHOWING, event -> menu.fire());
    }
}
