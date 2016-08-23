package br.org.eldorado.cliente.service;

public interface ServiceManager<T> {
	
	public T save(T object);
	
	public T getById(Integer id);

}
