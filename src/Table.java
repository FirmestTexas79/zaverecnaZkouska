import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Table extends JTable {
    private ArrayList<CustomerInfo> customerInfos = new ArrayList<>();


    public Table() {
        init();
    }

    public void loadData() {
        // Přečtěte a sloučí soubor people.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("src/people.txt"))) {
            String line;
            boolean isFirstLine = true; // vynechání řádku záhlaví
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // vynechání řádku záhlaví
                }
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String firstName = parts[1];
                String lastName = parts[2];
                customerInfos.add(new CustomerInfo(id, firstName, lastName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Přečtěte a sloučí soubor tshirts.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("src/tshirts.txt"))) {
            String line;
            boolean isFirstLine = true; // vynechání řádku záhlaví
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // vynechání řádku záhlaví
                }
                String[] parts = line.split(";");
                String size = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                int customerId = Integer.parseInt(parts[3]);

                // Vyhledání zákazníka v seznamu customerInfos na základě ID zákazníka
                for (CustomerInfo customer : customerInfos) {
                    if (customer.getId() == customerId) {
                        customer.setSize(size);
                        customer.setQuantity(quantity);
                        customer.setTotalPrice(price * quantity);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        updateModel();
    }

    private void init() {
        // Inicializace tabulky
        String[] columnNames = {"ID","Firstname","Surname","Size","Quantity", "Price"};
        Object[][] data = new Object[0][columnNames.length];
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        setModel(model);
    }

    private void updateModel() {
        // Aktualizace modelu tabulky
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(0);

        for (CustomerInfo item : customerInfos) {
            Object[] rowData = new Object[6];
            rowData[0] = item.getId();
            rowData[1] = item.getFirstname();
            rowData[2] = item.getSurname();
            rowData[3] = item.getSize();
            rowData[4] = item.getQuantity();
            rowData[5] = item.getTotalPrice();
            model.addRow(rowData);
        }
    }
}
