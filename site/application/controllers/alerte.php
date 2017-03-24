<?php
class Accueil extends CI_Controller
{
	public function __construct()
	{
		parent::__construct();
		$this->load->model('alerte_model');
	}

	public function alerte()
	{
		//Nv alerte BDD
		$num_capteur = $this->input->post('num_capteur');
		$this->alerte_model->alerte($num_capteur);
	}

	public function upload()
	{
		//Maj BDD ajout img pour alerte
		$num_capteur = $this->input->post('num_alerte');
		$num_capteur = $this->input->post('image');
		$this->alerte_model->alerte($num_alerte, $image);
	}
}
