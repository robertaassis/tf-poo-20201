import Lib.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button novo, excluir, emprestar, devolver;
    ObservableList<Item> dados;
    ObservableList<String> tipos = FXCollections.observableArrayList("Livro", "Revista", "Jornal");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Biblioteca");

        dados = FXCollections.observableArrayList(
                new Livro("abc", 0, Status.DISPONIVEL),
                new Jornal("efg", 1, Status.EMPRESTADO),
                new Revista("mno", 2, Status.RESERVADO)
        );

        TableView inventario = createTable(dados);
        createButtons();

        novo.setOnAction(actionEvent -> {
            showNewItemWindow(stage);
        });

        BorderPane border = new BorderPane();
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.prefWidthProperty().bind(stage.widthProperty().multiply(0.15f));
        vBox.setStyle("-fx-background-color: #3D3D3D");
        vBox.getChildren().addAll(novo, excluir, emprestar, devolver);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(inventario);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        border.setCenter(scrollPane);
        border.setRight(vBox);

        Scene cena = new Scene(border, 1000, 800);
        cena.getStylesheets().add("GUI/stylesheet.css");

        stage.setScene(cena);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    private TableView createTable(ObservableList<Item> dados) {
        TableView table = new TableView();
        TableColumn col_id = new TableColumn("ID");
        col_id.setCellValueFactory(new PropertyValueFactory<Item, String>("id"));
        TableColumn col_nome = new TableColumn("Nome");
        col_nome.setCellValueFactory(new PropertyValueFactory<Item, String>("nome"));
        TableColumn col_tipo = new TableColumn("Tipo");
        col_tipo.setCellValueFactory(new PropertyValueFactory<Item, String>("tipo"));
        TableColumn col_disp = new TableColumn("Disponibilidade");
        col_disp.setCellValueFactory(new PropertyValueFactory<Item, String>("disponibilidade"));

        table.setItems(dados);
        table.getColumns().addAll(col_id, col_nome, col_tipo, col_disp);
        return table;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }

    private void createButtons() {
        novo = new Button();
        novo.setText("Novo");
        novo.setMaxWidth(Double.MAX_VALUE);
        excluir = new Button();
        excluir.setText("Excluir");
        excluir.setMaxWidth(Double.MAX_VALUE);
        emprestar = new Button();
        emprestar.setText("Emprestar");
        emprestar.setMaxWidth(Double.MAX_VALUE);
        devolver = new Button();
        devolver.setText("Devolver");
        devolver.setMaxWidth(Double.MAX_VALUE);
    }

    private void showNewItemWindow(Stage stage) {
        Stage newItemWindow = new Stage();

        GridPane topGrid = new GridPane();
        topGrid.setHgap(4);
        topGrid.setVgap(3);
        topGrid.setAlignment(Pos.CENTER);
        topGrid.setPadding(new Insets(10, 10,10,10));

        Text txtNome = new Text("Nome");
        topGrid.add(txtNome, 0, 0);
        TextField tfNome = new TextField();
        topGrid.add(tfNome, 0, 1, 1, 1);

        Text txtTipo = new Text("Tipo");
        txtTipo.maxWidth(Double.MAX_VALUE);
        topGrid.add(txtTipo, 2,0);
        ComboBox cbTipo = new ComboBox(tipos);
        cbTipo.setValue(tipos.get(0));
        topGrid.add(cbTipo, 2, 1);

        //Livro
        GridPane livroGrid = new GridPane();
        livroGrid.setVgap(6);
        livroGrid.setHgap(6);
        livroGrid.setAlignment(Pos.CENTER);
        livroGrid.setPadding(new Insets(10,10,10,10));
        Text txtIsbn = new Text("ISBN");
        livroGrid.add(txtIsbn, 0, 1);
        TextField tfIsbn = new TextField();
        livroGrid.add(tfIsbn, 1, 1);

        Text txtAutor = new Text("Autor");
        livroGrid.add(txtAutor, 0, 2);
        TextField tfAutor = new TextField();
        livroGrid.add(tfAutor, 1, 2);

        Text txtEditoraLivro = new Text("Editora");
        livroGrid.add(txtEditoraLivro, 0, 3);
        TextField tfEditoraLivro = new TextField();
        livroGrid.add(tfEditoraLivro, 1, 3);

        //Revista
        GridPane revistaGrid = new GridPane();
        revistaGrid.setVgap(6);
        revistaGrid.setHgap(6);
        revistaGrid.setPadding(new Insets(10,10,10,10));
        Text txtDataRevista = new Text("Data");
        revistaGrid.add(txtDataRevista, 0, 1);
        DatePicker dpDataRevista = new DatePicker();
        revistaGrid.add(dpDataRevista, 1, 1);

        Text txtEdicao = new Text("Edição");
        revistaGrid.add(txtEdicao, 0, 2);
        TextField tfEdicao = new TextField();
        tfEdicao.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(!t1.matches("\\d*")) {
                    tfEdicao.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
        revistaGrid.add(tfEdicao, 1, 2);

        Text txtEditoraRevista = new Text("Editora");
        revistaGrid.add(txtEditoraRevista, 0, 3);
        TextField tfEditoraRevista = new TextField();
        revistaGrid.add(tfEditoraRevista, 1, 3);

        // Jornal
        GridPane jornalGrid = new GridPane();
        jornalGrid.setVgap(6);
        jornalGrid.setHgap(6);
        jornalGrid.setPadding(new Insets(10,10,10,10));
        Text txtDataJornal = new Text("Data");
        jornalGrid.add(txtDataJornal, 0, 1);
        DatePicker dpDataJornal = new DatePicker();
        jornalGrid.add(dpDataJornal, 1, 1);

        Text txtNumero = new Text("Número");
        jornalGrid.add(txtNumero, 0, 2);
        TextField tfNumero = new TextField();
        tfNumero.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(!t1.matches("\\d*")) {
                    tfNumero.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
        jornalGrid.add(tfNumero, 1, 2);

        Text txtDiretor = new Text("Diretor");
        jornalGrid.add(txtDiretor, 0, 3);
        TextField tfDiretor = new TextField();
        jornalGrid.add(tfDiretor, 1, 3);

        Button btnCriar = new Button("Criar");
        btnCriar.setMaxWidth(Double.MAX_VALUE);
        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setMaxWidth(Double.MAX_VALUE);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnCancelar, btnCriar);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.setHgrow(btnCriar, Priority.ALWAYS);
        hBox.setHgrow(btnCancelar, Priority.ALWAYS);

        VBox vBox = new VBox();
        vBox.setMaxHeight(Double.MAX_VALUE);
        vBox.getChildren().add(topGrid);
        vBox.getChildren().add(livroGrid);
        vBox.getChildren().add(hBox);

        btnCancelar.setOnAction(actionEvent -> {
            newItemWindow.close();
        });

        cbTipo.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (t1 == tipos.get(0)) {
                    vBox.getChildren().remove(1);
                    vBox.getChildren().add(1, livroGrid);
                } else if (t1 == tipos.get(1)) {
                    vBox.getChildren().remove(1);
                    vBox.getChildren().add(1, revistaGrid);
                } else {
                    vBox.getChildren().remove(1);
                    vBox.getChildren().add(1, jornalGrid);
                }
            }
        });

        Scene cena = new Scene(vBox);
        newItemWindow.setScene(cena);
        newItemWindow.setTitle("Novo Item");
        newItemWindow.initModality(Modality.WINDOW_MODAL);
        newItemWindow.initOwner(stage);
        newItemWindow.setResizable(false);
        newItemWindow.centerOnScreen();
        newItemWindow.show();
    }

}
