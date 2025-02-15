package com.oop.mahadi.demoshoping;


import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShopingController {

    @FXML
    private ComboBox<String> productComboBoxfxid;

    @FXML
    private ComboBox<String> quantityfxid;

    @FXML
    private TextField showpricefxid;

    @FXML
    private TextField vatfxid;
    @FXML
    private TableView<democlass> tableviewfxid;

    @FXML
    private TableColumn<democlass, String> a;

    @FXML
    private TableColumn<democlass, String> b;

    @FXML
    private TableColumn<democlass, String> c;

    @FXML
    private TableColumn<democlass, String> d;

    @FXML
    private TableColumn<democlass, String> e;

    @FXML
    private TableColumn<democlass, String> f;

    @FXML
    void productcombowboxonaction(ActionEvent event) {
        String s= hs.get(productComboBoxfxid.getValue()).getPrice().toString();
        String s1= hs.get(productComboBoxfxid.getValue()).getVat().toString();
        showpricefxid.setText(s);
                vatfxid.setText(s1);

    }
    ArrayList<Cartitems> arr=new ArrayList<>();
HashMap<String,Cartitems> hs= new HashMap<>();
    @FXML
    void initialize() {
        load_from_BinFile(arr2,"b.bin");
//        this.product = product;
//        this.price = price;
//        this.quantity = quantity;
//        this.vat = vat;
//        this.vatamount = vatamount;
//        this.total = total;
        a.setCellValueFactory (new PropertyValueFactory<democlass,String>("Product"));
        b.setCellValueFactory (new PropertyValueFactory<democlass,String>("Price"));
        c.setCellValueFactory (new PropertyValueFactory<democlass,String>("Quantity"));
        d.setCellValueFactory (new PropertyValueFactory<democlass,String>("Vat"));
        e.setCellValueFactory (new PropertyValueFactory<democlass,String>("Vatamount"));
        f.setCellValueFactory (new PropertyValueFactory<democlass,String>("Total"));

//        (String name, Float price, Integer vat)
            Cartitems c1=new Cartitems("singara",50.0f,10);
        Cartitems c2=new Cartitems("Somacha",50.0f,15);
        Cartitems c3=new Cartitems("rice",500.0f,10);
        Cartitems c4=new Cartitems("egg",40.0f,10);
        Cartitems c5=new Cartitems("meat",5000.0f,15);
        Cartitems c6=new Cartitems("banana",50.0f,10);
        Cartitems c7=new Cartitems("tormoj",500.0f,15);
        Cartitems c8=new Cartitems("papa",500.0f,10);
        Cartitems c9=new Cartitems("piazu",50.0f,15);
        Cartitems c10=new Cartitems("borbote",500.0f,10);
        Collections.addAll(arr, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10);
        Integer xx=1;
        for (Cartitems c :arr){
            productComboBoxfxid.getItems().add(c.getName());
            quantityfxid.getItems().add(xx.toString());
            xx+=1;
            hs.put(c.name,c);
        }


    }
ArrayList<Cartitems> arr2=new ArrayList<>();
    @FXML
    public void addbuttononclick(ActionEvent actionEvent) {
        tableviewfxid.getItems().clear();
        for (Cartitems c:arr){
            if (c.getName().equals(productComboBoxfxid.getValue())){

                c.setQuanlity(Integer.parseInt(quantityfxid.getValue()));
                arr2.add(c);
            }
        }
        for(Cartitems c:arr2){

// public democlass(String product, String price, String quantity, String vat) {

                tableviewfxid.getItems().add(new democlass(c.getName(),
                        c.getPrice().toString(),
                        c.getQuanlity().toString(),
                        c.getVat().toString()
                        ));
        }

    }

    @FXML
    public void chackoutbuttononclick(ActionEvent actionEvent) {
        tableviewfxid.getItems().clear();
        for (Cartitems c:arr2){
            float xx;
            float xy;
            xx = (c.getQuanlity() * c.getPrice());
            xy=xx+xx*(1-c.getVat())/100.0f;
            float aaa=-(xy-xx);


            tableviewfxid.getItems().add(
//String product, String price, String quantity, String vat, String vatamount, String total) {

                    new democlass(c.getName(),c.getPrice().toString(),c.getQuanlity().toString(),
                            c.getVat().toString(),Float.toString(aaa),Float.toString(xy)

                            )

            );



        }




    }
    public void load_from_BinFile(ArrayList<Cartitems> com,String fileName) {

        File f = new File(fileName);
        ArrayList<Cartitems> ccc=new ArrayList<>();

        if (f.exists()) {
            try {
                FileInputStream fios = new FileInputStream(f);
                ObjectInputStream obfs = new ObjectInputStream(fios);

                try {
                    while (true) {
                        Cartitems c = (Cartitems) obfs.readObject();
                        // Display the object, for example, using System.out.println
//                        System.out.println(c.toString());
                        // Optionally, add the object to a list or update the UI
                        com.add(c);
                    }
                } catch (EOFException e) {
                    // End of file reached
                } finally {
                    obfs.close();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); // Handle exceptions and print stack trace
            }
        }



    }

    @FXML
    public void showfBin(ActionEvent actionEvent) {
        File f = new File("b.bin");
        ArrayList<Cartitems> ccc=new ArrayList<>();

        if (f.exists()) {
            try {
                FileInputStream fios = new FileInputStream(f);
                ObjectInputStream obfs = new ObjectInputStream(fios);

                try {
                    while (true) {
                        Cartitems c = (Cartitems) obfs.readObject();
                        // Display the object, for example, using System.out.println
//                        System.out.println(c.toString());
                        // Optionally, add the object to a list or update the UI
                        ccc.add(c);
                    }
                } catch (EOFException e) {
                    // End of file reached
                } finally {
                    obfs.close();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); // Handle exceptions and print stack trace
            }
        } else {
            System.out.println("The file does not exist.");
        }
        tableviewfxid.getItems().clear();
        if(!ccc.isEmpty()){

            showAlert("Success","successfully load from bin file");
            for(Cartitems c:ccc){


                String x="";
                Float p=1.0f;

//                p=c.getPrice()+c.getPrice()*(15/100.0f);
                tableviewfxid.getItems().add(new democlass(c.getName(),
                        c.getPrice().toString(),
                        c.getQuanlity().toString(),
                        c.getVat().toString()
                ));
            }
        }


    }

    @FXML
    public void savetoB(ActionEvent actionEvent) {

        File f = new File("b.bin");

        try {
            if (!f.exists()) {
                f.createNewFile(); // Create a new blank binary file if it doesn't exist
            }

            FileOutputStream fios = new FileOutputStream(f);
            ObjectOutputStream obfs = new ObjectOutputStream(fios);

            for (Cartitems c : arr2) {
                obfs.writeObject(c);
            }

            obfs.close();
            showAlert("Done ","Successfully Saved to bin File");
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions and print stack trace
        }

    }

    private void showAlert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();

    }
}
