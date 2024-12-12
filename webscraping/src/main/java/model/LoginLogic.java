package model;

import DAO.AccountDAO;
import Entity.Account;
import Entity.Login;

public class LoginLogic {
	public boolean execute(Login login) {
		AccountDAO dao =new AccountDAO();
		Account account =dao.findByLogin(login);
		return account != null;
	}

}
