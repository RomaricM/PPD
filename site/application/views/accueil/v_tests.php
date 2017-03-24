<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Connexion</title>
</head>

<body>

	<h1>Connexion</h1>
	
	<p>
		Veuillez vous connecter pour accéder à l'application
	</p>
	
	<p>
		Bonjour <?php echo $pseudo; ?>
		<?php $pseudo_session = $this->session->userdata('pseudo');?>
		</br>
		La session me dit que vous êtes : <?php echo $pseudo_session; ?>
	</p>
	
	<p>
		Vous utilisez : <?php echo $navigateur; ?>
	</p>
	
	<p>
		Votre adresse IP est : <?php echo $ip; ?>
	</p>
	
	<p>
		<?php if($en_ligne): ?>
		Vous êtes en ligne.
		<?php else: ?>
		Vous n'êtes pas en ligne.
		<?php endif; ?>
	</p>
	
</body>

</html>