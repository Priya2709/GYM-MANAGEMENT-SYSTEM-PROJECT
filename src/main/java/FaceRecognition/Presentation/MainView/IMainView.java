package FaceRecognition.Presentation.MainView;

import FaceRecognition.Presentation.IView;
import FaceRecognition.View.Controls.FaceControlView;

public interface IMainView extends IView<IMainViewPresenter> {
  void addFaceControlView(FaceControlView faceControlView);
  void clearFaces();
}
