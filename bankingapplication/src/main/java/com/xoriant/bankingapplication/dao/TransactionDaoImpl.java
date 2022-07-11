package com.xoriant.bankingapplication.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Transactions;

@Component("transactionsDao")
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernate() {
		return hibernateTemplate;
	}

	public void setHibernate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public void saveNewTransactions(Transactions transaction) {
		hibernateTemplate.save(transaction);
	}

	@Override
	@Transactional
	public Transactions findById(Integer transactionsId) {
		Transactions transaction = hibernateTemplate.get(Transactions.class, transactionsId);
		return transaction;
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	@Transactional
	public List<Transactions> findByAccount(Account account) {
		String sql = "from Transactions u where u.fromAccount=?0";
		List<Transactions> transactions = (List<Transactions>) hibernateTemplate.find(sql, account);

		return transactions;

	}



	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	@Transactional
	public List<Transactions> findByAccountNumber(long accountNumber) {
		String sql = "from Transactions t where t.fromAccount = (from Account a where  a.accountNumber=?0) ";
		List<Transactions> transactions = (List<Transactions>) hibernateTemplate.find(sql,accountNumber);
		return transactions;

	}

	@Override
	@Transactional
	public List<Transactions> filter(int accountNumber, String filter, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public List<Transactions> statement(Account account) {
		String sql = "from Transactions t where t.fromAccount =?0 or t.toAccount =?1 order by t.dateOfTransaction DESC  ";
		@SuppressWarnings("unchecked")
		List<Transactions> transactions = (List<Transactions>) hibernateTemplate.find(sql,account,account);
		return transactions;

	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public List<Transactions> customizedStatement(Account account, Date fromDate, Date toDate, double amountLowerLimit,
			int numberOfTransaction) {
		String sql = "from Transactions t where (t.fromAccount =?0 or t.toAccount =?1) and t.amount>?2 "
				+ "and t.dateOfTransaction between ?3 and ?4 "
				+ "order by t.dateOfTransaction DESC  ";
		@SuppressWarnings("unchecked")
		List<Transactions> transactions = (List<Transactions>) hibernateTemplate.find(sql,account,account,amountLowerLimit,fromDate,toDate).subList(0, numberOfTransaction);
		return transactions;
	}

}
