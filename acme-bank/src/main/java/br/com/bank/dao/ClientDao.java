package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Client;

public interface ClientDao{

	public Client getClient(String name);
	
	public boolean getClientByPhone(String phone);
	
	public boolean getClientByEmail(String email);

	public List<Client> getAll();

	public void save(Client client);

	public boolean deleteById(Long idClient);
}
