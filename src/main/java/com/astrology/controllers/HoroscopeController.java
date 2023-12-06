package com.astrology.controllers;

import com.astrology.dao.ForecastTemplatesDAO;
import com.astrology.dao.GenderTypeDAO;
import com.astrology.dao.HoroscopeTypeDAO;
import com.astrology.dao.SignTypeDAO;
import com.astrology.dao.WordsBankDAO;
import com.astrology.models.HoroscopeParameters;
import com.astrology.models.HoroscopeType;
import com.astrology.models.SignType;
import com.astrology.models.WordsBank;
import com.astrology.models.WordBankFields;
import com.astrology.models.ForecastTemplates;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lex PopKorn73
 */
@Controller
public class HoroscopeController 
{
	private static int prevForecastID = -1;
	
	private final HoroscopeTypeDAO horoscopeDAO;
	private final SignTypeDAO signTypeDAO;
	private final GenderTypeDAO genderTypeDAO;
	
	private final WordsBankDAO wordsBankDAO;
	private final ForecastTemplatesDAO forecastTemplatesDAO;

	
	//@Autowired
	public HoroscopeController(
			HoroscopeTypeDAO horoscopeDAO,
			SignTypeDAO signTypeDAO,
			GenderTypeDAO genderTypeDAO,
			WordsBankDAO wordsBankDAO,
			ForecastTemplatesDAO forecastTemplatesDAO)
	{
		this.horoscopeDAO = horoscopeDAO;
		this.signTypeDAO = signTypeDAO;
		this.genderTypeDAO = genderTypeDAO;
		
		this.wordsBankDAO = wordsBankDAO;
		this.forecastTemplatesDAO = forecastTemplatesDAO;
	}
	
	@GetMapping("/horoscope")
	public String index(Model model) 
	{
		//System.out.println("===> Controller ");
		//System.out.println("List size = " +  horoscopeDAO.index().size());
		
		//model.addAttribute("people", personDAO.index());
		
		List<HoroscopeType> horoscopeTypeList = horoscopeDAO.index();
		int horoscopeId = horoscopeDAO.index().get(0).getHoroscopeId();
		
		model.addAttribute("horoscopes", horoscopeTypeList);		
		model.addAttribute("signs", signTypeDAO.index(horoscopeId));
		model.addAttribute("genders", genderTypeDAO.index());
		return "form";
	}
	
	@PostMapping("/horoscope")
	@ResponseBody
	public ResponseEntity<HashMap> GetHoroscope(@RequestBody HoroscopeParameters horoscopeParameters)
	{
		//System.out.println("Selected HoroscopeId = " + horoscopeParameters.horoscopeId);
		//System.out.println("Selected SignId = " + horoscopeParameters.signId);
		//System.out.println("Selected Gender = " + horoscopeParameters.genderId);
		//System.out.println("Got request");
		
		try
		{
			HashMap<String, String> map = new HashMap<>();
			map.put("Forecast", this.Forecast(horoscopeParameters));
			
			ResponseEntity<HashMap> responseEntity = new ResponseEntity<HashMap>(map, HttpStatus.OK);
			return responseEntity;
		}
		catch (Exception e)
		{
			return new ResponseEntity<HashMap>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/horoscope/signs")
	public ResponseEntity<List<SignType>> GetListSign(@RequestParam("horoscopeId") @Valid int horoscopeId)
	{
		System.out.println("Selected HoroscopeId = " + horoscopeId);
		//System.out.println("Selected SignId = " + horoscopeParameters.signId);
		
		//HashMap<Integer, String> dict = new HashMap<Integer, String>();
		List<SignType> signList = signTypeDAO.index(horoscopeId);
		
		try
		{
			ResponseEntity<List<SignType>> responseEntity = 
					new ResponseEntity<List<SignType>>(signList, HttpStatus.OK);
			return responseEntity;
		}
		catch (Exception e)
		{
			return new ResponseEntity<List<SignType>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	private String Forecast(HoroscopeParameters horoscopeParameters)
	{
	    WordsBank wordsBank = wordsBankDAO.index(horoscopeParameters.signId);
	    List<ForecastTemplates> listForecast = forecastTemplatesDAO.index();
	    
	    int randomIndex = new Random().nextInt(listForecast.size());
	    int randId = listForecast.get(randomIndex).getId();
	    
	    //System.out.println("randId = " + randId);
	    //System.out.println("prevForecastID = " + prevForecastID);
	    
	    if (prevForecastID != randId)
	    {
	    	prevForecastID = randId;
	    }
	    else
	    {
	    	System.out.println(">> prevForecastID = randId");
	    }
	    
	    String template = listForecast.get(randomIndex).getTemplate();
	    String ret = "";
		
		ret = template.replace(WordBankFields.sing_nom.toString(), wordsBank.getSingNom());
		ret = ret.replace(WordBankFields.sing_gen.toString(), wordsBank.getSingGen());
		ret = ret.replace(WordBankFields.pl_dat.toString(), wordsBank.getPlDat());
		ret = ret.replace(WordBankFields.pl_nom.toString(), wordsBank.getPlNom());
		ret = ret.replace(WordBankFields.pl_gen.toString(), wordsBank.getPlGen());
		
		//System.out.println(">> finally forecast = " + ret);
		
		return ret;
	}
}
