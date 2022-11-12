package com.laptrinhjavaweb.repository.custom.implCustom;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import org.apache.commons.lang.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> findCustomerByStaffId(Long staffId) {
        StringBuilder sql = new StringBuilder("SELECT c.* FROM customer c JOIN assignmentcustomer ac");
        sql.append("\nON c.id = ac.customerid");
        sql.append("\nWHERE ac.staffid = " + staffId);
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    @Override
    public List<CustomerEntity> findCustomers(CustomerSearchBuilder customerSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT c.* FROM customer c");
        sql = buildSqlJoining(customerSearchBuilder, sql);
        sql.append("\nWHERE 1 = 1");
        sql = buildSqlCommon(customerSearchBuilder, sql);
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    private StringBuilder buildSqlJoining(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
        if (customerSearchBuilder.getStaffId() != null) {
            sql.append("\nJOIN assignmentcustomer ac ON ac.customerid = c.id");
        }
        return sql;
    }

    private StringBuilder buildSqlCommon(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
        if (StringUtils.isNotBlank(customerSearchBuilder.getFullName())) {
            sql.append("\nAND c.fullname LIKE '%" + customerSearchBuilder.getFullName() + "%'");
        }

        if (StringUtils.isNotBlank(customerSearchBuilder.getEmail())) {
            sql.append("\nAND c.email LIKE '%" + customerSearchBuilder.getEmail() + "%'");
        }

        if (StringUtils.isNotBlank(customerSearchBuilder.getPhone())) {
            sql.append("\nAND c.phone LIKE '%" + customerSearchBuilder.getPhone() + "%'");
        }

        if (customerSearchBuilder.getStaffId() != null) {
            sql.append("\nAND ac.staffid = " + customerSearchBuilder.getStaffId());
        }
        return sql;
    }

    @Override
    public List<TransactionEntity> getTransactionsByCustomer(Long customerId) {
        StringBuilder sql = new StringBuilder("SELECT ts.* FROM users u JOIN transaction ts");
        sql.append("\nON u.id = ts.staffid");
        sql.append("\nWHERE ts.customerid = " + customerId);
        Query query = entityManager.createNativeQuery(sql.toString(), TransactionEntity.class);
        return query.getResultList();
    }
}
