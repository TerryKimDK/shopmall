package view.store;

import controller.MemberController;
import controller.StoreController;
import model.StoreDTO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create extends JFrame {
    private JButton create;
    private JButton back;
    private JTextField storeText;
    private JComboBox vegan;
    private JTextField telText;
    private JTextField address;
    private JComboBox open;
    private JComboBox close;
    private JButton imageButton;
    private JTextArea detail;
    private JLabel imageLabel;
    private JPanel storePanel;
    private JTextField lat;
    private JTextField lon;
    private JTextField capacity;
    private JComboBox category;

    private MemberController memberController = MemberController.getInstance();
    private StoreController storeController = StoreController.getInstance();

    private JFileChooser chooser;
    private StoreDTO store = new StoreDTO();

    public Create() {
        super("Store Create");
        chooser = new JFileChooser();
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images",
                        "jpg","gif");
                chooser.setFileFilter(filter);
                int ret = chooser.showOpenDialog(null);
                if(ret != JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(null,"파일 선택 X", "경고", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String filepath = chooser.getSelectedFile().getPath();
                imageLabel.setIcon(new ImageIcon(filepath));
            }
        });
        setContentPane(storePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store.setName(storeText.getText());
                store.setContact(telText.getText());
                store.setVegan((String) vegan.getSelectedItem());
                store.setAddress(address.getText());
                store.setLat(Float.valueOf(lat.getText()));store.setLon(Float.valueOf(lon.getText()));
                store.setDetail(detail.getText());
                store.setOpen((String) open.getSelectedItem());
                store.setClose((String) close.getSelectedItem());
                store.setImagePath(imageLabel.getIcon().toString());
                store.setCapacity(Integer.parseInt(capacity.getText()));
                store.setCategory((String) category.getSelectedItem());

                int result = storeController.create(store);
                if(result == 1){
                    JOptionPane.showMessageDialog(null,"식당등록 성공");
                }else{
                    JOptionPane.showMessageDialog(null,"식당등록 실패");
                }
                dispose();
                memberController.mainView();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                memberController.mainView();
            }
        });
    }
}
