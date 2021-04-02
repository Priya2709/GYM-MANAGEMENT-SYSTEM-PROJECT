package FaceRecognition.View.Controls.Events;

import FaceRecognition.View.Controls.FaceControlView;

import java.io.File;

public interface IOnRecognizeEventListener {
  void onRecognize(FaceControlView sender, File personImageFile);
}
