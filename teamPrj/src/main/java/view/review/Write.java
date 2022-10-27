package view.review;

import controller.ReviewController;
import model.ReviewDTO;
import model.StoreDTO;
import view.member.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Write extends JFrame {
    private JTextField title;
    private JTextField storeName;
    private JTextField id;
    private JTextArea content;
    private JButton save;
    private JButton back;
    private JPanel panel;
    private ReviewController reviewController = ReviewController.getInstance();
    private ReviewDTO review = new ReviewDTO();

    public Write(StoreDTO store) {
        super("Review Write");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

//        review.setStore_id(store.getStore_id());
        review.setStore_id(1);
//        storeName.setText(store.getName());
        storeName.setText("개미집");
        id.setText(Login.getSessionID());
        review.setId(Login.getSessionID());

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                review.setTitle(title.getText());
                review.setContent(content.getText());

                int result = reviewController.write(review);
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "리뷰작성 성공");
                    dispose();
                    reviewController.reviewList();
                } else {
                    JOptionPane.showMessageDialog(null, "리뷰작성 실패");
                    dispose();
                    reviewController.Write(review.getStore_id());
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
//                reviewController.reviewList(store.getStore_id());
                reviewController.reviewList();
            }
        });
    }

}
