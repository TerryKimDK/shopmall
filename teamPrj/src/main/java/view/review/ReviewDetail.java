package view.review;

import controller.ReviewController;
import model.ReviewDTO;
import model.StoreDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewDetail extends JFrame {
    private JTextField title;
    private JTextField storeName;
    private JTextArea content;
    private JButton modify;
    private JButton delete;
    private JButton back;
    private JLabel id;
    private JLabel register;
    private JPanel panel;

    ReviewController reviewController = ReviewController.getInstance();

    public ReviewDetail(ReviewDTO review, StoreDTO store) {
        super("Review Detail");
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        title.setText(review.getTitle());
        content.setText(review.getContent());
        storeName.setText(store.getName());
        id.setText(review.getId());
        register.setText(review.getRegister().toString());

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
