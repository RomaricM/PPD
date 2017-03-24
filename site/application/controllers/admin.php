<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Admin extends CI_Controller
{

	public function __construct()
	{
		parent::__construct();
		$this->load->model('utilisateur_model');
		$this->load->model('alerte_model');
		$data = array();
	}
	
	public function index()
	{
		if(!$this->utilisateur_model->isLoggedIn()) {
			redirect(base_url().'index.php/accueil/index'); 
		}
		$this->load->view('admin/v_accueil_admin.php');
	}
	
	public function streaming() 
	{
		$this->load->view('admin/v_streaming.php');
	}
	
	public function config() {
		$this->load->view('admin/v_config.php');
	}
	
	public function historique() {
		$id = $this->session->userdata('id');
		$data['alertes'] = $this->alerte_model->historique($id);
		$this->load->view('admin/v_historique', $data);	
	}
}
