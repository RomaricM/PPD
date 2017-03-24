 
<?php $this->load->view('global/header');?>

<script type="text/javascript" src="<?php echo(base_url() . 'assets/javascript/redirection.js')?>"></script>

<body onload="decompte();">

	<div id="content">
		<h3>Déconnexion</h3>
		
		<div>
			<p>Vous êtes maintenant déconnecté.</p></br>
		</div>
		
		<div id="chrono"></div></br>
		
		<div><a id="dec" href="<?php echo(base_url().'/index.php/accueil/index');?>">Retourner à la page de connexion.</a></div>
	</div>
		
<?php $this->load->view('global/footer');?>