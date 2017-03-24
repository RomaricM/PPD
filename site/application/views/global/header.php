<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html;charset=UTF-8">
		<title><?php $title ?></title>
		
		<link rel="stylesheet" type="text/css" href="<?php echo(base_url().'assets/css/lightbox.css'); ?>"/>
		<link rel="stylesheet" type="text/css" href="<?php echo(base_url().'assets/css/style.css'); ?>"/>
		<!-- Mettre une icone à notre site -->
		<link rel="shortcut icon" href="<?php echo(base_url().'assets/images/icone.ico'); ?>">
		
		<script src="<?php echo(base_url() . 'assets/javascript/jquery-1.10.2.min.js')?>"></script>
		<script src="<?php echo(base_url() . 'assets/javascript/lightbox-2.6.min.js')?>"></script>

	</head>

	<body>

	<div id="wrap">
	
	<header>
		<div id="logo">
			<a href="<?php echo(base_url().'index.php/accueil/index')?>"> <img src="<?php echo(base_url().'assets/images/logo.png')?>" alt="PPD" /> </a>
			
		</div>
		
		<div id="nav">
			<ul>
				<li><a href="<?php echo(base_url().'index.php/admin/index')?>">Accueil</a></li>
				<?php 
				if($this->session->userdata('logged_in')) 
				{ ?> <li><a href="<?php echo(base_url().'index.php/admin/streaming')?>">Streaming</a></li> 
				<li><a href="<?php echo(base_url().'index.php/admin/config')?>">Administration</a></li>
				<li><a id="dec" href="<?php echo(base_url().'index.php/accueil/deconnexion');?>">Se déconnecter</a></li>
				<?php } ?>
			</ul>
		</div>	
	</header>
	
	<div id="main">
	
