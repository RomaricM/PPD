<?php  if ( ! defined('BASEPATH')) exit('No direct script access allowed');
class Alerte_model extends CI_Model
{
	public function connexion($num_capteur)
	{
		/*préparer requête*/
		$q = 'INSERT INTO alerte(NoAlerte, DateAlerte, NoUtilisateur, NoApp)
		 VALUES (seqAlerte.nextVal, sysdate, ?, ?)';
		$data = array($XXXXX,$num_capteur);
		$q = $this->db->query($q,$data);
	}

	public function alerte($num_alerte, $image)
	{
		/*préparer requête*/
		$q = 'INSERT INTO imagealerte VALUES (?, ?)';
		$data = array($num_alert, $image);
		$q = $this->db->query($q,$data);
	}
	
	public function historique ($id)
	{
		$q = 'SELECT * FROM alerte WHERE NoUtilisateur = ?';
		$data = array($id);
		$query = $this->db->query($q,$data);
		return $query->result_array();	
	}
}

