/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.ArrayList;

/**
 *
 * @author pseudocfoch
 * @param <T>
 */
public interface IDAO <T> {
    public boolean create(T objeto);
    public boolean delete(Object id);
    public boolean update(T objeto);
    public T read(Object id);
    public ArrayList<T> readAll();
}
