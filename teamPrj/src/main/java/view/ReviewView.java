package view;

import controller.MemberController;
import lombok.Data;
import model.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.swing.*;

@Data
public class ReviewView extends JFrame {

    private JTable table1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPanel panel;

    public ReviewView() {
        super("Review");
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
