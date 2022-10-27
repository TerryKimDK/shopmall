package naver;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

public class example {
    public static void main(String[] args) {

        System.setProperty("jxbrowser.license.key", "1BNDHFSC1G49S3HTBQ1QD2BBIDDX0CE9YQVWSEOQQW469OA39QJ6ARACCO25ZCWS7JP9UY");

        // Initialize Chromium.
        Engine engine = Engine.newInstance(
                EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("1BNDHFSC1G49S3HTBQ1QD2BBIDDX0CE9YQVWSEOQQW469OA39QJ6ARACCO25ZCWS7JP9UY")
                .build());

        // Create a Browser instance.
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JxBrowser AWT/Swing");
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Shutdown Chromium and release allocated resources.
                    engine.close();
                }
            });
            // Create and embed Swing BrowserView component to display web content.
            frame.add(BrowserView.newInstance(browser));
            frame.setSize(1280, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Load the required web page.
            browser.navigation().loadUrl("https://html5test.com/");
        });
    }
}
