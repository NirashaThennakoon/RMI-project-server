
package lk.ijse.thogakade.reservation.impl;

import java.util.HashMap;
import lk.ijse.thogakade.reservation.Reservation;
import lk.ijse.thogakade.service.SuperService;


public class ReservationImpl implements Reservation{
    
    private HashMap<String, SuperService> reserveList = new HashMap<>();
    
    public boolean reserve(String customerId, SuperService superService){
        if (reserveList.containsKey(customerId)){
            if (reserveList.get(customerId) == superService){
                return true;
            }else{
                return false;
            }
        }else{
            reserveList.put(customerId, superService);
            return true;
        }
    }
    
    public boolean release(String customerId){
        if (reserveList.containsKey(customerId)){
            reserveList.remove(customerId);
            return true;
        }else{
            return false;
        }
    }
    
}
