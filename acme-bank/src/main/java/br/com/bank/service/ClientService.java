package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Client;

public interface ClientService {

	public Client getClient(String name);
	
	public boolean getClientByPhone(String phone);
	
	public boolean getClientByEmail(String email);

	public List<Client> getAll();
	
	public void save(Client client);
	
	public boolean deleteById(Long idClient);

}
