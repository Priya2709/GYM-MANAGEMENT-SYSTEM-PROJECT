package FaceRecognition.View;

import FaceRecognition.Presentation.IApplicationController;
import FaceRecognition.Presentation.MainView.IMainViewPresenter;
import FaceRecognition.Presentation.MainView.MainViewPresenter;
import FaceRecognition.View.Controls.FaceControlView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationController implements IApplicationController {
  private Stage _mainStage;

  public ApplicationController(Stage mainStage){
    _mainStage = mainStage;
  }

  @Override
  public File showChooseImageView() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Image File");
    fileChooser.setInitialDirectory(new File("C:\\Users\\Vancho\\Desktop\\Test"));
    File chosenFile = fileChooser.showOpenDialog(_mainStage);
    return chosenFile;
  }

  @Override
  public void showMainView() {
    MainView mainView = new MainView(_mainStage);
    IMainViewPresenter mainViewPresenter = new MainViewPresenter(mainView,this);

    mainView.show();
  }
}
