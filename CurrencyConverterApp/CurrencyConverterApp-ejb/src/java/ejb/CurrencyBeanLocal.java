/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Currency;

/**
 *
 * @author admin
 */
@Local
public interface CurrencyBeanLocal {

    List<Currency> getAllCurrency();

    Double getCurrenctRate(int Id);
}
