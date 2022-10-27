package view;

import controller.MemberController;
import controller.ReviewController;

import javax.swing.*;

public class MainView extends JFrame {
    private GoogleAPI googleAPI = new GoogleAPI();
    private String location = "이대역";
    private JLabel googleMap;
    private JPanel panel;
    private JToolBar toolbar;
    private JButton map;
    private JButton logout;
    private JComboBox comboBox;
    private JTextField textField;
    private JPanel mapPanel;
    private MemberController memberController = MemberController.getInstance();
    private ReviewController reviewController = ReviewController.getInstance();

    public MainView() {
        super("Main");
        googleAPI.downloadMap(location);
        googleMap = new JLabel(googleAPI.getMap(location));

        googleAPI.fileDelete(location);

        add(googleMap);
//        googleAPI.downloadMap(location);
//
//        googleAPI.fileDelete(location);
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        logout.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "로그아웃");
            dispose();
            memberController.loginView();
        });

        map.addActionListener(e -> {
            reviewController.reviewView();
            dispose();
        });
    }

}

