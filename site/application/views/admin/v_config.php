<?php $this->load->view('global/header');?>
	
	<div id="content_camera">
		<h3>Panneau d'administration</h3>
		
		<p>
			<a href="<?php echo(base_url().'index.php/admin/historique')?>">- Accèder à l'historique de mes alertes</a></br>
			<a href="<?php echo(base_url().'assets/telechargement/notice.pdf')?>">- Télécharger la notice d'utilisation au format PDF</a>
		</p>
	</div>
	
<?php $this->load->view('global/footer');?>