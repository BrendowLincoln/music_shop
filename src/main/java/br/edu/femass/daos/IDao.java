package br.edu.femass.daos;

import java.util.*;

public interface IDao<T> {

    public List<T> list() throws Exception;
    public void save(T value) throws Exception;
    public void change(T value) throws Exception;
    public void delete(T value) throws Exception;
}
