package config;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Main {

	//este arquivo é para gerar a Tabela ....
	//Hibernate ... (FrameWork para auxliar na gravação, busca dos dados
	
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().
				 configure("config/mysql_hibernate.cfg.xml");
		 
		 new SchemaExport(cfg).create(true,true);
		 System.out.println("Tabelas Geradas ...");
		 
		 //tetra ... usuario
		 //e amanha mais um duelo 
		 // nicolas cage vs  valente vs  latin lover
		 
		 
	}
}
