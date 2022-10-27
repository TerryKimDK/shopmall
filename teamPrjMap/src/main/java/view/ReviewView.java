package view;

import model.ReviewDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ReviewView extends JFrame {

    private JTable table;
    private JComboBox comboBox;
    private JTextField textField;
    private JPanel panel;

    public ReviewView(List<ReviewDTO> list) {
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
            boolean[] editable = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isEditable(int row, int column) {
                return editable[column];
            }
        });

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(45);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(164);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(4).setPreferredWidth(140);
    }

}
