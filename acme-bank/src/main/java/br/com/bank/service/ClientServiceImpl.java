/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;

/**
 * @author cbgomes
 *
 */
public class ClientServiceImpl implements ClientService {
	
	private ClientDaoImpl dao;
	
	public ClientServiceImpl() {
		this.dao = new ClientDaoImpl();
	}

	@Override
	public Client getClient(String name) {
		
		return this.dao.getClient(name);
	}
	
	
	@Override
	public boolean getClientByPhone(String phone) {
		
		return this.dao.getClientByPhone(phone);
	}
	
	@Override
	public boolean getClientByEmail(String email) {
		
		return this.dao.getClientByEmail(email);
	}

	@Override
	public List<Client> getAll() {
		return this.dao.getAll();
	}

	@Override
	public void save(Client client) {
		this.dao.save(client);
	}

	@Override
	public boolean deleteById(Long id) {
		if(this.dao.deleteById(id)){
			return true;
		}else {
			return false;
		}
	}

	
}
