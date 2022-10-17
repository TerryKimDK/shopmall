package view;

import controller.MemberController;
import model.MemberDTO;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JoinView extends JFrame {

    private JPanel joinPanel;
    private JButton idCheck;
    private JTextField nameText;
    private JComboBox veganBox;
    private JButton veganCheck;
    private JComboBox telBox;
    private JTextField contactText2;
    private JTextField contactText1;
    private JTextField emailText;
    private JComboBox emailBox;
    private JTextField idText;
    private JButton back;
    private JButton join;
    private JTextField zipcodeText;
    private JPasswordField passwordText;
    private JPasswordField passwordCheck;
    private MemberController memberController = MemberController.getInstance();

    public JoinView() {
        super("Join");
        setContentPane(joinPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        join.addActionListener(e -> {
            MemberDTO input = new MemberDTO();
            input.setId(idText.getText());
            input.setPassword(new String(passwordText.getPassword()));
            input.setName(nameText.getText());
            input.setEmail(emailText.getText() + '@' + emailBox.getSelectedItem());
            input.setContact(telBox.getSelectedItem() + contactText2.getText() + contactText1.getText());
            input.setAddress(zipcodeText.getText());
            input.setVegan((String) veganBox.getSelectedItem());

            int result = memberController.join(input);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "회원가입 성공");
                dispose();
                memberController.loginView();
            } else {
                JOptionPane.showMessageDialog(null, "회원가입 실패");
                dispose();
                memberController.joinView();
            }
        });

        contactText2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.getSource();
                int textLen = contactText2.getText().length();
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
                    contactText2.setText("");
                    e.consume();
                }
            }
        });

        contactText1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.getSource();
                int textLen = contactText2.getText().length();
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
                    contactText2.setText("");
                    e.consume();
                }
            }
        });

        idCheck.addActionListener(e -> {
            MemberDTO member = new MemberDTO();
            member.setId(idText.getText());

            int result = memberController.idCheck(member);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
                idText.setText("");
            } else
                JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
        });

        back.addActionListener(e -> {
            dispose();
            memberController.loginView();
        });

        passwordCheck.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println(e);
            }

            public void focusLost(FocusEvent e) {
                if (!new String(passwordText.getPassword()).equals(new String(passwordCheck.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "비밀번호와 확인 비밀번호가 일치하지 않습니다.");
                    passwordText.setText("");
                    passwordCheck.setText("");
                }
            }
        });
    }

}
