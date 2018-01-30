package com.virb.clone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virb.clone.doa.AccountDOA;
import com.virb.clone.doa.WebsiteDOA;
import com.virb.clone.entity.Account;
import com.virb.clone.entity.CombineAccountWebsite;
import com.virb.clone.entity.Website;

@Controller
@RequestMapping("/home")
public class WebController {
	
	@Autowired
	AccountDOA accountDoa;
	
	@Autowired
	WebsiteDOA websiteDao;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/about-us")
	public String aboutUs(){
		
		return "about-us";
	}
	
	@RequestMapping("/features")
	public String features(){
		
		return "features";
	}
	
	@RequestMapping("/pricing")
	public String pricing(){
		return "pricing";
	}
	
	@RequestMapping("/themes")
	public String themes(){
		return "themes";
	}
	
	@RequestMapping("/showcase")
	public String showcase(){
		return "showcase";
	}
	
	@RequestMapping("/logIn")
	public String showLoginForm(Model model){
		
		model.addAttribute("account", new Account());
		return "logIn-form";
	}
	
	@PostMapping("/processLogIn")
	public String processLogIn(
			@Valid @ModelAttribute("account") Account signInAccount, 
			BindingResult bindingResult){
		
		System.out.println("Checking account infomation");
		System.out.println("Email: " + signInAccount.getEmail() + " and Password: " 
				+ signInAccount.getPassword() + " Error: " + bindingResult.hasErrors());
		
		if(bindingResult.hasErrors()){
			return "logIn-form";
		}
		else {
			//do some hibernate to check if customer in there
			if(accountDoa.loginAccount(signInAccount)) {
				return "index";
			}
			else {
				return "logIn-form";
			}
			
			//send to confirmation page
			
			
		}
		
		
	}
	
	@RequestMapping("/startTrialForm")
	public String startTrialForm(Model model){
		String testPass = "Thank You!";
		
		model.addAttribute("combineAccountWebsite", new CombineAccountWebsite());
		model.addAttribute("ty", testPass);
		
		return "startFreeTrial-form";
	}
	
	@RequestMapping("/processFreeTrialForm")
	public String processFreeTrialForm(@Valid @ModelAttribute("combineAccountWebsite") CombineAccountWebsite combineAccountWebsite,
			BindingResult bindingResult){
		
		System.out.println("Starting free trial");
		
		//account
		Account trialAccount = new Account();
		trialAccount.setFirstName(combineAccountWebsite.getFirstName());
		trialAccount.setLastName(combineAccountWebsite.getLastName());
		trialAccount.setEmail(combineAccountWebsite.getEmail());
		trialAccount.setPassword(combineAccountWebsite.getPassword());
		
		
		//website
		Website trialWebsite = new Website();
		trialWebsite.setAccount(trialAccount);
		trialWebsite.setCategory(combineAccountWebsite.getCategory());
		trialWebsite.setLink(combineAccountWebsite.getLink());
		trialWebsite.setTitle(combineAccountWebsite.getTitle());
		
		
		if(bindingResult.hasErrors()){
			System.out.println("BindingResult has Error" + bindingResult.getErrorCount());
			
			return "startFreeTrial-form";
		}
		else{
			//save to database
			//List<Website> web = new ArrayList<>();
			//web.add(trialWebsite);
			//trialAccount.setWebsite(web);
			trialAccount.addWebsite(trialWebsite);
			
			trialWebsite.setAccount(trialAccount);
			
			accountDoa.addAccount(trialAccount);
			websiteDao.addWebsite(trialWebsite);
			
			
			//log in 
			return "redirect:/";
		}
		
	}

}
