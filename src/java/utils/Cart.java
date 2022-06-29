/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dto.ProductDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author duy
 */
public class Cart {
    private Map<Integer, Integer> cart;

    public Cart() {
        cart = new HashMap<Integer, Integer>();
    }
    
    public Integer getQuanity(Integer productID) {
        return cart.get(productID);
    }
    
    public Set<Map.Entry<Integer, Integer>> getEntrySet() {
        return cart.entrySet();
    }
    
    // If exist increase, if not add new
    public boolean add(Integer productID, Integer quanity) {
        boolean check = false;
                
        if (cart.containsKey(productID)) {
            quanity += cart.get(productID);
            check = true;
        }
        
        cart.put(productID, quanity);
        return check;
    }
    
    // Update if exist
    public boolean update(Integer productID, Integer quanity) {
        if (cart.containsKey(productID)) {
            cart.put(productID, quanity);
            return true;
        }
        return false;
    }
    
    public Integer delete(Integer productID) {
        Integer result = (Integer) cart.remove(productID);
        return result;
    }
}
