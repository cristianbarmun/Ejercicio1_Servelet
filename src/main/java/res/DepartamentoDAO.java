package main.java.res;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;



public class DepartamentoDAO {
	
	//INSERTA DEPARTAMENTO
	public static void insertDepartamento(Session s, Departamento departamento) {				
		s.save(departamento);		
	}
	//ACTUALIZA DEPARTAMENTO
	public static void updateDepartamento(Session s, Departamento departamentoActualizado) {				

		Departamento departamento = s.get(Departamento.class, departamentoActualizado.getCodigo());
		departamento.setCodResponsable(departamentoActualizado.getCodResponsable());
		departamento.setNombre(departamentoActualizado.getNombre());
		if (departamento != null) 
			departamento = departamentoActualizado;
						
	}
	//ELIMINA DEPARTAMENTO
	public static void deleteDepartamento(Session s, int codigo) {	
				
		Departamento departamento = s.get(Departamento.class, codigo);		
		s.delete(departamento);
	}
	//OBTIENE LISTA DEPARTAMENTOS
	public static List<Departamento> getAllDepartamento(Session s){
		String hQuery = "from Departamento";
		List<Departamento> departamentoList = s.createQuery(hQuery, Departamento.class).list();
		
		return departamentoList;
	}

	// hql queries

	// Native queries
		
	// Criteria queries
	public static List<Departamento> getAllDepartamentos(Session s) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Departamento.class);
		List<Departamento> result = criteria.getExecutableCriteria(s).list();
		return result;
	}
	
	public static Departamento getDepartamento(Session s, int codigo) {
		// deprecado desde 5.2
		Criteria criteria = s.createCriteria(Departamento.class);
		Departamento result = (Departamento)criteria.add(Restrictions.eq("codigo", codigo))
											.setMaxResults(1)
											.uniqueResult();
		
//		CriteriaBuilder builder = s.getCriteriaBuilder();
//		CriteriaQuery<Provider> query = builder.createQuery(Provider.class);
//		Root<Provider> root = query.from(Provider.class);
//     	query.select(root).where(builder.equal(root.get("providerId"), providerId));
//      Query<Provider> q = s.createQuery(query);
//      Provider result = q.getSingleResult();
		return result;
	}
}
