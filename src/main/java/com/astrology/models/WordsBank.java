package com.astrology.models;

public class WordsBank
{
	private int id;
	private int SignId;
	private String sing_nom;
	private String sing_gen;
	private String pl_nom;
	private String pl_gen;
	private String pl_dat;
	
	
	public WordsBank()
	{
		
	}
	
	public WordsBank(int id, int SignId, String sing_nom, String sing_gen, String pl_nom, String pl_gen, String pl_dat)
	{
		this.id = id;
		this.SignId = SignId; 
		this.sing_nom = sing_nom; 
		this.sing_gen = sing_gen; 
		this.pl_nom = pl_nom; 
		this.pl_gen = pl_gen; 
		this.pl_dat = pl_dat; 
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id= id;
	}

	public int getSignId()
	{
		return SignId;
	}
	
	public void setSignId(int SignId)
	{
		this.SignId = SignId;
	}
	
	public String getSingNom()
	{
		return sing_nom;
	}
	
	public void setSingNom(String sing_nom)
	{
		this.sing_nom = sing_nom;
	}
	
	public String getSingGen()
	{
		return sing_gen;
	}
	
	public void setSingGen(String sing_gen)
	{
		this.sing_gen = sing_gen;
	}
	
	public String getPlNom()
	{
		return pl_nom;
	}
	
	public void setPlNom(String pl_nom)
	{
		this.pl_nom = pl_nom;
	}
	
	public String getPlGen()
	{
		return pl_gen;
	}
	
	public void setPlGen(String pl_gen)
	{
		this.pl_gen = pl_gen;
	}
	public String getPlDat()
	
	{
		return pl_dat;
	}
	
	public void setPlDat(String pl_dat)
	{
		this.pl_dat = pl_dat;
	}
}
