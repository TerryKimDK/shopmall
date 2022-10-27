package view.search;

import controller.ReviewController;
import controller.SearchController;
import model.StoreDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class SearchList extends JFrame {

    private JTable table;
    private JComboBox vegan;
    private JTextField searchText;
    private JPanel panel;
    private JButton searchButton;
    private ReviewController reviewController = ReviewController.getInstance();
    private SearchController searchController = SearchController.getInstance();

    public SearchList(java.util.List<StoreDTO> list) {
        super("Search");
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        String[] columns = {"Name", "Vegan", "Category", "Address", "Open", "Close", "Capacity"};
        Object[][] rows = new Object[list.size()][columns.length];

        for (int i = 0; i < list.size(); i++) {
            rows[i] = new Object[]{
                    list.get(i).getName(),
                    list.get(i).getVegan(),
                    list.get(i).getCategory(),
                    list.get(i).getAddress(),
                    list.get(i).getOpen(),
                    list.get(i).getClose(),
                    list.get(i).getCategory(),
                    list.get(i).getCapacity()
            };
        }

//        table.setModel(new DefaultTableModel(rows, columns) {
//            public boolean isCellEditable(int r, int c) {
//                return false;
//            }
//        });
//
//        table.getTableHeader().setReorderingAllowed(false);
//        table.getTableHeader().setResizingAllowed(false);
//
//        table.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int row = table.getSelectedRow();
//                int col = table.getSelectedColumn();
//                if (col == 0) {
//                    int review_id = (Integer) table.getValueAt(row, col);
//
//                    dispose();
//                    reviewController.reviewDetail(review_id);
//                }
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

//        write.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
////                reviewController.Write(1);
//            }
//        });
//        // 검색
//        searchButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                searchText.getText();
//            }
//        });
//        vegan.addActionListener(new ActionListener() { //비건유형
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String veganC;
//                veganC = vegan.getAction().toString();
//                System.out.println(veganC);
//            }
//        });

//        if(){
//
//        }

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
    }

}
