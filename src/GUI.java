import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    static private JButton truckButton = new JButton("View Trucks");
    private JButton shipButton = new JButton("View Ships");
    private JButton airplaneButton = new JButton("View Airplanes");
    private JButton driverButton = new JButton("View Drivers");
    private JButton orderButton = new JButton("View Orders");
    JTable truckTable;
    JTable shipTable;
    JTable airplaneTable;
    JTable driverTable;
    JTable orderTable;

    public GUI() {

        frame.setLayout(new BorderLayout(10, 5));
        frame.setSize(1500, 900);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("LogisticsGUI");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.add(truckButton);
        panel.add(shipButton);
        panel.add(airplaneButton);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(driverButton);
        panel.add(orderButton);

        airplaneButton.setFocusable(false);
        airplaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel table=new JPanel();
                table.setBackground(Color.DARK_GRAY);
                airplaneTable=CreateVehicleTable(Main.Airplanes);
                JScrollPane jsp=new JScrollPane(airplaneTable);
                table.add(jsp);
                JFrame airplaneTableFrame=new JFrame("Airplanes");
                airplaneTableFrame.setLayout(new BorderLayout(10, 5));
                airplaneTableFrame.setSize(800, 500);
                airplaneTableFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                airplaneTableFrame.setLocationRelativeTo(null);
                airplaneTableFrame.setVisible(true);
                airplaneTableFrame.add(jsp);
            }
        });
        shipButton.setFocusable(false);
        shipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel table=new JPanel();
                table.setBackground(Color.DARK_GRAY);
                shipTable=CreateVehicleTable(Main.Ships);
                JScrollPane jsp=new JScrollPane(shipTable);
                table.add(jsp);
                JFrame shipTableFrame=new JFrame("Ships");
                shipTableFrame.setLayout(new BorderLayout(10, 5));
                shipTableFrame.setSize(800, 500);
                shipTableFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                shipTableFrame.setLocationRelativeTo(null);
                shipTableFrame.setVisible(true);
                shipTableFrame.add(jsp);
            }
        });
        truckButton.setFocusable(false);
        truckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel table=new JPanel();
                table.setBackground(Color.DARK_GRAY);
                truckTable=CreateVehicleTable(Main.Trucks);
                JScrollPane jsp=new JScrollPane(truckTable);
                table.add(jsp);
                JFrame truckTableFrame=new JFrame("Trucks");
                truckTableFrame.setLayout(new BorderLayout(10, 5));
                truckTableFrame.setSize(800, 500);
                truckTableFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                truckTableFrame.setLocationRelativeTo(null);
                truckTableFrame.setVisible(true);
                truckTableFrame.add(jsp);
            }
        });
        driverButton.setFocusable(false);
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel table=new JPanel();
                table.setBackground(Color.DARK_GRAY);
                driverTable=CreateDriverTable(Main.Drivers);
                JScrollPane jsp=new JScrollPane(driverTable);
                table.add(jsp);
                JFrame driverTableFrame=new JFrame("Drivers");
                driverTableFrame.setLayout(new BorderLayout(10, 5));
                driverTableFrame.setSize(800, 500);
                driverTableFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                driverTableFrame.setLocationRelativeTo(null);
                driverTableFrame.setVisible(true);
                driverTableFrame.add(jsp);
            }
        });
        orderButton.setFocusable(false);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel table=new JPanel();
                table.setBackground(Color.DARK_GRAY);
                orderTable=CreateOrderTable(Main.Orders);
                JScrollPane jsp=new JScrollPane(orderTable);
                table.add(jsp);
                JFrame orderTableFrame=new JFrame("Drivers");
                orderTableFrame.setLayout(new BorderLayout(10, 5));
                orderTableFrame.setSize(800, 500);
                orderTableFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                orderTableFrame.setLocationRelativeTo(null);
                orderTableFrame.setVisible(true);
                orderTableFrame.add(jsp);
            }
        });
    }
    public JTable CreateVehicleTable(ArrayList<VehicleClass> list)
    {
        JTable table;
        String[][] data=new String[list.size()][5];
        for(int i=0;i<list.size();i++)
        {
            data[i][0]=list.get(i).getID();
            data[i][1]=String.valueOf(list.get(i).getSpeed());
            data[i][2]=String.valueOf(list.get(i).getFuelConsumption());
            data[i][3]=String.valueOf(list.get(i).getRange());
            data[i][4]=String.valueOf(list.get(i).getWeightCapacity());
        }
        String[] col={"ID","Speed","Fuel Consumption","Range","Weight Capacity"};
        table=new JTable(data,col);
        return table;
    }

    public JTable CreateDriverTable(ArrayList<Driver> list)
    {
        JTable table;
        String[][] data=new String[list.size()][5];
        for(int i=0;i<list.size();i++)
        {
            data[i][0]=String.valueOf(list.get(i).getDriverID());
            data[i][1]=String.valueOf(list.get(i).getName());
            data[i][2]=String.valueOf(list.get(i).getPhoneNo());
            data[i][3]=String.valueOf(list.get(i).getEmail());
            data[i][4]=list.get(i).getAddress();
        }
        String[] col={"ID","Name","Phone No.","Email","Address"};
        table=new JTable(data,col);
        return table;
    }
    public JTable CreateOrderTable(ArrayList<Order> list)
    {
        JTable table;
        String[][] data=new String[list.size()][7];
        for(int i=0;i<list.size();i++)
        {
            data[i][0]=String.valueOf(list.get(i).getOrderID());
            data[i][1]=String.valueOf(list.get(i).getOrderDate());
            data[i][2]=String.valueOf(list.get(i).getQuantity());
            data[i][3]=String.valueOf(list.get(i).getProduct().getProductID());
            data[i][4]=String.valueOf(list.get(i).getCustomer().getCustomerID());
            data[i][5]=String.valueOf(list.get(i).getSupplier().supplierID);
            data[i][6]=String.valueOf(list.get(i).getWarehouse().getWarehouseID());
        }
        String[] col={"ID","Order Date","Quantity","Product ID","Customer ID","Supplier ID","Warehouse ID"};
        table=new JTable(data,col);
        return table;
    }
}
