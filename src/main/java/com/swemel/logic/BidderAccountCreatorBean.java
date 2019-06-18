package com.swemel.logic;

import com.swemel.persistence.BillingInfo;
import com.swemel.persistence.BiographicalInfo;
import com.swemel.persistence.LoginInfo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Stateless
public class BidderAccountCreatorBean {

    @Resource(lookup = "java:/PostgresDS")
    private DataSource dataSource;

    private LoginInfo loginInfo;

    private BiographicalInfo biographicalInfo;

    private BillingInfo billingInfo;

    private Connection connection;

    @PostConstruct
    @PostActivate
    public void openConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void addLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public void addBiographicalInfo(BiographicalInfo biographicalInfo)
            throws WorkflowOrderViolationException {
        if (loginInfo == null) {
            throw new WorkflowOrderViolationException(
                    "Login info must be set before biographical info");
        }
        this.biographicalInfo = biographicalInfo;
    }

    public void addBillingInfo(BillingInfo billingInfo)
            throws WorkflowOrderViolationException {
        if (biographicalInfo == null) {
            throw new WorkflowOrderViolationException(
                    "Biographical info must be set before billing info");
        }

        this.billingInfo = billingInfo;
    }

    @PrePassivate
    @PreDestroy
    public void cleanup() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Remove
    public void cancelAccountCreation() {
        loginInfo = null;
        biographicalInfo = null;
        billingInfo = null;
    }

    @Remove
    public void createAccount() {
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO BIDDERS(" + "username, " + "first_name, "
                    + "credit_card_type" + ") VALUES (" + "'"
                    + loginInfo.getUsername() + "', " +
                    "'" + biographicalInfo.getFirstName() + "', " +
                    "'" + billingInfo.getCreditCardType() + "'" +
                    ")";
            statement.execute(sql);
            statement.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
