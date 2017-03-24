<?php
class Accueil extends CI_Controller
{

	public function __construct()
	{
		parent::__construct();
		$this->load->model('utilisateur_model');
	}
	
	public function index()
	{
		if($this->utilisateur_model->isLoggedIn())
		{	
			redirect(base_url().'index.php/admin/index');  //redirection controleur
		} 
		
		else 
		{
			$this->connexion();
		}
	}
	
	public function connexion() 
	{	
		if($this->session->userdata('logged_in')) 
		{ 
			$this->load->view('accueil/v_error_connect'); 
		}
		
		else 
		{
			/*regles du formulaire.*/
			$this->form_validation->set_rules('pseudo', '"Pseudo"','trim|required|min_length[3]|max_length[30]|alpha_dash|encode_php_tags|xss_clean');
			$this->form_validation->set_rules('mdp', '"Mot de passe"', 'trim|required|min_length[5]|max_length[30]|alpha_dash|encode_php_tags|xss_clean');
			
			if($this->form_validation->run()) //run renvoie TRUE si le formulaire est valide
			{
				/*On récupère les valeurs du formulaire*/
				$pseudo = $this->input->post('pseudo');
				$mdp = $this->input->post('mdp');
				
				/*On charge le model*/
				$this->utilisateur_model->connexion($pseudo,$mdp);
				
				if($this->utilisateur_model->isLoggedIn())
				{
					$id = $this->utilisateur_model->get_id($pseudo);
					$this->session->set_userdata('id', $id);
					$this->index(); 
				} 
			
				else 
				{
					$this->load->view('accueil/v_formulaire', $data);
				}	
			}
			
			else
			{
				$this->load->view('accueil/v_formulaire'); // Le formulaire est invalide ou vide
			}
		}
	}
	
	public function deconnexion()
	{
		/*destruction de la session*/
		$this->session->sess_destroy();
		$this->load->view('accueil/v_deconnexion');
		header('refresh:2; url='.base_url().'index.php/accueil/index');
	}
}