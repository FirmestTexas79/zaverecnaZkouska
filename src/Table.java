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
        // Read and merge the people.txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/people.txt"))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the header line
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
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

        // Read and merge the tshirts.txt file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/tshirts.txt"))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the header line
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                String[] parts = line.split(";");
                String size = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                int customerId = Integer.parseInt(parts[3]);

                // Find the customer in the customerInfos list based on customer ID
                for (CustomerInfo customer : customerInfos) {
                    if (customer.getId() == customerId) {
                        customer.setQuantity(quantity);
                        customer.setTotalPrice(price * quantity);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CustomerInfo customer: customerInfos) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("First Name: " + customer.getFirstName());
            System.out.println("Last Name: " + customer.getSurName());
            System.out.println("Quantity: " + customer.getQuantity());
            System.out.println("Total Price: " + customer.getTotalPrice());
            System.out.println();
        }
    }

    private void init() {
        // Inicializace tabulky
        String[] columnNames = {"Index","Firstname","Surname","Quantity", "Price"};
        Object[][] data = new Object[0][columnNames.length];
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        setModel(model);
    }

    private void updateModel() {
        // Aktualizace modelu tabulky
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(0);

        for (CustomerInfo item : customerInfos) {
            Object[] rowData = new Object[5];
            rowData[0] = customerInfos.indexOf(item) + 1;
            rowData[1] = item.getFirstName();
            rowData[2] = item.getSurName();
            rowData[3] = item.getQuantity();
            rowData[4] = item.getTotalPrice();
            model.addRow(rowData);
        }
    }
}
