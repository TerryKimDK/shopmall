package view;

import controller.MemberController;
import model.MemberDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JFrame {
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel joinPanel;
    private JLabel joinLabel;
    private JTextField goJoinTextField;
    private MemberController memberController = MemberController.getInstance();

    public LoginView() {
        super("Login");
        goJoinTextField.setFont(new Font("Serif", Font.BOLD, 11));
        goJoinTextField.setForeground(Color.blue);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(e -> {
            MemberDTO member = new MemberDTO();
            member.setId(textField.getText());
            member.setPassword(new String(passwordField.getPassword()));

            int count = memberController.login(member);
            if (count == 1) {
                JOptionPane.showMessageDialog(null, "로그인 성공");
                dispose();
                memberController.mainView();
            } else
                JOptionPane.showMessageDialog(null, "로그인 실패");

        });

        goJoinTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                memberController.joinView();
            }
        });
    }

}
