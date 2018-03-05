package persistence;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jcommon.encryption.SimpleMD5;

import entity.Usuario;

public class UsuarioDao {
	
	Session session;
	Transaction transaction;//gravar, alterar, excluir....
	Criteria criteria; //consultar ...
	Query query; //consultar ...
	
	public void criptografia(Usuario u){
		//busca a senha embaralha com a palavra
		SimpleMD5 md5 =
      new SimpleMD5(u.getSenha(),"profedsonbelem@gmail.com#!1=1'"); 
		//criptogrando com chave a Senha dele ...
	u.setSenha(md5.toHexString()); //retorna  senha criptografada...
	}
	

	public void create(Usuario u)throws Exception{
		criptografia(u);//senha antes gravar ele criptografa
		 session = HibernateUtil.getSessionFactory().openSession();
		   transaction = session.beginTransaction();
		        session.save(u);
		   transaction.commit();
		 session.close();
	 }

	 public void update(Usuario u)throws Exception{
		 session = HibernateUtil.getSessionFactory().openSession();
		   transaction = session.beginTransaction();
		        session.update(u);
		   transaction.commit();
		 session.close();
	 }
	 

	 public void delete(Usuario u)throws Exception{
		 session = HibernateUtil.getSessionFactory().openSession();
		   transaction = session.beginTransaction();
		        session.delete(u);
		   transaction.commit();
		 session.close();
	 }
	 
	 public Usuario findByLogin(Usuario u){
			criptografia(u); //antes de buscar ele grava
	   session = HibernateUtil.getSessionFactory().openSession();		
	   query =session.
  createQuery("select u from Usuario u where u.login=:param1  and "
  		+ "   u.senha= :param2");	 
		 query.setParameter("param1", u.getLogin());
		 query.setParameter("param2", u.getSenha());
	   Usuario usuario =(Usuario) query.uniqueResult();
		 session.close();
		 return usuario;
	 }
	 
	 
	 public Usuario findByCode(Integer cod){
		 session = HibernateUtil.getSessionFactory().openSession();
		  query =session.
   createQuery("select u from Usuario u where u.codigo = :param1 ");
		  query.setParameter("param1", cod);
		  Usuario usuario = (Usuario) query.uniqueResult(); //retorna null
		  //ou retorna o usuario...
		  session.close();
		  return  usuario;
	 }
	 
	 public List<Usuario> findAll(){
		 session = HibernateUtil.getSessionFactory().openSession();
		  query =session.createQuery("select u from Usuario u");
		  List<Usuario> lst = (List<Usuario>) query.list();
		  session.close();
		  return  lst;	 
	 }
	 
	 
	 
	 public static void main(String[] args) {
		try{
	Usuario u1 = new Usuario(null,"thiago","tri@gmail.com","123");
	Usuario u2 = new Usuario(null,"lo","lo@gmail.com","123");
	 Usuario u3 = new Usuario(null,"valente","valenta@gmail.com","123");
		 
		  UsuarioDao dao = new UsuarioDao();
		    dao.create(u1);
		    dao.create(u2);
		    dao.create(u3);
  
		    //treinem muito stream()... java8...
		    dao.findAll().stream().map(Usuario::getNome)
		    .forEach(System.out::println);
			
		 
		}catch(Exception ex){
			ex.printStackTrace();
		}
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
