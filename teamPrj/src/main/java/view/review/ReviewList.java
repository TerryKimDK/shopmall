package view.review;

import controller.ReviewController;
import model.ReviewDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReviewList extends JFrame {

    private JTable table;
    private JComboBox comboBox;
    private JTextField textField;
    private JPanel panel;
    private JButton write;
    private JButton search;
    private ReviewController reviewController = ReviewController.getInstance();

    public ReviewList(java.util.List<ReviewDTO> list) {
        super("Review");
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        String[] columns = {"Review ID", "Store ID", "ID", "Title", "Content"};
        Object[][] rows = new Object[list.size()][columns.length];

        for (int i = 0; i < list.size(); i++) {
            rows[i] = new Object[]{
                    list.get(i).getReview_id(),
                    list.get(i).getStore_id(),
                    list.get(i).getId(),
                    list.get(i).getTitle(),
                    list.get(i).getContent()
            };
        }

        table.setModel(new DefaultTableModel(rows, columns) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        });

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                if (col == 0) {
                    int review_id = (Integer) table.getValueAt(row, col);

                    dispose();
                    reviewController.reviewDetail(review_id);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                reviewController.Write(1);
            }
        });
    }

}
