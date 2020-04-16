/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author admin
 */
@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/index.jsp",
                errorPage = "/loginError.jsp"))

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/mysql",
        callerQuery = "select password from users where UserId=?",
        groupsQuery = "select GroupName from GroupTB where UserId=?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "index.jsp"))
@ApplicationScoped //used for all global application
@Named
public class ProjectConfig {

}
