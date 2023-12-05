package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;
@RestController // if u dont want use restbody every time so use this 
public class Aliencontroller {
  @Autowired
	AlienRepo repo;
		@RequestMapping(value="/")
		public String home() {
			return "home.jsp";
		}
	
		
		
		// rest part 
//		@RequestMapping by default is get request
		
		
		@GetMapping(path="/alien",produces = {"application/xml"})// it produce only in xml
		public List<Alien> getallien() {
			return repo.findAll();   
		}
		@RequestMapping("/alien/{aid}")// wild card entry to pass any id 
		@ResponseBody() 
		public Optional<Alien> getallienbyid(@PathVariable Integer aid) {// intger cause value come from as wrapper class not primative
		   return repo.findById(aid);// 
		}

		
		// no nedd   tostring now 
		// question how it returing json format cause we returing the list of alien 
		// reason the in maven dependency their packge jackson who d
        //
		
		@PostMapping(path="/alien",consumes = {"application/xml"})//it will cosume only in xml
		public Alien postalien(@RequestBody Alien alien) { // if we are using row data of postman to add data
			                                             // it will pass data as the html body 
			repo.save(alien);
			return alien;
		}
		
		@PutMapping(path="/alien")//it will cosume only in xml
		public Alien saveandupdatealien(@RequestBody Alien alien) { // if we are using row data of postman to add data
			                                             // it will pass data as the html body 
			repo.save(alien);
			return alien;
		}
		
		
	
		@DeleteMapping(path="/alien/{aid}")
		public void Deleteallien(@PathVariable Integer aid) {
		Alien a=repo.getOne(aid);
			repo.delete(a);   
		}
}

//	@ResponseBody() -:	 indicates a method return value should be bound to the webresponse body. Supported for annotated handler methods. 
  
// instead string we can write alien object as we returing so if we returing all data list<Alien> and for if get error so optional<Alien> 

//@PathVariable to extract the value from the URL:

//content negotiation _-
//content negotiation in the context of a web server.
//Content negotiation is a process where the server and the client 
//communicate to determine the most suitable representation of a resource.
//This negotiation involves determining the format or type of 
//data that the client wants and that the server can provide.
//
//In the context of a web server, content negotiation often involves the HTTP "Accept" 
//header sent by the client. The "Accept" header specifies the media types 
//(or content types) that the client can understand. The server, in turn, tries to provide 
//the requested content type or negotiate to find a mutually acceptable content type.
//


//produce and consume- when u send data from server to client is producing
                       //when the server is accepting data from the client is called as conuming