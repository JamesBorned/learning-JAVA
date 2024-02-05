module com.todo_list.todo_list {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.todo_list.todo_list to javafx.fxml;
    exports com.todo_list.todo_list;
    exports com.todo_list.todo_list.controller;
    opens com.todo_list.todo_list.controller to javafx.fxml;
}