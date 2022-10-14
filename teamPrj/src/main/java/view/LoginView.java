package view;

import controller.MemberController;
import controller.ReviewController;
import model.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton joinButton;
    private static ApplicationContext context = new FileSystemXmlApplicationContext("src/main/BeanConfig.xml");
    private static MemberController memberController = context.getBean("MemberController", MemberController.class);
    private static ReviewController reviewController = context.getBean("ReviewController", ReviewController.class);

    public LoginView() {
        super("Login");
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loginButton.addActionListener(e -> {
            MemberDTO input = new MemberDTO();
            input.setId(textField.getText());
            input.setPassword(new String(passwordField.getPassword()));

            System.out.println(input.getId() + " " + input.getPassword());

            memberController.idCheck(input);
        });

        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
