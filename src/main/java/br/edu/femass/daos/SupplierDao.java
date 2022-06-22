package br.edu.femass.daos;

import br.edu.femass.models.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao extends DaoPostgres implements IDao<Supplier> {
    @Override
    public List<Supplier> list() throws Exception {
        final String sql = "SELECT * FROM Supplier ORDER BY commercial_name";
        PreparedStatement preparedStatement = getPreparedStatement(sql, false);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Supplier> suppliers = new ArrayList<Supplier>();
        while (resultSet.next()) {
            Supplier supplier = new Supplier();
            supplier.setId(resultSet.getLong("id"));
            supplier.setCnpj(resultSet.getString("cnpj"));
            supplier.setLegalName(resultSet.getString("legal_name"));
            supplier.setCommercialName(resultSet.getString("commercial_name"));
            suppliers.add(supplier);
        }


        return suppliers;
    }

    @Override
    public void save(Supplier value) throws Exception {
        final String sql = "INSERT INTO supplier (cnpj, legal_name, commercial_name) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(sql, true);

        preparedStatement.setString(1, value.getCnpj());
        preparedStatement.setString(2, value.getLegalName());
        preparedStatement.setString(3, value.getCommercialName());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        value.setId(resultSet.getLong(1));
    }

    @Override
    public void change(Supplier value) throws Exception {

    }

    @Override
    public void delete(Supplier value) throws Exception {

    }
}
