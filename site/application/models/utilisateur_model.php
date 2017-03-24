<?php  if ( ! defined('BASEPATH')) exit('No direct script access allowed');
class Utilisateur_model extends CI_Model
{
    public function connexion($pseudo, $mdp)
	{
		/*encrypter le mdp*/
		$mdp = $this->encrypt->sha1($mdp);
		
		/*préparer requête*/
		$q = 'SELECT * FROM utilisateur WHERE Login = ? AND Mdp = ?';
		$data = array($pseudo,$mdp);
		$q = $this->db->query($q,$data);
		
		if($q->num_rows() > 0)
		{
			$this->session->set_userdata('logged_in', true);
			$this->session->set_userdata('pseudo', $pseudo);
			return true;
		}

		else { return false; }
	}
	
	public function get_id($pseudo){
		$q = 'SELECT NoUtilisateur FROM utilisateur WHERE Login = ?';
		$data = array($pseudo);
		$query = $this->db->query($q,$data);
		
		if ($query->num_rows() > 0)
		{
			foreach ($query->result() as $row)
			{
				return $row->NoUtilisateur;
			}
		} 
		
	}
	
	public function isLoggedIn()
	{
		if($this->session->userdata('logged_in'))
		{ 
			return true; 
		} 
		else { return false; }
	}
}