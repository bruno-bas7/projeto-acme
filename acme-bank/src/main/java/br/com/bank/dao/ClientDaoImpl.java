/**
 * 
 */
package br.com.bank.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil;

/**
 * @author cbgomes
 *
 */
public class ClientDaoImpl implements ClientDao {

	@Override
	public Client getClient(String name) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			Client client = entityManager.createNamedQuery("Client.getByName",Client.class)
					.setParameter("name", name)
					.getSingleResult();
			
			return client;
			
		}catch (Exception e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}

	@Override
	public boolean getClientByPhone(String phone) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Client objclient = new Client();
			
		try {
			
			objclient = entityManager.createNamedQuery("Client.getByPhone",Client.class) //acessa o bd e verifica se existe um usuario com o num de telefone informado.
					.setParameter("phone", phone)//pesquisa na coluna phone , o telefone recebido
					.getSingleResult(); //pega o resultado da consulta
			
			if(objclient != null)//verifica se o obj esta vazio, se estiver significa que ele não encontrou o phone na base de dados
			return true;//caso retorne true, vai executar o if do clientservlet
			
		}catch (Exception e) {
			e.getMessage();
			entityManager.close();
		}
		
		return false; //caso retorne false, vai executar o else do clientservlet
	}
	
	public boolean getClientByEmail(String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Client objclient = new Client();
			
		try {
			
			objclient = entityManager.createNamedQuery("Client.getByEmail",Client.class) //acessa o bd e verifica se existe um usuario com o num de telefone informado.
					.setParameter("email", email)//pesquisa na coluna phone , o telefone recebido
					.getSingleResult(); //pega o resultado da consulta
			
			if(objclient != null)//verifica se o obj esta vazio, se estiver significa que ele não encontrou o phone na base de dados
			return true;//caso retorne true, vai executar o if do clientservlet
			
		}catch (Exception e) {
			e.getMessage();
			entityManager.close();
		}
		
		return false; //caso retorne false, vai executar o else do clientservlet
	}

	
	@Override
	public List<Client> getAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			List<Client> client = entityManager.createNamedQuery("Client.getAll", Client.class).getResultList();
			return client;
		}catch (NoResultException e) {
				e.getMessage();
				entityManager.close();
				return null;
		}	
		
	}

	@Override
	public void save(Client client) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			entityManager.persist(client);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public boolean deleteById(Long idClient) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		Client client = entityManager.find(Client.class, idClient);
		
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(client);
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
				e.getMessage();
				return false;
		}		
		
	}

}
