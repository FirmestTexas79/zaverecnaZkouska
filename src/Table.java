import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Table extends JTable {
    private ArrayList<ItemRow> list = new ArrayList<>();


    public Table() {
        init();
    }

    private void init() {
        // Inicializace tabulky
        String[] columnNames = {"Index"};
        Object[][] data = new Object[0][columnNames.length];
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        setModel(model);
    }

    private void updateModel() {
        // Aktualizace modelu tabulky
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(0);

        for (ItemRow item : list) {
            Object[] rowData = new Object[5];
            rowData[0] = list.indexOf(item) + 1;
            model.addRow(rowData);
        }
    }
}
