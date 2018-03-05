package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Usuario;
import persistence.UsuarioDao;

@Controller
public class UsuarioController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView iniciar(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/gravar.html",
			method=RequestMethod.POST)	
	public ModelAndView gravar(Usuario u){
	 ModelAndView mv = new ModelAndView("index");
	 try{
		 new UsuarioDao().create(u);
		 mv.addObject("msg","Usuario Gravado");
		 
	 }catch(Exception ex){
		 mv.addObject("msg","Error:" + ex.getMessage());
	 }
	 return mv;
	}
	

	@RequestMapping(value="/logar.html",method=RequestMethod.POST)	
	public ModelAndView logar(Usuario u){
	 ModelAndView mv = null;
	 try{
		Usuario resp =  new UsuarioDao().findByLogin(u);
		  if (resp!=null){
			mv= new ModelAndView("logado");
			mv.addObject("usuario", resp);
		  }
		 mv.addObject("msg","Usuario Logado com Sucesso");
		 return mv;
	 }catch(Exception ex){
		 mv.addObject("msg","Error:" + ex.getMessage());
		 mv= new ModelAndView("index");
		 return mv;
	 }
  }

}
