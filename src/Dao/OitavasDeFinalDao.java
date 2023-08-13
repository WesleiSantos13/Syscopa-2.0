package Dao;

import java.util.List;

import model.OitavasDeFinal;


public interface OitavasDeFinalDao {
	public void CreateOitavFinal(OitavasDeFinal partida);
	public void UpdateOitavFinal(OitavasDeFinal partida, int id);
	public void DeleteOitavFinal(int id);
	public List<OitavasDeFinal> ListOitavFinal();
	public List<Integer> SearchOitavFinal(String nome);
}
