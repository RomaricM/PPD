<?php $this->load->view('global/header');?>
	
	<center>
		<h2>Identifiez-vous pour accéder à vos services.</h2>
	</center>

	<form method="post" action="">
		<fieldset>
			<label for="pseudo" > Identifiant </label>
			<input name="pseudo" placeholder=" Entrez un identifiant" type="Text" maxlength="20" size="20" tabindex="1" required/> </br>
			
			<label  for="mdp" > Mot de passe </label> 
			<input type="password" name="mdp" placeholder=" Entrez votre mot de passe" maxlength="20" size="20" tabindex="1" required/> </br>
				 
			<!--affichage des erreurs de formulaire -->
			<?php 
			echo form_error('mdp');
			echo form_error('pseudo');?> </br>
								
			<center><input id="bouton" type="submit" value="Se Connecter" /></center>
		</fieldset>
	</form>
	
<?php $this->load->view('global/footer');?>
