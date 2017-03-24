
<?php $this->load->view('global/header');?>

<script type="text/javascript" src="<?php echo(base_url() . 'assets/javascript/redirection.js')?>"></script>

<body onload="decompte();">

	<h1>Connecté</h1>
	
	<div><p>Vous êtes maintenant connecté.</p></br></div>
	<div id="chrono"></div></br>
	<div> <a id="dec" href="<?php echo(base_url().'/index.php/admin/index');?>">Accèder au panneau d'administration.</a> </div>

<?php $this->load->view('global/footer');?>