package view;

import controller.MemberController;
import controller.ReviewController;
import controller.SearchController;
import controller.StoreController;
import model.StoreDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Main extends JFrame {
    private JPanel panel1;
    private JToolBar toolbar;
    private JButton search;
    private JButton logout;
    private JComboBox comboBox1;
    private JTextField searchText;
    private ImageIcon image1;
    private MemberController memberController = MemberController.getInstance();
    private ReviewController reviewController = ReviewController.getInstance();
    private StoreController storeController = StoreController.getInstance();
    private SearchController searchController = SearchController.getInstance();

    public Main() {
        super("Main");
        createMenu();
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        searchText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchText.getText().equals("주소를 검색해주세요")) {
                    searchText.setText("");
                    searchText.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchText.getText().isEmpty()) {
                    searchText.setForeground(Color.gray);
                    searchText.setText("주소를 검색해주세요");
                }
            }
        });


        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreDTO storeDTO = new StoreDTO();
                String veganCategory =comboBox1.getSelectedItem().toString(); // 비건유형
                String searchBox = searchText.getText();
                storeDTO.setVegan(veganCategory);
                System.out.println(veganCategory);
                System.out.println(searchBox);
                if(veganCategory != "해당 없음"){
                    if (searchBox.equals("주소를 검색해주세요")){
                        searchController.veganSearch(storeDTO);

                    }
                }
            }
        });
    }

    void createMenu() {
        searchText.setForeground(Color.GRAY);

        JMenuBar menuBar = new JMenuBar();
        //JMenuItem [] menuItem = new JMenuItem[5];
        JMenu screenMenu1 = new JMenu("식당 찾기(리뷰테스트)");
        JMenu screenMenu2 = new JMenu("식당 등록(테스트)");
        JMenu screenMenu3 = new JMenu("내 정보");
        JMenu screenMenu4 = new JMenu("로그아웃");
        JMenu screenMenu5 = new JMenu("종료");

        screenMenu1.add("식당 찾기").addActionListener(new MenuActionListener());
        screenMenu2.add("식당등록").addActionListener(new MenuActionListener());
        screenMenu3.add("내 정보").addActionListener(new MenuActionListener());
        screenMenu4.add("로그아웃").addActionListener(new MenuActionListener());
        screenMenu5.add("종료").addActionListener(new MenuActionListener());

        setJMenuBar(menuBar);
        menuBar.add(screenMenu1);
        menuBar.add(screenMenu2);
        menuBar.add(screenMenu3);
        menuBar.add(screenMenu4);
        menuBar.add(screenMenu5);

    }

    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd) {
                case "식당 찾기":

                    dispose();
//                    reviewController.reviewList(store_id);
                    reviewController.reviewList();
                    break;
                case "식당등록":
                    dispose();
                    storeController.Create();
                    break;
                case "내 정보":
                    dispose();
                    memberController.updateView();
                    break;
                case "로그아웃":
                    JOptionPane.showMessageDialog(null, "로그아웃하셨습니다.");
                    dispose();
                    memberController.loginView();
                    break;
                case "종료":
                    JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
                    dispose();
                    break;
            }
        }
    }

}