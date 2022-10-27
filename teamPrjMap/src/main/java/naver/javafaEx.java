//package naver;
//
//import com.teamdev.jxbrowser.browser.Browser;
//import com.teamdev.jxbrowser.engine.Engine;
//import com.teamdev.jxbrowser.view.swing.BrowserView;
//
//import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
//
//public class javafaEx {
//    public static void main(String[] args) {
//        // Initialize Chromium.
//        Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);
//
//// Create a Browser instance.
//        Browser browser = engine.newBrowser();
//
//// Load the required web page.
//        browser.navigation().loadUrl("https://html5test.com");
//
//// Create and embed JavaFX BrowserView component to display web content.
//        BrowserView view = BrowserView.newInstance(browser);
//
//        Scene scene = new Scene(new BorderPane(view), 1280, 800);
//        primaryStage.setTitle("JxBrowser JavaFX");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//// Shutdown Chromium and release allocated resources.
//        primaryStage.setOnCloseRequest(event -> engine.close());
//    }
//}
