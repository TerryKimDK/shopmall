package view;

import controller.MemberController;
import controller.ReviewController;

import javax.swing.*;

public class MainView extends JFrame {
    private JPanel panel;
    private JToolBar toolbar;
    private JButton map;
    private JButton logout;
    private JComboBox comboBox;
    private JTextField textField;
    private MemberController memberController = MemberController.getInstance();
    private ReviewController reviewController = ReviewController.getInstance();

    public MainView() {
        super("Main");
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

