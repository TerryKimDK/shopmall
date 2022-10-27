package view;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.navigation.internal.rpc.ReloadRequest;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import service.SessionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

public class MapDemo extends JFrame {

    private JPanel panelMain;
    private JTextField searchBox;
    private JButton searchBtn;
    private JPanel map_panel;

    Engine engine = Engine.newInstance(
            EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                    .licenseKey("1BNDHFSC1G49S3HTBQ1QD2BBIDDX0CE9YQVWSEOQQW469OA39QJ6ARACCO25ZCWS7JP9UY")
                    .build());
    Browser browser;
    SessionFactory factory;
    // Initialize Chromium.
    public MapDemo() {

        System.setProperty("jxbrowser.license.key", "1BNDHFSC1G49S3HTBQ1QD2BBIDDX0CE9YQVWSEOQQW469OA39QJ6ARACCO25ZCWS7JP9UY");
        browser = engine.newBrowser();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        SwingUtilities.invokeLater(() -> {
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Shutdown Chromium and release allocated resources.
                    engine.close();
                }
            });

        });
//        map_panel.setSize(300, 400);
        map_panel.add(BrowserView.newInstance(browser), BorderLayout.CENTER);

        browser.navigation().loadUrl("D:///shopmall/teamPrjMap/src/main/java/style/geomap.html");
        setContentPane(panelMain);
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBox.getText();
                System.out.println(searchBox.getText());
            }
        });
    }

    public static void main(String[] args) {
        new MapDemo();
    }
}




