/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Currency;

/**
 *
 * @author admin
 */
@Stateless
public class CurrencyBean implements CurrencyBeanLocal {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public void Initialize() throws SQLException {
        String url = "jdbc:mysql://localhost/currencyconverterdb";
        String username = "root";
        String password = "root";
        con = DriverManager.getConnection(url, username, password);
    }

    @Override
    public List<Currency> getAllCurrency() {
        List<Currency> lstCurrency = new ArrayList<Currency>();
        try {
            Initialize();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from currencytb");
            while (rs.next()) {
                int Id = rs.getInt(1);
                String CurrencyName = rs.getString(2);
                float Rate = rs.getFloat(3);
                Currency objCur = new Currency(Id, CurrencyName, Rate);
                lstCurrency.add(objCur);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lstCurrency;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Double getCurrenctRate(int Id) {
        double CurrencyRate = 0;
        try {
            Initialize();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from currencytb where Id = " + Id + "");
            while (rs.next()) {
                CurrencyRate = rs.getDouble(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CurrencyRate;
    }
}
