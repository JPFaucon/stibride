/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.view;

import g58990.stibride.dto.RidesDto;
import g58990.stibride.dto.StationsDto;
import g58990.stibride.presenter.Presenter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.controlsfx.control.SearchableComboBox;

/**
 *
 * @author jp
 */
public class MainViewController implements Initializable {
    private final ObservableList<StationsDto> datas = FXCollections.observableArrayList();

    private final Presenter presenter;
    @FXML
    private TableView table;
    @FXML
    private SearchableComboBox<StationsDto> origine;
    @FXML
    private SearchableComboBox<StationsDto> destination;
    @FXML
    private TableColumn<StationsDto, String> stationsCol;
    @FXML
    private TableColumn<StationsDto, List<Integer>> linesCol;
    @FXML
    private Label nbStations;
    @FXML
    private Label recherche;
    @FXML
    private TextField nameNF;
    @FXML
    private TextField nameMF;
    @FXML
    private SearchableComboBox<StationsDto> origineNF;
    @FXML
    private SearchableComboBox<StationsDto> origineMF;
    @FXML
    private SearchableComboBox<StationsDto> destinationNF;
    @FXML
    private SearchableComboBox<StationsDto> destinationMF;
    @FXML
    private SearchableComboBox<RidesDto> favoris;
    @FXML
    private SearchableComboBox<RidesDto> favorisMF;
    
    public MainViewController(Presenter presenter) {
        this.presenter = presenter;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<StationsDto> stations = presenter.getStations();
        origine.getItems().addAll(stations);
        origineNF.getItems().addAll(stations);
        origineMF.getItems().addAll(stations);
        
        destination.getItems().addAll(stations);
        destinationNF.getItems().addAll(stations);
        destinationMF.getItems().addAll(stations);
        
        List<RidesDto> favorisList = presenter.getFavoris();
        favoris.getItems().addAll(favorisList);
        favorisMF.getItems().addAll(favorisList);
        
        stationsCol.setCellValueFactory(
            data -> new SimpleStringProperty(data.getValue().getName())
        );
        linesCol.setCellValueFactory(
            data -> new ReadOnlyObjectWrapper<List<Integer>>(data.getValue().getLines())
        );
        table.setItems(datas);
        recherche.setVisible(false);
    }
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
        recherche.setVisible(false);
        presenter.shortestPath(origine.getValue(), destination.getValue());
    }
    
    @FXML
    public void addFav(ActionEvent event) {
        presenter.addFav(nameNF.getText(), origineNF.getValue(), destinationNF.getValue());
    }
    
    @FXML
    public void modifyFav(ActionEvent event) {
        presenter.modifyFav(favorisMF.getValue(), nameMF.getText(), origineMF.getValue(), destinationMF.getValue());
    }
    
    public void updateFav() {
        List<RidesDto> favorisList = presenter.getFavoris();
        favoris.getItems().clear();
        favorisMF.getItems().clear();
        favoris.getItems().addAll(favorisList);
        favorisMF.getItems().addAll(favorisList);
    }
    
    @FXML
    public void deleteFav() {
        presenter.deleteFav(favorisMF.getValue());
    }
    
    @FXML
    public void searchFav(ActionEvent event) {
        recherche.setVisible(false);
        presenter.shortestPathFav(favoris.getValue());
    }
    
    public void updateTable(List<StationsDto> stations) {
        table.getItems().clear();
        datas.clear();
        for (StationsDto station : stations) {
            datas.add(station);
        }
        nbStations.setText(String.valueOf(stations.size()));
        recherche.setVisible(true);
    }
}
